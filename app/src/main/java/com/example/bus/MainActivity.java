package com.example.bus;

import static com.example.bus.ui.settings.SettingsFragment.KEY_THEME;
import static com.example.bus.ui.settings.SettingsFragment.PREFS_NAME;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.bus.databinding.ActivityMainBinding;
import com.example.bus.ui.Search_Bus.Search_Bus;
import com.example.bus.ui.busTiming.Bus_timing;
import com.example.bus.ui.dbs.AppDatabase;
import com.example.bus.ui.dbs.DatabaseSeeder;
import com.example.bus.ui.feedback.FeedbackFragment;
import com.example.bus.ui.home.HomeFragment;
import com.example.bus.ui.login.LoginActivity;
import com.example.bus.ui.login.SignupActivity;
import com.example.bus.ui.settings.SettingsFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME ="" ;
    private AppBarConfiguration mAppBarConfiguration;
    private static final String TAG = "MainActivity";
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String theme = prefs.getString(KEY_THEME, "Theme.Bus");
        setTheme(getResources().getIdentifier(theme, "style", getPackageName()));

        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.setFirestoreSettings(new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build());

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.bus_timing,
                R.id.search_bus,
                R.id.nav_feedback
        ).setOpenableLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        executorService.execute(() -> {
            AppDatabase db = AppDatabase.getInstance(this);
            DatabaseSeeder.populateDatabase(this);
        });

        // Inside onCreate() or Navigation Item Selection:
        navigationView.setNavigationItemSelectedListener(item -> {
            getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

            if (item.getItemId() == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, new HomeFragment())
                        .commit();
            } else if (item.getItemId() == R.id.nav_feedback) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, new FeedbackFragment())
                        .commit();
            }
            else if (item.getItemId() == R.id.search_bus) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, new Search_Bus())
                        .commit();
            }
            else if (item.getItemId() == R.id.bus_timing) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, new Bus_timing())
                        .commit();
            }else if (item.getItemId() == R.id.nav_add_account) {
                addNewAccount();
            } else if (item.getItemId() == R.id.nav_logout) {
                logoutUser();
            } else {
                NavigationUI.onNavDestinationSelected(item, navController);
            }


            drawer.closeDrawers();
            return true;
        });
    }


    private void logoutUser() {
        SharedPreferences.Editor editor = getSharedPreferences("UserSession", MODE_PRIVATE).edit();
        editor.clear().apply();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void addNewAccount() {
        startActivity(new Intent(MainActivity.this, SignupActivity.class));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }

    private void fetchFirestoreData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("districts").get().addOnSuccessListener(districts -> {
            for (DocumentSnapshot districtDoc : districts) {
                String districtID = districtDoc.getId();
                String districtName = districtDoc.getString("name");
                Log.d(TAG, "📍 District: " + districtName);

                db.collection("taluks").whereEqualTo("districtID", districtID).get()
                        .addOnSuccessListener(taluks -> {
                            for (DocumentSnapshot talukDoc : taluks) {
                                String talukName = talukDoc.getString("name");
                                Log.d(TAG, "   ↳ 🏢 Taluk: " + talukName);
                            }
                        });
            }
        });
    }
}
package com.example.bus.ui.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.bus.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.*;
import java.util.Locale;

public class SettingsFragment extends Fragment {

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_LANGUAGE = "selected_language";
    private static final String KEY_THEME = "selected_theme";

    private EditText edtEmailInput, edtEmailInput2, edtNewUsername;
    private TextView tvCurrentUsername, tvCurrentPassword;
    private ProgressBar progressBar;
    private FirebaseFirestore db;
    private boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        // UI Elements
        edtEmailInput = view.findViewById(R.id.edtEmailInput);
        edtEmailInput2 = view.findViewById(R.id.edtEmailInput2);
        edtNewUsername = view.findViewById(R.id.edtNewUsername);
        tvCurrentUsername = view.findViewById(R.id.tvCurrentUsername);
        tvCurrentPassword = view.findViewById(R.id.tvCurrentPassword);
        progressBar = view.findViewById(R.id.progressBar);
        Button btnUpdateUsername = view.findViewById(R.id.btnUpdateUsername);
        Button btnFetchCredentials = view.findViewById(R.id.btnFetchCredentials);
        Spinner spinnerLanguage = view.findViewById(R.id.spinnerLanguage);
        Spinner spinnerTheme = view.findViewById(R.id.spinnerTheme);
        // Add this inside the onCreateView() method
        Button btnClearData = view.findViewById(R.id.btnClearData);
        btnClearData.setOnClickListener(v -> showClearDataConfirmationDialog());
        Button btnPrivacyPolicy = view.findViewById(R.id.btnPrivacyPolicy);
        btnPrivacyPolicy.setOnClickListener(v -> showPrivacyPolicyDialog());
        setupLanguageSpinner(spinnerLanguage);
        setupThemeSpinner(spinnerTheme);
        btnFetchCredentials.setOnClickListener(v -> fetchUserCredentials());
        btnUpdateUsername.setOnClickListener(v -> updateUsername());

        return view;
    }

    private void showPrivacyPolicyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Privacy Policy");

        // Inflate a custom layout for the dialog
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_privacy_policy, null);
        builder.setView(dialogView);

        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    private void showClearDataConfirmationDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Confirm Clear Data")
                .setMessage("Are you sure you want to clear all app data? This action cannot be undone.")
                .setPositiveButton("Yes", (dialog, which) -> clearAppData())
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    private void clearAppData() {
        try {
            // Open app settings for manual data clearance
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(android.net.Uri.parse("package:" + requireContext().getPackageName()));
            startActivity(intent);
            Toast.makeText(requireContext(), "Go to 'Storage & Cache' to clear data manually.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(requireContext(), "Failed to open settings for clearing data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUsername() {
        String email = edtEmailInput2.getText().toString().trim().toLowerCase(); // Ensure lowercase
        String newUsername = edtNewUsername.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            edtEmailInput2.setError("Enter your email");
            return;
        }
        if (TextUtils.isEmpty(newUsername)) {
            edtNewUsername.setError("Enter a new username");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

        usersRef.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                if (snapshot.exists()) {
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        userSnapshot.getRef().child("username").setValue(newUsername)
                                .addOnSuccessListener(aVoid -> {
                                    showToast("Username updated successfully!");
                                    tvCurrentUsername.setText("Username: " + newUsername);
                                })
                                .addOnFailureListener(e -> showToast("Update failed: " + e.getMessage()));
                    }
                } else {
                    showToast("Email not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                showToast("Database Error: " + error.getMessage());
            }
        });
    }


    private void fetchUserCredentials() {
        String userEmail = edtEmailInput.getText().toString().trim().toLowerCase();

        if (TextUtils.isEmpty(userEmail)) {
            edtEmailInput.setError("Enter email to retrieve credentials");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

        usersRef.orderByChild("email").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                if (snapshot.exists()) {
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String username = userSnapshot.child("username").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);

                        tvCurrentUsername.setText("Username: " + (username != null ? username : "Not Found"));
                        tvCurrentPassword.setText("Password: " + (password != null ? password : "Not Available"));
                    }
                } else {
                    showToast("User not found");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                showToast("Database Error: " + error.getMessage());
            }
        });
    }


    private void setupLanguageSpinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedLang = prefs.getString(KEY_LANGUAGE, "en");
        spinner.setSelection(getSpinnerIndex(savedLang, getResources().getStringArray(R.array.languages)));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedView, int position, long id) {
                if (isFirstLoad) {
                    isFirstLoad = false;
                    return;
                }
                String selectedLangCode = getLanguageCode(position);
                if (!savedLang.equals(selectedLangCode)) {
                    changeAppLanguage(selectedLangCode);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void setupThemeSpinner(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.theme_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        SharedPreferences prefs = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedTheme = prefs.getString(KEY_THEME, "Theme.Bus");

        int position = getSpinnerIndex(savedTheme, getResources().getStringArray(R.array.theme_values));
        spinner.setSelection(position);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedView, int position, long id) {
                if (isFirstLoad) {
                    isFirstLoad = false;
                    return;
                }

                String selectedTheme = getResources().getStringArray(R.array.theme_values)[position];

                if (!savedTheme.equals(selectedTheme)) {
                    applyTheme(selectedTheme);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void applyTheme(String themeName) {
        SharedPreferences.Editor editor = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(KEY_THEME, themeName);
        editor.apply();

        requireActivity().recreate();
    }

    private void changeAppLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        res.updateConfiguration(config, res.getDisplayMetrics());

        SharedPreferences.Editor editor = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(KEY_LANGUAGE, languageCode);
        editor.apply();

        requireActivity().recreate();
    }

    private String getLanguageCode(int position) {
        String[] langCodes = {"en", "ta", "hi", "bn", "te", "mr", "gu", "or", "pa", "ml"};
        return langCodes[position];
    }

    private int getSpinnerIndex(String value, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return 0;
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}

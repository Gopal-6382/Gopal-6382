package com.example.bus.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bus.R;
import com.example.bus.ui.dbs.HelperDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignupActivity extends AppCompatActivity {

    private EditText signupUsername, signupEmail, signupPassword;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupUsername = findViewById(R.id.signup_username);
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        TextView loginRedirectText = findViewById(R.id.login_redirect);
        Button signupButton = findViewById(R.id.signup_button);

        reference = FirebaseDatabase.getInstance().getReference("users");

        signupButton.setOnClickListener(view -> {
            String username = signupUsername.getText().toString().trim();
            String email = signupEmail.getText().toString().trim().toLowerCase(); // Convert to lowercase
            String password = signupPassword.getText().toString().trim();

            if (!validateInputs(username, email, password)) return;

            reference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        signupUsername.setError("Username already taken");
                        signupUsername.requestFocus();
                    } else {
                        HelperDB helperClass = new HelperDB(username, email, password);
                        reference.child(username).setValue(helperClass)
                                .addOnSuccessListener(aVoid -> {
                                    Toast.makeText(SignupActivity.this, "Signup Successful!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                    finish();
                                })
                                .addOnFailureListener(e ->
                                        Toast.makeText(SignupActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show()
                                );
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(SignupActivity.this, "Database Error!", Toast.LENGTH_SHORT).show();
                }
            });
        });

        loginRedirectText.setOnClickListener(view -> startActivity(new Intent(SignupActivity.this, LoginActivity.class)));
    }

    private boolean validateInputs(String username, String email, String password) {
        if (username.isEmpty()) {
            signupUsername.setError("Username cannot be empty");
            return false;
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signupEmail.setError("Enter a valid email");
            return false;
        }
        if (password.isEmpty() || password.length() < 6) {
            signupPassword.setError("Password must be at least 6 characters long");
            return false;
        }
        return true;
    }
}

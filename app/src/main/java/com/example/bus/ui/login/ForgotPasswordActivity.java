package com.example.bus.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.bus.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailInput;
    private ProgressBar progressBar;
    private TextView displayUsername, displayPassword;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailInput = findViewById(R.id.email_input);
        Button resetButton = findViewById(R.id.retrieve_button);
        progressBar = findViewById(R.id.progressBar);
        displayUsername = findViewById(R.id.display_username); // Add this TextView in XML
        displayPassword = findViewById(R.id.display_password); // Add this TextView in XML

        reference = FirebaseDatabase.getInstance().getReference("users");

        resetButton.setOnClickListener(view -> retrieveAccount());
    }

    private void retrieveAccount() {
        String email = emailInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email cannot be empty!");
            emailInput.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Search for email in the users node
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                progressBar.setVisibility(View.GONE);
                boolean found = false;

                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    String storedEmail = userSnapshot.child("email").getValue(String.class);

                    if (storedEmail != null && storedEmail.equals(email)) {
                        String username = userSnapshot.child("username").getValue(String.class);
                        String password = userSnapshot.child("password").getValue(String.class);

                        // Display Username & Password
                        displayUsername.setText("Username: " + username);
                        displayPassword.setText("Password: " + password);

                        displayUsername.setVisibility(View.VISIBLE);
                        displayPassword.setVisibility(View.VISIBLE);

                        found = true;
                        break; // Stop loop after finding the user
                    }
                }

                if (!found) {
                    emailInput.setError("Email not found!");
                    emailInput.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                emailInput.setError("Error retrieving data!");
            }
        });
    }
}

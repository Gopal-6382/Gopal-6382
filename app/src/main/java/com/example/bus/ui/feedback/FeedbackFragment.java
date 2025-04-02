package com.example.bus.ui.feedback;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bus.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FeedbackFragment extends Fragment {

    private EditText etName, etEmail, etFeedback;
    private Spinner spinnerFeedbackType;
    private RatingBar ratingBar;
    private Button btnSubmit;
    private FirebaseFirestore db;

    private final String[] feedbackTypes = {"General", "Bug Report", "Feature Request", "Other"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        initializeUI(view);
        setupSpinner();
        btnSubmit.setOnClickListener(v -> submitFeedback());

        return view;
    }

    private void initializeUI(View view) {
        etName = view.findViewById(R.id.et_name);
        etEmail = view.findViewById(R.id.et_email);
        etFeedback = view.findViewById(R.id.et_feedback);
        spinnerFeedbackType = view.findViewById(R.id.spinner_feedback_type);
        ratingBar = view.findViewById(R.id.rating_bar);
        btnSubmit = view.findViewById(R.id.btn_submit);
        db = FirebaseFirestore.getInstance();
    }

    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, feedbackTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFeedbackType.setAdapter(adapter);
    }

    private void submitFeedback() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String feedback = etFeedback.getText().toString().trim();
        String feedbackType = spinnerFeedbackType.getSelectedItem().toString();
        float rating = ratingBar.getRating();

        if (!validateInputs(name, email, feedback)) {
            return;
        }

        btnSubmit.setEnabled(false); // Prevent multiple submissions

        Map<String, Object> feedbackData = new HashMap<>();
        feedbackData.put("name", name);
        feedbackData.put("email", email);
        feedbackData.put("feedback", feedback);
        feedbackData.put("feedbackType", feedbackType);
        feedbackData.put("rating", rating);
        feedbackData.put("timestamp", System.currentTimeMillis());

        db.collection("user_feedback")
                .add(feedbackData)
                .addOnSuccessListener(documentReference -> {
                    showToast("Feedback submitted successfully");
                    clearFields();
                })
                .addOnFailureListener(e -> showToast("Failed to submit feedback"))
                .addOnCompleteListener(task -> btnSubmit.setEnabled(true)); // Re-enable button
         }

    private boolean validateInputs(String name, String email, String feedback) {
        if (name.isEmpty()) {
            etName.setError("Name is required");
            etName.requestFocus();
            return false;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email is required");
            etEmail.requestFocus();
            return false;
        }

        if (feedback.isEmpty()) {
            etFeedback.setError("Feedback is required");
            etFeedback.requestFocus();
            return false;
        }
        return true;
    }

    private void clearFields() {
        etName.setText("");
        etEmail.setText("");
        etFeedback.setText("");
        ratingBar.setRating(0);
        spinnerFeedbackType.setSelection(0);
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.bus.ui.busTiming;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bus.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class Bus_timing_online extends Fragment {
    private FirebaseFirestore firestore;
    private TableLayout tableLayout;
    private TextView tvDistrict, tvTaluk, tvBusStand, tvRoute, tvBusName;
    private String busID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bus_timing_online, container, false);
        firestore = FirebaseFirestore.getInstance();

        tableLayout = view.findViewById(R.id.tableLayout);
        tvDistrict = view.findViewById(R.id.tv_district);
        tvTaluk = view.findViewById(R.id.tv_taluk);
        tvBusStand = view.findViewById(R.id.tv_bus_stand);
        tvRoute = view.findViewById(R.id.tv_route);
        tvBusName = view.findViewById(R.id.tv_bus_name);
        MaterialButton btnRefresh = view.findViewById(R.id.btn_refresh_data);

        if (getArguments() != null) {
            busID = getArguments().getString("busID");
            fetchBusDetails(busID);
        }

        btnRefresh.setOnClickListener(v -> fetchBusDetails(busID));

        return view;
    }



    private void fetchBusDetails(String busID) {
        if (busID == null) {
            showToast("Bus ID not found");
            return;
        }

        firestore.collection("buses").document(busID).get()
                .addOnSuccessListener(busDoc -> {
                    if (busDoc.exists()) {
                        tvBusName.setText("Bus Name: " + busDoc.getString("name")); // Add label
                        String routeId = busDoc.getString("route_id");
                        fetchRouteDetails(routeId);
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching bus", e));
    }



    private void fetchBusStandDetails(String busStandId) {
        if (busStandId == null) return;

        firestore.collection("bus_stands").document(busStandId).get()
                .addOnSuccessListener(busStandDoc -> {
                    if (busStandDoc.exists()) {
                        tvBusStand.setText("Bus Stand: " + busStandDoc.getString("name")); // Add label
                        String talukId = busStandDoc.getString("taluk_id");
                        fetchTalukDetails(talukId);
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching bus stand", e));
    }

    private void fetchTalukDetails(String talukId) {
        if (talukId == null) return;

        firestore.collection("taluks").document(talukId).get()
                .addOnSuccessListener(talukDoc -> {
                    if (talukDoc.exists()) {
                        tvTaluk.setText("Taluk: " + talukDoc.getString("name")); // Add label
                        fetchDistrictDetails(talukDoc.getString("district_id"));
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching taluk", e));
    }

    private void fetchDistrictDetails(String districtId) {
        if (districtId == null) return;

        firestore.collection("districts").document(districtId).get()
                .addOnSuccessListener(districtDoc -> {
                    if (districtDoc.exists()) {
                        tvDistrict.setText("District: " + districtDoc.getString("name")); // Add label
                        fetchStopDetails();
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching district", e));
    }

    private void fetchStopDetails() {
        if (tableLayout == null) {
            Log.e("UIError", "TableLayout is null, skipping removeAllViews()");
            return;
        }
        tableLayout.removeAllViews(); // Clear old data

        firestore.collection("timings")
                .whereEqualTo("bus_id", busID)
                .get()
                .addOnSuccessListener(querySnapshots -> {
                    for (QueryDocumentSnapshot stopDoc : querySnapshots) {
                        addTableRow(stopDoc.getString("stop_name"),
                                stopDoc.getString("predicted_time"),
                                stopDoc.getString("actual_time"));
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching stops", e));
    }

    private void addTableRow(String stopName, String predictedTime, String actualTime) {
        TableRow row = new TableRow(requireContext());
        row.addView(createTextView(stopName));
        row.addView(createTextView(predictedTime));
        row.addView(createTextView(actualTime));
        tableLayout.addView(row);
    }


    // Create a new function for header text
    private TextView createHeaderTextView(String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setPadding(16, 8, 16, 8);
        textView.setTextSize(18);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        textView.setTypeface(null, android.graphics.Typeface.BOLD);
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        return textView;
    }




    private TextView createTextView(String text) {
        TextView textView = new TextView(requireContext());
        textView.setText(text);
        textView.setPadding(16, 8, 16, 8);
        textView.setTextSize(16);
        textView.setTextColor(getResources().getColor(android.R.color.black));
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER); // Center text
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER); // Ensure center alignment
        return textView;
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void fetchRouteDetails(String routeId) {
        if (routeId == null) return;

        firestore.collection("routes").document(routeId).get()
                .addOnSuccessListener(routeDoc -> {
                    if (routeDoc.exists()) {
                        tvRoute.setText("Route: " + routeDoc.getString("name")); // Add label
                        String busStandId = routeDoc.getString("bus_stand_id");
                        fetchBusStandDetails(busStandId);
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching route", e));
    }

    private void logError(String message, Exception e) {
        Log.e("FirestoreError", message + ": " + e.getMessage());
        showToast("Error fetching data");
    }
}

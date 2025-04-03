package com.example.bus.ui.Search_Bus;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.bus.R;
import com.example.bus.ui.busTiming.Bus_timing_online;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class SearchOnline extends Fragment {

    private EditText etSearchBus, etSource, etDestination;
    private FirebaseFirestore firestore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_online, container, false);

        firestore = FirebaseFirestore.getInstance();
        etSearchBus = view.findViewById(R.id.et_search_bus);
        etSource = view.findViewById(R.id.et_source);
        etDestination = view.findViewById(R.id.et_destination);
        Button btnSearchBus = view.findViewById(R.id.btn_search_bus);
        Button btnFindBuses = view.findViewById(R.id.btn_find_buses);

        btnSearchBus.setOnClickListener(v -> searchBusOnline());
        btnFindBuses.setOnClickListener(v -> searchBySourceDestinationOnline());

        return view;
    }

    private void searchBusOnline() {
        String busName = etSearchBus.getText().toString().trim().toLowerCase();
        if (busName.isEmpty()) {
            showToast("Enter a bus name");
            return;
        }

        firestore.collection("buses")
                .whereEqualTo("name", busName)
                .limit(1)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            openBusTimingFragment(document.getId());
                            return;
                        }
                    } else {
                        showToast("No matching buses found");
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching bus", e));
    }

    private void searchBySourceDestinationOnline() {
        String source = etSource.getText().toString().trim().toLowerCase();
        String destination = etDestination.getText().toString().trim().toLowerCase();

        if (source.isEmpty() || destination.isEmpty()) {
            showToast("Enter source and destination");
            return;
        }

        firestore.collection("routes")
                .whereEqualTo("source", source)
                .whereEqualTo("destination", destination)
                .limit(1)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            fetchBusForRoute(document.getId());
                            return;
                        }
                    } else {
                        showToast("No buses found for this route");
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching routes", e));
    }

    private void fetchBusForRoute(String routeId) {
        firestore.collection("buses")
                .whereEqualTo("route_id", routeId)
                .limit(1)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            openBusTimingFragment(document.getId());
                            return;
                        }
                    } else {
                        showToast("No bus found for this route");
                    }
                })
                .addOnFailureListener(e -> logError("Error fetching buses", e));
    }

    private void openBusTimingFragment(String busID) {
        if (busID == null || busID.isEmpty()) {
            showToast("Bus ID is missing");
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putString("busID", busID);
        Bus_timing_online fragment = new Bus_timing_online();
        fragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void logError(String message, Exception e) {
        Log.e("FirestoreError", message + ": " + e.getMessage());
        showToast("Error fetching data");
    }
}

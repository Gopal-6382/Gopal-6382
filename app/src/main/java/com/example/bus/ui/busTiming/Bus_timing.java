package com.example.bus.ui.busTiming;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.example.bus.R;
import com.example.bus.ui.dbs.AppDatabase;
import com.example.bus.ui.dbs.DaoInterfaces;
import com.example.bus.ui.dbs.TimingEntity;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bus_timing extends Fragment {

    private TableLayout tableLayout;
    private TextView tvDistrict, tvTaluk, tvBusStand, tvRoute, tvBusName;
    private Button btnRefresh;
    private DaoInterfaces dao;
    private String busID;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bus_timing, container, false);

        // Initialize Database
        dao = AppDatabase.getInstance(requireContext()).daoInterfaces();

        // Initialize UI Elements
        tableLayout = view.findViewById(R.id.tableLayout);
        tvDistrict = view.findViewById(R.id.tv_district);
        tvTaluk = view.findViewById(R.id.tv_taluk);
        tvBusStand = view.findViewById(R.id.tv_bus_stand);
        tvRoute = view.findViewById(R.id.tv_route);
        tvBusName = view.findViewById(R.id.tv_bus_name);
        btnRefresh = view.findViewById(R.id.btn_refresh_data);

        if (getArguments() != null) {
            busID = getArguments().getString("busID");
            if (busID != null) {
                loadBusDetails();
                loadStops();
            }
        }

        // Refresh Button Click Listener
        btnRefresh.setOnClickListener(v -> {
            if (busID != null) {
                loadBusDetails();
                loadStops();
            }
        });

        return view;
    }

    /**
     * Loads bus details including district, taluk, bus stand, route, and bus name.
     */
    private void loadBusDetails() {
        executorService.execute(() -> {
            String district = dao.getDistrictByBusID(busID);
            String taluk = dao.getTalukByBusID(busID);
            String busStand = dao.getBusStandByBusID(busID);
            String route = dao.getRouteByBusID(busID);
            String busName = dao.getBusNameByID(busID);

            requireActivity().runOnUiThread(() -> {
                tvDistrict.setText("District: " + (district != null ? district : "N/A"));
                tvTaluk.setText("Taluk: " + (taluk != null ? taluk : "N/A"));
                tvBusStand.setText("Bus Stand: " + (busStand != null ? busStand : "N/A"));
                tvRoute.setText("Route: " + (route != null ? route : "N/A"));
                tvBusName.setText("Bus Name: " + (busName != null ? busName : "N/A"));
            });
        });
    }

    /**
     * Loads bus stops and populates the table layout dynamically.
     */
    private void loadStops() {
        executorService.execute(() -> {
            List<TimingEntity> stops = dao.getTimingsByBus(busID);

            requireActivity().runOnUiThread(() -> {
                tableLayout.removeAllViews(); // Clear previous data

                // Add rows for each stop
                for (TimingEntity stop : stops) {
                    addStopRow(stop);
                }
            });
        });
    }

    /**
     * Adds a row dynamically using a LinearLayout to match the XML structure.
     */
    private void addStopRow(TimingEntity stop) {
        LinearLayout rowLayout = new LinearLayout(requireContext());
        rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        rowLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout.setPadding(8, 8, 8, 8);
        rowLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white));

        // Add Stop Name (Align left)
        addTextView(rowLayout, stop.getStopName(), true);

        // Add Predicted Time (Centered)
        addTextView(rowLayout, stop.getPredictedTime(), false);

        // Add Actual Time (Centered)
        addTextView(rowLayout, stop.getActualTime(), false);

        tableLayout.addView(rowLayout);
    }

    /**
     * Helper method to create and add a styled TextView dynamically.
     */
    private void addTextView(LinearLayout rowLayout, String text, boolean isStopName) {
        TextView textView = new TextView(requireContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0, // Use weight-based width
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1  // Equal weight for all columns
        );
        textView.setLayoutParams(params);
        textView.setText(text != null ? text : "N/A");
        textView.setTextSize(16);
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));

        // Adjust alignment: Move Stop Name slightly left, others remain centered
        if (isStopName) {
            textView.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            textView.setPadding(21, 0, 0, 0); // Extra left padding for Stop Name
        } else {
            textView.setGravity(Gravity.CENTER);
        }

        rowLayout.addView(textView);
    }
}

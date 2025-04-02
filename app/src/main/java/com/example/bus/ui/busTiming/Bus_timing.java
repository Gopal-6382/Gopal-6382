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
import androidx.lifecycle.ViewModelProvider;
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
    private DaoInterfaces dao;
    private String busID;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private BusTimingViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bus_timing, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(BusTimingViewModel.class);

        dao = AppDatabase.getInstance(requireContext()).daoInterfaces();
        tableLayout = view.findViewById(R.id.tableLayout);
        tvDistrict = view.findViewById(R.id.tv_district);
        tvTaluk = view.findViewById(R.id.tv_taluk);
        tvBusStand = view.findViewById(R.id.tv_bus_stand);
        tvRoute = view.findViewById(R.id.tv_route);
        tvBusName = view.findViewById(R.id.tv_bus_name);
        Button btnRefresh = view.findViewById(R.id.btn_refresh_data);

        if (getArguments() != null) {
            busID = getArguments().getString("busID");
            if (busID != null) {
                loadBusDetails();
                loadStops();
            }
        }

        btnRefresh.setOnClickListener(v -> {
            if (busID != null) {
                loadBusDetails();
                loadStops();
            }
        });

        observeViewModel();

        return view;
    }

    private void observeViewModel() {
        viewModel.getDistrict().observe(getViewLifecycleOwner(), district -> tvDistrict.setText("District: " + (district != null ? district : "N/A")));
        viewModel.getTaluk().observe(getViewLifecycleOwner(), taluk -> tvTaluk.setText("Taluk: " + (taluk != null ? taluk : "N/A")));
        viewModel.getBusStand().observe(getViewLifecycleOwner(), busStand -> tvBusStand.setText("Bus Stand: " + (busStand != null ? busStand : "N/A")));
        viewModel.getRoute().observe(getViewLifecycleOwner(), route -> tvRoute.setText("Route: " + (route != null ? route : "N/A")));
        viewModel.getBusName().observe(getViewLifecycleOwner(), busName -> tvBusName.setText("Bus Name: " + (busName != null ? busName : "N/A")));

        viewModel.getStops().observe(getViewLifecycleOwner(), stops -> {
            if (stops != null) {
                tableLayout.removeAllViews();
                for (TimingEntity stop : stops) {
                    addStopRow(stop);
                }
            }
        });
    }

    private void loadBusDetails() {
        executorService.execute(() -> {
            String district = dao.getDistrictByBusID(busID);
            String taluk = dao.getTalukByBusID(busID);
            String busStand = dao.getBusStandByBusID(busID);
            String route = dao.getRouteByBusID(busID);
            String busName = dao.getBusNameByID(busID);

            requireActivity().runOnUiThread(() -> {
                viewModel.setBusDetails(district, taluk, busStand, route, busName);
            });
        });
    }

    private void loadStops() {
        executorService.execute(() -> {
            List<TimingEntity> stops = dao.getTimingsByBus(busID);
            requireActivity().runOnUiThread(() -> {
                viewModel.setStops(stops);
            });
        });
    }

    private void addStopRow(TimingEntity stop) {
        LinearLayout rowLayout = new LinearLayout(requireContext());
        rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        rowLayout.setOrientation(LinearLayout.HORIZONTAL);
        rowLayout.setPadding(8, 8, 8, 8);
        rowLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white));

        addTextView(rowLayout, stop.getStopName(), true);
        addTextView(rowLayout, stop.getPredictedTime(), false);
        addTextView(rowLayout, stop.getActualTime(), false);

        tableLayout.addView(rowLayout);
    }

    private void addTextView(LinearLayout rowLayout, String text, boolean isStopName) {
        TextView textView = new TextView(requireContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        textView.setLayoutParams(params);
        textView.setText(text != null ? text : "N/A");
        textView.setTextSize(16);
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));

        if (isStopName) {
            textView.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            textView.setPadding(21, 0, 0, 0);
        } else {
            textView.setGravity(Gravity.CENTER);
        }

        rowLayout.addView(textView);
    }
}

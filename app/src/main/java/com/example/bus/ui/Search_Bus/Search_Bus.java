package com.example.bus.ui.Search_Bus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.bus.R;
import com.example.bus.ui.busTiming.Bus_timing;
import com.example.bus.ui.dbs.AppDatabase;
import com.example.bus.ui.dbs.BusEntity;
import com.example.bus.ui.dbs.DaoInterfaces;
import com.example.bus.ui.dbs.RouteEntity;
import com.example.bus.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Search_Bus extends Fragment {

    private EditText etSearchBus, etSource, etDestination;
    private Spinner spinnerDistrict, spinnerTaluk, spinnerBusStand, spinnerRoute, spinnerBus;
    private Button btnFindBuses;
    private DaoInterfaces dao;
    private AppDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_bus, container, false);
        db = AppDatabase.getInstance(requireContext());
        dao = db.daoInterfaces();

        etSearchBus = view.findViewById(R.id.et_search_bus);
        etSource = view.findViewById(R.id.et_source);
        etDestination = view.findViewById(R.id.et_destination);

        spinnerDistrict = view.findViewById(R.id.spinner_district);
        spinnerTaluk = view.findViewById(R.id.spinner_taluk);
        spinnerBusStand = view.findViewById(R.id.spinner_bus_stand);
        spinnerRoute = view.findViewById(R.id.spinner_route);
        spinnerBus = view.findViewById(R.id.spinner_bus);

        Button btnSearchBus = view.findViewById(R.id.btn_search_bus);
        btnFindBuses = view.findViewById(R.id.btn_find_buses);
        Button btnShowBusDetails = view.findViewById(R.id.btn_show_bus_details);

        loadDistricts();

        btnSearchBus.setOnClickListener(v -> searchBusByName());
        btnFindBuses.setOnClickListener(v -> searchBySourceDestination());
        btnShowBusDetails.setOnClickListener(v -> goToBusTiming());

        return view;
    }

    // ✅ Load Districts
    private void loadDistricts() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<String> districts = dao.getAllDistrictNames();

            requireActivity().runOnUiThread(() -> {
                List<String> districtOptions = new ArrayList<>();
                districtOptions.add("Select District");
                districtOptions.addAll(districts);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, districtOptions);
                spinnerDistrict.setAdapter(adapter);

                spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            clearSpinnersAfterDistrict();
                            loadTaluks(districtOptions.get(position));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            });
        });
    }

    // ✅ Load Taluks
    private void loadTaluks(String districtName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<String> taluks = dao.getTalukNamesByDistrict(districtName);

            requireActivity().runOnUiThread(() -> {
                List<String> talukOptions = new ArrayList<>();
                talukOptions.add("Select Taluk");
                talukOptions.addAll(taluks);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, talukOptions);
                spinnerTaluk.setAdapter(adapter);

                spinnerTaluk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            clearSpinnersAfterTaluk();
                            loadBusStands(talukOptions.get(position));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            });
        });
    }

    // ✅ Load Bus Stands
    private void loadBusStands(String talukName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<String> busStands = dao.getBusStandNamesByTaluk(talukName);

            requireActivity().runOnUiThread(() -> {
                List<String> busStandOptions = new ArrayList<>();
                busStandOptions.add("Select Bus Stand");
                busStandOptions.addAll(busStands);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, busStandOptions);
                spinnerBusStand.setAdapter(adapter);

                spinnerBusStand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            clearSpinnersAfterBusStand();
                            loadRoutes(busStandOptions.get(position));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            });
        });
    }

    // ✅ Load Routes
    private void loadRoutes(String busStandName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<String> routes = dao.getRouteNamesByBusStand(busStandName);

            requireActivity().runOnUiThread(() -> {
                List<String> routeOptions = new ArrayList<>();
                routeOptions.add("Select Route");
                routeOptions.addAll(routes);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, routeOptions);
                spinnerRoute.setAdapter(adapter);

                spinnerRoute.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position > 0) {
                            loadBuses(routeOptions.get(position));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            });
        });
    }

    // ✅ Load Buses
    private void loadBuses(String routeName) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<String> buses = dao.getBusNamesByRoute(routeName);

            requireActivity().runOnUiThread(() -> {
                List<String> busOptions = new ArrayList<>();
                busOptions.add("Select Bus");
                busOptions.addAll(buses);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, busOptions);
                spinnerBus.setAdapter(adapter);
            });
        });
    }

    private void clearSpinnersAfterDistrict() {
        spinnerTaluk.setAdapter(null);
        spinnerBusStand.setAdapter(null);
        spinnerRoute.setAdapter(null);
        spinnerBus.setAdapter(null);
    }

    private void clearSpinnersAfterTaluk() {
        spinnerBusStand.setAdapter(null);
        spinnerRoute.setAdapter(null);
        spinnerBus.setAdapter(null);
    }

    private void clearSpinnersAfterBusStand() {
        spinnerRoute.setAdapter(null);
        spinnerBus.setAdapter(null);
    }

    // ✅ Open Bus Timing from Spinner Button
    private void goToBusTiming() {
        if (spinnerBus.getSelectedItem() == null ||
                spinnerBus.getSelectedItem().toString().equals("Select Bus")) {
            Toast.makeText(requireContext(), "Please select a valid bus!", Toast.LENGTH_SHORT).show();
            return;
        }

        String selectedBusName = spinnerBus.getSelectedItem().toString();

        Executors.newSingleThreadExecutor().execute(() -> {
            List<BusEntity> buses = dao.getBusesByName(selectedBusName);

            if (!buses.isEmpty()) {
                requireActivity().runOnUiThread(() -> openBusTimingFragment(buses.get(0).busID));
            } else {
                requireActivity().runOnUiThread(() -> Toast.makeText(requireContext(), "Bus not found!", Toast.LENGTH_SHORT).show());
            }
        });
    }

    private void openBusTimingFragment(String busID) {
        Bundle bundle = new Bundle();
        bundle.putString("busID", busID);
        Bus_timing fragment = new Bus_timing();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, fragment)
                .addToBackStack(null)
                .commit();
    }
    private void searchBusByName() {
        String busName = etSearchBus.getText().toString().trim();

        if (busName.isEmpty()) {
            requireActivity().runOnUiThread(() ->
                    Toast.makeText(requireContext(), "Enter a bus name", Toast.LENGTH_SHORT).show()
            );
            return;
        }

        Executors.newSingleThreadExecutor().execute(() -> {
            List<BusEntity> buses = dao.getBusesByName("%" + busName + "%");

            if (!buses.isEmpty()) {
                BusEntity firstBus = buses.get(0);
                RouteEntity route = dao.getRouteByID(firstBus.routeID);

                String source = (route != null) ? route.source : "Unknown";
                String destination = (route != null) ? route.destination : "Unknown";
                String busStandID = dao.getBusStandByRouteID(firstBus.routeID);
                if (busStandID == null) busStandID = "DEFAULT_BS";

                if (route != null) {
                    int updatedRows = dao.incrementSearchCount(route.routeID);
                    if (updatedRows == 0) {
                        dao.insertRoute(new RouteEntity(firstBus.routeID, busStandID, firstBus.name, source, destination, 1));
                    }
                } else {
                    dao.insertRoute(new RouteEntity(firstBus.routeID, busStandID, firstBus.name, source, destination, 1));
                }

                requireActivity().runOnUiThread(() -> {
                    openBusTimingFragment(firstBus.busID);
                    Fragment homeFragment = requireActivity()
                            .getSupportFragmentManager()
                            .findFragmentByTag("HOME_FRAGMENT");

                    if (homeFragment instanceof HomeFragment) {
                        ((HomeFragment) homeFragment).updateSearchResults();
                    } else {
                        System.out.println("HomeFragment not found, skipping updateSearchResults"); // ✅ Prevents null crashes
                    }
                });


            } else {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "No matching buses found", Toast.LENGTH_SHORT).show()
                );
            }
        });
    }

    private void searchBySourceDestination() {
        String source = etSource.getText().toString().trim();
        String destination = etDestination.getText().toString().trim();

        if (source.isEmpty() || destination.isEmpty()) {
            requireActivity().runOnUiThread(() ->
                    Toast.makeText(requireContext(), "Enter source and destination", Toast.LENGTH_SHORT).show()
            );
            return;
        }



        Executors.newSingleThreadExecutor().execute(() -> {
            List<BusEntity> buses = dao.getBusesByRouteName("%" + source + "%", "%" + destination + "%");

            if (!buses.isEmpty()) {
                BusEntity firstBus = buses.get(0);
                RouteEntity route = dao.getRouteByID(firstBus.routeID);

                String busStandID = dao.getBusStandByRouteID(firstBus.routeID);
                if (busStandID == null) busStandID = "DEFAULT_BS";

                if (route != null) {
                    int updatedRows = dao.incrementSearchCount(route.routeID);
                    if (updatedRows == 0) {
                        dao.insertRoute(new RouteEntity(firstBus.routeID, busStandID, firstBus.name, source, destination, 1));
                    }
                } else {
                    dao.insertRoute(new RouteEntity(firstBus.routeID, busStandID, firstBus.name, source, destination, 1));
                }

                requireActivity().runOnUiThread(() -> {
                    openBusTimingFragment(firstBus.busID);

                    // ✅ Safe way to update HomeFragment
                    Fragment homeFragment = requireActivity()
                            .getSupportFragmentManager()
                            .findFragmentByTag("HOME_FRAGMENT");

                    if (homeFragment instanceof HomeFragment) {
                        ((HomeFragment) homeFragment).updateSearchResults();
                    }
                });

            } else {
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(), "No buses found for this route", Toast.LENGTH_SHORT).show()
                );
            }
        });
    }


}

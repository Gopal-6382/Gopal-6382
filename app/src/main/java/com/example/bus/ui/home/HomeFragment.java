package com.example.bus.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bus.R;
import com.example.bus.ui.adapters.SearchHistoryAdapter;
import com.example.bus.ui.dbs.AppDatabase;
import com.example.bus.ui.dbs.RouteEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class HomeFragment extends Fragment {
    private AppDatabase db;
    private RecyclerView recyclerView;
    private SearchHistoryAdapter adapter;
    private TextView textNoHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        db = AppDatabase.getInstance(requireContext());
        recyclerView = view.findViewById(R.id.recycler_search_history);
        textNoHistory = view.findViewById(R.id.text_no_search_history);

        adapter = new SearchHistoryAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        updateSearchResults();
        return view;
    }

    public void updateSearchResults() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<RouteEntity> searchResults = db.daoInterfaces().getOnlySearchedRoutes();

            requireActivity().runOnUiThread(() -> {
                if (!isAdded()) return;

                if (!searchResults.isEmpty()) {
                    textNoHistory.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    adapter.updateSearchHistory(searchResults);
                } else {
                    textNoHistory.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            });
        });
    }
}

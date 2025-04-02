package com.example.bus.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bus.R;
import com.example.bus.ui.dbs.RouteEntity;
import java.util.List;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder> {
    private final List<RouteEntity> searchHistoryList;

    public SearchHistoryAdapter(List<RouteEntity> searchHistoryList) {
        this.searchHistoryList = searchHistoryList;
    }

    public void updateSearchHistory(List<RouteEntity> newHistory) {
        this.searchHistoryList.clear();
        this.searchHistoryList.addAll(newHistory);
        notifyItemRangeChanged(0, searchHistoryList.size()); // ✅ More efficient update
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RouteEntity item = searchHistoryList.get(position);
        holder.tvBusName.setText(item.name);
        holder.tvSourceDestination.setText(item.source + " ➝ " + item.destination);
        holder.tvSearchCount.setText("Searched " + item.searchCount + " times");
    }

    @Override
    public int getItemCount() {
        return searchHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBusName, tvSourceDestination, tvSearchCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusName = itemView.findViewById(R.id.tv_bus_name);
            tvSourceDestination = itemView.findViewById(R.id.tv_source_destination);
            tvSearchCount = itemView.findViewById(R.id.tv_search_count);
        }
    }
}

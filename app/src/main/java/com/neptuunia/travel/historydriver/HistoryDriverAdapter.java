package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.travel.databinding.ItemHistoryDriverBinding;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Rengar
 * @version HistoryDriverAdapter, v 0.0.1 29/07/20 22.55 by Rengar
 */
public class HistoryDriverAdapter extends RecyclerView.Adapter<HistoryDriverAdapter.HistoryDriverViewHolder> {

    private List<HistoryDriverResponse> historyDriverResponses = new ArrayList<>();

    private HistoryDriverViewHolder historyDriverViewHolder;

    @Inject
    public HistoryDriverAdapter(HistoryDriverViewHolder historyDriverViewHolder) {
        this.historyDriverViewHolder = historyDriverViewHolder;
    }

    @NonNull
    @Override
    public HistoryDriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return historyDriverViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryDriverViewHolder holder, int position) {
        holder.bind(historyDriverResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return historyDriverResponses.size();
    }

    public void submitList(List<HistoryDriverResponse> historyDriverResponses) {
        if (historyDriverResponses != null) {
            this.historyDriverResponses.addAll(historyDriverResponses);
            notifyDataSetChanged();
        }
    }

    static class HistoryDriverViewHolder extends RecyclerView.ViewHolder {

        private ItemHistoryDriverBinding itemHistoryDriverBinding;

        @Inject
        public HistoryDriverViewHolder(
            @NonNull View itemView,
            ItemHistoryDriverBinding itemHistoryDriverBinding
        ) {
            super(itemView);
            this.itemHistoryDriverBinding = itemHistoryDriverBinding;
        }

        public void bind(HistoryDriverResponse historyDriverResponse) {
            itemHistoryDriverBinding.actvOrderCode.setText(
                String.valueOf(historyDriverResponse.getOrderCode())
            );
            itemHistoryDriverBinding.actvSeatBooked.setText(historyDriverResponse.getSeatBooked());
            itemHistoryDriverBinding.actvUserName.setText(historyDriverResponse.getUserName());
        }
    }
}

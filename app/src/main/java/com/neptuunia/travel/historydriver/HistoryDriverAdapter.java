package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.travel.databinding.ItemHistoryDriverBinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HistoryDriverAdapter, v 0.0.1 29/07/20 22.55 by Putra Nugraha
 */
public class HistoryDriverAdapter extends RecyclerView.Adapter<HistoryDriverAdapter.HistoryDriverViewHolder> {

    private List<HistoryDriverResponse> historyDriverResponses = new ArrayList<>();

    @NonNull
    @Override
    public HistoryDriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryDriverViewHolder(
            ItemHistoryDriverBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
            )
        );
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

        private final ItemHistoryDriverBinding itemHistoryDriverBinding;

        public HistoryDriverViewHolder(@NonNull ItemHistoryDriverBinding itemHistoryDriverBinding) {
            super(itemHistoryDriverBinding.getRoot());
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

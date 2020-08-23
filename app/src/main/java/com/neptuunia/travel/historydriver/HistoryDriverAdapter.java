package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.databinding.ItemHistoryDriverBinding;
import com.neptuunia.travel.utils.StatusUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryDriverAdapter extends RecyclerView.Adapter<HistoryDriverAdapter.HistoryDriverViewHolder> {

    private List<HistoryDriverResponse> historyDriverResponses = new ArrayList<>();

    private final Consumer<HistoryDriverResponse> historyDriverResponseConsumer;

    public HistoryDriverAdapter(
        @NonNull Consumer<HistoryDriverResponse> historyDriverResponseConsumer
    ) {
        this.historyDriverResponseConsumer = historyDriverResponseConsumer;
    }

    @NonNull
    @Override
    public HistoryDriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryDriverViewHolder(
            ItemHistoryDriverBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
            ),
            historyDriverResponseConsumer
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
            this.historyDriverResponses.clear();
            this.historyDriverResponses.addAll(historyDriverResponses);
            notifyDataSetChanged();
        }
    }

    static class HistoryDriverViewHolder extends RecyclerView.ViewHolder {

        private ItemHistoryDriverBinding itemHistoryDriverBinding;

        private Consumer<HistoryDriverResponse> historyDriverResponseConsumer;

        private View rootView;

        public HistoryDriverViewHolder(
            ItemHistoryDriverBinding itemHistoryDriverBinding,
            Consumer<HistoryDriverResponse> historyDriverResponseConsumer
        ) {
            super(itemHistoryDriverBinding.getRoot());
            this.rootView = itemHistoryDriverBinding.getRoot();
            this.itemHistoryDriverBinding = itemHistoryDriverBinding;
            this.historyDriverResponseConsumer = historyDriverResponseConsumer;
        }

        public void bind(HistoryDriverResponse historyDriverResponse) {
            Context context = itemHistoryDriverBinding.getRoot().getContext();

            rootView.setOnClickListener(view ->
                historyDriverResponseConsumer.accept(historyDriverResponse)
            );
            itemHistoryDriverBinding.actvOrderCode.setText(historyDriverResponse.getOrderCode());
            itemHistoryDriverBinding.actvSeatBooked.setText(
                String.format(
                    context.getString(R.string.amount_seat_booked),
                    historyDriverResponse.getSeatBooked()
                )
            );
            itemHistoryDriverBinding.actvUserName.setText(historyDriverResponse.getUserName());
            itemHistoryDriverBinding.actvStatus.setText(historyDriverResponse.getStatus());
            itemHistoryDriverBinding.actvStatus.setBackgroundResource(
                StatusUtils.getBackgroundColor(historyDriverResponse.getStatus())
            );
            itemHistoryDriverBinding.actvStatus.setTextColor(
                StatusUtils.getTextColor(context, historyDriverResponse.getStatus())
            );
        }
    }
}

package com.neptuunia.travel.historyuser;

import com.bumptech.glide.Glide;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.databinding.ItemHistoryUserBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryUserAdapter extends RecyclerView.Adapter<HistoryUserAdapter.HistoryUserViewHolder> {

    private List<HistoryUserResponse> historyUserResponses = new ArrayList<>();

    private final Consumer<HistoryUserResponse> historyUserResponseConsumer;

    @Inject
    public HistoryUserAdapter(Consumer<HistoryUserResponse> historyUserResponseConsumer) {
        this.historyUserResponseConsumer = historyUserResponseConsumer;
    }

    @NonNull
    @Override
    public HistoryUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryUserAdapter.HistoryUserViewHolder(
            ItemHistoryUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
            ),
            historyUserResponseConsumer
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryUserViewHolder holder, int position) {
        holder.bind(historyUserResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return historyUserResponses.size();
    }

    public void submitList(List<HistoryUserResponse> historyUserResponses) {
        if (historyUserResponses != null) {
            this.historyUserResponses.addAll(historyUserResponses);
            notifyDataSetChanged();
        }
    }

    static class HistoryUserViewHolder extends RecyclerView.ViewHolder {

        private ItemHistoryUserBinding binding;

        private Consumer<HistoryUserResponse> historyUserResponseConsumer;

        private View rootView;

        public HistoryUserViewHolder(
            ItemHistoryUserBinding itemHistoryUserBinding,
            Consumer<HistoryUserResponse> historyUserResponseConsumer
        ) {
            super(itemHistoryUserBinding.getRoot());
            this.rootView = itemHistoryUserBinding.getRoot();
            this.binding = itemHistoryUserBinding;
            this.historyUserResponseConsumer = historyUserResponseConsumer;
        }

        public void bind(HistoryUserResponse historyUserResponse) {
            rootView.setOnClickListener(view ->
                historyUserResponseConsumer.accept(historyUserResponse)
            );
            Glide.with(rootView)
                .load(historyUserResponse.getPhotoUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvOrderCode.setText(historyUserResponse.getOrderCode());
            binding.actvTotalPrice.setText(String.valueOf(historyUserResponse.getTotalPrice()));
            binding.actvDriverDepartDate.setText(historyUserResponse.getDepartureDate());
        }
    }
}

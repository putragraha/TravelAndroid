package com.neptuunia.travel.historyuser;

import com.bumptech.glide.Glide;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.databinding.ItemHistoryUserBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.ImageUtils;
import com.neptuunia.travel.utils.NumberUtils;
import com.neptuunia.travel.utils.StatusUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
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
            this.historyUserResponses.clear();
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
            Context context = rootView.getContext();
            Date date = new Date(Long.parseLong(historyUserResponse.getDatetime()));

            rootView.setOnClickListener(view ->
                historyUserResponseConsumer.accept(historyUserResponse)
            );
            Glide.with(rootView)
                .load(ImageUtils.getDriverFullUrl(historyUserResponse.getPhotoName()))
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvOrderCode.setText(historyUserResponse.getOrderCode());
            binding.actvRoute.setText(
                getRouteMessage(context, historyUserResponse)
            );
            binding.actvTotalPrice.setText(
                NumberUtils.toRupiah(historyUserResponse.getTotalPrice())
            );
            binding.actvDriverDepartDate.setText(DateTimeUtils.getFormattedDatetime(date));
            binding.actvStatus.setText(historyUserResponse.getStatus());
            binding.actvStatus.setBackgroundResource(
                StatusUtils.getBackgroundColor(historyUserResponse.getStatus())
            );
            binding.actvStatus.setTextColor(
                StatusUtils.getTextColor(context, historyUserResponse.getStatus())
            );
        }

        private String getRouteMessage(
            Context context,
            HistoryUserResponse historyUserResponse
        ) {
            return String.format(
                context.getString(R.string.route_message),
                historyUserResponse.getDeparture(),
                historyUserResponse.getArrival()
            );
        }
    }
}

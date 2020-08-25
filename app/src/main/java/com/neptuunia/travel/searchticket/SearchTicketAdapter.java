package com.neptuunia.travel.searchticket;

import com.bumptech.glide.Glide;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.databinding.ItemSearchTicketBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.ImageUtils;
import com.neptuunia.travel.utils.NumberUtils;

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

public class SearchTicketAdapter extends RecyclerView.Adapter<SearchTicketAdapter.SearchTicketViewHolder> {

    private List<TicketResponse> ticketResponses = new ArrayList<>();

    private final Consumer<TicketResponse> ticketResponseConsumer;

    @Inject
    public SearchTicketAdapter(Consumer<TicketResponse> ticketResponseConsumer) {
        this.ticketResponseConsumer = ticketResponseConsumer;
    }

    @NonNull
    @Override
    public SearchTicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchTicketViewHolder(
            ItemSearchTicketBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
            ),
            ticketResponseConsumer
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SearchTicketViewHolder holder, int position) {
        holder.bind(ticketResponses.get(position));
    }

    @Override
    public int getItemCount() {
        return ticketResponses.size();
    }

    public void submitList(List<TicketResponse> ticketResponses) {
        if (ticketResponses != null) {
            this.ticketResponses.clear();
            this.ticketResponses.addAll(ticketResponses);
            notifyDataSetChanged();
        }
    }

    static class SearchTicketViewHolder extends RecyclerView.ViewHolder {

        private ItemSearchTicketBinding binding;

        private Consumer<TicketResponse> ticketResponseConsumer;

        private View rootView;

        public SearchTicketViewHolder(
            ItemSearchTicketBinding binding,
            Consumer<TicketResponse> ticketResponseConsumer
        ) {
            super(binding.getRoot());
            this.rootView = binding.getRoot();
            this.binding = binding;
            this.ticketResponseConsumer = ticketResponseConsumer;
        }

        public void bind(TicketResponse ticketResponse) {
            rootView.setOnClickListener(view -> ticketResponseConsumer.accept(ticketResponse));
            Glide.with(rootView)
                .load(ImageUtils.getDriverFullUrl(ticketResponse.getPhotoName()))
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvDriverName.setText(ticketResponse.getDriverName());
            binding.actvSeatAvailable.setText(getAvailableSeatLabel(ticketResponse));
            binding.actvDriverDepartDateTime.setText(getDatetimeLabel(ticketResponse.getDatetime()));
            binding.actvTicketPrice.setText(getPriceLabel(ticketResponse.getPrice()));
        }

        private String getAvailableSeatLabel(TicketResponse ticketResponse) {
            Context context = rootView.getContext();

            return String.format(
                context.getString(R.string.amount_of_seat_available),
                ticketResponse.getSeatAvailable(),
                ticketResponse.getSeatAmount()
            );
        }

        private String getDatetimeLabel(String datetime) {
            return DateTimeUtils.getFormattedDatetime(
                new Date(Long.parseLong(datetime))
            );
        }

        private String getPriceLabel(String price) {
            return NumberUtils.toRupiah(Integer.parseInt(price));
        }
    }
}

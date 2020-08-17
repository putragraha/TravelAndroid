package com.neptuunia.travel.orderticket;

import com.bumptech.glide.Glide;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.databinding.ActivityOrderTicketBinding;

import android.os.Bundle;
import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderTicketActivity, v 0.0.1 17/08/20 10.40 by Putra Nugraha
 */
public class OrderTicketActivity extends BaseActivity {

    private ActivityOrderTicketBinding binding;

    @Override
    public View getView() {
        binding = ActivityOrderTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            setupForm(bundle);
        }
    }

    private void setupForm(Bundle bundle) {
        TicketResponse ticketResponse = bundle.getParcelable(Variable.TICKET_RESPONSE_DATA);

        if (ticketResponse != null) {
            Glide.with(this)
                .load(ticketResponse.getPhotoUrl())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvDriverName.setText(ticketResponse.getDriverName());
            binding.actvCar.setText(ticketResponse.getCar());
            binding.actvDepartureTime.setText(String.valueOf(ticketResponse.getDatetime()));
            binding.actvSeatAvailable.setText(String.valueOf(ticketResponse.getSeatAvailable()));
            binding.actvPrice.setText(String.valueOf(ticketResponse.getTicketPrice()));
        }
    }
}
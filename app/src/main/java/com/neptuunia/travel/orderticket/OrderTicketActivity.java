package com.neptuunia.travel.orderticket;

import com.bumptech.glide.Glide;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderTicketBinding;

import android.os.Bundle;
import android.view.View;

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
        TicketResponse ticketResponse = bundle.getParcelable(Constant.TICKET_RESPONSE_DATA);

        if (ticketResponse != null) {
            Glide.with(this)
                .load(ticketResponse.getPhotoName())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvDriverName.setText(ticketResponse.getDriverName());
            binding.actvGroup.setText(ticketResponse.getGroup());
            binding.actvCar.setText(ticketResponse.getCar());
            binding.actvDepartureTime.setText(ticketResponse.getDatetime());
            binding.actvArmadaClass.setText(ticketResponse.getArmadaClass());
            binding.actvSeatAvailable.setText(ticketResponse.getSeatAvailable());
            binding.actvPrice.setText(ticketResponse.getPrice());
            binding.actvPhoneNumber.setText(ticketResponse.getDriverPhoneNumber());
        }
    }
}

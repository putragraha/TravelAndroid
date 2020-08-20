package com.neptuunia.travel.orderticket;

import com.bumptech.glide.Glide;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderTicketBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.ImageUtils;
import com.neptuunia.travel.utils.NumberUtils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

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
                .load(ImageUtils.getFullUrl(ticketResponse.getPhotoName()))
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.acivDriverPicture);
            binding.actvDriverName.setText(ticketResponse.getDriverName());
            binding.actvGroup.setText(ticketResponse.getGroup());
            binding.actvCar.setText(ticketResponse.getCar());
            binding.actvDepartureTime.setText(getDatetimeLabel(ticketResponse.getDatetime()));
            binding.actvArmadaClass.setText(ticketResponse.getArmadaClass());
            binding.actvSeatAvailable.setText(getAvailableSeatLabel(ticketResponse));
            binding.actvPrice.setText(getPriceLabel(ticketResponse.getPrice()));
            binding.actvPhoneNumber.setText(ticketResponse.getDriverPhoneNumber());
        }
    }

    private String getDatetimeLabel(String datetime) {
        return DateTimeUtils.getFormattedDatetime(
            new Date(Long.parseLong(datetime))
        );
    }

    private String getAvailableSeatLabel(TicketResponse ticketResponse) {
        Context context = binding.getRoot().getContext();

        return String.format(
            context.getString(R.string.amount_of_seat_available),
            ticketResponse.getSeatAvailable(),
            ticketResponse.getSeatAmount()
        );
    }

    private String getPriceLabel(String price) {
        return NumberUtils.toRupiah(
            Integer.parseInt(price)
        );
    }
}

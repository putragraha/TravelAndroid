package com.neptuunia.travel.orderticket;

import com.bumptech.glide.Glide;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderTicketBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.ImageUtils;
import com.neptuunia.travel.utils.NumberUtils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OrderTicketActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityOrderTicketBinding binding;

    private OrderTicketViewModel orderTicketViewModel;

    private TicketResponse ticketResponse;

    @Override
    public View getView() {
        binding = ActivityOrderTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initOrderTicketViewModel();
        setupBundleData();
        setupOnSubmitClick();
        setupOnSuccessOrderTicket();
        setupOnErrorOrderTicket();
    }

    private void initOrderTicketViewModel() {
        orderTicketViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(OrderTicketViewModel.class);
    }

    private void setupBundleData() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            setupForm(bundle);
        }
    }

    private void setupForm(Bundle bundle) {
        ticketResponse = bundle.getParcelable(Constant.TICKET_RESPONSE_DATA);

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

    private void setupOnSubmitClick() {
        binding.btnSubmit.setOnClickListener(view -> {
            if (ticketResponse == null) {
                showErrorMessage("");
                return;
            }

            OrderTicketRequest orderTicketRequest = new OrderTicketRequest();
            orderTicketRequest.setArmadaId(ticketResponse.getArmadaId());
            orderTicketRequest.setNote(getEditTextValue(binding.acetNote));
            orderTicketRequest.setSeatBooked(getEditTextValue(binding.acetSeat));
            orderTicketRequest.setLatitude("0.0");
            orderTicketRequest.setLongitude("0.0");

            orderTicketViewModel.orderTicket(orderTicketRequest);
        });
    }

    private void setupOnSuccessOrderTicket() {
        orderTicketViewModel.getOrderTicketLiveData()
            .observe(this, commonResponse -> {
                    showMessage(getString(R.string.order_ticket_success));
                    finish();
                }
            );
    }

    private void setupOnErrorOrderTicket() {
        orderTicketViewModel.getErrorLiveData()
            .observe(this, this::showErrorMessage);
    }
}

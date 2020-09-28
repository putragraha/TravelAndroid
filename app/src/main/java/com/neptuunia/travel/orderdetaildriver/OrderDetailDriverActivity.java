package com.neptuunia.travel.orderdetaildriver;

import com.google.android.gms.maps.model.LatLng;

import com.neptuunia.data.constant.TicketStatus;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderDetailDriverBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.LocationUtils;
import com.neptuunia.travel.utils.NumberUtils;
import com.neptuunia.travel.utils.StatusUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import java.util.Date;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OrderDetailDriverActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityOrderDetailDriverBinding binding;

    private OrderDetailDriverViewModel orderDetailDriverViewModel;

    private HistoryDriverResponse historyDriverResponse;

    @Override
    public View getView() {
        binding = ActivityOrderDetailDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initOrderDetailDriverViewModel();
        setupToolbar();
        setupBundleData();
        setupOnAcceptClick();
        setupOnRejectClick();
        setupOnLocationClick();
        setupOnSuccessConfirmOrderTicket();
        setupOnErrorConfirmOrderTicket();
    }

    private void initOrderDetailDriverViewModel() {
        orderDetailDriverViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(OrderDetailDriverViewModel.class);
    }

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.detail_information);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void setupBundleData() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            setupForm(bundle);
        }
    }

    private void setupForm(Bundle bundle) {
         historyDriverResponse = bundle.getParcelable(Constant.HISTORY_DRIVER_RESPONSE_DATA);

        if (historyDriverResponse != null) {
            Date date = new Date(Long.parseLong(historyDriverResponse.getDatetime()));

            binding.viewArmadaDetail.actvOrderCode.setText(historyDriverResponse.getOrderCode());
            binding.viewArmadaDetail.actvGroup.setText(historyDriverResponse.getGroup());
            binding.viewArmadaDetail.actvDeparture.setText(historyDriverResponse.getDeparture());
            binding.viewArmadaDetail.actvArrival.setText(historyDriverResponse.getArrival());
            binding.viewArmadaDetail.actvPrice.setText(
                NumberUtils.toRupiah(historyDriverResponse.getTotalPrice())
            );
            binding.viewPassengerDetail.actvName.setText(historyDriverResponse.getUserName());
            binding.viewPassengerDetail.actvSeatBooked.setText(
                getString(R.string.amount_seat_booked, historyDriverResponse.getSeatBooked())
            );
            binding.viewArmadaDetail.actvDepartureTime.setText(
                DateTimeUtils.getFormattedDatetime(date)
            );
            binding.viewPassengerDetail.actvNote.setText(historyDriverResponse.getNote());
            binding.viewPassengerDetail.actvLocation.setText(getAddress(historyDriverResponse));
            binding.actvStatus.setText(historyDriverResponse.getStatus());
            binding.actvStatus.setBackgroundResource(
                StatusUtils.getBackgroundColor(historyDriverResponse.getStatus())
            );
            binding.actvStatus.setTextColor(
                StatusUtils.getTextColor(this, historyDriverResponse.getStatus())
            );
            binding.btnAccept.setVisibility(
                isTicketStatusPending(historyDriverResponse.getStatus()) ? View.VISIBLE : View.GONE
            );
            binding.btnReject.setVisibility(
                isTicketStatusPending(historyDriverResponse.getStatus()) ? View.VISIBLE : View.GONE
            );
        }
    }

    private String getAddress(HistoryDriverResponse historyDriverResponse) {
        LatLng latLng = new LatLng(
            Double.parseDouble(historyDriverResponse.getLatitude()),
            Double.parseDouble(historyDriverResponse.getLongitude())
        );

        String address = LocationUtils.getAddress(this, latLng)
            .getAddressLine(0);

        return TextUtils.isEmpty(address) ? "-" : address;
    }

    private boolean isTicketStatusPending(@TicketStatus String status) {
        return TicketStatus.PENDING.equals(status);
    }

    private void setupOnAcceptClick() {
        binding.btnAccept.setOnClickListener(view -> {
            if (historyDriverResponse != null) {
                orderDetailDriverViewModel.confirmTicket(
                    historyDriverResponse.getOrderCode(),
                    TicketStatus.ACCEPTED
                );
            }
        });
    }

    private void setupOnRejectClick() {
        binding.btnReject.setOnClickListener(view -> {
            if (historyDriverResponse != null) {
                orderDetailDriverViewModel.confirmTicket(
                    historyDriverResponse.getOrderCode(),
                    TicketStatus.REJECTED
                );
            }
        });
    }

    private void setupOnLocationClick() {
        binding.viewPassengerDetail.mbOpenPickupLocation.setOnClickListener(view -> {
            if (historyDriverResponse != null) {
                LocationUtils.openGoogleMaps(
                    OrderDetailDriverActivity.this,
                    historyDriverResponse.getLatitude(),
                    historyDriverResponse.getLongitude()
                );
            }
        });
    }

    private void setupOnSuccessConfirmOrderTicket() {
        orderDetailDriverViewModel.getConfirmTicketLiveData()
            .observe(this, this::showMessageAndBack);
    }

    private void showMessageAndBack(CommonResponse commonResponse) {
        showMessage(getString(R.string.order_confirmed));
        finish();
    }

    private void setupOnErrorConfirmOrderTicket() {
        orderDetailDriverViewModel.getErrorLiveData()
            .observe(this, this::showErrorMessage);
    }
}

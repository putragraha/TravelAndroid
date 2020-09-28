package com.neptuunia.travel.orderdetailuser;

import com.google.android.gms.maps.model.LatLng;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderDetailUserBinding;
import com.neptuunia.travel.selectpickup.SelectPickupActivity;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.LocationUtils;
import com.neptuunia.travel.utils.NumberUtils;
import com.neptuunia.travel.utils.StatusUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OrderDetailUserActivity extends BaseActivity {

    private static final int EDIT_LOCATION_REQUEST_CODE = 2;

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityOrderDetailUserBinding binding;

    private EditOrderTicketViewModel editOrderTicketViewModel;

    private HistoryUserResponse historyUserResponse;

    private LatLng latLng;

    @Override
    public View getView() {
        binding = ActivityOrderDetailUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initEditOrderTicketViewModel();
        setupToolbar();
        setupBundleData();
        setupOnUpdateClick();
        setupOnLocationClick();
        setupOnSuccessOrderTicket();
        setupOnErrorOrderTicket();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (EDIT_LOCATION_REQUEST_CODE == requestCode && RESULT_OK == resultCode && data != null) {
            binding.viewUpdateOrderDetailUser.acetLocation.setText(getAddress(data));
        }
    }

    private void initEditOrderTicketViewModel() {
        editOrderTicketViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(EditOrderTicketViewModel.class);
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

    private void setupOnUpdateClick() {
        binding.viewUpdateOrderDetailUser.btnUpdate.setOnClickListener(view -> {
            if (historyUserResponse == null || latLng == null) {
                showMessage(getString(R.string.address_not_found));
                return;
            }

            editOrderTicketViewModel.editTicket(getEditTicketRequest());
        });
    }

    private EditTicketRequest getEditTicketRequest() {
        EditTicketRequest editTicketRequest = new EditTicketRequest();
        editTicketRequest.setOrderCode(historyUserResponse.getOrderCode());
        editTicketRequest.setLatitude(String.valueOf(latLng.latitude));
        editTicketRequest.setLongitude(String.valueOf(latLng.longitude));
        editTicketRequest.setNote(
            getTextInputLayoutValue(binding.viewUpdateOrderDetailUser.tilNote)
        );

        return editTicketRequest;
    }

    private void setupOnLocationClick() {
        binding.viewUpdateOrderDetailUser.acetLocation.setOnClickListener(view ->
            startActivityForResult(SelectPickupActivity.class, EDIT_LOCATION_REQUEST_CODE)
        );
    }

    private void setupOnSuccessOrderTicket() {
        editOrderTicketViewModel.getEditOrderTicketLiveData()
            .observe(this, this::showMessageAndFinish);
    }

    private void showMessageAndFinish(CommonResponse commonResponse) {
        showMessage(getString(R.string.update_success));
        finish();
    }

    private void setupOnErrorOrderTicket() {
        editOrderTicketViewModel.getErrorLiveData()
            .observe(this, this::showErrorMessage);
    }

    private void setupForm(Bundle bundle) {
        historyUserResponse = bundle.getParcelable(Constant.HISTORY_USER_RESPONSE_DATA);

        if (historyUserResponse != null) {
            Date date = new Date(Long.parseLong(historyUserResponse.getDatetime()));

            binding.viewArmadaDetail.actvOrderCode.setText(historyUserResponse.getOrderCode());
            binding.viewArmadaDetail.actvDeparture.setText(historyUserResponse.getDeparture());
            binding.viewArmadaDetail.actvArrival.setText(historyUserResponse.getArrival());
            binding.viewArmadaDetail.actvGroup.setText(historyUserResponse.getGroup());
            binding.viewDriverOrderDetailUser.actvName.setText(historyUserResponse.getDriverName());
            binding.viewUpdateOrderDetailUser.actvSeatBooked.setText(
                historyUserResponse.getSeatBooked()
            );
            binding.viewArmadaDetail.actvPrice.setText(
                NumberUtils.toRupiah(historyUserResponse.getTotalPrice())
            );
            binding.viewArmadaDetail.actvDepartureTime.setText(
                DateTimeUtils.getFormattedDatetime(date)
            );
            binding.viewUpdateOrderDetailUser.acetLocation.setText(getAddress(historyUserResponse));
            binding.viewUpdateOrderDetailUser.tietNote.setText(historyUserResponse.getNote());
            binding.viewDriverOrderDetailUser.actvPhone.setText(
                historyUserResponse.getDriverPhoneNumber()
            );
            binding.actvStatus.setText(historyUserResponse.getStatus());
            binding.actvStatus.setBackgroundResource(
                StatusUtils.getBackgroundColor(historyUserResponse.getStatus())
            );
            binding.actvStatus.setTextColor(
                StatusUtils.getTextColor(this, historyUserResponse.getStatus())
            );
        }
    }

    private String getAddress(HistoryUserResponse historyUserResponse) {
        latLng = new LatLng(
            Double.parseDouble(historyUserResponse.getLatitude()),
            Double.parseDouble(historyUserResponse.getLongitude())
        );

        return LocationUtils.getAddress(this, latLng)
            .getAddressLine(0);
    }

    private String getAddress(Intent data) {
        latLng = data.getParcelableExtra(Constant.LATLNG_DATA);

        if (latLng != null) {
            return LocationUtils.getAddress(this, latLng).getAddressLine(0);
        }

        return getString(R.string.address_not_found);
    }
}

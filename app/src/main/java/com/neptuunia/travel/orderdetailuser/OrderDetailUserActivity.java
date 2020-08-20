package com.neptuunia.travel.orderdetailuser;

import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderDetailUserBinding;
import com.neptuunia.travel.utils.DateTimeUtils;

import android.os.Bundle;
import android.view.View;

import java.util.Date;

public class OrderDetailUserActivity extends BaseActivity {

    private ActivityOrderDetailUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityOrderDetailUserBinding.inflate(getLayoutInflater());
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
        HistoryUserResponse historyUserResponse =
            bundle.getParcelable(Constant.HISTORY_USER_RESPONSE_DATA);

        if (historyUserResponse != null) {
            Date date = new Date(Long.parseLong(historyUserResponse.getDatetime()));

            binding.acetOrderCode.setText(historyUserResponse.getOrderCode());
            binding.acetGroup.setText(historyUserResponse.getGroup());
            binding.acetArmadaClass.setText(historyUserResponse.getArmadaClass());
            binding.acetDriverName.setText(historyUserResponse.getDriverName());
            binding.acetSeatAmount.setText(String.valueOf(historyUserResponse.getSeatBooked()));
            binding.acetTotalPrice.setText(String.valueOf(historyUserResponse.getTotalPrice()));
            binding.acetDepartureDate.setText(DateTimeUtils.getFormattedDate(date));
            binding.acetDepartureTime.setText(DateTimeUtils.getFormattedTime(date));
            binding.acetLocation.setText(String.valueOf(historyUserResponse.getLatitude()));
            binding.acetNote.setText(historyUserResponse.getNote());
            binding.acetDriverPhoneNumber.setText(historyUserResponse.getDriverPhoneNumber());
        }
    }
}

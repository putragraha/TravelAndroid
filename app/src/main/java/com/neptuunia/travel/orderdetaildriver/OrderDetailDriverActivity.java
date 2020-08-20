package com.neptuunia.travel.orderdetaildriver;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityOrderDetailDriverBinding;

import android.os.Bundle;
import android.view.View;

public class OrderDetailDriverActivity extends BaseActivity {

    private ActivityOrderDetailDriverBinding binding;

    @Override
    public View getView() {
        binding = ActivityOrderDetailDriverBinding.inflate(getLayoutInflater());
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
        HistoryDriverResponse historyDriverResponse =
            bundle.getParcelable(Constant.HISTORY_DRIVER_RESPONSE_DATA);

        if (historyDriverResponse != null) {
            binding.acetOrderCode.setText(historyDriverResponse.getOrderCode());
            binding.acetGroup.setText(historyDriverResponse.getGroup());
            binding.acetArmadaClass.setText(historyDriverResponse.getArmadaClass());
            binding.acetUserName.setText(historyDriverResponse.getUserName());
            binding.acetTicketAmount.setText(historyDriverResponse.getSeatBooked());
            binding.acetTotalPrice.setText(String.valueOf(historyDriverResponse.getTotalPrice()));
            binding.acetNote.setText(historyDriverResponse.getNote());
            binding.acetLocation.setText(historyDriverResponse.getLatitude());
        }
    }
}

package com.neptuunia.travel.orderdetailuser;

import com.neptuunia.data.user.model.HistoryUserResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.databinding.ActivityOrderDetailUserBinding;

import android.os.Bundle;
import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderDetailUserActivity, v 0.0.1 04/08/20 07.39 by Putra Nugraha
 */
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
            bundle.getParcelable(Variable.HISTORY_USER_RESPONSE_DATA);

        if (historyUserResponse != null) {
            binding.acetOrderCode.setText(String.valueOf(historyUserResponse.getOrderCode()));
            binding.acetDriverName.setText(historyUserResponse.getDriverName());
            binding.acetSeatAmount.setText(String.valueOf(historyUserResponse.getSeatAmount()));
            binding.acetTotalPrice.setText(String.valueOf(historyUserResponse.getTotalPrice()));
            binding.acetDepartureDate.setText(historyUserResponse.getDepartureDate());
            binding.acetDepartureTime.setText(historyUserResponse.getDepartureTime());
            binding.acetLocation.setText(String.valueOf(historyUserResponse.getLatitude()));
            binding.acetNote.setText(historyUserResponse.getNote());
            binding.acetDriverPhoneNumber.setText(historyUserResponse.getDriverPhoneNumber());
        }
    }
}

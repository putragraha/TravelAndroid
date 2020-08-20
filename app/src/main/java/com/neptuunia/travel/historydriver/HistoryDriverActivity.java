package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityHistoryDriverBinding;
import com.neptuunia.travel.orderdetaildriver.OrderDetailDriverActivity;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoryDriverActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private HistoryDriverAdapter historyDriverAdapter;

    private ActivityHistoryDriverBinding binding;

    @Override
    public View getView() {
        binding = ActivityHistoryDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        setupHistoryDriverViewModel();
    }

    private void setupRecylerView() {
        historyDriverAdapter = new HistoryDriverAdapter(this::startOrderDetailActivity);
        binding.rvHistoryDriver.setLayoutManager(new LinearLayoutManager(this));
        binding.rvHistoryDriver.setAdapter(historyDriverAdapter);
    }

    private void setupHistoryDriverViewModel() {
        new ViewModelProvider(this, viewModelFactory).get(HistoryDriverViewModel.class)
            .getHistoryDrivers()
            .observe(
                this,
                historyDriverResponses -> historyDriverAdapter.submitList(historyDriverResponses)
            );
    }

    private void startOrderDetailActivity(HistoryDriverResponse historyDriverResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.HISTORY_DRIVER_RESPONSE_DATA, historyDriverResponse);
        startActivityWithBundle(OrderDetailDriverActivity.class, bundle);
    }
}

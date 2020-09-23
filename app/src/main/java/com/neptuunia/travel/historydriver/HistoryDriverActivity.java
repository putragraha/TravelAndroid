package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.travel.R;
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

    private HistoryDriverViewModel historyDriverViewModel;

    @Override
    public View getView() {
        binding = ActivityHistoryDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        initHistoryDriverViewModel();
        setupToolbar();
        getHistoryDrivers();
        setupOnSuccessGetHistoryDrivers();
    }

    private void setupRecylerView() {
        historyDriverAdapter = new HistoryDriverAdapter(this::startOrderDetailActivity);
        binding.rvHistoryDriver.setLayoutManager(new LinearLayoutManager(this));
        binding.rvHistoryDriver.setAdapter(historyDriverAdapter);
    }

    private void initHistoryDriverViewModel() {
        historyDriverViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(HistoryDriverViewModel.class);
    }

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.history);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void getHistoryDrivers() {
        if (historyDriverViewModel != null) {
            historyDriverViewModel.fetchHistoryDrivers();
        }
    }

    private void startOrderDetailActivity(HistoryDriverResponse historyDriverResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.HISTORY_DRIVER_RESPONSE_DATA, historyDriverResponse);
        startActivityWithBundle(OrderDetailDriverActivity.class, bundle);
    }

    private void setupOnSuccessGetHistoryDrivers() {
        if (historyDriverViewModel != null) {
            historyDriverViewModel.getHistoryDrivers()
                .observe(this, historyDriverAdapter::submitList);
        }
    }
}

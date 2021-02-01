package com.neptuunia.travel.historydriver;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityHistoryDriverBinding;
import com.neptuunia.travel.orderdetaildriver.OrderDetailDriverActivity;
import com.neptuunia.travel.utils.DateTimeUtils;

import android.os.Bundle;
import android.view.View;

import java.util.Date;

import javax.inject.Inject;

import androidx.core.util.Pair;
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

    private MaterialDatePicker<Pair<Long, Long>> picker;

    @Override
    public View getView() {
        binding = ActivityHistoryDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        initHistoryDriverViewModel();
        initMaterialDatePicker();
        setupDatePickerPositiveListener();
        setupToolbar();
        setupDateFilter();
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

    private void initMaterialDatePicker() {
        CalendarConstraints calendarConstraints = new CalendarConstraints.Builder()
            .build();

        picker = MaterialDatePicker.Builder
            .dateRangePicker()
            .setCalendarConstraints(calendarConstraints)
            .build();
    }

    private void setupDatePickerPositiveListener() {
        picker.addOnPositiveButtonClickListener(selection -> {
            if (selection == null || selection.first == null || selection.second == null) {
                return;
            }

            long minDate = selection.first;
            long maxDate = selection.second + DateTimeUtils.ONE_DAY_IN_MILLIS;

            historyDriverViewModel.filterHistoryDrivers(minDate, maxDate);
            binding.viewFilterDate.actvDate.setText(
                getString(
                    R.string.date_range_message,
                    DateTimeUtils.getFormattedDate(new Date(selection.first)),
                    DateTimeUtils.getFormattedDate(new Date(selection.second))
                )
            );
        });
    }

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.history);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void setupDateFilter() {
        binding.viewFilterDate.clFilterDate.setOnClickListener(this::openDateRangePicker);
        binding.viewFilterDate.acivCancel.setOnClickListener(this::clearDateRangeFilter);
    }

    private void openDateRangePicker(View view) {
        picker.show(getSupportFragmentManager(), picker.toString());
    }

    private void clearDateRangeFilter(View view) {
        binding.viewFilterDate.actvDate.setText(getString(R.string.date_range));
        historyDriverViewModel.clearHistoryDrivers();
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

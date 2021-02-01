package com.neptuunia.travel.historyuser;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityHistoryUserBinding;
import com.neptuunia.travel.orderdetailuser.OrderDetailUserActivity;
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
public class HistoryUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private HistoryUserAdapter historyUserAdapter;

    private ActivityHistoryUserBinding binding;

    private HistoryUserViewModel historyUserViewModel;

    private MaterialDatePicker<Pair<Long, Long>> picker;

    @Override
    public View getView() {
        binding = ActivityHistoryUserBinding.inflate(getLayoutInflater());
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
        setupOnSuccessGetHistoryUser();
    }

    private void setupRecylerView() {
        historyUserAdapter = new HistoryUserAdapter(this::startOrderDetailActivity);
        binding.rvHistoryUser.setLayoutManager(new LinearLayoutManager(this));
        binding.rvHistoryUser.setAdapter(historyUserAdapter);
    }

    private void initHistoryDriverViewModel() {
        historyUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(HistoryUserViewModel.class);
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

            historyUserViewModel.filterHistoryUsers(minDate, maxDate);
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
        historyUserViewModel.clearHistoryUsers();
    }

    private void setupOnSuccessGetHistoryUser() {
        historyUserViewModel.getHistoryUsers()
            .observe(this, historyUserAdapter::submitList);
    }

    private void startOrderDetailActivity(HistoryUserResponse historyUserResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.HISTORY_USER_RESPONSE_DATA, historyUserResponse);
        startActivityWithBundle(OrderDetailUserActivity.class, bundle);
    }
}

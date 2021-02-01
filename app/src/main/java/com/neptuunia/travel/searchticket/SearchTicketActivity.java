package com.neptuunia.travel.searchticket;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivitySearchTicketBinding;
import com.neptuunia.travel.orderticket.OrderTicketActivity;
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
public class SearchTicketActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private SearchTicketAdapter searchTicketAdapter;

    private ActivitySearchTicketBinding binding;

    private SearchTicketViewModel searchTicketViewModel;

    private MaterialDatePicker<Pair<Long, Long>> picker;

    @Override
    public View getView() {
        binding = ActivitySearchTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        initSearchTicketViewModel();
        initMaterialDatePicker();
        setupDatePickerPositiveListener();
        setupToolbar();
        setupDateFilter();
        setupOnSuccessGetTickets();
    }

    private void setupRecylerView() {
        searchTicketAdapter = new SearchTicketAdapter(this::startOrderDetailActivity);
        binding.rvSearchTicket.setLayoutManager(new LinearLayoutManager(this));
        binding.rvSearchTicket.setAdapter(searchTicketAdapter);
    }

    private void initSearchTicketViewModel() {
        searchTicketViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(SearchTicketViewModel.class);
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

            searchTicketViewModel.filterTickets(minDate, maxDate);
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
        binding.viewToolbar.actvTitle.setText(R.string.get_ticket);
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
        searchTicketViewModel.clearTickets();
    }

    private void startOrderDetailActivity(TicketResponse ticketResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.TICKET_RESPONSE_DATA, ticketResponse);
        startActivityWithBundle(OrderTicketActivity.class, bundle);
    }

    private void setupOnSuccessGetTickets() {
        searchTicketViewModel.getTickets()
            .observe(this, searchTicketAdapter::submitList);
    }
}

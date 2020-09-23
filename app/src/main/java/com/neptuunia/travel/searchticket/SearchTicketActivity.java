package com.neptuunia.travel.searchticket;

import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivitySearchTicketBinding;
import com.neptuunia.travel.orderticket.OrderTicketActivity;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

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

    @Override
    public View getView() {
        binding = ActivitySearchTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        initSearchTicketViewModel();
        setupToolbar();
        getTickets();
        setupOnSuccessGetTickets();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTickets();
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

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.get_ticket);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void getTickets() {
        if (searchTicketViewModel != null) {
            searchTicketViewModel.fetchTickets();
        }
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

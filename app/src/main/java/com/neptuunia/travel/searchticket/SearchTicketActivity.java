package com.neptuunia.travel.searchticket;

import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.databinding.ActivitySearchTicketBinding;
import com.neptuunia.travel.orderdetailuser.OrderDetailUserActivity;
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

    @Override
    public View getView() {
        binding = ActivitySearchTicketBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        setupSearchTicketViewModel();
    }

    private void setupRecylerView() {
        searchTicketAdapter = new SearchTicketAdapter(this::startOrderDetailActivity);
        binding.rvSearchTicket.setLayoutManager(new LinearLayoutManager(this));
        binding.rvSearchTicket.setAdapter(searchTicketAdapter);
    }

    private void setupSearchTicketViewModel() {
        new ViewModelProvider(this, viewModelFactory).get(SearchTicketViewModel.class)
            .getTickets()
            .observe(
                this,
                ticketResponses -> searchTicketAdapter.submitList(ticketResponses)
            );
    }

    private void startOrderDetailActivity(TicketResponse ticketResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Variable.TICKET_RESPONSE_DATA, ticketResponse);
        startActivityWithBundle(OrderTicketActivity.class, bundle);
    }
}

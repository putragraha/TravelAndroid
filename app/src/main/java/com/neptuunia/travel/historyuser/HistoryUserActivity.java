package com.neptuunia.travel.historyuser;

import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivityHistoryUserBinding;
import com.neptuunia.travel.orderdetailuser.OrderDetailUserActivity;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

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

    @Override
    public View getView() {
        binding = ActivityHistoryUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        initHistoryDriverViewModel();
        setupToolbar();
        getHistoryUsers();
        setupOnSuccessGetHistoryUser();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getHistoryUsers();
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

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.history);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void getHistoryUsers() {
        if (historyUserViewModel != null) {
            historyUserViewModel.fetchHistoryUsers();
        }
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

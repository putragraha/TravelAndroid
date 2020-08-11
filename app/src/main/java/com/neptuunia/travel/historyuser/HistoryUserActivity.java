package com.neptuunia.travel.historyuser;

import com.neptuunia.data.user.model.HistoryUserResponse;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.databinding.ActivityHistoryUserBinding;
import com.neptuunia.travel.orderdetailuser.OrderDetailUserActivity;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HistoryUserActivity, v 0.0.1 09/08/20 00.08 by Putra Nugraha
 */
@AndroidEntryPoint
public class HistoryUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private HistoryUserAdapter historyUserAdapter;

    private ActivityHistoryUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityHistoryUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        setupHistoryDriverViewModel();
    }

    private void setupRecylerView() {
        historyUserAdapter = new HistoryUserAdapter(this::startOrderDetailActivity);
        binding.rvHistoryUser.setLayoutManager(new LinearLayoutManager(this));
        binding.rvHistoryUser.setAdapter(historyUserAdapter);
    }

    private void setupHistoryDriverViewModel() {
        new ViewModelProvider(this, viewModelFactory).get(HistoryUserViewModel.class)
            .getHistoryUsers()
            .observe(
                this,
                historyUserResponse -> historyUserAdapter.submitList(historyUserResponse)
            );
    }

    private void startOrderDetailActivity(HistoryUserResponse historyUserResponse) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Variable.HISTORY_USER_RESPONSE_DATA, historyUserResponse);
        startActivityWithBundle(OrderDetailUserActivity.class, bundle);
    }
}

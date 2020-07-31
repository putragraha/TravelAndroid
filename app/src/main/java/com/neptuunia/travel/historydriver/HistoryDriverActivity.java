package com.neptuunia.travel.historydriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityHistoryDriverBinding;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * @author Rengar
 * @version HistoryDriverActivity, v 0.0.1 29/07/20 22.08 by Rengar
 */
public class HistoryDriverActivity extends BaseActivity {

    private ActivityHistoryDriverBinding activityHistoryDriverBinding;

    private HistoryDriverAdapter historyDriverAdapter;

    @Override
    public View getView() {
        activityHistoryDriverBinding = ActivityHistoryDriverBinding.inflate(getLayoutInflater());
        return activityHistoryDriverBinding.getRoot();
    }

    @Override
    public void setup() {
        setupRecylerView();
        setupHistoryDriverViewModel();
    }

    private void setupRecylerView() {
        historyDriverAdapter = new HistoryDriverAdapter();
        activityHistoryDriverBinding.rvHistoryDriver.setLayoutManager(new LinearLayoutManager(this));
        activityHistoryDriverBinding.rvHistoryDriver.setAdapter(historyDriverAdapter);
    }

    private void setupHistoryDriverViewModel() {
        new ViewModelProvider(this, new ViewModelFactory(getApplication()))
            .get(HistoryDriverViewModel.class)
            .getHistoryDrivers().observe(
            this,
            historyDriverResponses -> historyDriverAdapter.submitList(historyDriverResponses)
        );
    }
}

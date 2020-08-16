package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;
import com.neptuunia.travel.historyuser.HistoryUserActivity;
import com.neptuunia.travel.profileuser.ProfileUserActivity;
import com.neptuunia.travel.searchticket.SearchTicketActivity;

import android.view.View;

public class HomeUserActivity extends BaseActivity {

    private ActivityHomeUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityHomeUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        startProfileUserActivity();
        startHistoryUserActivity();
        startSearchTicketActivity();
    }

    private void startHistoryUserActivity() {
        binding.btnHistory.setOnClickListener(view ->
            startActivity(HistoryUserActivity.class)
        );
    }

    private void startProfileUserActivity() {
        binding.btnProfile.setOnClickListener(view ->
            startActivity(ProfileUserActivity.class)
        );
    }

    private void startSearchTicketActivity() {
        binding.btnGetTicket.setOnClickListener(view ->
            startActivity(SearchTicketActivity.class)
        );
    }
}

package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;
import com.neptuunia.travel.historyuser.HistoryUserActivity;
import com.neptuunia.travel.loginuser.LoginUserActivity;
import com.neptuunia.travel.profileuser.ProfileUserActivity;
import com.neptuunia.travel.searchticket.SearchTicketActivity;

import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityHomeUserBinding binding;

    private HomeUserViewModel homeUserViewModel;

    @Override
    public View getView() {
        binding = ActivityHomeUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initHomeUserViewModel();
        observeSession();
        startProfileUserActivity();
        startHistoryUserActivity();
        startSearchTicketActivity();
        setupLogout();
    }

    private void initHomeUserViewModel() {
        homeUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(HomeUserViewModel.class);
    }

    private void observeSession() {
        homeUserViewModel.getSessionLiveData().observe(this, this::logout);
    }

    private void startHistoryUserActivity() {
        binding.mbHistory.setOnClickListener(view ->
            startActivity(HistoryUserActivity.class)
        );
    }

    private void startProfileUserActivity() {
        binding.mbProfile.setOnClickListener(view ->
            startActivity(ProfileUserActivity.class)
        );
    }

    private void startSearchTicketActivity() {
        binding.mbGetTicket.setOnClickListener(view ->
            startActivity(SearchTicketActivity.class)
        );
    }

    private void setupLogout() {
        binding.mbLogout.setOnClickListener(view -> homeUserViewModel.logout());
    }

    private void logout(boolean sessionClear) {
        startActivityAndFinish(LoginUserActivity.class);
    }
}

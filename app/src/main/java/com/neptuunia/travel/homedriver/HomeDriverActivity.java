package com.neptuunia.travel.homedriver;

import com.neptuunia.travel.armadasetting.ArmadaSettingActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityHomeDriverBinding;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;
import com.neptuunia.travel.logindriver.LoginDriverActivity;
import com.neptuunia.travel.profiledriver.ProfileDriverActivity;

import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeDriverActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityHomeDriverBinding binding;

    private HomeDriverViewModel homeDriverViewModel;

    @Override
    public View getView() {
        binding = ActivityHomeDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        setupButtonArmadaSetting();
    }

    private void setupButtonArmadaSetting() {
        initHomeDriverViewModel();
        observeSession();
        setupStartArmadaSettingActivity();
        setupStartHistoryDriverActivity();
        setupStartProfileDriverActivity();
        setupLogout();
    }

    private void initHomeDriverViewModel() {
        homeDriverViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(HomeDriverViewModel.class);
    }

    private void observeSession() {
        homeDriverViewModel.getSessionLiveData().observe(this, this::logout);
    }

    private void setupStartProfileDriverActivity() {
        binding.mbProfile.setOnClickListener(
            view -> startActivity(ProfileDriverActivity.class)
        );
    }

    private void setupStartHistoryDriverActivity() {
        binding.mbHistory.setOnClickListener(
            view -> startActivity(HistoryDriverActivity.class)
        );
    }

    private void setupStartArmadaSettingActivity() {
        binding.mbArmadaSetting.setOnClickListener(
            view -> startActivity(ArmadaSettingActivity.class)
        );
    }

    private void setupLogout() {
        binding.mbLogout.setOnClickListener(view -> homeDriverViewModel.logout());
    }

    private void logout(boolean sessionClear) {
        startActivityAndFinish(LoginDriverActivity.class);
    }
}

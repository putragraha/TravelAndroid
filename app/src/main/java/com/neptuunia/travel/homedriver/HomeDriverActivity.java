package com.neptuunia.travel.homedriver;

import com.neptuunia.travel.armadasetting.ArmadaSettingActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeDriverBinding;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;
import com.neptuunia.travel.logindriver.LoginDriverActivity;
import com.neptuunia.travel.profiledriver.ProfileDriverActivity;

import android.view.View;

public class HomeDriverActivity extends BaseActivity {

    private ActivityHomeDriverBinding binding;

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
        setupStartArmadaSettingActivity();
        setupStartHistoryDriverActivity();
        setupStartProfileDriverActivity();
        setupLogout();
    }

    private void setupStartProfileDriverActivity() {
        binding.btnProfile.setOnClickListener(
            view -> startActivity(ProfileDriverActivity.class)
        );
    }

    private void setupStartHistoryDriverActivity() {
        binding.btnHistory.setOnClickListener(
            view -> startActivity(HistoryDriverActivity.class)
        );
    }

    private void setupStartArmadaSettingActivity() {
        binding.btnArmadaSetting.setOnClickListener(
            view -> startActivity(ArmadaSettingActivity.class)
        );
    }

    private void setupLogout() {
        binding.btnLogout.setOnClickListener(
            view -> startActivityAndFinish(LoginDriverActivity.class)
        );
    }
}

package com.neptuunia.travel.homedriver;

import com.neptuunia.travel.armadasetting.ArmadaSettingActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeDriverBinding;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;
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
        binding.btnArmadaSetting.setOnClickListener(view ->
            startActivity(ArmadaSettingActivity.class)
        );
        binding.btnHistory.setOnClickListener(view ->
            startActivity(HistoryDriverActivity.class)
        );
        binding.btnProfile.setOnClickListener(view ->
            startActivity(ProfileDriverActivity.class)
        );
    }
}

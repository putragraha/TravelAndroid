package com.neptuunia.travel.homedriver;

import com.neptuunia.travel.armadasetting.ArmadaSettingActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeDriverBinding;

import android.view.View;

public class HomeDriverActivity extends BaseActivity {

    private ActivityHomeDriverBinding activityHomeDriverBinding;

    @Override
    public View getView() {
        activityHomeDriverBinding = ActivityHomeDriverBinding.inflate(getLayoutInflater());
        return activityHomeDriverBinding.getRoot();
    }

    @Override
    public void setup() {
        setupButtonArmadaSetting();
    }

    private void setupButtonArmadaSetting() {
        activityHomeDriverBinding.btnArmadaSetting.setOnClickListener(view ->
            startActivity(ArmadaSettingActivity.class)
        );
    }
}

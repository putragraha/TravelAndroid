package com.neptuunia.travel.homedriver;

import com.neptuunia.travel.armadasetting.ArmadaSettingActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeDriverBinding;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;

import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HomeDriverActivity, v 0.0.1 19/07/20 08.57 by Putra Nugraha
 */
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
        activityHomeDriverBinding.btnHistory.setOnClickListener(view ->
            startActivity(HistoryDriverActivity.class)
        );
    }
}

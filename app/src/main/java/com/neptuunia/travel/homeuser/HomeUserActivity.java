package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;

import android.view.View;

public class HomeUserActivity extends BaseActivity {

    private ActivityHomeUserBinding activityHomeUserBinding;

    @Override
    public View getView() {
        activityHomeUserBinding = ActivityHomeUserBinding.inflate(getLayoutInflater());
        return activityHomeUserBinding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation
    }
}

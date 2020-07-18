package com.neptuunia.travel;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityMainBinding;

import android.view.View;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    public View getView() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return activityMainBinding.getRoot();
    }

    @Override
    public void setup() {
        activityMainBinding.btnLoginDriver.setOnClickListener(
            view -> DriverLoginActivity.startActivity(MainActivity.this)
        );
    }
}
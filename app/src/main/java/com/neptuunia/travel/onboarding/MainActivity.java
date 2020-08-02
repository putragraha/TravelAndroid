package com.neptuunia.travel.onboarding;

import com.neptuunia.travel.logindriver.LoginDriverActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityMainBinding;
import com.neptuunia.travel.loginuser.LoginUserActivity;

import android.view.View;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    public View getView() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return activityMainBinding.getRoot();
    }

    @Override
    public void setup() {
        setupButtonLoginDriver();
        setupButtonUserDriver();
    }

    private void setupButtonLoginDriver() {
        activityMainBinding.btnLoginDriver.setOnClickListener(
            view -> startActivity(LoginDriverActivity.class)
        );
    }

    private void setupButtonUserDriver() {
        activityMainBinding.btnLoginUser.setOnClickListener(
            view -> startActivity(LoginUserActivity.class)
        );
    }
}
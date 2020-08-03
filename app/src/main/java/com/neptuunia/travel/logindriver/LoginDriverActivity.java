package com.neptuunia.travel.logindriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

import android.view.View;

public class LoginDriverActivity extends BaseActivity {

    private ActivityLoginDriverBinding activityLoginDriverBinding;

    @Override
    public View getView() {
        activityLoginDriverBinding = ActivityLoginDriverBinding.inflate(getLayoutInflater());
        return activityLoginDriverBinding.getRoot();
    }

    @Override
    public void setup() {
        setupButton();
    }

    private void setupButton() {
        activityLoginDriverBinding.btnLogin.setOnClickListener(view ->
            startActivity(HomeDriverActivity.class)
        );
    }
}
package com.neptuunia.travel.logindriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

import android.view.View;

import javax.inject.Inject;

public class LoginDriverActivity extends BaseActivity {

    @Inject
    ActivityLoginDriverBinding activityLoginDriverBinding;

    @Override
    public View getView() {
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
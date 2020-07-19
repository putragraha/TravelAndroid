package com.neptuunia.travel.logindriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

import android.app.Activity;
import android.content.Intent;
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

    public static void startActivity(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, LoginDriverActivity.class);
        sourceActivity.startActivity(intent);
    }

    private void setupButton() {
        activityLoginDriverBinding.btnLogin.setOnClickListener(view ->
            startActivity(HomeDriverActivity.class)
        );
    }
}
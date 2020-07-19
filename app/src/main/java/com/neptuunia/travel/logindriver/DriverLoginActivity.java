package com.neptuunia.travel.logindriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class DriverLoginActivity extends BaseActivity {

    private ActivityLoginDriverBinding activityLoginDriverBinding;

    @Override
    public View getView() {
        activityLoginDriverBinding = ActivityLoginDriverBinding.inflate(getLayoutInflater());
        return activityLoginDriverBinding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation
    }

    public static void startActivity(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, DriverLoginActivity.class);
        sourceActivity.startActivity(intent);
    }
}
package com.neptuunia.travel;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityDriverLoginBinding;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class DriverLoginActivity extends BaseActivity {

    private ActivityDriverLoginBinding activityDriverLoginBinding;

    @Override
    public View getView() {
        activityDriverLoginBinding = ActivityDriverLoginBinding.inflate(getLayoutInflater());
        return activityDriverLoginBinding.getRoot();
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
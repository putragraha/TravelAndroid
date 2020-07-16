package com.neptuunia.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DriverLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
    }

    public static void startActivity(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, DriverLoginActivity.class);
        sourceActivity.startActivity(intent);
    }
}
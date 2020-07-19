package com.neptuunia.travel.base;

import com.neptuunia.travel.R;
import com.neptuunia.travel.TravelApplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract View getView();

    public abstract void setup();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTravelable();
    }

    protected void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    private void initTravelable() {
        if (isTravelable()) {
            setContentView(getView());
            setup();
        } else {
            showRoxMessage();
        }
    }

    private boolean isTravelable() {
        return ((TravelApplication) getApplication()).getFlags().getTravelable().isEnabled();
    }

    private void showRoxMessage() {
        new AlertDialog.Builder(this)
            .setMessage(R.string.rox_message)
            .setIcon(R.mipmap.ic_launcher)
            .setCancelable(false)
            .setPositiveButton(android.R.string.yes, (dialog, which) -> dialog.cancel())
            .create()
            .show();
    }
}

package com.neptuunia.travel.base;

import com.neptuunia.travel.R;
import com.neptuunia.travel.TravelApplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version BaseActivity, v 0.0.1 19/07/20 04.29 by Putra Nugraha
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract View getView();

    public abstract void setup();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTravelable();
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

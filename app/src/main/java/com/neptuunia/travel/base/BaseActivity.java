package com.neptuunia.travel.base;

import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import com.neptuunia.travel.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private static final int ONE_MINUTE = 60;

    private FirebaseRemoteConfig firebaseRemoteConfig;

    public abstract View getView();

    public abstract void setup();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initApps();
    }

    protected <T> void startActivityWithBundle(Class<T> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected <T> void startActivity(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    private void initApps() {
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setDefaultsAsync(R.xml.firebase_defaults);
        firebaseRemoteConfig.fetch(ONE_MINUTE)
            .addOnCompleteListener(this::onFetchComplete);
    }

    private void onFetchComplete(Task<Void> task) {
        activateFetch(task);
        initView();
    }

    private void activateFetch(Task<Void> task) {
        if (task.isSuccessful()) {
            firebaseRemoteConfig.activate();
        }
    }

    private void initView() {
        if (firebaseRemoteConfig.getBoolean(getString(R.string.app_green_light))) {
            setContentView(getView());
            setup();
        }
    }
}

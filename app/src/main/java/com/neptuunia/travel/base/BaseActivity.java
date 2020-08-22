package com.neptuunia.travel.base;

import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import com.neptuunia.travel.R;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    protected <T> void startActivityForResult(Class<T> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    protected <T> void startActivityAndFinish(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    protected <T> void startActivityAndFinishAffinity(Class<T> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finishAffinity();
    }

    protected void showErrorMessage(String message) {
        showMessage(TextUtils.isEmpty(message) ? getString(R.string.failed) : message);
    }

    protected void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected String getEditTextValue(EditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }

    protected int getEditTextAsInteger(EditText editText) {
        return editText.getText() == null ? 0 : Integer.parseInt(editText.getText().toString());
    }

    protected String getTextInputLayoutValue(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();

        return editText == null ? "" : editText.getText().toString().trim();
    }

    private void initApps() {
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setDefaultsAsync(R.xml.firebase_defaults);
        firebaseRemoteConfig.setConfigSettingsAsync(getFirebaseRemoteConfigSettings());
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(this::initView);
    }

    private FirebaseRemoteConfigSettings getFirebaseRemoteConfigSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(ONE_MINUTE)
            .build();
    }

    private void initView(Task<Boolean> task) {
        if (firebaseRemoteConfig.getBoolean(getString(R.string.app_green_light))) {
            setContentView(getView());
            setup();
        }
    }
}

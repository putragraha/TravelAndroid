package com.neptuunia.travel.logindriver;

import com.google.android.material.textfield.TextInputLayout;

import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginDriverActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private LoginDriverViewModel loginDriverViewModel;

    private ActivityLoginDriverBinding binding;

    @Override
    public View getView() {
        binding = ActivityLoginDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initLoginDriverViewModel();
        setupButton();
        setupOnSuccessLoginDriver();
        setupOnErrorLoginDriver();
    }

    private void initLoginDriverViewModel() {
        loginDriverViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(LoginDriverViewModel.class);
    }

    private void setupButton() {
        binding.btnLogin.setOnClickListener(view -> loginDriver());
    }

    private void loginDriver() {
        loginDriverViewModel.loginDriver(
                getTextInputLayoutValue(binding.tilEmail),
                getTextInputLayoutValue(binding.tilPassword)
            );
    }

    private String getTextInputLayoutValue(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();

        return editText == null ? "" : editText.getText().toString().trim();
    }

    private void setupOnSuccessLoginDriver() {
        loginDriverViewModel.getSuccessLiveData().observe(
            this,
            success -> startActivityAndFinish(HomeDriverActivity.class)
        );
    }

    private void setupOnErrorLoginDriver() {
        loginDriverViewModel.getErrorLiveData().observe(
            this,
            this::showErrorMessage
        );
    }

    private void showErrorMessage(String message) {
        showToast(TextUtils.isEmpty(message) ? getString(R.string.login_failed) : message);
    }
}
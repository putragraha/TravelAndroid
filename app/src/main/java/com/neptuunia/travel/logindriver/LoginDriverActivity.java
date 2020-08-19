package com.neptuunia.travel.logindriver;

import com.google.android.material.textfield.TextInputLayout;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

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
        setupOnLoginDriver();
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

    private void setupOnLoginDriver() {
        loginDriverViewModel.getLoginResponseLiveData()
            .observe(this, this::handleOnLogin);
    }

    private void handleOnLogin(boolean success) {
        if (success) {
            startActivityAndFinish(HomeDriverActivity.class);
        } else {
            showToast("Login Failed");
        }
    }
}
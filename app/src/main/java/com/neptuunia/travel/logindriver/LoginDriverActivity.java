package com.neptuunia.travel.logindriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityLoginDriverBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;

import android.view.View;

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
        binding.viewLogin.btnLogin.setOnClickListener(view -> loginDriver());
    }

    private void loginDriver() {
        loginDriverViewModel.loginDriver(
                getTextInputLayoutValue(binding.viewLogin.tilEmail),
                getTextInputLayoutValue(binding.viewLogin.tilPassword)
            );
    }

    private void setupOnSuccessLoginDriver() {
        loginDriverViewModel.getSuccessLiveData().observe(
            this,
            success -> startActivityAndFinishAffinity(HomeDriverActivity.class)
        );
    }

    private void setupOnErrorLoginDriver() {
        loginDriverViewModel.getErrorLiveData().observe(
            this,
            this::showErrorMessage
        );
    }
}
package com.neptuunia.travel.onboarding;

import com.neptuunia.data.constant.AccountType;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.homedriver.HomeDriverActivity;
import com.neptuunia.travel.homeuser.HomeUserActivity;
import com.neptuunia.travel.logindriver.LoginDriverActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityMainBinding;
import com.neptuunia.travel.loginuser.LoginUserActivity;

import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityMainBinding activityMainBinding;

    @Override
    public View getView() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return activityMainBinding.getRoot();
    }

    @Override
    public void setup() {
        setupButtonLoginDriver();
        setupButtonUserDriver();
        setupMainViewModel();
    }

    private void setupButtonLoginDriver() {
        activityMainBinding.btnLoginDriver.setOnClickListener(
            view -> startActivity(LoginDriverActivity.class)
        );
    }

    private void setupButtonUserDriver() {
        activityMainBinding.btnLoginUser.setOnClickListener(
            view -> startActivity(LoginUserActivity.class)
        );
    }

    private void setupMainViewModel() {
        new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class)
            .getSessionLiveData()
            .observe(this, this::startRespectiveHomeActivity);
    }

    private void startRespectiveHomeActivity(@AccountType String type) {
        if (AccountType.USER.equals(type)) {
            startActivityAndFinish(HomeUserActivity.class);
        } else {
            startActivityAndFinish(HomeDriverActivity.class);
        }
    }
}
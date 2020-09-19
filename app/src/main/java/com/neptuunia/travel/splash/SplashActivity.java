package com.neptuunia.travel.splash;

import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivitySplashBinding;
import com.neptuunia.travel.homedriver.HomeDriverActivity;
import com.neptuunia.travel.homeuser.HomeUserActivity;
import com.neptuunia.travel.logindriver.LoginDriverActivity;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.loginuser.LoginUserActivity;

import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SplashActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private SplashViewModel splashViewModel;

    @Override
    public View getView() {
        return ActivitySplashBinding.inflate(getLayoutInflater()).getRoot();
    }

    @Override
    public void setup() {
        initSplashViewModel();
        initSplashAction();
        setupOnShouldGoToHomeDriver();
        setupOnShouldGoToHomeUser();
        setupOnShouldGoToLoginDriver();
        setupOnShouldGoToLoginUser();
    }

    private void initSplashViewModel() {
        splashViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(SplashViewModel.class);
    }

    private void initSplashAction() {
        splashViewModel.initSplashAction();
    }

    private void setupOnShouldGoToHomeDriver() {
        splashViewModel.getHomeDriverLiveData()
            .observe(this, accountType -> startActivityAndFinish(HomeDriverActivity.class));
    }

    private void setupOnShouldGoToHomeUser() {
        splashViewModel.getHomeUserLiveData()
            .observe(this, accountType -> startActivityAndFinish(HomeUserActivity.class));
    }

    private void setupOnShouldGoToLoginDriver() {
        splashViewModel.getLoginDriverLiveData()
            .observe(this, accountType -> startActivityAndFinish(LoginDriverActivity.class));
    }

    private void setupOnShouldGoToLoginUser() {
        splashViewModel.getLoginUserLiveData()
            .observe(this, accountType -> startActivityAndFinish(LoginUserActivity.class));
    }
}
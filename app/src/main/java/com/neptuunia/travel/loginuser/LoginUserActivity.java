package com.neptuunia.travel.loginuser;

import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityLoginUserBinding;
import com.neptuunia.travel.homeuser.HomeUserActivity;
import com.neptuunia.travel.registeruser.RegisterUserActivity;
import com.neptuunia.travel.utils.StringUtils;

import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private LoginUserViewModel loginUserViewModel;

    private ActivityLoginUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityLoginUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initLoginUserViewModel();
        setupRegisterTextView();
        setupButtonLogin();
        setupOnSuccessLoginUser();
        setupOnErrorLoginUser();
    }

    private void initLoginUserViewModel() {
        loginUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(LoginUserViewModel.class);
    }

    private void setupRegisterTextView() {
        binding.viewLogin.tvRegisterLabel.setText(
            StringUtils.getSpannableText(
                getString(R.string.register_here),
                getString(R.string.have_no_account),
                this::onSpannedTextClicked
            )
        );
        binding.viewLogin.tvRegisterLabel.setMovementMethod(LinkMovementMethod.getInstance());
        binding.viewLogin.tvRegisterLabel.setHighlightColor(Color.TRANSPARENT);
    }

    private void onSpannedTextClicked(View view) {
        startActivity(RegisterUserActivity.class);
    }

    private void setupButtonLogin() {
        binding.viewLogin.btnLogin.setOnClickListener(this::loginUser);
    }

    private void loginUser(View view) {
        loginUserViewModel.loginUser(
            getTextInputLayoutValue(binding.viewLogin.tilEmail),
            getTextInputLayoutValue(binding.viewLogin.tilPassword)
        );
    }

    private void setupOnSuccessLoginUser() {
        loginUserViewModel.getSuccessLiveData().observe(
            this,
            success -> startActivityAndFinishAffinity(HomeUserActivity.class)
        );
    }

    private void setupOnErrorLoginUser() {
        loginUserViewModel.getErrorLiveData().observe(
            this,
            this::showErrorMessage
        );
    }
}

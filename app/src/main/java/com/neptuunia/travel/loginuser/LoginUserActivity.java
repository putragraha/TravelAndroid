package com.neptuunia.travel.loginuser;

import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityLoginUserBinding;
import com.neptuunia.travel.homeuser.HomeUserActivity;
import com.neptuunia.travel.registeruser.RegisterUserActivity;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;

import javax.inject.Inject;

import androidx.annotation.NonNull;
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
        binding.tvRegisterLabel.setText(getRegisterSpannableText());
        binding.tvRegisterLabel.setMovementMethod(LinkMovementMethod.getInstance());
        binding.tvRegisterLabel.setHighlightColor(Color.TRANSPARENT);
    }

    private SpannableString getRegisterSpannableText() {
        String registerHere = getString(R.string.register_here);
        SpannableString registerSpannableText = new SpannableString(
            String.format(getString(R.string.have_no_account), registerHere)
        );
        int startIndex = registerSpannableText.length() - registerHere.length();

        registerSpannableText.setSpan(new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                startActivity(RegisterUserActivity.class);
            }
        }, startIndex, registerSpannableText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return registerSpannableText;
    }

    private void setupButtonLogin() {
        binding.btnLogin.setOnClickListener(this::loginUser);
    }

    private void loginUser(View view) {
        loginUserViewModel.loginUser(
            getTextInputLayoutValue(binding.tilEmail),
            getTextInputLayoutValue(binding.tilPassword)
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

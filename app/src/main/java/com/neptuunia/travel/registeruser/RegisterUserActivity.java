package com.neptuunia.travel.registeruser;

import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityRegisterUserBinding;

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
public class RegisterUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityRegisterUserBinding binding;

    private RegisterUserViewModel registerUserViewModel;

    @Override
    public View getView() {
        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initRegisterViewModel();
        setupToolbar();
        setupOnSubmitClick();
        setupLoginTextView();
        setupOnSuccessRegisterUser();
        setupOnErrorRegisterUser();
    }

    private void initRegisterViewModel() {
        registerUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(RegisterUserViewModel.class);
    }

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.signup);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void setupOnSubmitClick() {
        binding.viewRegister.btnSignUp.setOnClickListener(view -> {
            RegisterUserRequest registerUserRequest = new RegisterUserRequest();
            registerUserRequest.setEmail(getTextInputLayoutValue(binding.viewRegister.tilEmail));
            registerUserRequest.setPassword(
                getTextInputLayoutValue(binding.viewRegister.tilPassword)
            );
            registerUserRequest.setUserName(getTextInputLayoutValue(binding.viewRegister.tilName));
            registerUserRequest.setPhoneNumber(
                getTextInputLayoutValue(binding.viewRegister.tilPhoneNumber)
            );

            registerUserViewModel.registerUser(registerUserRequest);
        });
    }

    private void setupLoginTextView() {
        binding.viewRegister.tvLoginLabel.setText(getLoginSpannableText());
        binding.viewRegister.tvLoginLabel.setMovementMethod(LinkMovementMethod.getInstance());
        binding.viewRegister.tvLoginLabel.setHighlightColor(Color.TRANSPARENT);
    }

    private SpannableString getLoginSpannableText() {
        String loginHere = getString(R.string.login);
        SpannableString loginSpannableText = new SpannableString(
            String.format(getString(R.string.have_an_account), loginHere)
        );
        int startIndex = loginSpannableText.length() - loginHere.length();

        loginSpannableText.setSpan(new ClickableSpan() {

            @Override
            public void onClick(@NonNull View widget) {
                onBackPressed();
            }
        }, startIndex, loginSpannableText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return loginSpannableText;
    }

    private void setupOnSuccessRegisterUser() {
        registerUserViewModel.getSuccessRegisterUserLiveData()
            .observe(this, commonResponse -> {
                    showMessage(getString(R.string.register_success));
                    finish();
                }
            );
    }

    private void setupOnErrorRegisterUser() {
        registerUserViewModel.getErrorLiveData().observe(this, this::showErrorMessage);
    }
}

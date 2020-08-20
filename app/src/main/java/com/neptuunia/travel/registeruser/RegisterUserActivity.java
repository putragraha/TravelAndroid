package com.neptuunia.travel.registeruser;

import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityRegisterUserBinding;

import android.view.View;

import javax.inject.Inject;

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
        setupOnSubmitClick();
        setupOnSuccessRegisterUser();
        setupOnErrorRegisterUser();
    }

    private void initRegisterViewModel() {
        registerUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(RegisterUserViewModel.class);
    }

    private void setupOnSubmitClick() {
        binding.btnSubmit.setOnClickListener(view -> {
            if (isPasswordMatch()) {
                RegisterUserRequest registerUserRequest = new RegisterUserRequest();
                registerUserRequest.setEmail(getEditTextValue(binding.acetEmail));
                registerUserRequest.setPassword(getEditTextValue(binding.acetPassword));
                registerUserRequest.setUserName(getEditTextValue(binding.acetName));
                registerUserRequest.setPhoneNumber(getEditTextValue(binding.acetPhoneNumber));

                registerUserViewModel.registerUser(registerUserRequest);
            } else {
                binding.acetConfirmPassword.setError(getString(R.string.password_did_not_match));
            }
        });
    }

    private boolean isPasswordMatch() {
        return getEditTextValue(binding.acetPassword)
            .equals(getEditTextValue(binding.acetConfirmPassword));
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

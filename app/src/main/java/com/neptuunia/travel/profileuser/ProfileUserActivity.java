package com.neptuunia.travel.profileuser;

import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.response.ProfileUserResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityProfileUserBinding;

import android.view.View;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileUserActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ProfileUserViewModel profileUserViewModel;

    private ActivityProfileUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityProfileUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initProfileUserViewModel();
        setupToolbar();
        setupOnSuccessGetProfileUser();
        setupOnSuccessEditProfileUser();
        setupOnSuccessChangePassword();
        setupOnErrorGetProfileUser();
        setupOnUpdateClick();
        setupOnChangePasswordClick();
    }

    private void initProfileUserViewModel() {
        profileUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(ProfileUserViewModel.class);
    }

    private void setupToolbar() {
        binding.viewToolbar.actvTitle.setText(R.string.profile);
        binding.viewToolbar.acivArrowBack.setOnClickListener(view -> onBackPressed());
    }

    private void setupOnSuccessGetProfileUser() {
        profileUserViewModel.getSuccessGetProfileUserLiveData()
            .observe(this, this::setupForm);
    }

    private void setupOnSuccessEditProfileUser() {
        profileUserViewModel.getSuccessEditProfileUserLiveData()
            .observe(this, commonResponse -> showMessage(getString(R.string.update_success)));
    }

    private void setupForm(ProfileUserResponse profileUserResponse) {
        binding.tietName.setText(profileUserResponse.getName());
        binding.tietEmail.setText(profileUserResponse.getEmail());
        binding.tietPhoneNumber.setText(profileUserResponse.getPhoneNumber());
    }

    private void setupOnSuccessChangePassword() {
        profileUserViewModel.getSuccessChangePasswordLiveData()
            .observe(this, commonResponse -> showMessage(getString(R.string.password_changed)));
    }

    private void setupOnErrorGetProfileUser() {
        profileUserViewModel.getErrorLiveData()
            .observe(this, this::showErrorMessage);
    }

    private void setupOnUpdateClick() {
        binding.btnUpdate.setOnClickListener(view -> {
            EditProfileUserRequest editProfileUserRequest = new EditProfileUserRequest();
            editProfileUserRequest.setEmail(getTextInputLayoutValue(binding.tilEmail));
            editProfileUserRequest.setName(getTextInputLayoutValue(binding.tilName));
            editProfileUserRequest.setPhoneNumber(getTextInputLayoutValue(binding.tilPhoneNumber));

            profileUserViewModel.editProfileUser(editProfileUserRequest);
        });
    }

    private void setupOnChangePasswordClick() {
        binding.btnChange.setOnClickListener(view -> {
            if (isPasswordMatch()) {
                profileUserViewModel.changePassword(
                    getTextInputLayoutValue(binding.tilNewPassword),
                    getTextInputLayoutValue(binding.tilOldPassword)
                );
            } else {
                binding.tilConfirmPassword.setError(getString(R.string.password_did_not_match));
            }
        });
    }

    private boolean isPasswordMatch() {
        return getTextInputLayoutValue(binding.tilNewPassword).equals(
            getTextInputLayoutValue(binding.tilConfirmPassword)
        );
    }
}

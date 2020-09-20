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
        fetchProfileUser();
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

    private void fetchProfileUser() {
        profileUserViewModel.fetchProfileUser();
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
        binding.acetName.setText(profileUserResponse.getName());
        binding.acetEmail.setText(profileUserResponse.getEmail());
        binding.acetPhoneNumber.setText(profileUserResponse.getPhoneNumber());
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
            editProfileUserRequest.setEmail(getEditTextValue(binding.acetEmail));
            editProfileUserRequest.setName(getEditTextValue(binding.acetName));
            editProfileUserRequest.setPhoneNumber(getEditTextValue(binding.acetPhoneNumber));

            profileUserViewModel.editProfileUser(editProfileUserRequest);
        });
    }

    private void setupOnChangePasswordClick() {
        binding.btnChange.setOnClickListener(view -> {
            if (isPasswordMatch()) {
                profileUserViewModel.changePassword(
                    getEditTextValue(binding.acetNewPassword),
                    getEditTextValue(binding.acetOldPassword)
                );
            } else {
                binding.acetConfirmPassword.setError(getString(R.string.password_did_not_match));
            }
        });
    }

    private boolean isPasswordMatch() {
        return getEditTextValue(binding.acetNewPassword).equals(
            getEditTextValue(binding.acetConfirmPassword)
        );
    }
}

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
        setupOnSuccessGetProfileUser();
        setupOnSuccessEditProfileDriver();
        setupOnErrorGetProfileDriver();
        setupOnUpdateClick();
    }

    private void initProfileUserViewModel() {
        profileUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(ProfileUserViewModel.class);
    }

    private void setupOnSuccessGetProfileUser() {
        profileUserViewModel.getSuccessGetProfileUserLiveData()
            .observe(this, this::setupForm);
    }

    private void setupOnSuccessEditProfileDriver() {
        profileUserViewModel.getSuccessEditProfileUserLiveData()
            .observe(this, commonResponse -> showMessage(getString(R.string.update_success)));
    }

    private void setupForm(ProfileUserResponse profileUserResponse) {
        binding.acetName.setText(profileUserResponse.getName());
        binding.acetEmail.setText(profileUserResponse.getEmail());
        binding.acetPhoneNumber.setText(profileUserResponse.getPhoneNumber());
    }

    private void setupOnErrorGetProfileDriver() {
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
}

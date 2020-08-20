package com.neptuunia.travel.profileuser;

import com.neptuunia.data.user.model.response.ProfileUserResponse;
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
        setupOnErrorGetProfileDriver();
    }

    private void setupOnErrorGetProfileDriver() {
        profileUserViewModel.getErrorProfileUserLiveData()
            .observe(this, this::showErrorMessage);
    }

    private void initProfileUserViewModel() {
        profileUserViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(ProfileUserViewModel.class);
    }

    private void setupOnSuccessGetProfileUser() {
        profileUserViewModel.getSuccessGetProfileUserLiveData()
            .observe(this, this::setupForm);
    }

    private void setupForm(ProfileUserResponse profileUserResponse) {
        binding.acetName.setText(profileUserResponse.getName());
        binding.acetEmail.setText(profileUserResponse.getEmail());
        binding.acetPhoneNumber.setText(profileUserResponse.getPhoneNumber());
    }
}

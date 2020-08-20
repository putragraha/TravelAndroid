package com.neptuunia.travel.profiledriver;

import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.databinding.ActivityProfileDriverBinding;

import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileDriverActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityProfileDriverBinding binding;

    private ProfileDriverViewModel profileDriverViewModel;

    @Override
    public View getView() {
        binding = ActivityProfileDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initProfileDriverViewModel();
        setupOnSuccessGetProfileDriver();
        setupOnSuccessEditProfileDriver();
        setupOnErrorGetProfileDriver();
        setupOnEditClick();
    }

    private void initProfileDriverViewModel() {
        profileDriverViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(ProfileDriverViewModel.class);
    }

    private void setupOnSuccessGetProfileDriver() {
        profileDriverViewModel.getSuccessGetProfileDriverLiveData()
            .observe(this, this::setupForm);
    }

    private void setupOnSuccessEditProfileDriver() {
        profileDriverViewModel.getSuccessEditProfileDriverLiveData()
            .observe(this, commonResponse -> showMessage(getString(R.string.update_success)));
    }

    private void setupOnErrorGetProfileDriver() {
        profileDriverViewModel.getErrorProfileDriverLiveData()
            .observe(this, this::showErrorMessage);
    }

    private void setupForm(ProfileDriverResponse profileDriverResponse) {
        binding.acetName.setText(profileDriverResponse.getName());
        binding.acetEmail.setText(profileDriverResponse.getEmail());
        binding.acetGroup.setText(profileDriverResponse.getGroup());
        binding.acetPhoneNumber.setText(profileDriverResponse.getPhoneNumber());
    }

    private void setupOnEditClick() {
        binding.btnUpdate.setOnClickListener(view ->
            profileDriverViewModel.editProfileDriver(
                getEditTextValue(binding.acetName),
                getEditTextValue(binding.acetPhoneNumber)
            )
        );
    }

    private String getEditTextValue(EditText editText) {
        return editText.getText() == null ? "" : editText.getText().toString().trim();
    }
}

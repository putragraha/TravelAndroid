package com.neptuunia.travel.registeruser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityRegisterUserBinding;

import android.view.View;

public class RegisterUserActivity extends BaseActivity {

    private ActivityRegisterUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation yet
    }
}

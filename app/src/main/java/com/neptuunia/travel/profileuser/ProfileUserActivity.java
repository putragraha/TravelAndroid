package com.neptuunia.travel.profileuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityProfileDriverBinding;
import com.neptuunia.travel.databinding.ActivityProfileUserBinding;

import android.view.View;

public class ProfileUserActivity extends BaseActivity {

    private ActivityProfileUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityProfileUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation yet
    }
}

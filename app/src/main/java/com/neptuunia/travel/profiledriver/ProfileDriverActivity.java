package com.neptuunia.travel.profiledriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityProfileDriverBinding;

import android.view.View;

public class ProfileDriverActivity extends BaseActivity {

    private ActivityProfileDriverBinding binding;

    @Override
    public View getView() {
        binding = ActivityProfileDriverBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation yet
    }
}

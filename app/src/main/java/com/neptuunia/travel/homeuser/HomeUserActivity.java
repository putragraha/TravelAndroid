package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;
import com.neptuunia.travel.profileuser.ProfileUserActivity;

import android.view.View;

public class HomeUserActivity extends BaseActivity {

    private ActivityHomeUserBinding binding;

    @Override
    public View getView() {
        binding = ActivityHomeUserBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        binding.btnProfile.setOnClickListener(view ->
            startActivity(ProfileUserActivity.class)
        );
    }
}

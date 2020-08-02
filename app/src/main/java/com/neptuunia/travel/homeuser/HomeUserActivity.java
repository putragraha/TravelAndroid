package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;

import android.view.View;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeUserActivity extends BaseActivity {

    @Inject
    ActivityHomeUserBinding activityHomeUserBinding;

    @Override
    public View getView() {
        return activityHomeUserBinding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation
    }
}

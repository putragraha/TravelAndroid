package com.neptuunia.travel.profileuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityProfileDriverBinding;
import com.neptuunia.travel.databinding.ActivityProfileUserBinding;

import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ProfileDriverActivity, v 0.0.1 08/08/20 22.48 by Putra Nugraha
 */
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

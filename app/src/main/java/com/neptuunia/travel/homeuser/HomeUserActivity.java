package com.neptuunia.travel.homeuser;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityHomeUserBinding;

import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HomeUserActivity, v 0.0.1 19/07/20 09.28 by Putra Nugraha
 */
public class HomeUserActivity extends BaseActivity {

    private ActivityHomeUserBinding activityHomeUserBinding;

    @Override
    public View getView() {
        activityHomeUserBinding = ActivityHomeUserBinding.inflate(getLayoutInflater());
        return activityHomeUserBinding.getRoot();
    }

    @Override
    public void setup() {
        // No implementation
    }
}

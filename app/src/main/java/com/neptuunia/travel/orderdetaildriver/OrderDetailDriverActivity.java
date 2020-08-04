package com.neptuunia.travel.orderdetaildriver;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityOrderDetailDriverBinding;

import android.view.View;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderDetailDriverActivity, v 0.0.1 04/08/20 07.39 by Putra Nugraha
 */
public class OrderDetailDriverActivity extends BaseActivity {

    private ActivityOrderDetailDriverBinding activityOrderDetailDriverBinding;

    @Override
    public View getView() {
        activityOrderDetailDriverBinding =
            ActivityOrderDetailDriverBinding.inflate(getLayoutInflater());
        return activityOrderDetailDriverBinding.getRoot();
    }

    @Override
    public void setup() {
        // No Implementation
    }
}

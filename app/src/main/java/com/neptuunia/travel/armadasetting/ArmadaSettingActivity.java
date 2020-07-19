package com.neptuunia.travel.armadasetting;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityArmadaSettingBinding;

import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaSettingActivity, v 0.0.1 19/07/20 11.32 by Putra Nugraha
 */
public class ArmadaSettingActivity extends BaseActivity {

    private ActivityArmadaSettingBinding activityArmadaSettingBinding;

    @Override
    public View getView() {
        activityArmadaSettingBinding = ActivityArmadaSettingBinding.inflate(getLayoutInflater());
        return activityArmadaSettingBinding.getRoot();
    }

    @Override
    public void setup() {
        setupEditTextDepartureTime();
    }

    private void setupEditTextDepartureTime() {
        Calendar calendar = Calendar.getInstance();
        activityArmadaSettingBinding.etDepartureTime.setOnClickListener(view ->
                new TimePickerDialog(
                    this,
                    this::setTimeEditTextDepartureTime,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    DateFormat.is24HourFormat(this)
                ).show()
        );
    }

    private void setTimeEditTextDepartureTime(TimePicker timePicker, int hourOfDay, int minute) {
        activityArmadaSettingBinding.etDepartureTime.setText(
            String.format("%s:%s", hourOfDay, minute)
        );
    }
}

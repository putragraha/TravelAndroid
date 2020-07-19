package com.neptuunia.travel.armadasetting;

import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivityArmadaSettingBinding;
import com.neptuunia.travel.utils.DateTimeUtils;
import com.neptuunia.travel.utils.NumberUtils;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

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
        setupEditTextDepartureDate();
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
            String.format(
                DateTimeUtils.TIME_STRING_FORMAT,
                NumberUtils.getTwoDigitsNumber(hourOfDay),
                NumberUtils.getTwoDigitsNumber(minute)
            )
        );
    }

    private void setupEditTextDepartureDate() {
        Calendar calendar = Calendar.getInstance();
        activityArmadaSettingBinding.etDepartureDate.setOnClickListener(view ->
            new DatePickerDialog(
                this,
                this::setDateEditTextDepartureDate,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        );
    }

    private void setDateEditTextDepartureDate(DatePicker datePicker, int year, int month,
        int dayOfMonth) {
        activityArmadaSettingBinding.etDepartureDate.setText(
            String.format(
                DateTimeUtils.DATE_STRING_FORMAT,
                NumberUtils.getTwoDigitsNumber(dayOfMonth),
                NumberUtils.getTwoDigitsNumber(month + 1),
                year
            )
        );
    }
}

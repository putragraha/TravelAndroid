package com.neptuunia.travel.armadasetting;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.common.ViewModelFactory;
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

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ArmadaSettingActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;

    private ActivityArmadaSettingBinding binding;

    private ArmadaSettingViewModel armadaSettingViewModel;

    @Override
    public View getView() {
        binding = ActivityArmadaSettingBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initArmadaSettingViewModel();
        setupEditTextDepartureTime();
        setupEditTextDepartureDate();
        setupOnSubmitClicked();
        setupOnSuccessAddArmada();
        setupOnErrorAddArmada();
    }

    private void initArmadaSettingViewModel() {
        armadaSettingViewModel = new ViewModelProvider(this, viewModelFactory)
            .get(ArmadaSettingViewModel.class);
    }

    private void setupEditTextDepartureTime() {
        Calendar calendar = Calendar.getInstance();
        binding.acetDepartureTime.setOnClickListener(view ->
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
        binding.acetDepartureTime.setText(
            String.format(
                DateTimeUtils.TIME_STRING_FORMAT,
                NumberUtils.getTwoDigitsNumber(hourOfDay),
                NumberUtils.getTwoDigitsNumber(minute)
            )
        );
    }

    private void setupEditTextDepartureDate() {
        Calendar calendar = Calendar.getInstance();
        binding.acetDepartureDate.setOnClickListener(view ->
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
        binding.acetDepartureDate.setText(
            String.format(
                DateTimeUtils.DATE_STRING_FORMAT,
                NumberUtils.getTwoDigitsNumber(dayOfMonth),
                NumberUtils.getTwoDigitsNumber(month + 1),
                year
            )
        );
    }

    private void setupOnSubmitClicked() {
        binding.btnSubmit.setOnClickListener(this::addArmada);
    }

    private void addArmada(View view) {
        AddArmadaRequest addArmadaRequest = new AddArmadaRequest();
        addArmadaRequest.setArmadaClass("");
        addArmadaRequest.setDatetime(getDateTimeInMillis());
        addArmadaRequest.setNote(getEditTextValue(binding.etNote));
        addArmadaRequest.setPrice(getEditTextAsInteger(binding.etTicketPrice));
        addArmadaRequest.setSeatAmount(getEditTextAsInteger(binding.etSeatAmount));

        armadaSettingViewModel.addArmada(addArmadaRequest);
    }

    private String getDateTimeInMillis() {
        return String.valueOf(
            DateTimeUtils.parseToMillis(
                getEditTextValue(binding.acetDepartureDate),
                getEditTextValue(binding.acetDepartureTime)
            )
        );
    }

    private void setupOnSuccessAddArmada() {
        armadaSettingViewModel.getSuccessAddArmadaLiveData()
            .observe(this, commonResponse -> {
                showMessage(getString(R.string.add_success));
                finish();
            });
    }

    private void setupOnErrorAddArmada() {
        armadaSettingViewModel.getErrorLiveData()
            .observe(this, this::showErrorMessage);
    }
}

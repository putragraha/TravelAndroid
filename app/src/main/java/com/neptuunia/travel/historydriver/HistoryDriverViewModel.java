package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HistoryDriverViewModel extends AndroidViewModel {

    private MutableLiveData<List<HistoryDriverResponse>> historyDriverResponseLiveData =
        new MutableLiveData<>();

    private DriverRepository driverRepository;

    private List<HistoryDriverResponse> historyDriverResponses = new ArrayList<>();

    @Inject
    public HistoryDriverViewModel(
        @NonNull Application application,
        DriverRepository driverRepository
    ) {
        super(application);
        this.driverRepository = driverRepository;
    }

    public LiveData<List<HistoryDriverResponse>> getHistoryDrivers() {
        return historyDriverResponseLiveData;
    }

    public void fetchHistoryDrivers() {
        driverRepository.getHistoryDrivers()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<List<HistoryDriverResponse>>() {

                @Override
                public void onSuccess(List<HistoryDriverResponse> historyDriverResponses) {
                    super.onSuccess(historyDriverResponses);
                    HistoryDriverViewModel.this.historyDriverResponses = historyDriverResponses;
                    historyDriverResponseLiveData.postValue(historyDriverResponses);
                }
            });
    }

    public void filterHistoryDrivers(long minDate, long maxDate) {
        List<HistoryDriverResponse> results = new ArrayList<>();

        for (HistoryDriverResponse historyDriverResponse : historyDriverResponses) {
            long datetime = Long.parseLong(historyDriverResponse.getDatetime());

            if (datetime >= minDate && datetime <= maxDate) {
                results.add(historyDriverResponse);
            }
        }

        historyDriverResponseLiveData.postValue(results);
    }

    public void clearHistoryDrivers() {
        historyDriverResponseLiveData.postValue(historyDriverResponses);
    }
}

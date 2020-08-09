package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author nSystem
 * @version HistoryDriverViewModel, v 0.0.1 19/07/20 19.57 by nSystem
 */
public class HistoryDriverViewModel extends AndroidViewModel {

    private MutableLiveData<List<HistoryDriverResponse>> historyDriverResponseLiveData =
        new MutableLiveData<>();

    private DriverRepository driverRepository;

    @Inject
    public HistoryDriverViewModel(
        @NonNull Application application,
        DriverRepository driverRepository
    ) {
        super(application);
        this.driverRepository = driverRepository;
        fetchHistoryDrivers();
    }

    public LiveData<List<HistoryDriverResponse>> getHistoryDrivers() {
        return historyDriverResponseLiveData;
    }

    private void fetchHistoryDrivers() {
        driverRepository.getHistoryDrivers()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<List<HistoryDriverResponse>>() {

                @Override
                public void onSuccess(List<HistoryDriverResponse> historyDriverResponses) {
                    super.onSuccess(historyDriverResponses);
                    historyDriverResponseLiveData.postValue(historyDriverResponses);
                }
            });
    }
}

package com.neptuunia.travel.historydriver;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.DriverEntityRepository;

import android.app.Application;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author nSystem
 * @version HistoryDriverViewModel, v 0.0.1 19/07/20 19.57 by nSystem
 */
public class HistoryDriverViewModel extends AndroidViewModel {

    private static final String TAG = HistoryDriverViewModel.class.getSimpleName();

    private MutableLiveData<List<HistoryDriverResponse>> historyDriverResponseLiveData =
        new MutableLiveData<>();

    private DriverEntityRepository driverEntityRepository;

    @Inject
    public HistoryDriverViewModel(
        @NonNull Application application,
        DriverEntityRepository driverEntityRepository
    ) {
        super(application);
        this.driverEntityRepository = driverEntityRepository;
        fetchHistoryDrivers();
    }

    public LiveData<List<HistoryDriverResponse>> getHistoryDrivers() {
        return historyDriverResponseLiveData;
    }

    private void fetchHistoryDrivers() {
        driverEntityRepository.getHistoryDrivers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new DisposableSingleObserver<List<HistoryDriverResponse>>() {
                @Override
                public void onSuccess(
                    @io.reactivex.rxjava3.annotations.NonNull List<HistoryDriverResponse> historyDriverResponses
                ) {
                    historyDriverResponseLiveData.postValue(historyDriverResponses);
                    dispose();
                }

                @Override
                public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                    Log.e(TAG, "onError: " + e.getMessage());
                    dispose();
                }
            });
    }
}

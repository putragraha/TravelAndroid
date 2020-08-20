package com.neptuunia.travel.profiledriver;

import com.neptuunia.data.driver.model.ProfileDriverResponse;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileDriverViewModel extends AndroidViewModel {

    private MutableLiveData<ProfileDriverResponse> successLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private DriverRepository driverRepository;

    @Inject
    public ProfileDriverViewModel(
        @NonNull Application application,
        DriverRepository driverRepository
    ) {
        super(application);
        this.driverRepository = driverRepository;
        fetchProfileDriver();
    }

    public LiveData<ProfileDriverResponse> getSuccessProfileDriverLiveData() {
        return successLiveData;
    }

    public MutableLiveData<String> getErrorProfileDriverLiveData() {
        return errorLiveData;
    }

    private void fetchProfileDriver() {
        driverRepository.getProfileDriver()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<ProfileDriverResponse>() {

                @Override
                public void onSuccess(ProfileDriverResponse profileDriverResponse) {
                    super.onSuccess(profileDriverResponse);
                    successLiveData.postValue(profileDriverResponse);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    errorLiveData.postValue(e.getMessage());
                }
            });
    }
}

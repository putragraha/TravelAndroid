package com.neptuunia.travel.profiledriver;

import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileDriverViewModel extends AndroidViewModel {

    private MutableLiveData<ProfileDriverResponse> successGetProfileDriverLiveData =
        new MutableLiveData<>();

    private MutableLiveData<CommonResponse> successEditProfileDriverLiveData =
        new MutableLiveData<>();

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

    public LiveData<ProfileDriverResponse> getSuccessGetProfileDriverLiveData() {
        return successGetProfileDriverLiveData;
    }

    public MutableLiveData<CommonResponse> getSuccessEditProfileDriverLiveData() {
        return successEditProfileDriverLiveData;
    }

    public MutableLiveData<String> getErrorProfileDriverLiveData() {
        return errorLiveData;
    }

    public void editProfileDriver(String name, String phoneNumber) {
        driverRepository.updateProfileDriver(name, phoneNumber)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>() {

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        successEditProfileDriverLiveData.postValue(commonResponse);
                    } else {
                        errorLiveData.postValue("");
                    }
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    errorLiveData.postValue(e.getMessage());
                }
            });
    }

    private void fetchProfileDriver() {
        driverRepository.getProfileDriver()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<ProfileDriverResponse>() {

                @Override
                public void onSuccess(ProfileDriverResponse profileDriverResponse) {
                    super.onSuccess(profileDriverResponse);
                    successGetProfileDriverLiveData.postValue(profileDriverResponse);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    errorLiveData.postValue(e.getMessage());
                }
            });
    }
}

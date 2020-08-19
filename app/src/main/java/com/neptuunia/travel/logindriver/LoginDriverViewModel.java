package com.neptuunia.travel.logindriver;

import com.neptuunia.data.driver.model.LoginDriverResponse;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginDriverViewModel, v 0.0.1 18/08/20 08.32 by Putra Nugraha
 */
public class LoginDriverViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> successLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private DriverRepository driverRepository;

    @Inject
    public LoginDriverViewModel(
        @NonNull Application application,
        DriverRepository driverRepository
    ) {
        super(application);
        this.driverRepository = driverRepository;
    }

    public MutableLiveData<Boolean> getSuccessLiveData() {
        return successLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void loginDriver(String email, String password) {
        driverRepository.loginDriver(email, password)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<LoginDriverResponse>(){

                @Override
                public void onSuccess(LoginDriverResponse loginDriverResponse) {
                    super.onSuccess(loginDriverResponse);

                    if (loginDriverResponse.isSuccess()) {
                        successLiveData.postValue(loginDriverResponse.isSuccess());
                    } else {
                        errorLiveData.postValue("");
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    super.onError(throwable);
                    errorLiveData.postValue(throwable.getMessage());
                }
            });
    }
}

package com.neptuunia.travel.registeruser;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.data.user.repository.UserRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RegisterUserViewModel extends AndroidViewModel {

    private MutableLiveData<CommonResponse> successRegisterUserLiveData =
        new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private UserRepository userRepository;

    @Inject
    public RegisterUserViewModel(
        @NonNull Application application,
        UserRepository userRepository
    ) {
        super(application);
        this.userRepository = userRepository;
    }

    public LiveData<CommonResponse> getSuccessRegisterUserLiveData() {
        return successRegisterUserLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void registerUser(RegisterUserRequest registerUserRequest) {
        userRepository.registerUser(registerUserRequest)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>() {

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        successRegisterUserLiveData.postValue(commonResponse);
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
}

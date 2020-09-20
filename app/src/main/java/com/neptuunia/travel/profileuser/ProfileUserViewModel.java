package com.neptuunia.travel.profileuser;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.response.ProfileUserResponse;
import com.neptuunia.data.user.repository.UserRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileUserViewModel extends AndroidViewModel {

    private MutableLiveData<ProfileUserResponse> successGetProfileUserLiveData =
        new MutableLiveData<>();

    private MutableLiveData<CommonResponse> successEditProfileUserLiveData =
        new MutableLiveData<>();

    private MutableLiveData<CommonResponse> successChangePasswordLiveData =
        new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private UserRepository userRepository;

    @Inject
    public ProfileUserViewModel(
        @NonNull Application application,
        UserRepository userRepository
    ) {
        super(application);
        this.userRepository = userRepository;
    }

    public void fetchProfileUser() {
        userRepository.getProfileUser()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<ProfileUserResponse>() {

                @Override
                public void onSuccess(ProfileUserResponse profileUserResponse) {
                    super.onSuccess(profileUserResponse);
                    successGetProfileUserLiveData.postValue(profileUserResponse);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    errorLiveData.postValue(e.getMessage());
                }
            });
    }

    public LiveData<ProfileUserResponse> getSuccessGetProfileUserLiveData() {
        return successGetProfileUserLiveData;
    }

    public MutableLiveData<CommonResponse> getSuccessEditProfileUserLiveData() {
        return successEditProfileUserLiveData;
    }

    public MutableLiveData<CommonResponse> getSuccessChangePasswordLiveData() {
        return successChangePasswordLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void editProfileUser(EditProfileUserRequest editProfileUserRequest) {
        userRepository.updateProfileUser(editProfileUserRequest)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>() {

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        successEditProfileUserLiveData.postValue(commonResponse);
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

    public void changePassword(String newPassword, String oldPassword) {
        userRepository.changePassword(newPassword, oldPassword)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>() {

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        successChangePasswordLiveData.postValue(commonResponse);
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

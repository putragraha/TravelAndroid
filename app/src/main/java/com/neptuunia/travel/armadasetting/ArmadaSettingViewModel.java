package com.neptuunia.travel.armadasetting;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.armada.repository.ArmadaRepository;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ArmadaSettingViewModel extends AndroidViewModel {

    private ArmadaRepository armadaRepository;

    private MutableLiveData<CommonResponse> successAddArmadaLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    @Inject
    public ArmadaSettingViewModel(
        @NonNull Application application,
        ArmadaRepository armadaRepository
    ) {
        super(application);
        this.armadaRepository = armadaRepository;
    }

    public MutableLiveData<CommonResponse> getSuccessAddArmadaLiveData() {
        return successAddArmadaLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void addArmada(AddArmadaRequest addArmadaRequest) {
        armadaRepository.addArmada(addArmadaRequest)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>(){

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        successAddArmadaLiveData.postValue(commonResponse);
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

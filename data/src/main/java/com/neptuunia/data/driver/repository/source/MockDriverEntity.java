package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import java.util .ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MockDriverEntity implements DriverEntity {

    @Inject
    public MockDriverEntity() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers(CommonRequest commonRequest) {
        List<HistoryDriverResponse> armadaSettingResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            HistoryDriverResponse armadaSettingResponse = new HistoryDriverResponse();
            armadaSettingResponse.setOrderCode("String code: " + i);
            armadaSettingResponse.setGroup(String.format("Group: %s", i));
            armadaSettingResponse.setArmadaClass(String.format("Armada Class: %s", i));
            armadaSettingResponse.setUserName(String.format("User Name: %s", i));
            armadaSettingResponse.setLatitude("Latitude: " + i);
            armadaSettingResponse.setLongitude("Longitude: " + i);
            armadaSettingResponse.setNote(String.format("Code: %s", i));
            armadaSettingResponse.setTotalPrice(i);
            armadaSettingResponse.setSeatBooked(String.format("Seat number: %s", i));

            armadaSettingResponses.add(armadaSettingResponse);
        }

        return Single.just(armadaSettingResponses);
    }

    @Override
    public Single<ProfileDriverResponse> getProfileDriver(CommonRequest commonRequest) {
        return Single.just(new ProfileDriverResponse());
    }

    @Override
    public Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest) {
        return Single.just(new LoginDriverResponse());
    }

    @Override
    public Single<CommonResponse> updateProfileDriver(EditProfileDriverRequest editProfileDriverRequest) {
        return Single.just(new CommonResponse());
    }
}

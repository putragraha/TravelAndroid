package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.user.model.request.LoginUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MockUserEntity implements UserEntity {

    @Inject
    public MockUserEntity() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers() {
        List<HistoryUserResponse> historyUserResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            HistoryUserResponse historyUserResponse = new HistoryUserResponse();
            historyUserResponse.setOrderCode("Code" + i);
            historyUserResponse.setGroup("Group: " + i);
            historyUserResponse.setArmadaClass("Armada Class: " + i);
            historyUserResponse.setPhotoUrl("PhotoUrl" + i);
            historyUserResponse.setDriverName("DriverName " + i);
            historyUserResponse.setDriverPhoneNumber("Driver Phone Number " + i);
            historyUserResponse.setSeatAmount(i);
            historyUserResponse.setTotalPrice(i * 120000);
            historyUserResponse.setDepartureDate("DepartureDate" + i);
            historyUserResponse.setDepartureTime("DepartureTime" + i);
            historyUserResponse.setLatitude(i);
            historyUserResponse.setLongitude(i);
            historyUserResponse.setNote("Note" + i);

            historyUserResponses.add(historyUserResponse);
        }

        return Single.just(historyUserResponses);
    }

    @Override
    public Single<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest) {
        return Single.just(new LoginUserResponse());
    }
}

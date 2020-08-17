package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.user.model.HistoryUserResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MockUserEntity, v 0.0.1 09/08/20 01.46 by Putra Nugraha
 */
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
}

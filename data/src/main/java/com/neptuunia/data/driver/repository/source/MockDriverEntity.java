package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util .ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MockDriverEntityData, v 0.0.1 19/07/20 14.50 by Putra Nugraha
 */
public class MockDriverEntity implements DriverEntity {

    public MockDriverEntity() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        List<HistoryDriverResponse> armadaSettingResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            HistoryDriverResponse armadaSettingResponse = new HistoryDriverResponse();
            armadaSettingResponse.setOrderCode(i);
            armadaSettingResponse.setUserName(String.format("Nama: %s", i));
            armadaSettingResponse.setLatitude(i);
            armadaSettingResponse.setLongitude(i);
            armadaSettingResponse.setNote(String.format("Code: %s", i));
            armadaSettingResponse.setPrice(i);
            armadaSettingResponse.setSeatBooked(String.format("Seat number: %s", i));

            armadaSettingResponses.add(armadaSettingResponse);
        }

        return Single.just(armadaSettingResponses);
    }
}

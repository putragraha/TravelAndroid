package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverEntity {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();

    Single<Boolean> loginDriver(String email, String password);
}

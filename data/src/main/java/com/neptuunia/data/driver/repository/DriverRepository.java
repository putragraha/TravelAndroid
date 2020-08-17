package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverRepository {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();
}

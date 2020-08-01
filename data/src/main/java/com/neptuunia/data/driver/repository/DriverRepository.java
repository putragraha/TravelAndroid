package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author nSystem
 * @version DriverRepository, v 0.0.1 19/07/20 14.18 by nSystem
 */
public interface DriverRepository {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();
}

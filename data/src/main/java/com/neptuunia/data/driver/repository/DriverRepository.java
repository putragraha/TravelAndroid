package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Rengar
 * @version DriverRepository, v 0.0.1 19/07/20 14.18 by Rengar
 */
public interface DriverRepository {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();
}

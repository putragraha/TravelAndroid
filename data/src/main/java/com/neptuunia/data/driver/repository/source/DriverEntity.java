package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.HistoryDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version DriverEntityData, v 0.0.1 19/07/20 14.49 by Putra Nugraha
 */
public interface DriverEntity {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();
}

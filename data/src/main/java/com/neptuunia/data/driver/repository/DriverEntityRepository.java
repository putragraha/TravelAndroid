package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.source.DriverEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author nSystem
 * @version DriverEntityRepository, v 0.0.1 19/07/20 15.18 by nSystem
 */
public class DriverEntityRepository implements DriverRepository {

    public DriverEntityRepository() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        return createDriverEntity(Source.MOCK)
            .getHistoryDrivers();
    }

    public DriverEntity createDriverEntity(@Source String source) {
        return new DriverEntityFactory().createDriverEntity(source);
    }
}

package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.source.DriverEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Rengar
 * @version DriverEntityRepository, v 0.0.1 19/07/20 15.18 by Rengar
 */
public class DriverEntityRepository implements DriverRepository {

    @Inject
    DriverEntityFactory driverEntityFactory;

    @Inject
    public DriverEntityRepository() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        return createDriverEntity()
            .getHistoryDrivers();
    }

    public DriverEntity createDriverEntity() {
        return driverEntityFactory.createDriverEntity();
    }
}

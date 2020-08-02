package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.source.DriverEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author nSystem
 * @version DriverEntityRepository, v 0.0.1 19/07/20 15.18 by nSystem
 */
public class DriverEntityRepository implements DriverRepository {

    private DriverEntityFactory driverEntityFactory;

    @Inject
    public DriverEntityRepository(DriverEntityFactory driverEntityFactory) {
        this.driverEntityFactory = driverEntityFactory;
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

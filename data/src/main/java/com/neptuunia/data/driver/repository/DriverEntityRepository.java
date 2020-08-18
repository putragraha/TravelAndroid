package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.repository.source.DriverEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class DriverEntityRepository implements DriverRepository {

    private DriverEntityFactory driverEntityFactory;

    @Inject
    public DriverEntityRepository(DriverEntityFactory driverEntityFactory) {
        this.driverEntityFactory = driverEntityFactory;
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        return createDriverEntity(Source.MOCK)
            .getHistoryDrivers();
    }

    @Override
    public Single<Boolean> loginDriver(String email, String password) {
        return createDriverEntity(Source.NETWORK)
            .loginDriver(email, password);
    }

    public DriverEntity createDriverEntity(@Source String source) {
        return driverEntityFactory.createDriverEntity(source);
    }
}

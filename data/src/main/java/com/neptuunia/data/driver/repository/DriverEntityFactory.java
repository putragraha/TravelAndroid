package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.repository.source.DriverEntity;
import com.neptuunia.data.driver.repository.source.MockDriverEntity;
import com.neptuunia.data.driver.repository.source.NetworkDriverEntity;

import javax.inject.Inject;

public class DriverEntityFactory {

    private MockDriverEntity mockDriverEntity;

    private NetworkDriverEntity networkDriverEntity;

    @Inject
    public DriverEntityFactory(
        MockDriverEntity mockDriverEntity,
        NetworkDriverEntity networkDriverEntity
    ) {
        this.mockDriverEntity = mockDriverEntity;
        this.networkDriverEntity = networkDriverEntity;
    }

    public DriverEntity createDriverEntity(@Source String source) {
        if (Source.NETWORK.equals(source)) {
            return networkDriverEntity;
        }

        return mockDriverEntity;
    }
}

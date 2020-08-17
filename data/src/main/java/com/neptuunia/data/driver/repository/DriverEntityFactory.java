package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.repository.source.DriverEntity;
import com.neptuunia.data.driver.repository.source.MockDriverEntity;

import javax.inject.Inject;

public class DriverEntityFactory {

    private MockDriverEntity mockDriverEntity;

    @Inject
    public DriverEntityFactory(MockDriverEntity mockDriverEntity) {
        this.mockDriverEntity = mockDriverEntity;
    }

    public DriverEntity createDriverEntity() {
        return mockDriverEntity;
    }
}

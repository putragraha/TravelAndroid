package com.neptuunia.data.driver.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.repository.source.DriverEntity;
import com.neptuunia.data.driver.repository.source.MockDriverEntity;

/**
 * @author Rengar
 * @version DriverEntityFactory, v 0.0.1 19/07/20 15.25 by Rengar
 */
public class DriverEntityFactory {

    public DriverEntityFactory() {
        // For dagger injection
    }

    public DriverEntity createDriverEntity(@Source String source) {
        return new MockDriverEntity();
    }
}

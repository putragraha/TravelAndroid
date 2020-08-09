package com.neptuunia.travel.di;

import com.neptuunia.data.driver.repository.DriverEntityRepository;
import com.neptuunia.data.driver.repository.DriverRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HistoryDriverActivityModule, v 0.0.1 02/08/20 07.52 by Putra Nugraha
 */
@Module
@InstallIn(ActivityComponent.class)
public class HistoryDriverActivityModule {

    @Provides
    DriverRepository provideDriverEntityRepository(DriverEntityRepository driverEntityRepository) {
        return driverEntityRepository;
    }
}

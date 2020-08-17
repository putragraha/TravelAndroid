package com.neptuunia.travel.di;

import com.neptuunia.data.driver.repository.DriverEntityRepository;
import com.neptuunia.data.driver.repository.DriverRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class HistoryDriverActivityModule {

    @Provides
    DriverRepository provideDriverEntityRepository(DriverEntityRepository driverEntityRepository) {
        return driverEntityRepository;
    }
}

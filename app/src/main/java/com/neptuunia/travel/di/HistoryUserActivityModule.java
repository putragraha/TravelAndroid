package com.neptuunia.travel.di;

import com.neptuunia.data.user.repository.UserEntityRepository;
import com.neptuunia.data.user.repository.UserRepository;

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
public class HistoryUserActivityModule {

    @Provides
    UserRepository provideUserEntityRepository(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }
}

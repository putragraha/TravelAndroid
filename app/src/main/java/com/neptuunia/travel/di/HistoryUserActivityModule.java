package com.neptuunia.travel.di;

import com.neptuunia.data.user.repository.UserEntityRepository;
import com.neptuunia.data.user.repository.UserRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class HistoryUserActivityModule {

    @Provides
    UserRepository provideUserEntityRepository(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }
}

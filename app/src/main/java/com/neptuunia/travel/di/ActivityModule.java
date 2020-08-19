package com.neptuunia.travel.di;

import com.neptuunia.data.driver.repository.DriverEntityRepository;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.data.ticket.repository.TicketEntityRepository;
import com.neptuunia.data.ticket.repository.TicketRepository;
import com.neptuunia.data.user.repository.UserEntityRepository;
import com.neptuunia.data.user.repository.UserRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ActivityModule, v 0.0.1 19/08/20 07.41 by Putra Nugraha
 */
@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {

    @Provides
    DriverRepository provideDriverRepository(DriverEntityRepository driverEntityRepository) {
        return driverEntityRepository;
    }

    @Provides
    UserRepository provideUserRepository(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }

    @Provides
    TicketRepository provideTicketRepository(TicketEntityRepository ticketEntityRepository) {
        return ticketEntityRepository;
    }
}

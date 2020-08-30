package com.neptuunia.travel.di;

import com.neptuunia.data.account.repository.AccountEntityRepository;
import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.armada.repository.ArmadaEntityRepository;
import com.neptuunia.data.armada.repository.ArmadaRepository;
import com.neptuunia.data.driver.repository.DriverEntityRepository;
import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.data.ticket.repository.TicketEntityRepository;
import com.neptuunia.data.ticket.repository.TicketRepository;
import com.neptuunia.data.user.repository.UserEntityRepository;
import com.neptuunia.data.user.repository.UserRepository;
import com.neptuunia.travel.constant.Constant;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@Module
@InstallIn(ActivityComponent.class)
public class ActivityModule {

    @Provides
    SharedPreferences provideSharedPreferences(@ActivityContext Context context) {
        return context.getSharedPreferences(Constant.SP_NAME, Context.MODE_PRIVATE);
    }

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

    @Provides
    AccountRepository provideAccountRepository(AccountEntityRepository accountEntityRepository) {
        return accountEntityRepository;
    }

    @Provides
    ArmadaRepository provideArmadaRepository(ArmadaEntityRepository armadaEntityRepository) {
        return armadaEntityRepository;
    }
}

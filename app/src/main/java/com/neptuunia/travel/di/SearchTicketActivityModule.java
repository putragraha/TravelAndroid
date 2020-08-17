package com.neptuunia.travel.di;

import com.neptuunia.data.ticket.repository.TicketEntityRepository;
import com.neptuunia.data.ticket.repository.TicketRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class SearchTicketActivityModule {

    @Provides
    TicketRepository provideDriverEntityRepository(TicketEntityRepository ticketEntityRepository) {
        return ticketEntityRepository;
    }
}

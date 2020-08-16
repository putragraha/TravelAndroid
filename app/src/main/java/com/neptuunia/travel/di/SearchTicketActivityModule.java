package com.neptuunia.travel.di;

import com.neptuunia.data.ticket.repository.TicketEntityRepository;
import com.neptuunia.data.ticket.repository.TicketRepository;

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
public class SearchTicketActivityModule {

    @Provides
    TicketRepository provideDriverEntityRepository(TicketEntityRepository ticketEntityRepository) {
        return ticketEntityRepository;
    }
}

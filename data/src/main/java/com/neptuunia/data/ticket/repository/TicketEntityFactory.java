package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.ticket.repository.source.MockTicketEntity;
import com.neptuunia.data.ticket.repository.source.NetworkTicketEntity;
import com.neptuunia.data.ticket.repository.source.TicketEntity;

import javax.inject.Inject;

public class TicketEntityFactory {

    private MockTicketEntity mockTicketEntity;

    private NetworkTicketEntity networkTicketEntity;

    @Inject
    public TicketEntityFactory(
        MockTicketEntity mockTicketEntity,
        NetworkTicketEntity networkTicketEntity
    ) {
        this.mockTicketEntity = mockTicketEntity;
        this.networkTicketEntity = networkTicketEntity;
    }

    public TicketEntity createTicketEntity(@Source String source) {
        if (Source.NETWORK.equals(source)) {
            return networkTicketEntity;
        }

        return mockTicketEntity;
    }
}

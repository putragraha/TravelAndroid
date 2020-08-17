package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.ticket.repository.source.MockTicketEntity;
import com.neptuunia.data.ticket.repository.source.TicketEntity;

import javax.inject.Inject;

public class TicketEntityFactory {

    private MockTicketEntity mockTicketEntity;

    @Inject
    public TicketEntityFactory(MockTicketEntity mockTicketEntity) {
        this.mockTicketEntity = mockTicketEntity;
    }

    public TicketEntity createTicketEntity() {
        return mockTicketEntity;
    }
}

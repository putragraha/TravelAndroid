package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.ticket.repository.source.MockTicketEntity;
import com.neptuunia.data.ticket.repository.source.TicketEntity;

import javax.inject.Inject;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketEntityFactory, v 0.0.1 16/08/20 19.29 by Putra Nugraha
 */
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

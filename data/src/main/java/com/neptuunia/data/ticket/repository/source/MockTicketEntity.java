package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MockTicketEntity implements TicketEntity {

    @Inject
    public MockTicketEntity() {
        // For dagger hilt injection
    }

    @Override
    public Single<List<TicketResponse>> getTickets() {
        List<TicketResponse> ticketResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            TicketResponse ticketResponse = new TicketResponse();
            ticketResponse.setPhotoName("PhotoUrl" + i);
            ticketResponse.setDriverName("Driver Name" + i);
            ticketResponse.setGroup("Group: " + i);
            ticketResponse.setCar("Car" + i);
            ticketResponse.setDatetime("Datetime: " + i);
            ticketResponse.setArmadaClass("Armada Class: " + i);
            ticketResponse.setSeatAvailable("Seat Available: " + i);
            ticketResponse.setPrice("Price: " + i);
            ticketResponse.setDriverPhoneNumber("PhoneNumber: " + i);

            ticketResponses.add(ticketResponse);
        }

        return Single.just(ticketResponses);
    }
}

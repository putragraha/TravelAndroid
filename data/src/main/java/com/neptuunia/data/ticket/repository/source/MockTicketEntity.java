package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketStatusRequest;
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
            ticketResponse.setDeparture("Departure: " + i);
            ticketResponse.setArrival("Arrival: " + i);
            ticketResponse.setPhotoName("PhotoUrl" + i);
            ticketResponse.setDriverName("Driver Name" + i);
            ticketResponse.setGroup("Group: " + i);
            ticketResponse.setCar("Car" + i);
            ticketResponse.setCarName("Car name: " + i);
            ticketResponse.setDatetime("Datetime: " + i);
            ticketResponse.setArmadaClass("Armada Class: " + i);
            ticketResponse.setSeatAmount("Seat Amount: " + i);
            ticketResponse.setSeatAvailable("Seat Available: " + i);
            ticketResponse.setPrice("Price: " + i);
            ticketResponse.setDriverPhoneNumber("PhoneNumber: " + i);

            ticketResponses.add(ticketResponse);
        }

        return Single.just(ticketResponses);
    }

    @Override
    public Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest) {
        return Single.just(new CommonResponse());
    }

    @Override
    public Single<CommonResponse> editTicket(EditTicketRequest editTicketRequest) {
        return Single.just(new CommonResponse());
    }

    @Override
    public Single<CommonResponse> confirmTicket(TicketStatusRequest ticketStatusRequest) {
        return Single.just(new CommonResponse());
    }
}

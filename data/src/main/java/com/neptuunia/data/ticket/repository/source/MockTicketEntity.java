package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MockTicketEntity, v 0.0.1 16/08/20 18.00 by Putra Nugraha
 */
public class MockTicketEntity implements TicketEntity {

    @Override
    public Single<List<TicketResponse>> getTickets() {
        List<TicketResponse> ticketResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            TicketResponse ticketResponse = new TicketResponse();
            ticketResponse.setPhotoUrl("PhotoUrl" + i);
            ticketResponse.setDriverName("Driver Name" + i);
            ticketResponse.setCar("Car" + i);
            ticketResponse.setDatetime(i);
            ticketResponse.setSeatAvailable(i);
            ticketResponse.setTicketPrice(i);

            ticketResponses.add(ticketResponse);
        }

        return Single.just(ticketResponses);
    }
}

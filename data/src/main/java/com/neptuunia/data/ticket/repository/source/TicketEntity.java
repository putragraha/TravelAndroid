package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface TicketEntity {

    Single<List<TicketResponse>> getTickets();
}

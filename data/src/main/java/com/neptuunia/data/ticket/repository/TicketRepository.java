package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface TicketRepository {

    Single<List<TicketResponse>> getTickets();

}

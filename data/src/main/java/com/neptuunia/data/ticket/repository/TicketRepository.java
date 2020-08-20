package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface TicketRepository {

    Single<List<TicketResponse>> getTickets();

    Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest);
}

package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;

public interface TicketRepository {

    Single<List<TicketResponse>> getTickets();

    Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest);

    Single<CommonResponse> editTicket(@Body EditTicketRequest editTicketRequest);
}

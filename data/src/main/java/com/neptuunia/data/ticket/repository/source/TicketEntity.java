package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketStatusRequest;
import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface TicketEntity {

    Single<List<TicketResponse>> getTickets();

    Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest);

    Single<CommonResponse> editTicket(EditTicketRequest editTicketRequest);

    Single<CommonResponse> confirmTicket(TicketStatusRequest ticketStatusRequest);
}

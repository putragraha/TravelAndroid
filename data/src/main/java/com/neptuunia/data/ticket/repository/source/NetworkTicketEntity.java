package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.data.ticket.repository.source.network.TicketApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NetworkTicketEntity, v 0.0.1 20/08/20 20.58 by Putra Nugraha
 */
public class NetworkTicketEntity implements TicketEntity {

    private TicketApi ticketApi;

    @Inject
    public NetworkTicketEntity(Retrofit retrofit) {
        ticketApi = retrofit.create(TicketApi.class);
    }

    @Override
    public Single<List<TicketResponse>> getTickets() {
        return ticketApi.getTickets();
    }

    @Override
    public Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest) {
        return ticketApi.orderTicket(orderTicketRequest);
    }

    @Override
    public Single<CommonResponse> editTicket(EditTicketRequest editTicketRequest) {
        return ticketApi.editTicket(editTicketRequest);
    }
}

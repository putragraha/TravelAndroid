package com.neptuunia.data.ticket.repository.source.network;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketStatusRequest;
import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketApi, v 0.0.1 20/08/20 18.48 by Putra Nugraha
 */
public interface TicketApi {

    @GET("get_armada_setting.php")
    Single<List<TicketResponse>> getTickets();

    @POST("order_ticket.php")
    Single<CommonResponse> orderTicket(@Body OrderTicketRequest orderTicketRequest);

    @POST("edit_order_ticket.php")
    Single<CommonResponse> editTicket(@Body EditTicketRequest editTicketRequest);

    @POST("update_ticket_status.php")
    Single<CommonResponse> confirmTicket(@Body TicketStatusRequest ticketStatusRequest);
}

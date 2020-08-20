package com.neptuunia.data.ticket.repository.source.network;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketApi, v 0.0.1 20/08/20 18.48 by Putra Nugraha
 */
public interface TicketApi {

    @GET("get_armada_setting.php")
    Single<List<TicketResponse>> getTickets();
}

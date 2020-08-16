package com.neptuunia.data.ticket.repository.source;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketEntity, v 0.0.1 16/08/20 17.03 by Putra Nugraha
 */
public interface TicketEntity {

    Single<List<TicketResponse>> getTickets();
}

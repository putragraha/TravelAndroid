package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.ticket.model.TicketResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketRepository, v 0.0.1 16/08/20 16.50 by Putra Nugraha
 */
public interface TicketRepository {

    Single<List<TicketResponse>> getTickets();

}

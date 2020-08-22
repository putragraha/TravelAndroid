package com.neptuunia.data.ticket.repository;

import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.constant.Source;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.model.OrderTicketRequest;
import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.data.ticket.repository.source.TicketEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class TicketEntityRepository implements TicketRepository {

    private TicketEntityFactory ticketEntityFactory;

    private AccountRepository accountRepository;

    @Inject
    public TicketEntityRepository(
        TicketEntityFactory ticketEntityFactory,
        AccountRepository accountRepository
    ) {
        this.ticketEntityFactory = ticketEntityFactory;
        this.accountRepository = accountRepository;
    }

    @Override
    public Single<List<TicketResponse>> getTickets() {
        return createNetworkTicketEntity().getTickets();
    }

    @Override
    public Single<CommonResponse> orderTicket(OrderTicketRequest orderTicketRequest) {
        orderTicketRequest.setUserId(accountRepository.getSession().getId());

        return createNetworkTicketEntity().orderTicket(orderTicketRequest);
    }

    @Override
    public Single<CommonResponse> editTicket(EditTicketRequest editTicketRequest) {
        return createNetworkTicketEntity().editTicket(editTicketRequest);
    }

    public TicketEntity createNetworkTicketEntity() {
        return ticketEntityFactory.createTicketEntity(Source.NETWORK);
    }
}

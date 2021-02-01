package com.neptuunia.travel.searchticket;

import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.data.ticket.repository.TicketRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SearchTicketViewModel extends AndroidViewModel {

    private final MutableLiveData<List<TicketResponse>> ticketResponseLiveData =
        new MutableLiveData<>();

    private final TicketRepository ticketRepository;

    private List<TicketResponse> ticketResponses = new ArrayList<>();

    @Inject
    public SearchTicketViewModel(
        @NonNull Application application,
        TicketRepository ticketRepository
    ) {
        super(application);
        this.ticketRepository = ticketRepository;
        fetchTickets();
    }

    public LiveData<List<TicketResponse>> getTickets() {
        return ticketResponseLiveData;
    }

    public void filterTickets(long minDate, long maxDate) {
        List<TicketResponse> results = new ArrayList<>();

        for (TicketResponse ticketResponse : ticketResponses) {
            long datetime = Long.parseLong(ticketResponse.getDatetime());

            if (datetime >= minDate && datetime <= maxDate) {
                results.add(ticketResponse);
            }
        }

        ticketResponseLiveData.postValue(results);
    }

    public void clearTickets() {
        ticketResponseLiveData.postValue(ticketResponses);
    }

    private void fetchTickets() {
        ticketRepository.getTickets()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<List<TicketResponse>>() {

                @Override
                public void onSuccess(@NonNull List<TicketResponse> ticketResponses) {
                    super.onSuccess(ticketResponses);
                    SearchTicketViewModel.this.ticketResponses = ticketResponses;
                    ticketResponseLiveData.postValue(ticketResponses);
                }
            });
    }
}

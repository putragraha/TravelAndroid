package com.neptuunia.travel.searchticket;

import com.neptuunia.data.ticket.model.TicketResponse;
import com.neptuunia.data.ticket.repository.TicketRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SearchTicketViewModel extends AndroidViewModel {

    private MutableLiveData<List<TicketResponse>> ticketResponseLiveData = new MutableLiveData<>();

    private TicketRepository ticketRepository;

    @Inject
    public SearchTicketViewModel(
        @NonNull Application application,
        TicketRepository ticketRepository
    ) {
        super(application);
        this.ticketRepository = ticketRepository;
    }

    public LiveData<List<TicketResponse>> getTickets() {
        return ticketResponseLiveData;
    }

    public void fetchTickets() {
        ticketRepository.getTickets()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<List<TicketResponse>>() {

                @Override
                public void onSuccess(List<TicketResponse> ticketResponses) {
                    super.onSuccess(ticketResponses);
                    ticketResponseLiveData.postValue(ticketResponses);
                }
            });
    }
}

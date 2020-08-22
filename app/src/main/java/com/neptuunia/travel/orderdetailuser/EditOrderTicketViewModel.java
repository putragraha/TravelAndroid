package com.neptuunia.travel.orderdetailuser;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.ticket.model.EditTicketRequest;
import com.neptuunia.data.ticket.repository.TicketRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class EditOrderTicketViewModel extends AndroidViewModel {

    private MutableLiveData<CommonResponse> editOrderTicketLiveData =
        new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private TicketRepository ticketRepository;

    @Inject
    public EditOrderTicketViewModel(
        @NonNull Application application,
        TicketRepository ticketRepository
    ) {
        super(application);
        this.ticketRepository = ticketRepository;
    }

    public MutableLiveData<CommonResponse> getEditOrderTicketLiveData() {
        return editOrderTicketLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void editTicket(EditTicketRequest editTicketRequest) {
        ticketRepository.editTicket(editTicketRequest)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<CommonResponse>() {

                @Override
                public void onSuccess(CommonResponse commonResponse) {
                    super.onSuccess(commonResponse);

                    if (commonResponse.isSuccess()) {
                        editOrderTicketLiveData.postValue(commonResponse);
                    } else {
                        errorLiveData.postValue("");
                    }
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    errorLiveData.postValue(e.getMessage());
                }
            });
    }
}

package com.neptuunia.data.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

@StringDef({TicketStatus.ACCEPTED, TicketStatus.PENDING, TicketStatus.REJECTED})
@Retention(RetentionPolicy.SOURCE)
public @interface TicketStatus {

    String PENDING = "PENDING";

    String REJECTED = "REJECTED";

    String ACCEPTED = "ACCEPTED";
}

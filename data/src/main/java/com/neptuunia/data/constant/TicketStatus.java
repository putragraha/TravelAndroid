package com.neptuunia.data.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketStatus, v 0.0.1 22/08/20 22.15 by Putra Nugraha
 */
@StringDef({TicketStatus.ACCEPTED, TicketStatus.PENDING, TicketStatus.REJECTED})
@Retention(RetentionPolicy.SOURCE)
public @interface TicketStatus {

    String PENDING = "PENDING";

    String REJECTED = "REJECTED";

    String ACCEPTED = "ACCEPTED";
}

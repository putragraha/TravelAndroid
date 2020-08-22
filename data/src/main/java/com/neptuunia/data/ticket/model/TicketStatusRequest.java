package com.neptuunia.data.ticket.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version TicketStatusRequest, v 0.0.1 23/08/20 00.03 by Putra Nugraha
 */
public class TicketStatusRequest {

    private String orderCode;

    private String status;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

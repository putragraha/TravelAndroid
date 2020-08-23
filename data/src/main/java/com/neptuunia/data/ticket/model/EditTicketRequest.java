package com.neptuunia.data.ticket.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version EditTicketResponse, v 0.0.1 22/08/20 14.36 by Putra Nugraha
 */
public class EditTicketRequest {

    private String orderCode;

    private String latitude;

    private String longitude;

    private String note;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

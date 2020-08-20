package com.neptuunia.data.ticket.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderTicketRequest, v 0.0.1 20/08/20 22.27 by Putra Nugraha
 */
public class OrderTicketRequest {

    private int userId;

    private String armadaId;

    private String seatBooked;

    private String note;

    private String latitude;

    private String longitude;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getArmadaId() {
        return armadaId;
    }

    public void setArmadaId(String armadaId) {
        this.armadaId = armadaId;
    }

    public String getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        this.seatBooked = seatBooked;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}

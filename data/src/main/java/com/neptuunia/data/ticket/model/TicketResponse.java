package com.neptuunia.data.ticket.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderTicketResponse, v 0.0.1 16/08/20 16.45 by Putra Nugraha
 */
public class TicketResponse {

    private String photoUrl;

    private String driverName;

    private String car;

    private long datetime;

    private int seatAvailable;

    private long ticketPrice;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(int seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

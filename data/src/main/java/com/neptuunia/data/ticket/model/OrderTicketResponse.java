package com.neptuunia.data.ticket.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderTicketResponse, v 0.0.1 16/08/20 16.45 by Putra Nugraha
 */
public class OrderTicketResponse {

    private String photoUrl;

    private String driverName;

    private String car;

    private String departureDate;

    private String departureTime;

    private String phoneNumber;

    private String seatAvailable;

    private String ticketPrice;

    private String seatOrderedAmount;

    private String note;

    private double latitutde;

    private double longitude;

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

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(String seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSeatOrderedAmount() {
        return seatOrderedAmount;
    }

    public void setSeatOrderedAmount(String seatOrderedAmount) {
        this.seatOrderedAmount = seatOrderedAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getLatitutde() {
        return latitutde;
    }

    public void setLatitutde(double latitutde) {
        this.latitutde = latitutde;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

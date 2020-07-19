package com.neptuunia.data.driver.model;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaSettingResponse, v 0.0.1 19/07/20 14.22 by Putra Nugraha
 */
public class ArmadaSettingResponse {

    private int orderCode;

    private String userName;

    private String seatBooked;

    private int price;

    private String note;

    private double latitude;

    private double longitude;

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        this.seatBooked = seatBooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
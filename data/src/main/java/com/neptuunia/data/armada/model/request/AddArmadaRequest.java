package com.neptuunia.data.armada.model.request;

public class AddArmadaRequest {

    private int driverId;

    private String datetime;

    private String armadaClass;

    private int price;

    private int seatAmount;

    private String note;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getArmadaClass() {
        return armadaClass;
    }

    public void setArmadaClass(String armadaClass) {
        this.armadaClass = armadaClass;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

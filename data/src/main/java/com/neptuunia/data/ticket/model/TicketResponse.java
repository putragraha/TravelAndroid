package com.neptuunia.data.ticket.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TicketResponse implements Parcelable {

    public static final Creator<TicketResponse> CREATOR = new Creator<TicketResponse>() {
        @Override
        public TicketResponse createFromParcel(Parcel in) {
            return new TicketResponse(in);
        }

        @Override
        public TicketResponse[] newArray(int size) {
            return new TicketResponse[size];
        }
    };

    private String armadaId;

    private String driverId;

    private String departure;

    private String arrival;

    private String photoName;

    private String driverName;

    private String group;

    private String car;

    private String carName;

    private String datetime;

    private String armadaClass;

    private String seatAmount;

    private String seatAvailable;

    private String price;

    private String driverPhoneNumber;

    private String note;

    public TicketResponse() {
        // Enable empty constructor
    }

    protected TicketResponse(Parcel in) {
        armadaId = in.readString();
        driverId = in.readString();
        departure = in.readString();
        arrival = in.readString();
        photoName = in.readString();
        driverName = in.readString();
        group = in.readString();
        car = in.readString();
        carName = in.readString();
        datetime = in.readString();
        armadaClass = in.readString();
        seatAmount = in.readString();
        seatAvailable = in.readString();
        price = in.readString();
        driverPhoneNumber = in.readString();
        note = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(armadaId);
        dest.writeString(driverId);
        dest.writeString(departure);
        dest.writeString(arrival);
        dest.writeString(photoName);
        dest.writeString(driverName);
        dest.writeString(group);
        dest.writeString(car);
        dest.writeString(carName);
        dest.writeString(datetime);
        dest.writeString(armadaClass);
        dest.writeString(seatAmount);
        dest.writeString(seatAvailable);
        dest.writeString(price);
        dest.writeString(driverPhoneNumber);
        dest.writeString(note);
    }

    public String getArmadaId() {
        return armadaId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public String getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(String seatAmount) {
        this.seatAmount = seatAmount;
    }

    public String getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(String seatAvailable) {
        this.seatAvailable = seatAvailable;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

package com.neptuunia.data.user.model.response;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryUserResponse implements Parcelable {

    public static final Creator<HistoryUserResponse> CREATOR = new Creator<HistoryUserResponse>() {
        @Override
        public HistoryUserResponse createFromParcel(Parcel source) {
            return new HistoryUserResponse(source);
        }

        @Override
        public HistoryUserResponse[] newArray(int size) {
            return new HistoryUserResponse[size];
        }
    };

    private String orderCode;

    private String group;

    private String departure;

    private String arrival;

    private String armadaClass;

    private String photoName;

    private String driverName;

    private String driverPhoneNumber;

    private String seatBooked;

    private int totalPrice;

    private String datetime;

    private String latitude;

    private String longitude;

    private String status;

    private String note;

    public HistoryUserResponse() {
        // Enable empty constructor
    }

    protected HistoryUserResponse(Parcel in) {
        orderCode = in.readString();
        group = in.readString();
        departure = in.readString();
        arrival = in.readString();
        armadaClass = in.readString();
        photoName = in.readString();
        driverName = in.readString();
        driverPhoneNumber = in.readString();
        seatBooked = in.readString();
        totalPrice = in.readInt();
        datetime = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        status = in.readString();
        note = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderCode);
        dest.writeString(this.group);
        dest.writeString(this.departure);
        dest.writeString(this.arrival);
        dest.writeString(this.armadaClass);
        dest.writeString(this.photoName);
        dest.writeString(this.driverName);
        dest.writeString(this.driverPhoneNumber);
        dest.writeString(this.seatBooked);
        dest.writeInt(this.totalPrice);
        dest.writeString(this.datetime);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeString(this.status);
        dest.writeString(this.note);
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getArmadaClass() {
        return armadaClass;
    }

    public void setArmadaClass(String armadaClass) {
        this.armadaClass = armadaClass;
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

    public String getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(String seatBooked) {
        this.seatBooked = seatBooked;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }
}

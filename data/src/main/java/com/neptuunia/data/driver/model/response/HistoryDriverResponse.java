package com.neptuunia.data.driver.model.response;

import android.os.Parcel;
import android.os.Parcelable;

public class HistoryDriverResponse implements Parcelable {

    public static final Creator<HistoryDriverResponse> CREATOR =
        new Creator<HistoryDriverResponse>() {
            @Override
            public HistoryDriverResponse createFromParcel(Parcel in) {
                return new HistoryDriverResponse(in);
            }

            @Override
            public HistoryDriverResponse[] newArray(int size) {
                return new HistoryDriverResponse[size];
            }
        };

    private String orderCode;

    private String group;

    private String armadaClass;

    private String userName;

    private String seatBooked;

    private int totalPrice;

    private String note;

    private String latitude;

    private String longitude;

    private String status;

    public HistoryDriverResponse() {
        // Enable empty constructor
    }

    protected HistoryDriverResponse(Parcel in) {
        orderCode = in.readString();
        group = in.readString();
        armadaClass = in.readString();
        userName = in.readString();
        seatBooked = in.readString();
        totalPrice = in.readInt();
        note = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        status = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(orderCode);
        out.writeString(group);
        out.writeString(armadaClass);
        out.writeString(userName);
        out.writeString(seatBooked);
        out.writeInt(totalPrice);
        out.writeString(note);
        out.writeString(latitude);
        out.writeString(longitude);
        out.writeString(status);
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

    public String getArmadaClass() {
        return armadaClass;
    }

    public void setArmadaClass(String armadaClass) {
        this.armadaClass = armadaClass;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
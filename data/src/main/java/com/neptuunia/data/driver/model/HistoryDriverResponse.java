package com.neptuunia.data.driver.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author nSystem
 * @version ArmadaSettingResponse, v 0.0.1 19/07/20 14.22 by nSystem
 */
public class HistoryDriverResponse implements Parcelable {

    private int orderCode;

    private String userName;

    private String seatBooked;

    private int price;

    private String note;

    private double latitude;

    private double longitude;

    public HistoryDriverResponse() {
        // Enable empty constructor
    }

    protected HistoryDriverResponse(Parcel in) {
        orderCode = in.readInt();
        userName = in.readString();
        seatBooked = in.readString();
        price = in.readInt();
        note = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(orderCode);
        out.writeString(userName);
        out.writeString(seatBooked);
        out.writeInt(price);
        out.writeString(note);
        out.writeDouble(latitude);
        out.writeDouble(longitude);
    }
}
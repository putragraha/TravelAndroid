package com.neptuunia.data.user.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HistoryUserResponse, v 0.0.1 09/08/20 00.20 by Putra Nugraha
 */
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

    private String photoUrl;

    private String driverName;

    private int seatAmount;

    private int totalPrice;

    private String departureDate;

    private String departureTime;

    private double latitude;

    private double longitude;

    private String note;

    public HistoryUserResponse() {
        // Enable empty constructor
    }

    protected HistoryUserResponse(Parcel in) {
        orderCode = in.readString();
        photoUrl = in.readString();
        driverName = in.readString();
        seatAmount = in.readInt();
        totalPrice = in.readInt();
        departureDate = in.readString();
        departureTime = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        note = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.orderCode);
        dest.writeString(this.photoUrl);
        dest.writeString(this.driverName);
        dest.writeInt(this.seatAmount);
        dest.writeInt(this.totalPrice);
        dest.writeInt(this.totalPrice);
        dest.writeString(this.departureDate);
        dest.writeString(this.departureTime);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.note);
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

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

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

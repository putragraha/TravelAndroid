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

    private String photoUrl;

    private String driverName;

    private String group;

    private String car;

    private long datetime;

    private String armadaClass;

    private int seatAvailable;

    private long ticketPrice;

    private String driverPhoneNumber;

    public TicketResponse() {
        // Enable empty constructor
    }

    protected TicketResponse(Parcel in) {
        photoUrl = in.readString();
        driverName = in.readString();
        group = in.readString();
        car = in.readString();
        datetime = in.readLong();
        armadaClass = in.readString();
        seatAvailable = in.readInt();
        ticketPrice = in.readLong();
        driverPhoneNumber = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photoUrl);
        dest.writeString(driverName);
        dest.writeString(group);
        dest.writeString(car);
        dest.writeLong(datetime);
        dest.writeString(armadaClass);
        dest.writeInt(seatAvailable);
        dest.writeLong(ticketPrice);
        dest.writeString(driverPhoneNumber);
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

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String getArmadaClass() {
        return armadaClass;
    }

    public void setArmadaClass(String armadaClass) {
        this.armadaClass = armadaClass;
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

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }
}

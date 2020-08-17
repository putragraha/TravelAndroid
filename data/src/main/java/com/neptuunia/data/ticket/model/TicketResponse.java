package com.neptuunia.data.ticket.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version OrderTicketResponse, v 0.0.1 16/08/20 16.45 by Putra Nugraha
 */
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

    private String car;

    private long datetime;

    private int seatAvailable;

    private long ticketPrice;

    public TicketResponse() {
        // Enable empty constructor
    }

    protected TicketResponse(Parcel in) {
        photoUrl = in.readString();
        driverName = in.readString();
        car = in.readString();
        datetime = in.readLong();
        seatAvailable = in.readInt();
        ticketPrice = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photoUrl);
        dest.writeString(driverName);
        dest.writeString(car);
        dest.writeLong(datetime);
        dest.writeInt(seatAvailable);
        dest.writeLong(ticketPrice);
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

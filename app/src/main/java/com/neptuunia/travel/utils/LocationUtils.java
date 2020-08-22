package com.neptuunia.travel.utils;

import com.google.android.gms.maps.model.LatLng;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LocationUtils, v 0.0.1 22/08/20 13.03 by Putra Nugraha
 */
public class LocationUtils {

    private LocationUtils() {
        // Prevent instantiation
    }

    public static Address getAddress(Context context, LatLng latLng) {
        try {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            List<Address> addresses = geocoder
                .getFromLocation(latLng.latitude, latLng.longitude, 1);

            if (!addresses.isEmpty()) {
                return addresses.get(0);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return new Address(Locale.getDefault());
    }
}

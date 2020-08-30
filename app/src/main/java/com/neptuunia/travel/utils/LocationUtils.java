package com.neptuunia.travel.utils;

import com.google.android.gms.maps.model.LatLng;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationUtils {

    private static final String GOOGLE_MAPS_URL_FORMAT = "http://maps.google.com/maps?daddr=%f,%f";

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

    public static void openGoogleMaps(Context context, String latitudeText, String longitudeText) {
        double latitude = Double.parseDouble(latitudeText.replace(",", "."));
        double longitude = Double.parseDouble(longitudeText.replace(",", "."));

        String uri = String.format(Locale.ENGLISH, GOOGLE_MAPS_URL_FORMAT, latitude, longitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        context.startActivity(intent);
    }
}

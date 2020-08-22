package com.neptuunia.travel.selectpickup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.neptuunia.travel.R;
import com.neptuunia.travel.base.BaseActivity;
import com.neptuunia.travel.databinding.ActivitySelectPickupBinding;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.view.View;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SelectPickupActivity, v 0.0.1 21/08/20 14.05 by Putra Nugraha
 */
public class SelectPickupActivity extends BaseActivity
    implements OnMapReadyCallback, MultiplePermissionsListener {

    private static final long INTERVAL_TEN_SECONDS = 10000L;

    private static final long FAST_INTERVAL_TWO_SECONDS = 2000L;

    private static final float DEFAULT_CAMERA_POSITION = 17f;

    private FusedLocationProviderClient fusedLocationProviderClient;

    private GoogleMap googleMap;

    @Override
    public View getView() {
        return ActivitySelectPickupBinding.inflate(getLayoutInflater())
            .getRoot();
    }

    @Override
    public void setup() {
        initMapsFragment();
        initMaps();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        if (isPermissionGranted()) {
            this.googleMap.setMyLocationEnabled(true);
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            this.googleMap.getUiSettings().setZoomControlsEnabled(true);
            initCurrentLocation();
        } else {
            requestPermission();
        }
    }

    @Override
    public void onPermissionsChecked(MultiplePermissionsReport report) {
        if (report.areAllPermissionsGranted()) {
            initCurrentLocation();
        } else {
            showAlertAndFinish();
        }
    }

    @Override
    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions,
        PermissionToken token) {
        if (token == null) {
            return;
        }

        token.continuePermissionRequest();
    }

    private void showAlertAndFinish() {
        showMessage(getString(R.string.alert_permission_required));
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    private void initMapsFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.map);

        if (fragment instanceof SupportMapFragment) {
            ((SupportMapFragment) fragment).getMapAsync(this);
        }
    }

    private void initMaps() {
        fusedLocationProviderClient = new FusedLocationProviderClient(this);
    }

    private boolean isPermissionGranted() {
        return PackageManager.PERMISSION_GRANTED ==
            getPermissionCode(Manifest.permission.ACCESS_FINE_LOCATION) &&
            PackageManager.PERMISSION_GRANTED ==
                getPermissionCode(Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    private int getPermissionCode(String permissionName) {
        return ContextCompat.checkSelfPermission(
            this,
            permissionName
        );
    }

    private void requestPermission() {
        Dexter.withActivity(this)
            .withPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
            .withListener(this)
            .check();
    }

    private void initCurrentLocation() {
        LocationServices.getSettingsClient(this)
            .checkLocationSettings(getLocationSettingsRequest())
            .addOnCompleteListener(this::handleOnCompleteLocationSettings);
    }

    private LocationSettingsRequest getLocationSettingsRequest() {
        return new LocationSettingsRequest.Builder()
            .addLocationRequest(getLocationRequest())
            .build();
    }

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(INTERVAL_TEN_SECONDS);
        locationRequest.setFastestInterval(FAST_INTERVAL_TWO_SECONDS);

        return locationRequest;
    }

    private void handleOnCompleteLocationSettings(Task<LocationSettingsResponse> task) {
        if (task.getResult().getLocationSettingsStates().isLocationPresent()) {
            initGetLastLocation();
        }
    }

    @SuppressLint("MissingPermission")
    private void initGetLastLocation() {
        if (isPermissionGranted()) {
            fusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(this, this::updateMarkerAndCamera);
        }
    }

    private void updateMarkerAndCamera(Task<Location> task) {
        Location location = task.getResult();

        if (!task.isSuccessful() || location == null) {
            showMessage(getString(R.string.current_location_not_found));
            return;
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        updateMarker(latLng);
        updateCameraPosition(latLng);
    }

    private void updateMarker(LatLng latLng) {
        googleMap.addMarker(
            new MarkerOptions().position(latLng)
                .title(getString(R.string.location))
                .snippet(getAddress(latLng))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker))
        );
    }

    private String getAddress(LatLng latLng) {
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder
                .getFromLocation(latLng.latitude, latLng.longitude, 1);

            if (!addresses.isEmpty()) {
                return addresses.get(0).getAddressLine(0);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return getString(R.string.address_not_found);
    }

    private void updateCameraPosition(LatLng latLng) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(latLng)
            .zoom(DEFAULT_CAMERA_POSITION)
            .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}

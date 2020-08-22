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
import com.neptuunia.travel.constant.Constant;
import com.neptuunia.travel.databinding.ActivitySelectPickupBinding;
import com.neptuunia.travel.utils.LocationUtils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.view.View;

import java.util.List;

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

    private ActivitySelectPickupBinding binding;

    private LatLng selectedLocation;

    @Override
    public View getView() {
        binding = ActivitySelectPickupBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void setup() {
        initMapsFragment();
        initMaps();
        setupOnConfirmClick();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        if (isPermissionGranted()) {
            this.googleMap.setMyLocationEnabled(true);
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            this.googleMap.getUiSettings().setZoomControlsEnabled(true);
            this.googleMap.setOnMapClickListener(this::updateMarkerAndAddress);
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

    private void updateMarkerAndAddress(LatLng latLng) {
        selectedLocation = latLng;
        updateAddress(latLng);
        updateMarker(latLng);
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

    private void setupOnConfirmClick() {
        binding.btnConfirmation.setOnClickListener(view -> {
            if (selectedLocation == null) {
                showMessage(getString(R.string.choose_pick_up_location));
                return;
            }

            setResultAndFinish();
        });
    }

    private void setResultAndFinish() {
        Intent intent = new Intent();
        intent.putExtra(Constant.LATLNG_DATA, selectedLocation);
        setResult(RESULT_OK, intent);
        finish();
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

        selectedLocation = new LatLng(location.getLatitude(), location.getLongitude());
        updateAddress(selectedLocation);
        updateMarker(selectedLocation);
        updateCameraPosition(selectedLocation);
    }

    private void updateAddress(LatLng latLng) {
        Address address = LocationUtils.getAddress(this, latLng);

        binding.actvLocality.setText(address.getLocality());
        binding.actvAddress.setText(address.getAddressLine(0));
    }

    private void updateMarker(LatLng latLng) {
        googleMap.clear();
        googleMap.addMarker(
            new MarkerOptions().position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker))
        );
    }

    private void updateCameraPosition(LatLng latLng) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
            .target(latLng)
            .zoom(DEFAULT_CAMERA_POSITION)
            .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}

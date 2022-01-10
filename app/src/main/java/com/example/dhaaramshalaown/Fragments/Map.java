package com.example.dhaaramshalaown.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.dhaaramshalaown.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.Locale;


public class Map extends Fragment implements OnMapReadyCallback {

    AutocompleteSupportFragment searchBarFragment;
//    EditText searchBar;
    ImageView mapOptions;
    private Boolean permissionsGranted = false;
    LatLng defaultLocation;
    Float defaultZoomLevel;

    private final FragmentManager fragmentManager;
    private final Context context;
    private GoogleMap googleMap;
    MapViewingOptionsFragment mapViewFragment;

    private static final String fine_Location = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String coarse_Location = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final String internet = Manifest.permission.INTERNET;


    public Map(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        if (!Places.isInitialized()) {
            Places.initialize(context, getString(R.string.api_key), Locale.US);
        }

        initializeTheView(view);
        checkThePermissions();

        mapOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MapViewingOptionsFragment mapViewFragment = new MapViewingOptionsFragment(googleMap);
                mapViewFragment.show(fragmentManager, "MapViewOptions");
            }
        });

        if(permissionsGranted) { // searchBarFragment.getView().setVisibility(View.GONE);
            searchBarFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(@NonNull Place place) {
                    Toast.makeText(context, place.getName() + " Selected!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(@NonNull Status status) {
                    Toast.makeText(context, "An Error Occurred: " + status, Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;
    }

    void initializeTheView(View view) {
//        searchBar = view.findViewById(R.id.id_searchLocation);
        mapOptions = view.findViewById(R.id.id_mapViewOptions);

        defaultLocation = new LatLng(29.359975377948096, 76.29785166299233);
        defaultZoomLevel = 5f;
    }

    private void initializeTheMap() {
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.id_fragmentForMap);
        supportMapFragment.getMapAsync(this);

        searchBarFragment = (AutocompleteSupportFragment) getChildFragmentManager().findFragmentById(R.id.id_placeAutoComplete);
        // Specify the types of place data to return.
        searchBarFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
    }

    private void checkThePermissions() {
        if(ContextCompat.checkSelfPermission(context, fine_Location) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(context, coarse_Location) == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(context, internet) == PackageManager.PERMISSION_GRANTED) {
                    permissionsGranted = true;
                    initializeTheMap();
                }
                else {
                    openPermissionsPrompt();
                }
            } else {
                openPermissionsPrompt();
            }
        } else {
            openPermissionsPrompt();
        }
    }

    private void openPermissionsPrompt() {
        ActivityResultLauncher<String[]> locationPermissionRequest = registerForActivityResult(
            new ActivityResultContracts.RequestMultiplePermissions(), result -> {
                Boolean fineLocationGranted = result.getOrDefault(fine_Location, false);
                Boolean coarseLocationGranted = result.getOrDefault(coarse_Location,false);
                Boolean internetGranted = result.getOrDefault(internet,false);

                if(fineLocationGranted != null && fineLocationGranted) {
                    // Precise location access granted.
                    if(coarseLocationGranted != null && coarseLocationGranted) {
                        // Approximate location access granted.
                        if(internetGranted != null && internetGranted) {
                            // internet access granted.
                            Toast.makeText(context, "Permissions Granted", Toast.LENGTH_SHORT).show();
                            permissionsGranted = true;
                            initializeTheMap();
                        }
                        else {
                            // No location access granted.
                            Toast.makeText(context, "Permissions Denied!", Toast.LENGTH_SHORT).show();
                            getFragmentManager().popBackStackImmediate();
                        }
                    }
                    else {
                        // No location access granted.
                        Toast.makeText(context, "Permissions Denied!", Toast.LENGTH_SHORT).show();
                        getFragmentManager().popBackStackImmediate();
                    }
                }
                else {
                    // No location access granted.
                    Toast.makeText(context, "Permissions Denied!", Toast.LENGTH_SHORT).show();
                    getFragmentManager().popBackStackImmediate();
                }
            });

        locationPermissionRequest.launch(new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;
        mapViewFragment = new MapViewingOptionsFragment(googleMap, defaultLocation, defaultZoomLevel);
        Toast.makeText(context, "Map is Ready!", Toast.LENGTH_SHORT).show();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, defaultZoomLevel));
    }
}
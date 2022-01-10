package com.example.dhaaramshalaown.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dhaaramshalaown.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MapViewingOptionsFragment extends BottomSheetDialogFragment {

    GoogleMap googleMap;
    LinearLayout defaultMapLayout;
    LinearLayout hybridMapLayout;
    LinearLayout satelliteMapLayout;
    LinearLayout terrainMapLayout;
//    private static int mapType;
    LatLng defaultLocation;
    Float defaultZoomLevel;

    public MapViewingOptionsFragment() { }

    public MapViewingOptionsFragment(GoogleMap map, LatLng defaultLocation, Float defaultZoomLevel) {
        googleMap = map;
        this.defaultLocation = defaultLocation;
        this.defaultZoomLevel = defaultZoomLevel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map_viewing_options, container, false);

        initializeTheView(view);

        defaultMapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Default MapView", Toast.LENGTH_SHORT).show();
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, defaultZoomLevel));
//                mapType = GoogleMap.MAP_TYPE_NORMAL;
                MapViewingOptionsFragment.this.dismiss();
            }
        });

        hybridMapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Hybrid MapView", Toast.LENGTH_SHORT).show();
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, defaultZoomLevel));
//                mapType = GoogleMap.MAP_TYPE_HYBRID;
                MapViewingOptionsFragment.this.dismiss();
            }
        });

        satelliteMapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Satellite MapView", Toast.LENGTH_SHORT).show();
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, defaultZoomLevel));
//                mapType = GoogleMap.MAP_TYPE_SATELLITE;
                MapViewingOptionsFragment.this.dismiss();
            }
        });

        terrainMapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Terrain MapView", Toast.LENGTH_SHORT).show();
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, defaultZoomLevel));
//                mapType = GoogleMap.MAP_TYPE_TERRAIN;
                MapViewingOptionsFragment.this.dismiss();
            }
        });


        return view;
    }

    void initializeTheView(View view) {
        defaultMapLayout = view.findViewById(R.id.id_defaultMapTypeLayout);
        hybridMapLayout = view.findViewById(R.id.id_hybridMapTypeLayout);
        satelliteMapLayout = view.findViewById(R.id.id_satelliteMapTypeLayout);
        terrainMapLayout = view.findViewById(R.id.id_terrainMapTypeLayout);

        defaultMapLayout.setSelected(true);
//        mapType = 1;
    }
}
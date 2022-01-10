package com.example.dhaaramshalaown.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceSecurity extends Fragment {
    ImageView securityCamerasCheckBox, weaponsCheckBox, dangerousAnimalsCheckBox;
    Boolean securityCameras;
    Boolean weapons;
    Boolean dangerousAnimals;
    private static final ArrayList<String> placeSecurityList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_security, container, false);
        initializeTheFields(view);

        securityCamerasCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!securityCameras) {
                    Drawable drawable = getResources().getDrawable(R.drawable.tick_mark);
                    securityCamerasCheckBox.setImageDrawable(drawable);
                    securityCameras = true;
                    placeSecurityList.add("Security Camera(s)");
                }
                else {
                    Drawable drawable = getResources().getDrawable(R.drawable.circle);
                    securityCamerasCheckBox.setImageDrawable(drawable);
                    securityCameras = false;
                    placeSecurityList.remove("Security Camera(s)");
                }
            }
        });
        weaponsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!weapons) {
                    Drawable drawable = getResources().getDrawable(R.drawable.tick_mark);
                    weaponsCheckBox.setImageDrawable(drawable);
                    weapons = true;
                    placeSecurityList.add("Weapons");
                }
                else {
                    Drawable drawable = getResources().getDrawable(R.drawable.circle);
                    weaponsCheckBox.setImageDrawable(drawable);
                    weapons = false;
                    placeSecurityList.remove("Weapons");
                }
            }
        });
        dangerousAnimalsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dangerousAnimals) {
                    Drawable drawable = getResources().getDrawable(R.drawable.tick_mark);
                    dangerousAnimalsCheckBox.setImageDrawable(drawable);
                    dangerousAnimals = true;
                    placeSecurityList.add("Dangerous Animals");
                }
                else {
                    Drawable drawable = getResources().getDrawable(R.drawable.circle);
                    dangerousAnimalsCheckBox.setImageDrawable(drawable);
                    dangerousAnimals = false;
                    placeSecurityList.remove("Dangerous Animals");
                }
            }
        });

        return view;
    }

    void initializeTheFields(View view) {
        securityCamerasCheckBox = view.findViewById(R.id.id_securityCamerasCheckBox);
        weaponsCheckBox = view.findViewById(R.id.id_weaponsCheckBox);
        dangerousAnimalsCheckBox = view.findViewById(R.id.id_dangerousAnimalsCheckBox);

        securityCameras = false;
        weapons = false;
        dangerousAnimals = false;

        placeSecurityList.clear();
    }

    public static ArrayList<String> getPlaceSecurityList() {
        return placeSecurityList;
    }
}
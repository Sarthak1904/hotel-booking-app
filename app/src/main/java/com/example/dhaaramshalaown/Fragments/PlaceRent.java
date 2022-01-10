package com.example.dhaaramshalaown.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dhaaramshalaown.R;

public class PlaceRent extends Fragment {

    EditText rentInput;
    ImageView rentSubtract, rentAdd, offerCheckBox;
    private static Boolean checkBox = false;
    Integer originalRent;
    private static String rent = "1000";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_rent, container, false);
        initializeTheFields(view);

        rentAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(rentInput.getText().toString());
                if(value < 1610) {
                    value = value + 50;
                    if(value < 966) value = 966;
                    rentInput.setText(value.toString());
                }
                else {
                    rentInput.setText("1610");
                }
                rent = rentInput.getText().toString();
            }
        });

        rentSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(rentInput.getText().toString());
                if(value > 966) {
                    value = value - 10;
                    if(value > 1610) value = 1610;
                    rentInput.setText(value.toString());
                }
                else {
                    rentInput.setText("966");
                }
                rent = rentInput.getText().toString();
            }
        });

        offerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(rentInput.getText().toString());
                if(value > 1610) value = 1610;
                if(value < 966) value = 966;

                if(!checkBox) {
                    Drawable drawable = getResources().getDrawable(R.drawable.tick_mark);
                    offerCheckBox.setImageDrawable(drawable);
                    checkBox = true;

                    originalRent = value;
                    Integer rent = originalRent - (value*20)/100;
                    rentInput.setText(rent.toString());
                }
                else {
                    Drawable drawable = getResources().getDrawable(R.drawable.circle);
                    offerCheckBox.setImageDrawable(drawable);
                    checkBox = false;

                    rentInput.setText(originalRent.toString());
                }
                rent = rentInput.getText().toString();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        rentInput.setText(rent);
        Drawable drawable;
        if(checkBox) {
            drawable = getResources().getDrawable(R.drawable.tick_mark);
        }
        else {
            drawable = getResources().getDrawable(R.drawable.circle);
        }
        offerCheckBox.setImageDrawable(drawable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rent = "1000";
        rentInput.setText(rent);
        checkBox = false;
        offerCheckBox.setImageDrawable(getResources().getDrawable(R.drawable.circle));
    }

    void initializeTheFields(View view) {
        rentInput = view.findViewById(R.id.id_rentInput);
        rentSubtract = view.findViewById(R.id.id_rentSubtract);
        rentAdd = view.findViewById(R.id.id_rentAdd);
        offerCheckBox = view.findViewById(R.id.id_offerCheckBox);

        rentInput.setText(rent);
    }

    public static String getPlaceRent() {
        return rent;
    }
}
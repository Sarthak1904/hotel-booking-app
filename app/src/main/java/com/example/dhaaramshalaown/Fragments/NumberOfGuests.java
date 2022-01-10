package com.example.dhaaramshalaown.Fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfGuests extends Fragment {
    private static EditText guests, beds, bedrooms, bathrooms;
    ImageView yesPrivateBathroom, noPrivateBathroom;
    ImageView subtractGuests, subtractBeds, subtractBedrooms, subtractBathrooms;
    ImageView addGuests, addBeds, addBedrooms, addBathrooms;
    private static Boolean yesPB = false;
    Boolean noPB = false;
    private static final Integer[] numberOfGuestsList = new Integer[5];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_number_of_guests, container, false);

        initializeTheFields(view);

        yesPrivateBathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!yesPB) {
                    yesPrivateBathroom.setColorFilter(ContextCompat.getColor(getContext(), R.color.highlightColor));
                    noPrivateBathroom.setColorFilter(ContextCompat.getColor(getContext(), R.color.light_black));
                    yesPB = true;
                    noPB = false;
                    numberOfGuestsList[4] = 1;
                }
            }
        });
        noPrivateBathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!noPB) {
                    noPrivateBathroom.setColorFilter(ContextCompat.getColor(getContext(), R.color.highlightColor));
                    yesPrivateBathroom.setColorFilter(ContextCompat.getColor(getContext(), R.color.light_black));
                    noPB = true;
                    yesPB = false;
                    numberOfGuestsList[4] = 0;
                }
            }
        });

        subtractGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(guests.getText().toString());
                if(value > 0) {
                    value = value - 1;
                    guests.setText(value.toString());
                    numberOfGuestsList[0] = value;
                }
            }
        });
        subtractBeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(beds.getText().toString());
                if(value > 0) {
                    value = value - 1;
                    beds.setText(value.toString());
                    numberOfGuestsList[1] = value;
                }
            }
        });
        subtractBedrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(bedrooms.getText().toString());
                if(value > 0) {
                    value = value - 1;
                    bedrooms.setText(value.toString());
                    numberOfGuestsList[2] = value;
                }
            }
        });
        subtractBathrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(bathrooms.getText().toString());
                if(value > 0) {
                    value = value - 1;
                    bathrooms.setText(value.toString());
                    numberOfGuestsList[3] = value;
                }
            }
        });

        addGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(guests.getText().toString());
                if(value < 99) {
                    value = value + 1;
                    guests.setText(value.toString());
                    numberOfGuestsList[0] = value;
                }
            }
        });
        addBeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(beds.getText().toString());
                if(value < 99) {
                    value = value + 1;
                    beds.setText(value.toString());
                    numberOfGuestsList[1] = value;
                }
            }
        });
        addBedrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(bedrooms.getText().toString());
                if(value < 99) {
                    value = value + 1;
                    bedrooms.setText(value.toString());
                    numberOfGuestsList[2] = value;
                }
            }
        });
        addBathrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer value = Integer.parseInt(bathrooms.getText().toString());
                if(value < 99) {
                    value = value + 1;
                    bathrooms.setText(value.toString());
                    numberOfGuestsList[3] = value;
                }
            }
        });

        numberOfGuestsList[0] = Integer.parseInt(guests.getText().toString());
        numberOfGuestsList[1] = Integer.parseInt(beds.getText().toString());
        numberOfGuestsList[2] = Integer.parseInt(bedrooms.getText().toString());
        numberOfGuestsList[3] = Integer.parseInt(bathrooms.getText().toString());
        numberOfGuestsList[4] = yesPB?1:0;

        return view;
    }

    void initializeTheFields(View view) {
        guests = view.findViewById(R.id.id_guestsInput);
        beds = view.findViewById(R.id.id_bedsInput);
        bedrooms = view.findViewById(R.id.id_bedroomsInput);
        bathrooms = view.findViewById(R.id.id_bathroomsInput);

        guests.setText("1");
        beds.setText("1");
        bedrooms.setText("1");
        bathrooms.setText("1");

        yesPrivateBathroom = view.findViewById(R.id.id_yesPB);
        noPrivateBathroom = view.findViewById(R.id.id_noPB);

        subtractGuests = view.findViewById(R.id.id_guestsSubtract);
        subtractBeds = view.findViewById(R.id.id_bedsSubtract);
        subtractBedrooms = view.findViewById(R.id.id_bedroomsSubtract);
        subtractBathrooms = view.findViewById(R.id.id_bathroomssSubtract);

        addGuests = view.findViewById(R.id.id_guestsAdd);
        addBeds = view.findViewById(R.id.id_bedsAdd);
        addBedrooms = view.findViewById(R.id.id_bedroomsAdd);
        addBathrooms = view.findViewById(R.id.id_bathroomsAdd);

        noPB = true;
        noPrivateBathroom.setColorFilter(ContextCompat.getColor(getContext(), R.color.highlightColor));
    }

    public static Integer[] getNumberOfGuestsList() {
        numberOfGuestsList[0] = Integer.parseInt(guests.getText().toString());
        numberOfGuestsList[1] = Integer.parseInt(beds.getText().toString());
        numberOfGuestsList[2] = Integer.parseInt(bedrooms.getText().toString());
        numberOfGuestsList[3] = Integer.parseInt(bathrooms.getText().toString());
        numberOfGuestsList[4] = yesPB?1:0;
        return numberOfGuestsList;
    }
}
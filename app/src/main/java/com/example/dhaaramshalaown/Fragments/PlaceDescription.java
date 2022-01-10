package com.example.dhaaramshalaown.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.Adapters.PlaceDescriptionAdapter;

import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceDescription extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PlaceDescriptionAdapter placeDescriptionAdapter;
    ArrayList<DataClass> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_description, container, false);

        initializeTheFields(view);
        itemList = new ArrayList<>();

        itemList.add(new DataClass("Bed and Breakfast",
                "A hospitality business offering guests breakfast with a Host onsite."));
        itemList.add(new DataClass("Nature Lodge",
                "A business offering stays near natural settings like forests or mountains."));
        itemList.add(new DataClass("Farm Stay",
                "A rural stays where guests may spend time with animals, hiking, crafting."));
        itemList.add(new DataClass("Minsu",
                "A hospitality business offering guests private rooms in Talwan."));
        itemList.add(new DataClass("Casa Particular",
                "A private room in a home that feels like a bed and breakfast in Cuba."));
        itemList.add(new DataClass("Ryokan",
                "A small in offering guests a unique cultural experience in Japan."));

        placeDescriptionAdapter = new PlaceDescriptionAdapter(getContext(), itemList);

        recyclerView.setAdapter(placeDescriptionAdapter);
        recyclerView.setLayoutManager(layoutManager);

//        selectedItems = placeDescriptionAdapter.getSelectedPlaceList();
//        Toast.makeText(getContext(), selectedItems.toString(), Toast.LENGTH_SHORT).show();

        return view;
    }

    void initializeTheFields(View view) {
        recyclerView = view.findViewById(R.id.id_recyclerViewPlaceDescription);
        layoutManager = new LinearLayoutManager(getContext());
    }
}
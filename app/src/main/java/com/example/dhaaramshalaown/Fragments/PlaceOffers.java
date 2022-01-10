package com.example.dhaaramshalaown.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.Adapters.PlaceOffersAdapter;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceOffers extends Fragment {
    ArrayList<String> itemList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PlaceOffersAdapter recyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_offers, container, false);

        initializeTheFields(view);

        itemList = new ArrayList<String>();
        itemList.add("Do you have any standout amenlties?");
        itemList.add("What about these guests favorites?");
        itemList.add("Have any of these safety items?");

        recyclerViewAdapter = new PlaceOffersAdapter(getContext(), itemList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    void initializeTheFields(View view) {
        recyclerView = view.findViewById(R.id.id_recyclerViewPlaceOffersDescription);
        layoutManager = new LinearLayoutManager(getContext());
    }
}
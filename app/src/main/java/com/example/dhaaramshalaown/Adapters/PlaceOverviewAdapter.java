package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.Fragments.NumberOfGuests;
import com.example.dhaaramshalaown.Fragments.PlaceDescription;
import com.example.dhaaramshalaown.Fragments.PlaceRent;
import com.example.dhaaramshalaown.Fragments.PlaceSecurity;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceOverviewAdapter extends RecyclerView.Adapter<PlaceOverviewAdapter.PlaceOverviewViewHolder> {
    Context context;
    ArrayList<String> fragmentNames;

    public PlaceOverviewAdapter(Context context, ArrayList<String> fragmentNames) {
        this.context = context;
        this.fragmentNames = fragmentNames;
    }

    @NonNull
    @Override
    public PlaceOverviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_overview_main_recyclerview_items_ui, parent, false);
        return new PlaceOverviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceOverviewAdapter.PlaceOverviewViewHolder holder, int position) {
        String data = fragmentNames.get(position);

        holder.fragmentName.setText(data);

        if(position == 0) {
            ArrayList<DataClass> placeDescriptionList = PlaceDescriptionAdapter.getSelectedPlaceList();

            holder.childRecyclerViewPlaceOverview.setLayoutManager(new LinearLayoutManager(context));
            holder.childRecyclerViewPlaceOverview.setAdapter(new PlaceDescriptionAdapterInPlaceOverview(context, placeDescriptionList));
        }
        else if(position == 1) {
            ArrayList<DataClass> placeOffersList = ChildPlaceOffersAdapter.getPlaceOfferList();

            holder.childRecyclerViewPlaceOverview.setLayoutManager(new GridLayoutManager(context, 2));
            holder.childRecyclerViewPlaceOverview.setAdapter(new PlaceOfferAdapterInPlaceOverview(context, placeOffersList));
        }
        else if(position == 2) {
            Integer[] numberOfGuestsList = NumberOfGuests.getNumberOfGuestsList();

            holder.childRecyclerViewPlaceOverview.setLayoutManager(new LinearLayoutManager(context));
            holder.childRecyclerViewPlaceOverview.setAdapter(new NumberOfGuestsAdapterInPlaceOverview(context, numberOfGuestsList));
        }
        else if(position == 3) {
            String rent = PlaceRent.getPlaceRent();

            holder.childRecyclerViewPlaceOverview.setLayoutManager(new LinearLayoutManager(context));
            holder.childRecyclerViewPlaceOverview.setAdapter(new PlaceRentAdapterInPlaceOverview(rent));
        }
        else if(position == 4) {
            ArrayList<String> placeSecurityList = PlaceSecurity.getPlaceSecurityList();

            holder.childRecyclerViewPlaceOverview.setLayoutManager(new LinearLayoutManager(context));
            holder.childRecyclerViewPlaceOverview.setAdapter(new PlaceSecurityAdapterInPlaceOverview(context, placeSecurityList));
        }
        else {

        }
    }

    @Override
    public int getItemCount() {
        return fragmentNames.size();
    }

    public class PlaceOverviewViewHolder extends RecyclerView.ViewHolder {
        TextView fragmentName;
        RecyclerView childRecyclerViewPlaceOverview;

        public PlaceOverviewViewHolder(@NonNull View itemView) {
            super(itemView);

            fragmentName = itemView.findViewById(R.id.id_fragmentNamePlaceOverview);
            childRecyclerViewPlaceOverview = itemView.findViewById(R.id.id_childRecyclerViewPlaceOverview);
        }
    }
}

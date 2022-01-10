package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceDescriptionAdapterInPlaceOverview extends RecyclerView.Adapter<PlaceDescriptionAdapterInPlaceOverview.PlaceDescriptionAdapterViewHolder> {
    Context context;
    ArrayList<DataClass> selectedItemsList;

    public PlaceDescriptionAdapterInPlaceOverview(Context context, ArrayList<DataClass> selectedItemsList) {
        this.context = context;
        this.selectedItemsList = selectedItemsList;
    }

    @NonNull
    @Override
    public PlaceDescriptionAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_place_description_items_ui, parent, false);
        return new PlaceDescriptionAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceDescriptionAdapterInPlaceOverview.PlaceDescriptionAdapterViewHolder holder, int position) {
        DataClass data = selectedItemsList.get(position);

        holder.heading.setText(data.getHeading());
        holder.description.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return selectedItemsList.size();
    }


    public class PlaceDescriptionAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView heading, description;

        public PlaceDescriptionAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.id_heading);
            description = itemView.findViewById(R.id.id_heading_Description);
        }
    }
}
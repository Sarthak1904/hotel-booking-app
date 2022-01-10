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

public class PlaceDescriptionAdapter extends RecyclerView.Adapter<PlaceDescriptionAdapter.ViewHolder> {
    Context context;
    ArrayList<DataClass> placeList;
    private static final ArrayList<DataClass> placeDescriptionSelectedData = new ArrayList<>();

    public PlaceDescriptionAdapter(Context context, ArrayList<DataClass> placeList) {
        this.context = context;
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_place_description_items_ui, parent, false);
        placeDescriptionSelectedData.clear();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataClass data = placeList.get(position);

        holder.heading.setText(data.getHeading());
        holder.description.setText(data.getDescription());
        holder.dataClassObject = new DataClass(holder.heading.getText().toString(), holder.description.getText().toString());

        holder.placeDescriptionItemUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!holder.highLight) {
                    holder.placeDescriptionItemUI.setBackgroundResource(R.drawable.highlight);
                    holder.highLight = true;

                    placeDescriptionSelectedData.add(holder.dataClassObject);
                }
                else {
                    holder.placeDescriptionItemUI.setBackgroundResource(R.drawable.recyclerview_items_background);
                    holder.highLight = false;

                    placeDescriptionSelectedData.remove(holder.dataClassObject);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView heading, description;
        LinearLayout placeDescriptionItemUI;
        boolean highLight = false;
        DataClass dataClassObject;

        public ViewHolder(View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.id_heading);
            description = itemView.findViewById(R.id.id_heading_Description);
            placeDescriptionItemUI = itemView.findViewById(R.id.id_recyclerView_place_description_items_ui);
        }
    }

    public static ArrayList<DataClass> getSelectedPlaceList() {
        return placeDescriptionSelectedData;
    }
}
package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceSecurityAdapterInPlaceOverview extends RecyclerView.Adapter<PlaceSecurityAdapterInPlaceOverview.PlaceSecurityViewHolder> {
    Context context;
    ArrayList<String> placeSecurityList;

    public PlaceSecurityAdapterInPlaceOverview(Context context, ArrayList<String> placeSecurityList) {
        this.context = context;
        this.placeSecurityList = placeSecurityList;
    }

    @NonNull
    @Override
    public PlaceSecurityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_security_items_ui_in_place_overview, parent, false);
        return new PlaceSecurityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceSecurityAdapterInPlaceOverview.PlaceSecurityViewHolder holder, int position) {
        String data = placeSecurityList.get(position);

        if(data.equals("Security Camera(s)")) {
            holder.title.setText("Security Camera(s)");
        }
        if(data.equals("Weapons")) {
            holder.title.setText("Weapons");
        }
        if(data.equals("Dangerous Animals")) {
            holder.title.setText("Dangerous Animals");
        }
    }

    @Override
    public int getItemCount() {
        return placeSecurityList.size();
    }

    public class PlaceSecurityViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public PlaceSecurityViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.id_titleOfPlaceSecurityInPlaceOverview);
        }
    }
}
package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class PlaceOffersAdapter extends RecyclerView.Adapter<PlaceOffersAdapter.PlaceOffersViewHolder> {

    Context context;
    ArrayList<String> parentItemList;

    public PlaceOffersAdapter(Context context, ArrayList<String> parentItemList) {
        this.context = context;
        this.parentItemList = parentItemList;
    }

    @NonNull
    @Override
    public PlaceOffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_offers_recycler_view_items_ui, parent, false);
        return new PlaceOffersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceOffersViewHolder holder, int position) {
        String data = parentItemList.get(position);

        holder.question.setText(data);

        ArrayList<DataClass> childitemList = new ArrayList<>();

        if(position == 0) {
            childitemList.add(new DataClass(R.drawable.pool,"Pool"));
            childitemList.add(new DataClass(R.drawable.hot_tub, "Hot Tub"));
            childitemList.add(new DataClass(R.drawable.patio, "Patio"));
            childitemList.add(new DataClass(R.drawable.bbq_grill, "BBQ Grill"));
            childitemList.add(new DataClass(R.drawable.fire_pit, "Fire Pit"));
            childitemList.add(new DataClass(R.drawable.pool_table, "Pool Table"));
            childitemList.add(new DataClass(R.drawable.indoor_fireplace, "Indoor Fireplace"));
            childitemList.add(new DataClass(R.drawable.outdoor_dining_area, "Outdoor Dining Area"));
            childitemList.add(new DataClass(R.drawable.exercise, "Exercise Area"));
        }
        else if(position == 1) {
            childitemList.add(new DataClass(R.drawable.wifi, "WiFi"));
            childitemList.add(new DataClass(R.drawable.tv, "TV"));
            childitemList.add(new DataClass(R.drawable.kitchen, "Kitchen"));
            childitemList.add(new DataClass(R.drawable.washing_machine, "Washing Machine"));
            childitemList.add(new DataClass(R.drawable.free_parking, "Free Parking on Premises"));
            childitemList.add(new DataClass(R.drawable.paid_parking, "Paid Parking on Premises"));
            childitemList.add(new DataClass(R.drawable.air_conditioner, "Air Conditioning"));
            childitemList.add(new DataClass(R.drawable.dedicated_workspace, "Dedicated Workspace"));
            childitemList.add(new DataClass(R.drawable.outdoor_shower, "Outdoor Shower"));
        }
        else {
            childitemList.add(new DataClass(R.drawable.smoke_alarm, "Smoke Alarm"));
            childitemList.add(new DataClass(R.drawable.first_aid_kit, "First Aid Kit"));
            childitemList.add(new DataClass(R.drawable.carbon_monoxide_alarm, "Carbon Monoxide Alarm"));
            childitemList.add(new DataClass(R.drawable.lock_on_bedroom_door, "Lock on Bedroom Door"));
            childitemList.add(new DataClass(R.drawable.fire_extinguisher, "Fire Extinguisher"));
        }

        holder.offersChildList.setLayoutManager(new GridLayoutManager(context, 2));
        holder.offersChildList.setAdapter(new ChildPlaceOffersAdapter(context, childitemList));
    }

    @Override
    public int getItemCount() {
        return parentItemList.size();
    }

    public class PlaceOffersViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        RecyclerView offersChildList;

        public PlaceOffersViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.id_services);
            offersChildList = itemView.findViewById(R.id.id_offersChildListRecyclerView);
        }
    }
}
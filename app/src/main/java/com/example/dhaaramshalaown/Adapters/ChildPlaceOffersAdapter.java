package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Domain.DataClass;
import com.example.dhaaramshalaown.R;

import java.util.ArrayList;

public class ChildPlaceOffersAdapter extends RecyclerView.Adapter<ChildPlaceOffersAdapter.ChildPlaceOffersViewHolder> {

    Context context;
    ArrayList<DataClass> offersList;
    private static final ArrayList<DataClass> placeOfferSelectedData = new ArrayList<>();

    public ChildPlaceOffersAdapter(Context context, ArrayList<DataClass> offersList) {
        this.context = context;
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public ChildPlaceOffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_place_offers_items_ui, parent, false);
        placeOfferSelectedData.clear();
        return new ChildPlaceOffersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildPlaceOffersViewHolder holder, int position) {
        DataClass data = offersList.get(position);

        holder.heading.setText(data.getHeading());
        holder.icon.setImageResource(data.getDrawableImageId());
        holder.dataClassObject = new DataClass(data.getDrawableImageId(), holder.heading.getText().toString());

        holder.placeOfferItemsUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!holder.highLight) {
                    holder.placeOfferItemsUI.setBackgroundResource(R.drawable.highlight);
                    holder.highLight = true;

                    placeOfferSelectedData.add(holder.dataClassObject);
                }
                else {
                    holder.placeOfferItemsUI.setBackgroundResource(R.drawable.recyclerview_items_background);
                    holder.highLight = false;

                    placeOfferSelectedData.remove(holder.dataClassObject);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class ChildPlaceOffersViewHolder extends RecyclerView.ViewHolder {
        TextView heading;
        ImageView icon;
        LinearLayout placeOfferItemsUI;
        boolean highLight = false;
        DataClass dataClassObject;

        public ChildPlaceOffersViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.id_offers);
            icon = itemView.findViewById(R.id.id_offersIcon);
            placeOfferItemsUI = itemView.findViewById(R.id.id_recyclerView_Place_Offers_Items_UI);
        }
    }

    public static ArrayList<DataClass> getPlaceOfferList() {
        return placeOfferSelectedData;
    }
}
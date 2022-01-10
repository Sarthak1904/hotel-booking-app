package com.example.dhaaramshalaown.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhaaramshalaown.R;

public class PlaceRentAdapterInPlaceOverview extends RecyclerView.Adapter<PlaceRentAdapterInPlaceOverview.PlaceRentViewHolder> {
    String rent;

    public PlaceRentAdapterInPlaceOverview(String rent) {
        this.rent = rent;
    }

    @NonNull
    @Override
    public PlaceRentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_of_guests_items_ui_in_place_overview, parent, false);
        return new PlaceRentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceRentAdapterInPlaceOverview.PlaceRentViewHolder holder, int position) {
        holder.title.setText("Rent per Night (in Rs.): ");
        holder.result.setText(rent);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class PlaceRentViewHolder extends RecyclerView.ViewHolder {
        TextView title, result;

        public PlaceRentViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.id_titleOfNumberOfGuestsInPlaceOverview);
            result = itemView.findViewById(R.id.id_resultOfNumberOfGuestsInPlaceOverview);
        }
    }

}

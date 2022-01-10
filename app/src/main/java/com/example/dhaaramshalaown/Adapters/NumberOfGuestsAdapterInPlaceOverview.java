package com.example.dhaaramshalaown.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dhaaramshalaown.R;

public class NumberOfGuestsAdapterInPlaceOverview extends RecyclerView.Adapter<NumberOfGuestsAdapterInPlaceOverview.NumberOfGuestsViewHolder> {
    Context context;
    Integer[] numberOfGuestsList;

    public NumberOfGuestsAdapterInPlaceOverview(Context context, Integer[] numberOfGuestsList) {
        this.context = context;
        this.numberOfGuestsList = numberOfGuestsList;
    }

    @NonNull
    @Override
    public NumberOfGuestsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_of_guests_items_ui_in_place_overview, parent, false);
        return new NumberOfGuestsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberOfGuestsAdapterInPlaceOverview.NumberOfGuestsViewHolder holder, int position) {
        Integer result = numberOfGuestsList[position];

        switch(position) {
            case 0:
                holder.title.setText("Guests");
                holder.result.setText(result.toString());
                break;
            case 1:
                holder.title.setText("Beds");
                holder.result.setText(result.toString());
                break;
            case 2:
                holder.title.setText("Bedrooms");
                holder.result.setText(result.toString());
                break;
            case 3:
                holder.title.setText("Bathrooms");
                holder.result.setText(result.toString());
                break;
            case 4:
                holder.title.setText("Private Bathroom?");
                if(result == 0) holder.result.setText("No");
                else holder.result.setText("Yes");
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return numberOfGuestsList.length;
    }

    public class NumberOfGuestsViewHolder extends RecyclerView.ViewHolder {
        TextView title, result;

        public NumberOfGuestsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.id_titleOfNumberOfGuestsInPlaceOverview);
            result = itemView.findViewById(R.id.id_resultOfNumberOfGuestsInPlaceOverview);
        }
    }
}

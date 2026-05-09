package com.example.androidproject.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.MechanicLocation;
import com.example.androidproject.R;
import com.example.androidproject.model.AvailableMechanics;

import java.util.ArrayList;

public class AvailableMechanicsAdapter extends RecyclerView.Adapter<AvailableMechanicsAdapter.AvailableMechanicHolder> {
    ArrayList<com.example.androidproject.model.AvailableMechanics> mechanicsList;

    public AvailableMechanicsAdapter(ArrayList<AvailableMechanics> mechanics) {
        this.mechanicsList = mechanics;
    }

    @NonNull
    @Override
    public AvailableMechanicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(parent.getContext());
        View view = lf.inflate(R.layout.available_mechanics, parent, false);
        AvailableMechanicsAdapter.AvailableMechanicHolder mechanics = new AvailableMechanicsAdapter.AvailableMechanicHolder(view);

        return mechanics;
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableMechanicHolder holder, int position) {

        holder.mechanicName.setText(mechanicsList.get(position).getName());
        holder.location.setText(mechanicsList.get(position).getLocation());
        holder.serviceType.setText(mechanicsList.get(position).getService());
        holder.locationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(), MechanicLocation.class);
                view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mechanicsList.size();
    }

    static class AvailableMechanicHolder extends RecyclerView.ViewHolder {

        public TextView mechanicName;
        public TextView location;
        public TextView serviceType;
        public ImageView locationImage;

        public AvailableMechanicHolder(@NonNull View itemView) {
            super(itemView);
            this.mechanicName = itemView.findViewById(R.id.textView54);
            this.serviceType = itemView.findViewById(R.id.textView55);
            this.location = itemView.findViewById(R.id.textView56);
            this.locationImage=itemView.findViewById(R.id.imageView18);
        }
    }
}



package com.example.androidproject.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.model.BrokenDownCarList;

import java.util.ArrayList;

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.CarViewHolder>{

    ArrayList<BrokenDownCarList> carList;
    public CarListAdapter(ArrayList<BrokenDownCarList> carList){
        this.carList=carList;

    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("ok","Done");

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View inflatedView =inflater.inflate(R.layout.available_vehicals,parent,false);

        CarViewHolder car=new CarViewHolder(inflatedView);


        return car;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        BrokenDownCarList cars=carList.get(position);
        holder.tv1.setText(cars.getName());
        holder.tv2.setText(cars.getFault());

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class CarViewHolder extends RecyclerView.ViewHolder{

        Button button;
        TextView tv1;
        TextView tv2;
        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            button= itemView.findViewById(R.id.button12);
            tv1=itemView.findViewById(R.id.textView38);
            tv2=itemView.findViewById(R.id.textView39);

        }
    }
}

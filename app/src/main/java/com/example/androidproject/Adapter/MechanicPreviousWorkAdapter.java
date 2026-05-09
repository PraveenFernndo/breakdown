package com.example.androidproject.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.model.PreviousWork;

import java.util.ArrayList;

public class MechanicPreviousWorkAdapter extends RecyclerView.Adapter<MechanicPreviousWorkAdapter.WorkItemHolder> {

    ArrayList<PreviousWork> previousWorkList;

    public MechanicPreviousWorkAdapter(ArrayList<PreviousWork> workList){
        this.previousWorkList=workList;
    }

    @NonNull
    @Override
    public WorkItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(parent.getContext());
        View view = lf.inflate(R.layout.mechanic_prevoius_work, parent, false);
        WorkItemHolder workItems = new WorkItemHolder(view);
        Log.i("Done","Done");


        return workItems;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkItemHolder holder, int position) {
        holder.vehicalName.setText(previousWorkList.get(position).getVehicalName());
        holder.fault.setText(previousWorkList.get(position).getFault());
        holder.date.setText(previousWorkList.get(position).getDate());
        holder.amount.setText(previousWorkList.get(position).getIncome());
        Log.i("Done","Done");


    }

    @Override
    public int getItemCount() {
        return previousWorkList.size();

    }

    static class WorkItemHolder extends RecyclerView.ViewHolder{

        public TextView vehicalName;
        public TextView date;
        public TextView amount;
        public TextView fault;
        public WorkItemHolder(@NonNull View itemView) {
            super(itemView);
            this.amount=itemView.findViewById(R.id.textView44);
            this.date=itemView.findViewById(R.id.textView46);
            this.fault=itemView.findViewById(R.id.textView45);
            this.vehicalName=itemView.findViewById(R.id.textView43);
        }
    }


}

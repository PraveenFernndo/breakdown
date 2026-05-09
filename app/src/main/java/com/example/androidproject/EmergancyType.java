package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.model.Emergancy;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class EmergancyType extends AppCompatActivity {
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emergancy_type);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        RecyclerView rv = findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(EmergancyType.this);
        rv.setLayoutManager(layoutManager);


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("service_type")
                .get().
                addOnSuccessListener(queryDocumentSnapshots -> {
                    ArrayList<Emergancy> categoryList = new ArrayList<>();

                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        type = document.getString("name");
                        if (type != null) {
                            categoryList.add(new Emergancy(type));
                        }
                    }
                    EmergancyItems emergancyItems = new EmergancyItems(categoryList);
                    rv.setAdapter(emergancyItems);
                });


    }
}

class EmergancyItemsHolder extends RecyclerView.ViewHolder {


    public Button availableMechanics;
    public TextView emergancyType;

    public EmergancyItemsHolder(@NonNull View itemView) {
        super(itemView);
        this.availableMechanics = itemView.findViewById(R.id.button9);
        this.emergancyType = itemView.findViewById(R.id.textView27);
    }
}

class EmergancyItems extends RecyclerView.Adapter<EmergancyItemsHolder> {

    ArrayList<Emergancy> emergancyArrayList;

    public EmergancyItems(ArrayList<Emergancy> emergancyArrayList) {
        this.emergancyArrayList = emergancyArrayList;
    }


    @NonNull
    @Override
    public EmergancyItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(parent.getContext());
        View view = lf.inflate(R.layout.emergancytypes, parent, false);
        EmergancyItemsHolder emrgancyItems = new EmergancyItemsHolder(view);

        return emrgancyItems;
    }

    @Override
    public void onBindViewHolder(@NonNull EmergancyItemsHolder holder, int position) {
        holder.emergancyType.setText(emergancyArrayList.get(position).getEmergancyTypeName());
        holder.availableMechanics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AvailableMechanics.class);
                i.putExtra("name", emergancyArrayList.get(position).getEmergancyTypeName().toString());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return emergancyArrayList.size();
    }
}
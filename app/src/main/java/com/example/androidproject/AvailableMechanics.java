package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Adapter.AvailableMechanicsAdapter;
import com.example.androidproject.Adapter.MechanicPreviousWorkAdapter;
import com.example.androidproject.model.PreviousWork;

import java.util.ArrayList;

public class AvailableMechanics extends AppCompatActivity {
    String serviceType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_available_mechanics);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv = findViewById(R.id.textView52);
        Intent i = getIntent();
        serviceType = i.getStringExtra("name");
        tv.setText(serviceType);

        RecyclerView rv = findViewById(R.id.recycleView5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(AvailableMechanics.this);
        rv.setLayoutManager(layoutManager);

        ArrayList<com.example.androidproject.model.AvailableMechanics> mechanicList = new ArrayList<>();
        mechanicList.add(new com.example.androidproject.model.AvailableMechanics("Praveen", "Moratuwa", "path", "0764165971", "Battery"));


//        MechanicPreviousWorkAdapter adapter = new MechanicPreviousWorkAdapter(work);
//        rv.setAdapter(adapter);

        AvailableMechanicsAdapter adpter = new AvailableMechanicsAdapter(mechanicList);
        rv.setAdapter(adpter);

    }
}
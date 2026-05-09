package com.example.androidproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Adapter.MechanicPreviousWorkAdapter;
import com.example.androidproject.model.Emergancy;
import com.example.androidproject.model.PreviousWork;

import java.util.ArrayList;

public class MechanicPrevoiusWork extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mechanic_prevoius_work);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rv = findViewById(R.id.recycleView3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MechanicPrevoiusWork.this);
        rv.setLayoutManager(layoutManager);

        ArrayList<PreviousWork> work = new ArrayList<>();

        work.add(new PreviousWork("Vezel","1000","2025/02/01","Engine Fault"));
        work.add(new PreviousWork("Vezel","2000","2025/02/01","Engine Fault"));
        work.add(new PreviousWork("Vezel","4000","2025/02/01","Engine Fault"));
        work.add(new PreviousWork("Vezel","7000","2025/02/01","Engine Fault"));


        MechanicPreviousWorkAdapter adapter = new MechanicPreviousWorkAdapter(work);
        rv.setAdapter(adapter);

    }
}
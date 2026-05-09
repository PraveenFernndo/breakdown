package com.example.androidproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.Adapter.CarListAdapter;
import com.example.androidproject.model.BrokenDownCarList;

import java.util.ArrayList;

public class MechanicViewHome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mechanic_view_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recycleView = findViewById(R.id.recycleView2);
        ArrayList<BrokenDownCarList> carList = new ArrayList<>();
        carList.add(new BrokenDownCarList("Vezel", "Battery", "contact"));
        carList.add(new BrokenDownCarList("Vezel", "Battery", "contact"));
        carList.add(new BrokenDownCarList("Vezel", "Battery", "contact"));
        carList.add(new BrokenDownCarList("Vezel", "Battery", "contact"));

        CarListAdapter carListAdapter = new CarListAdapter(carList);

        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(carListAdapter);

    }
}
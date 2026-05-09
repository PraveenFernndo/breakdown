package com.example.androidproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences storage=getSharedPreferences("AndroidProject",MODE_PRIVATE);
        String storageName=storage.getString("name","defaultName");

        TextView name=findViewById(R.id.textView15);
        name.setText("Welcome, "+storageName);

        Button vehicleRegistration = findViewById(R.id.button5);
        vehicleRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomePage.this, VehicalRegistration.class);
                startActivity(intent);
            }
        });

        Button mechanicRegistration = findViewById(R.id.button6);
        mechanicRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomePage.this, MechanicRegistration.class);
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomePage.this, Home.class);
                startActivity(i);
            }
        });

        Button btn13=findViewById(R.id.button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WelcomePage.this,MechanicViewHome.class);
                startActivity(intent);
            }
        });

        Button btn1=findViewById(R.id.button17);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(WelcomePage.this,Mechanic_view.class);
                startActivity(i);
            }
        });

    }
}
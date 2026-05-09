package com.example.androidproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproject.controller.Mechanic;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MechanicRegistration extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mechanic_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadServiceTypes();
        loadCities();

        Button register = findViewById(R.id.button18);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Spinner service = findViewById(R.id.spinner);
                Spinner city = findViewById(R.id.spinner5);

                EditText line01 = findViewById(R.id.editTextText7);
                EditText line02 = findViewById(R.id.editTextText9);

                SharedPreferences storage = getSharedPreferences("AndroidProject", MODE_PRIVATE);
                String userId = storage.getString("id", "defaultName");

                if (service.getSelectedItem().equals("Select")) {
                    Toast.makeText(MechanicRegistration.this, "Service Type Required", Toast.LENGTH_LONG).show();
                } else if (line01.getText().isEmpty()) {
                    Toast.makeText(MechanicRegistration.this, "Add Address Line1", Toast.LENGTH_LONG).show();
                } else if (line02.getText().isEmpty()) {
                    Toast.makeText(MechanicRegistration.this, "Add Address Line2", Toast.LENGTH_LONG).show();
                } else if (city.getSelectedItem().equals("Select")) {
                    Toast.makeText(MechanicRegistration.this, "City Required", Toast.LENGTH_LONG).show();
                } else {
                    db.collection("mechanic").whereEqualTo("user_id", userId).get().addOnSuccessListener(result -> {
                        if (!result.isEmpty()) {
                            Toast.makeText(MechanicRegistration.this, "Already Registered", Toast.LENGTH_LONG).show();
                        }else{
                            Mechanic mechanicData=new Mechanic(service.getSelectedItem().toString(),line01.getText().toString(),line02.getText().toString(),city.getSelectedItem().toString(),userId);
                            db.collection("mechanic").add(mechanicData).addOnSuccessListener(
                                    new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            Intent i=new Intent(MechanicRegistration.this,Mechanic_view.class);
                                            startActivity(i);
                                        }
                                    }

                            );
                        }
                    });
                }

            }
        });

    }

    private void loadServiceTypes() {

        Spinner spinner = findViewById(R.id.spinner);

        db.collection("service_type")
                .get().
                addOnSuccessListener(queryDocumentSnapshots -> {
                    List<String> categoryList = new ArrayList<>();
                    categoryList.add("Select");

                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        String type = document.getString("name");
                        if (type != null) {
                            categoryList.add(type);
                        }
                    }

                    String[] categories = categoryList.toArray(new String[0]);

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            MechanicRegistration.this,
                            android.R.layout.simple_spinner_item,
                            categories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                }).addOnFailureListener(e -> {
                    Log.e("Load Categories", "Error loading categories: " + e.getMessage());

                    String[] defaultCategories = {"Choose event type", "Sports", "Charity", "Art", "Design", "Music"};
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            MechanicRegistration.this,
                            android.R.layout.simple_spinner_item,
                            defaultCategories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                });
    }


    private void loadCities() {

        Spinner spinner = findViewById(R.id.spinner5);

        db.collection("city")
                .get().
                addOnSuccessListener(queryDocumentSnapshots -> {
                    List<String> categoryList = new ArrayList<>();
                    categoryList.add("Select");

                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        String type = document.getString("name");
                        if (type != null) {
                            categoryList.add(type);
                        }
                    }

                    String[] categories = categoryList.toArray(new String[0]);

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            MechanicRegistration.this,
                            android.R.layout.simple_spinner_item,
                            categories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                }).addOnFailureListener(e -> {
                    Log.e("Load Categories", "Error loading categories: " + e.getMessage());

                    String[] defaultCategories = {"Choose event type", "Sports", "Charity", "Art", "Design", "Music"};
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            MechanicRegistration.this,
                            android.R.layout.simple_spinner_item,
                            defaultCategories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                });
    }

}


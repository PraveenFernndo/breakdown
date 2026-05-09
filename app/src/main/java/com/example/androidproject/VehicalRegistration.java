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

import com.example.androidproject.controller.Vehicle;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicalRegistration extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vehical_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadVehicleTypes();
        loadVehicleModels();


        Button registerBtn = findViewById(R.id.button4);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number = findViewById(R.id.editTextText6);
                Spinner type = findViewById(R.id.spinner2);
                Spinner model = findViewById(R.id.spinner3);
                EditText yearManufactured = findViewById(R.id.editTextText8);
                EditText name = findViewById(R.id.editTextText10);

                if (number.getText().isEmpty()) {
                    Toast.makeText(VehicalRegistration.this, "Vehicle Number Required", Toast.LENGTH_LONG).show();
                } else if (type.getSelectedItem().equals("Select")) {
                    Toast.makeText(VehicalRegistration.this, "Vehicle Type Required", Toast.LENGTH_LONG).show();
                } else if (yearManufactured.getText().isEmpty()) {
                    Toast.makeText(VehicalRegistration.this, "Manufactured Year Required", Toast.LENGTH_LONG).show();
                } else if (model.getSelectedItem().equals("Select")) {
                    Toast.makeText(VehicalRegistration.this, "Vehicle Model Required", Toast.LENGTH_LONG).show();
                } else if (name.getText().isEmpty()) {
                    Toast.makeText(VehicalRegistration.this, "Vehicle Name Required", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences storage = getSharedPreferences("AndroidProject", MODE_PRIVATE);
                    String userId = storage.getString("id", "defaultName");

//                    db.collection("vehicle_type").whereEqualTo("name", type.getSelectedItem().toString()).get().addOnSuccessListener(
//                            task -> {
//                                if (!task.isEmpty()) {
//                                    QueryDocumentSnapshot document = (QueryDocumentSnapshot) task.getDocuments().get(0);
//
//                                    vehicle_type_id = document.getId();
//                                    Log.i("data",vehicle_type_id);
//                                }
//                            }
//                    );
//
//                    db.collection("vehicle_model").whereEqualTo("name", model.getSelectedItem().toString()).get().addOnSuccessListener(
//                            task -> {
//                                if (!task.isEmpty()) {
////                                    QueryDocumentSnapshot document = (QueryDocumentSnapshot) task.getDocuments().get(0);
//
//                                    for(QueryDocumentSnapshot document:task){
//                                        vehicle_model_id = document.getId();
//                                    }
//
//
//                                    Log.i("data",vehicle_model_id);
//
//                                }
//                            }
//                    );

                    Vehicle vehicleData = new Vehicle(name.getText().toString(), number.getText().toString(), type.getSelectedItem().toString(), model.getSelectedItem().toString(), "path", yearManufactured.getText().toString(), userId);
                    db.collection("vehicle").whereEqualTo("vehicle_number", number.getText().toString()).get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    if (!task.getResult().isEmpty()) {
                                        Toast.makeText(VehicalRegistration.this, "This Vehicle Already Exist", Toast.LENGTH_LONG).show();
                                    } else {

                                        db.collection("vehicle").add(vehicleData).addOnSuccessListener(
                                                new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {
                                                        Intent i=new Intent(VehicalRegistration.this, Home.class);
                                                        startActivity(i);
                                                    }
                                                }
                                        );

                                    }

                                }
                            });
                }
            }
        });

    }

    private void loadVehicleTypes() {

        Spinner spinner = findViewById(R.id.spinner2);

        db.collection("vehicle_type")
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
                            VehicalRegistration.this,
                            android.R.layout.simple_spinner_item,
                            categories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                }).addOnFailureListener(e -> {
                    Log.e("Load Categories", "Error loading categories: " + e.getMessage());

                    String[] defaultCategories = {"Choose event type", "Sports", "Charity", "Art", "Design", "Music"};
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            VehicalRegistration.this,
                            android.R.layout.simple_spinner_item,
                            defaultCategories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                });
    }

    private void loadVehicleModels() {

        Spinner spinner = findViewById(R.id.spinner3);

        db.collection("vehicle_model")
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
                            VehicalRegistration.this,
                            android.R.layout.simple_spinner_item,
                            categories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                }).addOnFailureListener(e -> {
                    Log.e("Load Categories", "Error loading categories: " + e.getMessage());

                    String[] defaultCategories = {"Select", "Toyota", "Nissan", "Mitsubishi", "BMW", "Benz"};
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                            VehicalRegistration.this,
                            android.R.layout.simple_spinner_item,
                            defaultCategories
                    );
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(arrayAdapter);

                });
    }

}
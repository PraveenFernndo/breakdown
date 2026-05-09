package com.example.androidproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonRegister = findViewById(R.id.button8);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, UserRegistration.class);
                startActivity(intent);
            }
        });

        Button buttonLogin = findViewById(R.id.button7);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText email = findViewById(R.id.editTextText5);
                EditText password = findViewById(R.id.editTextTextPassword2);

//                if (email.getText().isEmpty()) {
//                    Toast.makeText(Login.this, "Email Required", Toast.LENGTH_LONG).show();
//                } else if (password.getText().isEmpty()) {
//                    Toast.makeText(Login.this, "Password Required", Toast.LENGTH_LONG).show();
//                } else {
//                    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
//
//                    firestore.collection("user").whereEqualTo("email", email.getText().toString())
//                            .whereEqualTo("password", password.getText().toString()).get()
//                            .addOnCompleteListener(task -> {
//                                if (task.isSuccessful()) {
//                                    if (task.getResult().isEmpty()) {
//                                        // Name exists in the database
//                                        Toast.makeText(Login.this, "No User Found", Toast.LENGTH_LONG).show();
//                                    } else {
//                                        SharedPreferences storage = getSharedPreferences("AndroidProject", MODE_PRIVATE);
//                                        SharedPreferences.Editor edit = storage.edit();
//
//                                        for (QueryDocumentSnapshot document : task.getResult()) {
//                                            String id = document.getId();
//                                            String name = document.getString("name");
//
//                                            edit.putString("name",name);
//                                            edit.putString("id",id);
//                                        }
//
//                                        edit.apply();
//
//                                        Intent intent = new Intent(Login.this, WelcomePage.class);
//                                        startActivity(intent);
//
//                                    }
//
//                                }
//                            });
//                }

                Intent intent = new Intent(Login.this, WelcomePage.class);
                startActivity(intent);
            }
        });
    }
}
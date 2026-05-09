package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidproject.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class UserRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonLogin = findViewById(R.id.button3);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = findViewById(R.id.editTextText);
                EditText mobile = findViewById(R.id.editTextText2);
                EditText email = findViewById(R.id.editTextText3);
                EditText password = findViewById(R.id.editTextTextPassword);
                EditText nic = findViewById(R.id.editTextText4);

                if (name.getText().isEmpty()) {
                    Toast.makeText(UserRegistration.this, "Name Required", Toast.LENGTH_LONG).show();
                } else if (mobile.getText().isEmpty()) {
                    Toast.makeText(UserRegistration.this, "Mobile Required", Toast.LENGTH_LONG).show();
                } else if (email.getText().isEmpty()) {
                    Toast.makeText(UserRegistration.this, "Email Required", Toast.LENGTH_LONG).show();
                } else if (password.getText().isEmpty()) {
                    Toast.makeText(UserRegistration.this, "Password Required", Toast.LENGTH_LONG).show();
                } else if (nic.getText().isEmpty()) {
                    Toast.makeText(UserRegistration.this, "NIC Required", Toast.LENGTH_LONG).show();
                } else {

                    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

                    firestore.collection("user").whereEqualTo("nic", nic.getText().toString()).whereEqualTo
                                    ("email",email.getText().toString()).whereEqualTo("mobile",mobile.getText().toString()).get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    if (!task.getResult().isEmpty()) {
                                        // Name exists in the database
                                        Toast.makeText(UserRegistration.this, "Some Data Already Exist", Toast.LENGTH_LONG).show();
                                    } else {
                                        Date d = new Date();
                                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
                                        String date = sdf.format(d);

                                        User user = new User(name.getText().toString(), mobile.getText().toString(), email.getText().toString(), password.getText().toString(), nic.getText().toString(), "path", date, "Active", "U");

                                        firestore.collection("user").add(user).addOnSuccessListener(
                                                new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {
                                                        Log.i("id", documentReference.getId());
                                                    }
                                                }
                                        );

                                        Intent intent = new Intent(UserRegistration.this, Login.class);
                                        startActivity(intent);
                                    }
                                }
                            });



                }


            }
        });

        Button btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserRegistration.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
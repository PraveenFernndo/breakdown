package com.example.androidproject;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);


        WebView web = findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setGeolocationEnabled(true);

        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        String url = "https://www.google.com/maps/search/?api=1&query= 6.758818250000001 ,  79.91111924999998";
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(url);

        Button emergancyButton=findViewById(R.id.button27);
        emergancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this,EmergancyType.class);
                startActivity(intent);
            }
        });

//        Button btn=findViewById(R.id.button11);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FirebaseFirestore firestore=FirebaseFirestore.getInstance();
//                HashMap<String, Object> mapdata=new HashMap();
//                mapdata.put("name","Kamal");
//                mapdata.put("mobile","0764165971");
//                mapdata.put("city","Panadura");
//
//                firestore.collection("user").add(mapdata);
//
//            }
//        });


    }




}
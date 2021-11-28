package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    Button btnOpenCompany, btnOpenClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnOpenCompany = findViewById(R.id.btnOpenCompany);
        btnOpenClient = findViewById(R.id.btnOpenClient);

        btnOpenClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ClientActivity2.class);
                startActivity(intent);
            }
        });
    }
}
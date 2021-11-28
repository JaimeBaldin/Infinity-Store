package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.myapplication.ListView.Company;

import java.util.ArrayList;


public class ClientActivity2 extends AppCompatActivity {

    Button btnGoToCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client2);

        btnGoToCompany = findViewById(R.id.btnGoToCompany);

        btnGoToCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClientActivity2.this, Company.class);
                startActivity(intent);
            }
        });

    }
}
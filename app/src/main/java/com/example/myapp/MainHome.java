package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainHome extends AppCompatActivity {

 Button btnToyo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

         btnToyo = findViewById(R.id.btnToyo);
         btnToyo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(getApplicationContext(),Toyota.class);
                 startActivity(intent);

                 Toast.makeText(MainHome.this, "Welcome to Auckland Toyota", Toast.LENGTH_SHORT).show();
             }
         });


    }
}
package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainHome extends AppCompatActivity {

 Button btnToyo;
 Button btnss;
 Button btnbmw;
 ImageView task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        task = findViewById(R.id.taskviewbar);
        btnbmw = findViewById(R.id.btnbmw);
         btnToyo = findViewById(R.id.btnToyo);
         btnss = findViewById(R.id.btnss);



         task.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(getApplicationContext(),com.example.myapp.activity.main.reports.class);
                 startActivity(intent);

                 Toast.makeText(MainHome.this, "Welcome to Ssyaong", Toast.LENGTH_SHORT).show();
             }
         });

         btnss.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),SShow.class);
                 startActivity(intent);

                 Toast.makeText(MainHome.this, "Welcome to Ssyaong", Toast.LENGTH_SHORT).show();
             }
         });
         btnToyo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(getApplicationContext(),Toyota.class);
                 startActivity(intent);

                 Toast.makeText(MainHome.this, "Welcome to Auckland Toyota", Toast.LENGTH_SHORT).show();
             }
         });

         btnbmw.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(getApplicationContext(),BMWPage.class);
                 startActivity(intent);

                 Toast.makeText(MainHome.this, "Welcome to Auckland BMW", Toast.LENGTH_SHORT).show();

             }
         });

    }
}
package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.activity.main.reports;

public class Dash extends AppCompatActivity {

    Button site, task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

      site.findViewById(R.id.btnsites);
      task.findViewById(R.id.btntask);


      task.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(), com.example.myapp.activity.main.reports.class);
              startActivity(intent);
              Toast.makeText(Dash.this, "You are in Dash Page", Toast.LENGTH_SHORT).show();
          }
      });


      site.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent intent = new Intent(getApplicationContext(),MainHome.class);
              startActivity(intent);
              Toast.makeText(Dash.this, "You are in Sites Page", Toast.LENGTH_SHORT).show();
          }
      });


    }
}
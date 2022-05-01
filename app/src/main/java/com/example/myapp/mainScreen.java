package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapp.activity.main.reports;

public class mainScreen extends AppCompatActivity {

    Button btnSignIn, btnSignUp, btngal, btnvideo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btngal = findViewById(R.id.btngal);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnvideo = findViewById(R.id.btnVideo);

        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
                startActivity(intent);

                Toast.makeText(mainScreen.this, "You are in Login page", Toast.LENGTH_SHORT).show();

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);

                Toast.makeText(mainScreen.this, "You are in Login page", Toast.LENGTH_SHORT).show();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),registrationScreen.class);
                startActivity(intent);

                Toast.makeText(mainScreen.this, "You are in Sign Up Page", Toast.LENGTH_SHORT).show();
            }
        });

        btngal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Gallery.class);
                startActivity(intent);
            }
        });





    }
}
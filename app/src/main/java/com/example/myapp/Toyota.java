package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Toyota extends AppCompatActivity {


   ImageView imgCall;
    ImageView imgSms;
    ImageView btnBack;
    ImageView btnLogout;
    ImageView toyomap;
    ImageView webb3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota);

        webb3 = findViewById(R.id.Webb3);
        btnBack = findViewById(R.id.btnBack);
      imgCall = findViewById(R.id.imgCall);
        imgSms = findViewById(R.id.imgSms);
        btnLogout = findViewById(R.id.btnLogout);
        toyomap = findViewById(R.id.toyomap);

        webb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Browsety.class);
                startActivity(i);
            }
        });

        toyomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.google.com/maps/place/Auckland+City+Toyota+-+Mt+Wellington/@-36.8971937,174.8461055,17z/data=!3m1!4b1!4m5!3m4!1s0x6d0d49653acc9041:0x7f369e4e749d4d2b!8m2!3d-36.8971937!4d174.8482942";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);

                }

        });

        btnLogout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intentLogout = new Intent(getApplicationContext(),loginActivity.class);
                startActivity(intentLogout);

                Toast.makeText(Toyota.this, "You are now Logout", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getApplicationContext(),MainHome.class);
                startActivity(intentBack);
            }
        });
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02041248991"));
                startActivity(intent);
            }
        });

        imgSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","02041248991", null));
                intentsms.putExtra("sms_body", "Hello Sir");
                startActivity(intentsms);
            }
        });
    }
}
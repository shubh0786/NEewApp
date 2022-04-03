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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota);

        btnBack = findViewById(R.id.btnBack);
      imgCall = findViewById(R.id.imgCall);
        imgSms = findViewById(R.id.imgSms);
        btnLogout = findViewById(R.id.btnLogout);
        toyomap = findViewById(R.id.toyomap);

        toyomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent bmintent = new Intent(getApplicationContext(),Toyotmap.class);
                startActivity(bmintent);
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
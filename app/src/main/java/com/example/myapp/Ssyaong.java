package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Ssyaong extends AppCompatActivity {

    ImageView imgssCall;
    ImageView imgssSms;
    ImageView btnBack;
    ImageView btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyota);

        btnBack = findViewById(R.id.btnBack);
        imgssCall = findViewById(R.id.imgCall);
        imgssSms = findViewById(R.id.imgSms);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intentLogout = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intentLogout);

                Toast.makeText(Ssyaong.this, "You are now Logout", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getApplicationContext(), MainHome.class);
                startActivity(intentBack);
            }
        });
        imgssCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02041248991"));
                startActivity(intent);
            }
        });

        imgssSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "02041248991", null));
                intentsms.putExtra("sms_body", "Hello Sir");
                startActivity(intentsms);
            }
        });
    }
}
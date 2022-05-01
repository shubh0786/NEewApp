package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class BMWPage extends AppCompatActivity {



        ImageView imgCall1;
        ImageView imgSms1;
        ImageView btnBack1;
        ImageView btnLogout1;
        ImageView toyomap1;
        ImageView webb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmwpage);


        btnBack1 = findViewById(R.id.btnBack1);
            imgCall1 = findViewById(R.id.imgCall1);
            imgSms1 = findViewById(R.id.imgSms1);
            btnLogout1 = findViewById(R.id.btnLogout1);
            toyomap1 = findViewById(R.id.toyomap1);
            webb1 = findViewById(R.id.webb1);

            toyomap1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String url = "https://www.google.com/maps/place/Auckland+City+BMW/@-36.876465,174.7772688,19z/data=!4m5!3m4!1s0x6d0d487bfd269bbb:0x443ad2e194ac9a5c!8m2!3d-36.876462!4d174.7778122";

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                    startActivity(intent);
                }

            });

            btnLogout1.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    Intent intentLogout = new Intent(getApplicationContext(),loginActivity.class);
                    startActivity(intentLogout);

                    Toast.makeText(BMWPage.this, "You are now Logout", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            btnBack1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentBack = new Intent(getApplicationContext(),MainHome.class);
                    startActivity(intentBack);
                }
            });
            imgCall1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:02041248991"));
                    startActivity(intent);
                }
            });

            imgSms1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","02041248991", null));
                    intentsms.putExtra("sms_body", "Hello Sir");
                    startActivity(intentsms);
                }
            });

            webb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentBack = new Intent(getApplicationContext(),Browsebmw.class);
                    startActivity(intentBack);
                }
            });
    }
}
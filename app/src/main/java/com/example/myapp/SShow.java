package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SShow extends AppCompatActivity {


    ImageView imgCall2;
    ImageView imgSms2;
    ImageView btnBack2;
    ImageView btnLogout2;
    ImageView toyomap2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sshow);

        btnBack2 = findViewById(R.id.btnBack2);
        imgCall2 = findViewById(R.id.imgCall2);
        imgSms2 = findViewById(R.id.imgSms2);
        btnLogout2 = findViewById(R.id.btnLogout2);
        toyomap2 = findViewById(R.id.toyomap2);

        toyomap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    String url = "https://www.google.com/maps/place/SsangYong+Tauranga/@-37.6944987,176.0922649,12z/data=!4m9!1m2!2m1!1sssangyong+motor+company!3m5!1s0x6d6ddb1702db650f:0xb2e321446ae39da3!8m2!3d-37.6944799!4d176.162263!15sChdzc2FuZ3lvbmcgbW90b3IgY29tcGFueSIDiAEBWhkiF3NzYW5neW9uZyBtb3RvciBjb21wYW55kgEKY2FyX2RlYWxlcpoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VSbk5ITjVjVjlSUlJBQg";
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                    startActivity(intent);

                }



        });

        btnLogout2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent intentLogout = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intentLogout);

                Toast.makeText(SShow.this, "You are now Logout", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getApplicationContext(), MainHome.class);
                startActivity(intentBack);
            }
        });
        imgCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:02041248991"));
                startActivity(intent);
            }
        });

        imgSms2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsms = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "02041248991", null));
                intentsms.putExtra("sms_body", "Hello Sir");
                startActivity(intentsms);
            }
        });
    }
}
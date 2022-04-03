package com.example.myapp;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class Toyotmap extends AppCompatActivity {





        WebView mapview1;
        GeolocationPermissions.Callback mCallback;
        String mOrigin;
        ImageView btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toyotmap);

            btnBack2 = findViewById(R.id.btnBack2);
            mapview1 = findViewById(R.id.mapview1);
            mapview1.getSettings().setJavaScriptEnabled(true);
            mapview1.getSettings().setGeolocationEnabled(true);



            mapview1.setWebViewClient(new WebViewClient());

            mapview1.setWebChromeClient(new WebChromeClient(){

                @Override
                public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                    super.onGeolocationPermissionsShowPrompt(origin, callback);


                    if (Build.VERSION.SDK_INT>=23){

                        if (hasPermission()){
                            callback.invoke(origin, true, false);
                        }else {

                            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 362);
                            mCallback = callback;
                            mOrigin = origin;
                        }
                    } else {
                        callback.invoke(origin, true, false);

                    }




                }
            });
            btnBack2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent bintent = new Intent(getApplicationContext(),Toyota.class);
                    startActivity(bintent);
                }
            });


            mapview1.loadUrl("https://www.google.com/maps/place/Auckland+City+Toyota+-+Mt+Wellington/@-36.8971937,174.8461055,17z/data=!3m1!4b1!4m5!3m4!1s0x6d0d49653acc9041:0x7f369e4e749d4d2b!8m2!3d-36.8971937!4d174.8482942");

        }
        public boolean hasPermission(){
            return ContextCompat.checkSelfPermission(Toyotmap.this, Manifest.permission.ACCESS_FINE_LOCATION)== PERMISSION_GRANTED;
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 362)

            {
                if (grantResults.length>0&&grantResults[0]== PERMISSION_GRANTED){

                    mCallback.invoke(mOrigin, true, false);
                }
            }


        }
    }

package com.example.myapp;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

public class BMWActivity extends AppCompatActivity {

    WebView mapview;
    GeolocationPermissions.Callback mCallback;
    String mOrigin;
    ImageView btnBack2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmwactivity);

        btnBack2 = findViewById(R.id.btnBack2);
        mapview = findViewById(R.id.mapview);
        mapview.getSettings().setJavaScriptEnabled(true);
        mapview.getSettings().setGeolocationEnabled(true);



        mapview.setWebViewClient(new WebViewClient());

        mapview.setWebChromeClient(new WebChromeClient(){

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


        mapview.loadUrl("https://www.google.com/maps/place/Auckland+City+BMW/@-36.876465,174.7772688,19z/data=!4m5!3m4!1s0x6d0d487bfd269bbb:0x443ad2e194ac9a5c!8m2!3d-36.876462!4d174.7778122");

    }
    public boolean hasPermission(){
        return ContextCompat.checkSelfPermission(BMWActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)== PERMISSION_GRANTED;
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
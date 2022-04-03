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

public class SSmap extends AppCompatActivity {


    WebView mapview2;
    GeolocationPermissions.Callback mCallback;
    String mOrigin;
    ImageView btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssmap);

        btnBack2 = findViewById(R.id.btnBack2);
        mapview2 = findViewById(R.id.mapview2);
        mapview2.getSettings().setJavaScriptEnabled(true);
        mapview2.getSettings().setGeolocationEnabled(true);


        mapview2.setWebViewClient(new WebViewClient());

        mapview2.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);


                if (Build.VERSION.SDK_INT >= 23) {

                    if (hasPermission()) {
                        callback.invoke(origin, true, false);
                    } else {

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
                Intent bintent = new Intent(getApplicationContext(), Toyota.class);
                startActivity(bintent);
            }
        });


        mapview2.loadUrl("https://www.google.com/maps/place/SsangYong+Tauranga/@-37.6944987,176.0922649,12z/data=!4m9!1m2!2m1!1sssangyong+motor+company!3m5!1s0x6d6ddb1702db650f:0xb2e321446ae39da3!8m2!3d-37.6944799!4d176.162263!15sChdzc2FuZ3lvbmcgbW90b3IgY29tcGFueSIDiAEBWhkiF3NzYW5neW9uZyBtb3RvciBjb21wYW55kgEKY2FyX2RlYWxlcpoBJENoZERTVWhOTUc5blMwVkpRMEZuU1VSbk5ITjVjVjlSUlJBQg");

    }

    public boolean hasPermission() {
        return ContextCompat.checkSelfPermission(SSmap.this, Manifest.permission.ACCESS_FINE_LOCATION) == PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 362) {
            if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED) {

                mCallback.invoke(mOrigin, true, false);
            }
        }


    }
}

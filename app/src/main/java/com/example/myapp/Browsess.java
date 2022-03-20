package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Browsess extends AppCompatActivity {

    WebView webb2;
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsess);

            webb2 = findViewById(R.id.webView3);
            webb2.setWebViewClient(new WebViewClient());
            webb2.loadUrl("https://www.google.com");

    }
}
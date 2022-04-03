package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Browsety extends AppCompatActivity {


    WebView webb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsety);


        webb3 = findViewById(R.id.webView3);
        webb3.setWebViewClient(new WebViewClient());
        webb3.loadUrl("https://www.google.com");


    }

}
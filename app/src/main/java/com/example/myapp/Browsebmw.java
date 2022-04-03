package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Browsebmw extends AppCompatActivity {


    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browsebmw);

      webView = findViewById(R.id.webView);
      webView.setWebViewClient(new WebViewClient());
      webView.loadUrl("https://www.google.com");
    }
}
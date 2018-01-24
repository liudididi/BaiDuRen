package com.example.login_demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticularsActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView webview;

    @Override
    public int getId() {
        return R.layout.activity_particulars;
    }

    @Override
    public void InIt() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);



        webview.loadUrl(url);
    }


}

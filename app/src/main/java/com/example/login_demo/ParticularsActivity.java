package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ParticularsActivity extends BaseActivity {


    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.progressBar1)
    ProgressBar pg1;
    @BindView(R.id.particulars_iv_back)
    ImageView particularsIvBack;
    @BindView(R.id.particular_tv)
    TextView particularTv;

    @Override
    public int getId() {
        return R.layout.activity_particulars;
    }

    @Override
    public void InIt() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String particulars_title = intent.getStringExtra("particulars_title");
        particularTv.setText(particulars_title);
        pg1 = findViewById(R.id.progressBar1);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO 自动生成的方法存根

                if (newProgress == 100) {
                    pg1.setVisibility(View.GONE);//加载完网页进度条消失
                } else {
                    pg1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    pg1.setProgress(newProgress);//设置进度值
                }

            }
        });
        WebSettings webSettings = webView.getSettings();
        // 让WebView能够执行javaScript
        webSettings.setJavaScriptEnabled(true);
        // 让JavaScript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);


        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);
        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);
        // 设置默认字体大小
        webSettings.setDefaultFontSize(12);

        //webView.loadUrl("http://39.106.32.50/#/entrancenews?newsId=2");

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;// 返回false
            }
        });
    }




    @OnClick({R.id.particulars_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.particulars_iv_back:
                finish();
                break;

        }
    }
}

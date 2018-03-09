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
      /*  webView.loadData("<html>\n" +
                        "    <head>\n" +
                        "        <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />\n" +
                        "        <title>支付宝电脑网站支付</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?charset=UTF-8&method=alipay.trade.wap.pay&sign=vRtSoM82lyOgtfZxIC0QMZUshB5O9Pk%2B%2BN8Om4fUzZNaO0ZXLKP5Dw5iyn42mqtyVOQZDmsuOes17UhWQbbo6UXz%2BvyR0iAzY3gzV%2FQy32qIPBTdHDs%2Bpn4cyuv7Gk%2FPA%2FMCaSNlg0RjQ65TiLpHvYlckhYEvgv4dDxAZXihQutrHx2zilGQyUIK5yMcBjDS2unX74BjbCuAwWrF85nLNunvBXxTXHxZ%2BJ8CDXdFb7%2Fne8%2BylqSpu4nDnC%2F8ZBXai9YfqUOWRwzAYj92UJVnHNkGRmszuehxF9%2FQCMoq24nb9eay%2BjEPGoULz8Tj1J7Lrj3%2FPhP1xaX%2FwT6TvgXxGQ%3D%3D&return_url=http%3A%2F%2Fbdrvip.com%2F&notify_url=http%3A%2F%2Flocalhost%3A8098%2Falipay%2Fpay&version=1.0&app_id=2018012302039128&sign_type=RSA2&timestamp=2018-02-28+13%3A18%3A58&alipay_sdk=alipay-sdk-java-dynamicVersionNo&format=json\">\n" +
                        "            <input type=\"hidden\" name=\"biz_content\" value=\"{'out_trade_no':'2018022812351261','total_amount':'0.01','subject':'hbnuhbu','seller_id':'2088921604587154','product_code':'QUICK_WAP_PAY','body':'uhiuhiu'}\">\n" +
                        "            <input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n" +
                        "        </form>\n" +
                        "        <script>document.forms[0].submit();</script>\n" +
                        "    </body>\n" +
                        "</html>",

                "text/html", "utf-8");*/
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

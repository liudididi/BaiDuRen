package com.example.login_demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.example.login_demo.wxapi.WXPayUtils;

import java.io.IOException;
import java.util.Map;

import base.BaseActivity;
import base.BaseApi;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import untils.MyQusetUtils;
import untils.QuestInterface;
import zfbpay.AliPayResult;
import zfbpay.PayResult;

import static java.security.AccessController.getContext;

//TODO 心理测评
public class MentalityActivity extends BaseActivity {


    @BindView(R.id.mentality_iv_back)
    ImageView mentalityIvBack;
    @BindView(R.id.rl1)
    ImageView rl1;
    @BindView(R.id.rl2)
    ImageView rl2;

    public   static    String  xlcp=null;
    @Override
    public int getId() {
        return R.layout.activity_mentality;
    }

    @Override
    public void InIt() {

    }

    @OnClick({R.id.mentality_iv_back, R.id.rl1, R.id.rl2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mentality_iv_back:
                finish();
                break;
            case R.id.rl1:
                xlcp="MBTI";
                Intent intent=new Intent(this,BuyActivity.class);
                intent.putExtra("price","0.01");
                 startActivity(intent);
                break;
            case R.id.rl2:
                xlcp="霍兰德";
                Intent intent2=new Intent(this,BuyActivity.class);
                intent2.putExtra("price","0.01");
                startActivity(intent2);
                break;
        }
    }
}

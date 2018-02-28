package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import untils.MyQusetUtils;
import untils.QuestInterface;

//TODO 心理测评
public class MentalityActivity extends BaseActivity {


    @BindView(R.id.mentality_iv_back)
    ImageView mentalityIvBack;
    @BindView(R.id.rl1)
    ImageView rl1;
    @BindView(R.id.rl2)
    ImageView rl2;

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


                break;
            case R.id.rl2:


                break;
        }
    }
}

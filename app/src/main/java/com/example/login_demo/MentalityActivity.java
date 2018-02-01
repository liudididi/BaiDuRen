package com.example.login_demo;

import android.os.Bundle;
import android.widget.ImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//TODO 心理测评
public class MentalityActivity extends BaseActivity {


    @BindView(R.id.mentality_iv_back)
    ImageView mentalityIvBack;

    @Override
    public int getId() {
        return R.layout.activity_mentality;
    }

    @Override
    public void InIt() {

    }


    @OnClick(R.id.mentality_iv_back)
    public void onViewClicked() {
        finish();
    }
}

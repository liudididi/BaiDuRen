package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolBrouesDetailsActivity extends BaseActivity {


    @BindView(R.id.school_iv_back)
    ImageView schoolIvBack;
    @BindView(R.id.tv_cont)
    TextView tvCont;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @Override
    public int getId() {
        return R.layout.activity_school_broues_details;
    }

    @Override
    public void InIt() {

        Intent intent = getIntent();
        String admissionRules = intent.getStringExtra("count");
        String tltle1 = intent.getStringExtra("tltle1");
        tv_title.setText(tltle1);
        tvCont.setText(admissionRules);

    }


    @OnClick(R.id.school_iv_back)
    public void onViewClicked() {
        finish();
    }
}

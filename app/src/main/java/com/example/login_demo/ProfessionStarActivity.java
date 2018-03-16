package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfessionStarActivity extends BaseActivity {

    @BindView(R.id.img_nan)
    ImageView imgNan;
    @BindView(R.id.ll_nan)
    LinearLayout llNan;
    @BindView(R.id.img_nv)
    ImageView imgNv;
    @BindView(R.id.ll_nv)
    LinearLayout llNv;
    private String classify;
    private String type;
    public static String gender="1";
    @BindView(R.id.pro_iv_back)
    ImageView proIvBack;
    @BindView(R.id.img_wen)
    ImageView imgWen;
    @BindView(R.id.ll_wen)
    LinearLayout llWen;
    @BindView(R.id.img_li)
    ImageView imgLi;
    @BindView(R.id.ll_li)
    LinearLayout llLi;
    @BindView(R.id.img_ben)
    ImageView imgBen;
    @BindView(R.id.ll_ben)
    LinearLayout llBen;
    @BindView(R.id.img_zhuan)
    ImageView imgZhuan;
    @BindView(R.id.ll_zhuan)
    LinearLayout llZhuan;
    @BindView(R.id.pro_tvyes)
    TextView proTvyes;

    @Override
    public int getId() {
        return R.layout.activity_profession_star;
    }

    @Override
    public void InIt() {
        classify = "wen";
        type = "1";
    }

    @OnClick({R.id.pro_iv_back, R.id.ll_wen, R.id.ll_li, R.id.ll_ben, R.id.ll_zhuan, R.id.pro_tvyes, R.id.ll_nan, R.id.ll_nv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pro_iv_back:
                finish();
                break;
            case R.id.ll_wen:
                imgWen.setImageResource(R.drawable.hong);
                imgLi.setImageResource(R.drawable.bai);
                classify = "wen";
                break;
            case R.id.ll_li:
                imgLi.setImageResource(R.drawable.hong);
                imgWen.setImageResource(R.drawable.bai);
                classify = "li";
                break;
            case R.id.ll_ben:
                imgBen.setImageResource(R.drawable.hong);
                imgZhuan.setImageResource(R.drawable.bai);
                type = "1";
                break;
            case R.id.ll_zhuan:
                imgZhuan.setImageResource(R.drawable.hong);
                imgBen.setImageResource(R.drawable.bai);
                type = "0";
                break;
            case R.id.ll_nan:
                imgNan.setImageResource(R.drawable.hong);
                imgNv.setImageResource(R.drawable.bai);
                gender = "1";
                break;
            case R.id.ll_nv:
                imgNan.setImageResource(R.drawable.bai);
                imgNv.setImageResource(R.drawable.hong);
                gender = "0";
                break;
            case R.id.pro_tvyes:
                Intent intent = new Intent(this, startfenleiActivity.class);
                intent.putExtra("classify", classify);
                intent.putExtra("type", type);
                startActivity(intent);
                finish();
                break;
        }
    }


}

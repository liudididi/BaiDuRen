package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EFCJieSuoActivity extends BaseActivity {


    @BindView(R.id.jiesuo_iv_back)
    ImageView jiesuoIvBack;
    @BindView(R.id.img_xlcs)
    ImageView imgXlcs;
    @BindView(R.id.img_zhiyxk)
    ImageView imgZhiyxk;
    @BindView(R.id.img_zhuanyxk)
    ImageView imgZhuanyxk;
    @BindView(R.id.img_mnzy)
    ImageView imgMnzy;

    @Override
    public int getId() {
        return R.layout.activity_efcjie_suo;
    }

    @Override
    public void InIt() {


    }

    @OnClick({R.id.jiesuo_iv_back, R.id.img_xlcs, R.id.img_zhiyxk, R.id.img_zhuanyxk, R.id.img_mnzy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jiesuo_iv_back:
                finish();
                break;
            case R.id.img_xlcs:
                intent(this,XlcsActivity.class);
                break;
            case R.id.img_zhiyxk:
                intent(this,ProfessionStarActivity.class);
                break;
            case R.id.img_zhuanyxk:
                intent(this,MajorStarActivity.class);
                break;
            case R.id.img_mnzy:

                break;
        }
    }
}

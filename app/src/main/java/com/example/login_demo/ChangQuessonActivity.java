package com.example.login_demo;

import android.os.Bundle;
import android.widget.ImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangQuessonActivity extends BaseActivity {


    @BindView(R.id.quesson_iv_back)
    ImageView quessonIvBack;

    @Override
    public int getId() {
        return R.layout.activity_chang_quesson;
    }

    @Override
    public void InIt() {


    }



    @OnClick(R.id.quesson_iv_back)
    public void onViewClicked() {

    finish();
    }
}

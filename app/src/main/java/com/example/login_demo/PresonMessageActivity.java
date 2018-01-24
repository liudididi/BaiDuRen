package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PresonMessageActivity extends BaseActivity {


    @BindView(R.id.preson_iv_back)
    ImageView presonIvBack;
    @BindView(R.id.preson_complie)
    ImageView presonComplie;
    @BindView(R.id.preson_title)
    RelativeLayout presonTitle;
    @BindView(R.id.preson_right)
    ImageView presonRight;
    @BindView(R.id.preson_icon)
    RelativeLayout presonIcon;
    @BindView(R.id.preson_name)
    TextView presonName;
    @BindView(R.id.preson_six)
    TextView presonSix;
    @BindView(R.id.preson_type)
    TextView presonType;
    @BindView(R.id.preson_near)
    TextView presonNear;
    @BindView(R.id.preson_highschool)
    TextView presonHighschool;

    @Override
    public int getId() {
        return R.layout.activity_preson_message;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.preson_iv_back, R.id.preson_complie, R.id.preson_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.preson_iv_back:
                finish();
                break;
            case R.id.preson_complie:
                Toast("编辑");
                break;
            case R.id.preson_icon:
                Toast("设置头像");
                break;
        }
    }
}

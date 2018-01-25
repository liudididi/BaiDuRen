package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySchoolActivity extends BaseActivity {
    @BindView(R.id.myschool_iv_back)
    ImageView myschoolIvBack;
    @BindView(R.id.myschool_hint)
    TextView myschoolHint;
    @BindView(R.id.myschool_see)
    TextView myschoolSee;
    @BindView(R.id.myschool_xrecycle)
    XRecyclerView myschoolXrecycle;

    @Override
    public int getId() {
        return R.layout.activity_my_school;
    }

    @Override
    public void InIt() {


    }


    @OnClick({R.id.myschool_iv_back, R.id.myschool_hint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myschool_iv_back:
                finish();
                break;
            case R.id.myschool_hint:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrimaryActivity extends BaseActivity {


    @BindView(R.id.primary_iv_back)
    ImageView primaryIvBack;
    @BindView(R.id.primary_minute)
    TextView primaryMinute;
    @BindView(R.id.primary_sprint)
    TextView primary_sprint;
    @BindView(R.id.primary_reliable)
    TextView primary_reliable;
    @BindView(R.id.primary_minimum)
    TextView primary_minimum;
    @BindView(R.id.view_sprint)
    View view_sprint;
    @BindView(R.id.view_reliable)
    View view_reliable;
    @BindView(R.id.view_minimum)
    View view_minimum;

    @BindView(R.id.rl_sprint)
    RelativeLayout rl_sprint;
    @BindView(R.id.rl_reliable)
    RelativeLayout rl_reliable;
    @BindView(R.id.rl_minimum)
    RelativeLayout rl_minimum;
    @Override
    public int getId() {
        return R.layout.activity_primary;
    }

    @Override
    public void InIt() {
        primary_sprint.setTextColor(Color.BLACK);
    }

   

    @OnClick({R.id.primary_iv_back, R.id.primary_minute,R.id.rl_sprint,R.id.rl_reliable,R.id.rl_minimum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.primary_iv_back:
                finish();
                break;
            case R.id.primary_minute:
                // TODO: 2018/1/26 地址文理科分数
                break;
            case R.id.rl_sprint:
                primary_sprint.setTextColor(Color.BLACK);
                primary_reliable.setTextColor(Color.GRAY);
                primary_minimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.VISIBLE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.GONE);
                break;
            case R.id.rl_reliable:
                primary_sprint.setTextColor(Color.GRAY);
                primary_reliable.setTextColor(Color.BLACK);
                primary_minimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.VISIBLE);
                view_minimum.setVisibility(View.GONE);
                break;
            case R.id.rl_minimum:
                primary_sprint.setTextColor(Color.GRAY);
                primary_reliable.setTextColor(Color.GRAY);
                primary_minimum.setTextColor(Color.BLACK);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.VISIBLE);
                break;
        }
    }
}

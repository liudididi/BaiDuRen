package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//填报志愿表
public class ReportedActivity extends BaseActivity {

    @BindView(R.id.reported_iv_back)
    ImageView reportedIvBack;
    @BindView(R.id.reported_primary)
    TextView reportedPrimary;
    @BindView(R.id.reported_advanced)
    TextView reportedAdvanced;
    @BindView(R.id.reported_accurate)
    TextView reportedAccurate;

    @Override
    public int getId() {
        return R.layout.activity_reported;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.reported_iv_back, R.id.reported_primary, R.id.reported_advanced, R.id.reported_accurate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.reported_iv_back:
                finish();
                break;
                //初级志愿表
            case R.id.reported_primary:
                intent(this,PrimaryActivity.class);
                break;
                //高级志愿表
            case R.id.reported_advanced:
                intent(this,AdvancedActivity.class);
                break;
                //精选志愿表
            case R.id.reported_accurate:
               Intent intent=new Intent(this,BuyEFCActivity.class);
               intent.putExtra("price","698");
               startActivity(intent);
                break;
        }
    }
}

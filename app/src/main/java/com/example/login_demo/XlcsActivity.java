package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XlcsActivity extends BaseActivity {


    @BindView(R.id.xlcs_iv_back)
    ImageView xlcsIvBack;
    @BindView(R.id.xlcs_bt)
    Button xlcsBt;

    @Override
    public int getId() {
        return R.layout.activity_xlcs;
    }

    @Override
    public void InIt() {

    }


    @OnClick({R.id.xlcs_iv_back, R.id.xlcs_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xlcs_iv_back:
                finish();
                break;
            case R.id.xlcs_bt:
                intent(this,AnswerActivity.class);
                break;
        }
    }
}

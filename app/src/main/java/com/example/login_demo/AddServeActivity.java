package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddServeActivity extends BaseActivity {


    @BindView(R.id.addserve_iv_back)
    ImageView addserveIvBack;


    @Override
    public int getId() {
        return R.layout.activity_add_serve;
    }

    @Override
    public void InIt() {

    }




    @OnClick({R.id.addserve_iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addserve_iv_back:
                finish();
                break;

        }
    }
}

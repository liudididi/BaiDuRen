package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelpActivity extends BaseActivity {


    @BindView(R.id.help_iv_back)
    ImageView helpIvBack;


    @Override
    public int getId() {
        return R.layout.activity_help;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.help_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.help_iv_back:
                finish();
                break;

        }
    }
}

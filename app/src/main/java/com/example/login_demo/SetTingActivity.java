package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetTingActivity extends BaseActivity {

    @BindView(R.id.setting_iv_back)
    ImageView settingIvBack;
    @BindView(R.id.setting_account)
    RelativeLayout settingAccount;
    @BindView(R.id.setting_baiduren)
    RelativeLayout settingBaiduren;
    @BindView(R.id.setting_verson)
    RelativeLayout settingVerson;
    @BindView(R.id.setting_useragreen)
    RelativeLayout settingUseragreen;
    @BindView(R.id.setting_back)
    TextView settingBack;

    @Override
    public int getId() {
        return R.layout.activity_set_ting;
    }

    @Override
    public void InIt() {

    }


    @OnClick({R.id.setting_iv_back, R.id.setting_account, R.id.setting_baiduren, R.id.setting_verson, R.id.setting_useragreen, R.id.setting_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_iv_back:
                finish();
                break;
              //账户管理
            case R.id.setting_account:
                Intent intent=new Intent(this,AccountMagActivity.class);
                startActivity(intent);

                break;
            //关于摆渡人
            case R.id.setting_baiduren:
                break;
                //版本介绍
            case R.id.setting_verson:
                break;
            //用户协议
            case R.id.setting_useragreen:
                intent=new Intent(this,UserAgreenActivity.class);
                startActivity(intent);
                break;
            //退出登录
            case R.id.setting_back:

                break;
        }
    }
}

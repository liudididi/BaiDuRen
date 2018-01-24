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

public class AccountMagActivity extends BaseActivity {

    @BindView(R.id.account_iv_back)
    ImageView accountIvBack;
    @BindView(R.id.account_tv_phone)
    TextView accountTvPhone;
    @BindView(R.id.account_setingpass)
    TextView accountSetingpass;
    @BindView(R.id.account_settingphone)
    TextView accountSettingphone;

    @Override
    public int getId() {
        return R.layout.activity_account_mag;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.account_iv_back, R.id.account_setingpass, R.id.account_settingphone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account_iv_back:
                finish();
                break;
            case R.id.account_setingpass:
                Intent intent=new Intent(AccountMagActivity.this,GetBackPassActivity.class);
                intent.putExtra("getback","设置新密码");
                startActivity(intent);
                break;
            case R.id.account_settingphone:
              intent(this,ChangPhoneActivity.class);
                break;
        }
    }
}

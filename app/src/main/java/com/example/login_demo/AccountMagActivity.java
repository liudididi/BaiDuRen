package com.example.login_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import bean.MyUserBean;
import bean.UserBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.SPUtils;

public class AccountMagActivity extends BaseActivity {

    @BindView(R.id.account_iv_back)
    ImageView accountIvBack;
    @BindView(R.id.account_tv_phone)
    TextView accountTvPhone;
    @BindView(R.id.account_setingpass)
    TextView accountSetingpass;
    @BindView(R.id.account_settingphone)
    TextView accountSettingphone;
    private  String token;

    @Override
    public int getId() {
        return R.layout.activity_account_mag;
    }

    @Override
    public void InIt() {
        MyUserBean.checkLogin();
        UserBean userBeanInstans = MyUserBean.getUserBeanInstans();
        if(userBeanInstans!=null){
            String mobile = userBeanInstans.getMobile();
            mobile=mobile.substring(0,3)+"****"+mobile.substring(7,11);
            accountTvPhone.setText(mobile);
        }


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

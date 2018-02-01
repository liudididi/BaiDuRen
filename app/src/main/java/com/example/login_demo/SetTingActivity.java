package com.example.login_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.SPUtils;

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
    private  String token;
    private  Intent intent;

    @Override
    public int getId() {
        return R.layout.activity_set_ting;
    }

    @Override
    public void InIt() {
        token = (String) SPUtils.get(MyApp.context, "token", "");
    }

    private Boolean checLogin() {
        if(token.length()<4){
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("该功能需要登录后才能使用")
                    .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            intent=new Intent(SetTingActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return  false;
        }else {
            return true;
        }
    }
    @OnClick({R.id.setting_iv_back, R.id.setting_account, R.id.setting_baiduren, R.id.setting_verson, R.id.setting_useragreen, R.id.setting_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_iv_back:
                finish();
                break;
              //账户管理
            case R.id.setting_account:
                Boolean aBoolean = checLogin();
                if(aBoolean==true){
                   intent=new Intent(this,AccountMagActivity.class);
                    startActivity(intent);
                }
                break;
            //关于摆渡人
            case R.id.setting_baiduren:
                intent=new Intent(this,AsForBaiDuRenActivity.class);
                startActivity(intent);

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
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("您确定要退出登录吗？退出登录后，您将无法使用部分高级功能")
                        .setPositiveButton("确认退出", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SPUtils.remove(MyApp.context,"token");
                                SPUtils.remove(MyApp.context,"tbmaxfen");
                                SPUtils.remove(MyApp.context,"tbarea");
                                SPUtils.remove(MyApp.context,"tbsubtype");
                                finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
}

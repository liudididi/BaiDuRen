package com.example.login_demo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;

import base.BaseActivity;
import bean.MyUserBean;
import bean.UserBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.PermissionUtils;
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
    @BindView(R.id.setting_name)
    TextView settingname;
    @BindView(R.id.setting_school)
    TextView settingschool;
    @BindView(R.id.setting_icon)
    CustomShapeImageView setting_icon;
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

    @Override
    protected void onResume() {
        super.onResume();

        UserBean userBeanInstans = MyUserBean.getUserBeanInstans();
        if(userBeanInstans!=null){
            String sex = userBeanInstans.getSex();
            if(sex!=null){
                if(sex.equals("女")){
                    Glide.with(this).load(R.drawable.gril).into(setting_icon);
                }else {
                    Glide.with(this).load(R.drawable.boy).into(setting_icon);
                }
            }else {
                Glide.with(this).load(R.drawable.boy).into(setting_icon);
            }
            String name = userBeanInstans.getName();
           if(name!=null){
               settingname.setText(name);
           }else {
               settingname.setText("");
           }
            String midSchool = userBeanInstans.getMidSchool();
            if(midSchool!=null){
                settingschool.setText(midSchool);
            }else {
                settingschool.setText("");
            }

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

                PermissionUtils permissionUtils=new PermissionUtils(this);
                boolean b = permissionUtils.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(b){
                    new AlertDialog.Builder(this)
                            .setTitle("版本更新")
                            .setMessage("当前处于流量状态，建议wifi下更新！！！")
                            .setPositiveButton("土豪任性", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    settingVerson.setEnabled(false);
                                    Intent intent=new Intent(SetTingActivity.this,DownApkServer.class);
                                    intent.putExtra("downUrl","http://bdrvip.com:9096/app/bdr_beta_1.0.1.apk");
                                    startService(intent);
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                }else {
                    permissionUtils.requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,10);
                }
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
                                MyUserBean.setUserBean(null);
                                finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
        }
    }
}

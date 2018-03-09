package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import bean.MyUserBean;
import bean.UserBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.ChangePhonePresent;
import untils.SPUtils;
import view.ChangePhoneView;

public class ChangPhoneActivity extends BaseActivity implements ChangePhoneView {

    private static Handler handler = new Handler();
    @BindView(R.id.changephone_tv_countdown)
    TextView changephoneTvCountdown;
    @BindView(R.id.changephone_iv_left)
    ImageView changephoneIvLeft;
    @BindView(R.id.changephone_rv_oldphone)
    RelativeLayout changephoneRvOldphone;
    @BindView(R.id.changephone_rv_newphone)
    RelativeLayout changephoneRvNewphone;
    private int time;
    private Runnable runnable;
    @BindView(R.id.changephone_tv_phone)
    TextView changephoneTvPhone;
    @BindView(R.id.changephone_ed_phone)
    EditText changephoneEdPhone;
    @BindView(R.id.changephone_ed_captcha)
    EditText changephoneEdCaptcha;
    @BindView(R.id.changephone_tv_captcha)
    TextView changephoneTvCaptcha;
    @BindView(R.id.changephone_tv_change)
    TextView changephoneTvChange;
    private ChangePhonePresent changePhonePresent;
    private boolean oldphone = false;
    private UserBean userBeanInstans;
    private  String token;
    private String mobile;

    @Override
    public int getId() {
        return R.layout.activity_chang_phone;
    }

    @Override
    public void InIt() {
        token = (String) SPUtils.get(MyApp.context, "token", "");
        userBeanInstans = MyUserBean.getUserBeanInstans();
        if (userBeanInstans != null) {
            String mobile = userBeanInstans.getMobile();
            mobile=mobile.substring(0,3)+"****"+mobile.substring(7,11);
            changephoneTvPhone.setText(mobile);
        }
        changephoneRvOldphone.setVisibility(View.VISIBLE);
        changephoneRvNewphone.setVisibility(View.GONE);
        changePhonePresent = new ChangePhonePresent(this);
    }

    private void inItRunable() {
        runnable = new Runnable() {
            @Override
            public void run() {
                time--;
                if (time > 0) {
                    handler.postDelayed(this, 1000);
                    changephoneTvCountdown.setText(time + "S后重发");
                }
                if (time == 0) {
                    time = 30;
                    changephoneTvCaptcha.setVisibility(View.VISIBLE);
                    changephoneTvCountdown.setVisibility(View.GONE);
                }
                changephoneTvCountdown.setText(time + "S后重发");
            }
        };
    }


    @OnClick({R.id.changephone_tv_captcha, R.id.changephone_tv_change, R.id.changephone_iv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.changephone_tv_captcha:
                if(oldphone==false){
                    if(userBeanInstans!=null){
                        mobile=userBeanInstans.getMobile();
                    }else {
                        Toast("检查您的网络");
                    }
                }else {
                    mobile = changephoneEdPhone.getText().toString();
                    if (TextUtils.isEmpty(mobile)) {
                        Toast("手机号为空");
                        return;
                    } else if (mobile.length() <= 10) {
                        Toast("手机号格式错误");
                        return;
                    }
                }
                changePhonePresent.mobileUpdateCaptcha(mobile);
                break;
            case R.id.changephone_tv_change:
                if(oldphone==false){
                 changePhonePresent.updateMobileVerifyOld(userBeanInstans.getMobile(),changephoneEdCaptcha.getText().toString(),token);
                }else {
                    changePhonePresent.updateMobile(changephoneEdPhone.getText().toString(),changephoneEdCaptcha.getText().toString(),token);
                }
                break;
            case R.id.changephone_iv_left:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        changePhonePresent.onDestory();
    }

    @Override
    public void getCaptChaSuccess(String msg) {
             Toast(msg);
            time = 30;
            changephoneTvCountdown.setText(time + "S后重发");
            changephoneTvCaptcha.setVisibility(View.GONE);
            changephoneTvCountdown.setVisibility(View.VISIBLE);
            inItRunable();
            handler.postDelayed(runnable, 1000);

    }

    @Override
    public void getCaptChafail(String msg) {
Toast(msg);
    }

    @Override
    public void oldPhonesuccess(String msg) {

            changephoneRvOldphone.setVisibility(View.GONE);
            changephoneRvNewphone.setVisibility(View.VISIBLE);
            oldphone=true;
            changephoneEdCaptcha.setText("");
            time = 30;
            changephoneTvCaptcha.setVisibility(View.VISIBLE);
            changephoneTvCountdown.setVisibility(View.GONE);
            changephoneTvCountdown.setText(time + "S后重发");


    }

    @Override
    public void oldPhonefail(String msg) {
        Toast(msg);
    }

    @Override
    public void newPhonesuccess(String msg) {
            Intent intent=new Intent(ChangPhoneActivity.this,AccountMagActivity.class);
            startActivity(intent);
            finish();
    }

    @Override
    public void newPhonefail(String msg) {
       Toast(msg);
    }



}

package com.example.login_demo;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.GetBackPresent;
import untils.SPUtils;
import view.GetBackView;

/**
 * 找回密码
 */

public class GetBackPassActivity extends BaseActivity implements GetBackView {
    private static Handler handler = new Handler();

    @BindView(R.id.getback_captcha)
    TextView getbackCaptcha;
    @BindView(R.id.getback_Countdown)
    TextView getbackCountdown;
    @BindView(R.id.getback_title)
    TextView getbackTitle;
    private Runnable runnable;
    //左箭头
    @BindView(R.id.getback_iv_left)
    ImageView getbackIvLeft;
    //找回密码的手机号
    @BindView(R.id.getback_phone)
    EditText getbackPhone;
    //找回密码的验证码
    @BindView(R.id.getback_code)
    EditText getbackCode;
    //找回密码的新密码
    @BindView(R.id.getback_pass)
    EditText getbackPass;
    //找回密码的确认
    @BindView(R.id.confirm)
    TextView confirm;
    //闭眼
    @BindView(R.id.getback_iv_close)
    ImageView getback_iv_close;
    //睁眼
    @BindView(R.id.getback_iv_open)
    ImageView getback_iv_open;
    private int time;
    private GetBackPresent getBackPresent;
    private String getbackString;

    @Override
    public int getId() {
        return R.layout.activity_get_back_pass;
    }

    @Override
    public void InIt() {
        inItRunable();
        getbackString = getIntent().getStringExtra("getback");
        getbackTitle.setText(getbackString);
        getBackPresent = new GetBackPresent(this);
    }

    @OnClick({R.id.getback_iv_open, R.id.getback_iv_close, R.id.getback_captcha, R.id.getback_iv_left, R.id.getback_code, R.id.confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.getback_iv_left:
                finish();
                break;
            case R.id.getback_code:
                break;
            case R.id.getback_captcha:
                String mobile = getbackPhone.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    Toast("手机号为空");
                    return;
                } else if (mobile.length()!=11) {
                    Toast("手机号格式错误");
                    return;
                }
                getBackPresent.UpdateCaptcha(mobile);
                break;
            case R.id.confirm:
                mobile = getbackPhone.getText().toString();
                String code = getbackCode.getText().toString();
                String password = getbackPass.getText().toString();

                if (TextUtils.isEmpty(mobile)) {
                    Toast("手机号为空");
                    return;
                }
                if (TextUtils.isEmpty(code)) {
                    Toast("验证码为空");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast("密码为空");
                    return;
                }
                getBackPresent.findPwdByMobile(mobile, code, password);
                break;
            case R.id.getback_iv_close:
                getback_iv_close.setVisibility(View.GONE);
                getback_iv_open.setVisibility(View.VISIBLE);
                getbackPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            case R.id.getback_iv_open:
                getback_iv_close.setVisibility(View.VISIBLE);
                getback_iv_open.setVisibility(View.GONE);
                getbackPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
        }
    }

    private void inItRunable() {
        runnable = new Runnable() {
            @Override
            public void run() {
                time--;
                if (time > 0) {
                    handler.postDelayed(this, 1000);
                    getbackCountdown.setText(time + "S后重发");
                }
                if (time == 0) {
                    time = 30;
                    getbackCaptcha.setVisibility(View.VISIBLE);
                    getbackCountdown.setVisibility(View.GONE);
                    getbackCountdown.setText(time + "S后重发");
                }
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
     getBackPresent.onDestory();
    }

    @Override
    public void getBackSuccess(String msg) {
        Toast(msg);
        if (msg.equals("验证码发送成功")) {
            time = 30;
            getbackCountdown.setText(time + "S后重发");
            getbackCaptcha.setVisibility(View.GONE);
            getbackCountdown.setVisibility(View.VISIBLE);
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    public void getBackfail(String msg) {


    }

    @Override
    public void getBackUpsuccess(String msg) {
        Toast(msg);
        if (msg.equals("找回密码成功")) {
            if( getbackString.equals("找回密码")){
                intent(GetBackPassActivity.this, MainActivity.class);
                SPUtils.put(this, "loginpage", true);
            }
            finish();
        }
    }

    @Override
    public void getBackUpfail(String msg) {

    }


}

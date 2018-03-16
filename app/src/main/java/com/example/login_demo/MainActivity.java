package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

import base.BaseActivity;
import base.BaseBean;
import bean.MyUserBean;
import bean.UserBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.LogInPresenter;
import untils.SPUtils;
import view.LoginView;

public class MainActivity extends BaseActivity implements LoginView {


    @BindView(R.id.tv_pass)
    TextView tvPass;
    @BindView(R.id.phone)
    RelativeLayout phone;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.pass)
    RelativeLayout pass;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.register)
    RelativeLayout register;
    @BindView(R.id.zc)
    TextView zc;

    @BindView(R.id.et_register_pass)
    TextView et_register_pass;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_pass)
    EditText edPass;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.tv_phone_captcha)
    TextView tvPhoneCaptcha;
    @BindView(R.id.ed_mobile)
    EditText edMobile;
    @BindView(R.id.ed_phone_captcha)
    EditText edPhoneCaptcha;

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.iv_open)
    ImageView iv_open;


    @BindView(R.id.tv_Countdown)
    TextView tv_Countdown;


    @BindView(R.id.register_iv_close)
    ImageView register_iv_close;
    @BindView(R.id.register_iv_open)
    ImageView register_iv_open;
    @BindView(R.id.zc_captcha)
    TextView zcCaptcha;
    @BindView(R.id.zc_Countdown)
    TextView zcCountdown;
    @BindView(R.id.zc_ed_phone)
    TextView zcEdphone;

    @BindView(R.id.zc_ed_captcha)
    EditText zcEdcaptcha;
    @BindView(R.id.zc_register)
    TextView zcRegister;



    private LogInPresenter logInPresenter;
    private String mobile;
    private   Boolean flag;
    private int time = 30;  //初始化时间
    private static Handler handler = new Handler();
    private Runnable runnable;

    @Override
    public int getId() {
        return R.layout.activity_main;
    }

    @Override
    public void InIt() {
        Boolean loginpage = (Boolean) SPUtils.get(MyApp.context, "loginpage", false);
        if(loginpage==true){
            pass.setVisibility(View.VISIBLE);
            phone.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            zc.setVisibility(View.GONE);
        }
      /*  edMobile.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               Toast(edMobile.getText().toString());
                return false;
            }
        });*/
        logInPresenter = new LogInPresenter(this);
        inItRunable();
    }

    private void inItRunable() {
        runnable = new Runnable() {
            @Override
            public void run() {
                time--;
                if (time > 0) {
                    handler.postDelayed(this, 1000);
                    if(flag==true){
                        tv_Countdown.setText(time + "S后重发");
                    }else {
                        zcCountdown.setText(time + "S后重发");
                    }
                }
                if (time == 0) {
                    time = 30;
                    if(flag==true){
                        tvPhoneCaptcha.setVisibility(View.VISIBLE);
                        tv_Countdown.setVisibility(View.GONE);
                        tv_Countdown.setText(time + "S后重发");
                    }else {
                        zcCountdown.setVisibility(View.GONE);
                        zcCaptcha.setVisibility(View.VISIBLE);
                        zcCountdown.setText(time + "S后重发");
                    }
                }
            }
        };

    }

    @OnClick({R.id.tv_pass,
            R.id.zc_register,
            R.id.zc_captcha, R.id.login, R.id.register_iv_close, R.id.register_iv_open, R.id.iv_close, R.id.iv_open, R.id.tv_phone_captcha, R.id.phone, R.id.tv_login, R.id.pass, R.id.iv_left, R.id.tv_register, R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_iv_close:
                register_iv_close.setVisibility(View.GONE);
                register_iv_open.setVisibility(View.VISIBLE);
                et_register_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            case R.id.zc_register:
                String zcedPhone = zcEdphone.getText().toString();
                String zcedcaptcha = zcEdcaptcha.getText().toString();
                String zcedpassword =et_register_pass.getText().toString();
                if(TextUtils.isEmpty(zcedPhone)){
                    Toast("手机号为空");
                    return;
                }
                if(TextUtils.isEmpty(zcedcaptcha)){
                    Toast("验证码为空");
                    return;
                }
                if(TextUtils.isEmpty(zcedpassword)){
                    Toast("密码为空");
                    return;
                }
                logInPresenter.Register(zcedPhone,zcedpassword,zcedcaptcha);
                break;
            case R.id.zc_captcha:
                mobile = zcEdphone.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    Toast("手机号为空");
                    return;
                } else if (mobile.length() <= 10) {
                    Toast("手机号格式错误");
                    return;
                }
                flag=false;
                logInPresenter.RegisterCaptcha(mobile);
                break;
            case R.id.login:
                mobile = edMobile.getText().toString();
                String edPcaptcha = edPhoneCaptcha.getText().toString();
                if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(edPcaptcha)) {
                    Toast("手机号或验证码为空");
                    return;
                } else if (mobile.length() <= 10) {
                    Toast("手机号格式错误");
                    return;
                }
                logInPresenter.phoneLogin(mobile, edPcaptcha);
                break;
            case R.id.register_iv_open:
                register_iv_close.setVisibility(View.VISIBLE);
                register_iv_open.setVisibility(View.GONE);
                et_register_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            case R.id.iv_close:
                iv_close.setVisibility(View.GONE);
                iv_open.setVisibility(View.VISIBLE);
                edPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                break;
            case R.id.iv_open:
                iv_close.setVisibility(View.VISIBLE);
                iv_open.setVisibility(View.GONE);
                edPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                break;
            case R.id.tv_pass:
                pass.setVisibility(View.VISIBLE);
                phone.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                zc.setVisibility(View.GONE);
                break;
            case R.id.phone:
                break;
            case R.id.tv_phone_captcha:
                mobile = edMobile.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    Toast("手机号为空");
                    return;
                } else if (mobile.length() <= 10) {
                    Toast("手机号格式错误");
                    return;
                }
                logInPresenter.LogCaptcha(mobile);
                flag=true;
                break;
            case R.id.tv_forget:

                Intent intent=new Intent(MainActivity.this, GetBackPassActivity.class);
                intent.putExtra("getback","找回密码");
                startActivity(intent);

                finish();
                break;
            case R.id.tv_login:
                String edphone = edPhone.getText().toString();
                String edpass = edPass.getText().toString();
                if (TextUtils.isEmpty(edphone) || TextUtils.isEmpty(edpass)) {
                    Toast("手机或密码为空");
                    return;
                }
                logInPresenter.Login(edphone,edpass);
                break;
            case R.id.pass:
                break;
            case R.id.iv_left:
                finish();
                break;
            case R.id.tv_register:
                pass.setVisibility(View.GONE);
                this.phone.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);
                zc.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void loginsuccess(String msg, BaseBean<UserBean> baseBean) {
        Toast(msg);

            SPUtils.put(MyApp.context,"token",baseBean.token);
            intent(MainActivity.this, HomeActivity.class);
            finish();


    }

    @Override

    public void loginfail(String msg) {
        Toast(msg);
    }

    /**
     * 验证码获取成功
     * @param msg
     */
    @Override
    public void CaptChasuccess(String msg) {
           Toast(msg);
            time = 30;
            inItRunable();
            if(flag==true){
                tvPhoneCaptcha.setVisibility(View.GONE);
                tv_Countdown.setVisibility(View.VISIBLE);
                tv_Countdown.setText(time + "S后重发");
            }else {
                zcCountdown.setText(time + "S后重发");
                zcCaptcha.setVisibility(View.GONE);
                zcCountdown.setVisibility(View.VISIBLE);
            }
            handler.postDelayed(runnable, 1000);


    }
    /**
     * 验证码获取失败
     * @param msg
     */
    @Override
    public void CaptChaFail(String msg) {
        Toast(msg);
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
        logInPresenter.onDestory();
        SPUtils.remove(MyApp.context,"loginpage");
    }



}

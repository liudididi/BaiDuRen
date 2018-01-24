package com.example.login_demo;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.ChangePhonePresent;
import view.ChangePhoneView;

public class ChangPhoneActivity extends BaseActivity implements ChangePhoneView {

    private static Handler handler = new Handler();
    @BindView(R.id.changephone_tv_countdown)
    TextView changephoneTvCountdown;
    @BindView(R.id.changephone_iv_left)
    ImageView changephoneIvLeft;
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

    @Override
    public int getId() {
        return R.layout.activity_chang_phone;
    }

    @Override
    public void InIt() {
        inItRunable();
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


    @OnClick({R.id.changephone_tv_captcha, R.id.changephone_tv_change,R.id.changephone_iv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.changephone_tv_captcha:
                String mobile = changephoneEdPhone.getText().toString();
                if (TextUtils.isEmpty(mobile)) {
                    Toast("手机号为空");
                    return;
                } else if (mobile.length() <= 10) {
                    Toast("手机号格式错误");
                    return;
                }
                changePhonePresent.mobileUpdateCaptcha(mobile);
                break;
            case R.id.changephone_tv_change:


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
        if (msg.equals("success")) {
            time = 30;
            changephoneTvCountdown.setText(time + "S后重发");
            changephoneTvCaptcha.setVisibility(View.GONE);
            changephoneTvCountdown.setVisibility(View.VISIBLE);
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override
    public void getCaptChafail(String msg) {
        Toast(msg);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

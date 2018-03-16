package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EvaluatingActivity extends BaseActivity {
    @BindView(R.id.evaluating_iv_back)
    ImageView evaluatingIvBack;
    @BindView(R.id.evaluating_tv)
    TextView evaluatingTv;

    @Override
    public int getId() {
        return R.layout.activity_evaluating;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.evaluating_iv_back, R.id.evaluating_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.evaluating_iv_back:
                finish();
                break;
            case R.id.evaluating_tv:
                intent(this,ComlitEFCActivity.class);
                break;
        }
    }
}

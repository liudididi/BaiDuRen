package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JJParticularsActivity extends BaseActivity {

    @BindView(R.id.jj_iv_back)
    ImageView jjIvBack;
    @BindView(R.id.tv_jj)
    TextView tvJj;
    @BindView(R.id.school_tv_count)
    TextView school_tv_count;
    @Override
    public int getId() {
        return R.layout.activity_jjparticulars;
    }

    @Override
    public void InIt() {
        String school_title = getIntent().getStringExtra("school_title");
        String history = getIntent().getStringExtra("history");
        tvJj.setText(school_title);
        if(history!=null)
        {
            school_tv_count.setText(history);
        }
        else
        {
            school_tv_count.setText("暂无数据");
        }

    }



    @OnClick({R.id.jj_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.jj_iv_back:
                finish();
                break;

        }
    }
}

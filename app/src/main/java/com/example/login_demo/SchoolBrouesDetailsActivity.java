package com.example.login_demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolBrouesDetailsActivity extends BaseActivity {


    @BindView(R.id.school_iv_back)
    ImageView schoolIvBack;
    @BindView(R.id.tv_cont)
    TextView tvCont;
    @BindView(R.id.tv_title)
    TextView tv_title;
    private String substring;


    @Override
    public int getId() {
        return R.layout.activity_school_broues_details;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void InIt() {

        Intent intent = getIntent();

        final String admissionRules = intent.getStringExtra("count");
        String tltle1 = intent.getStringExtra("tltle1");
        tv_title.setText(tltle1);
        if(admissionRules.equals(""))
        {
            tvCont.setText("暂无信息");
            return;
        }
        tvCont.setText(admissionRules);
        if(admissionRules!=null)
        {
            substring = admissionRules.substring(0, 4);
        }
        if(substring.equals("http"))
        {
            tvCont.setTextColor(R.color.red);
            tvCont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1=new Intent(SchoolBrouesDetailsActivity.this,WVActivity.class);
                    intent1.putExtra("url",admissionRules);
                    startActivity(intent1);
                }
            });
        }
    }


    @OnClick(R.id.school_iv_back)
    public void onViewClicked() {
        finish();
    }


}

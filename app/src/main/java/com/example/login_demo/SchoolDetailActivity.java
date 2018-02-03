package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.meg7.widget.CustomShapeImageView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SchoolDetailActivity extends BaseActivity {

    @BindView(R.id.schoold_name)
    TextView schooldName;
    @BindView(R.id.school_icon)
    CustomShapeImageView schoolIcon;
    @BindView(R.id.schoold_iv_back)
    ImageView schooldIvBack;
    @BindView(R.id.schoold_address)
    TextView schooldAddress;
    @BindView(R.id.schoold_two)
    TextView schooldTwo;
    @BindView(R.id.schoold_nine)
    TextView schooldNine;
    @BindView(R.id.schoold_yjs)
    TextView schooldYjs;
    @BindView(R.id.schoold_gfs)
    TextView schooldGfs;
    @BindView(R.id.schoold_zyjh)
    TextView schooldZyjh;
    @BindView(R.id.schoold_zhpj)
    TextView schooldZhpj;
    @BindView(R.id.schoold_lq)
    TextView schooldLq;
    @BindView(R.id.schoold_jj)
    TextView schooldJj;
    @BindView(R.id.schoold_zsjz)
    TextView schooldZsjz;
    @BindView(R.id.school_fl)
    FrameLayout schoolFl;

    @Override
    public int getId() {
        return R.layout.activity_school_detail;
    }

    @Override
    public void InIt() {

        String schoolname = getIntent().getStringExtra("schoolname");
        schooldName.setText(schoolname);

    }




    @OnClick({R.id.schoold_iv_back, R.id.schoold_lq, R.id.schoold_jj, R.id.schoold_zsjz})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.schoold_iv_back:
                finish();
                break;
            case R.id.schoold_lq:
                schooldLq.setTextColor(Color.WHITE);
                schooldLq.setBackgroundResource(R.drawable.back_schooldlan);


                schooldJj.setTextColor(Color.BLACK);
                schooldJj.setBackgroundResource(R.drawable.back_schoold);

                schooldZsjz.setTextColor(Color.BLACK);
                schooldZsjz.setBackgroundResource(R.drawable.back_schoold);



                break;
            case R.id.schoold_jj:

                schooldLq.setTextColor(Color.BLACK);
                schooldLq.setBackgroundResource(R.drawable.back_schoold);


                schooldJj.setTextColor(Color.WHITE);
                schooldJj.setBackgroundResource(R.drawable.back_schooldlan);

                schooldZsjz.setTextColor(Color.BLACK);
                schooldZsjz.setBackgroundResource(R.drawable.back_schoold);



                break;
            case R.id.schoold_zsjz:



                schooldLq.setTextColor(Color.BLACK);
                schooldLq.setBackgroundResource(R.drawable.back_schoold);


                schooldJj.setTextColor(Color.BLACK);
                schooldJj.setBackgroundResource(R.drawable.back_schoold);

                schooldZsjz.setTextColor(Color.WHITE);
                schooldZsjz.setBackgroundResource(R.drawable.back_schooldlan);
                break;
        }
    }
}

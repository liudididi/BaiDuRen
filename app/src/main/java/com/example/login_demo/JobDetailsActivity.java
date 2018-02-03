package com.example.login_demo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JobDetailsActivity extends BaseActivity {

    @BindView(R.id.jobd_tvjob)
    TextView jobdTvjob;
    @BindView(R.id.jobd_tvxq)
    TextView jobdTvxq;
    @BindView(R.id.jobd_tvpx)
    TextView jobdTvpx;
    @BindView(R.id.jobd_tvzpjy)
    TextView jobdTvzpjy;
    @BindView(R.id.jobd_iv_back)
    ImageView jobdIvBack;

    @Override
    public int getId() {
        return R.layout.activity_job_details;
    }

    @Override
    public void InIt() {
        String jobname = getIntent().getStringExtra("jobname");

        jobdTvjob.setText(jobname);

    }




    @OnClick(R.id.jobd_iv_back)
    public void onViewClicked() {

        finish();
    }
}

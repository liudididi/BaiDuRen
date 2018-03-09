package com.example.login_demo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import base.BaseActivity;
import bean.JobInforBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.GetJobinfoPresent;
import view.GetJobinfoView;

public class JobDetailsActivity extends BaseActivity implements GetJobinfoView {

    @BindView(R.id.jobd_tvjob)
    TextView jobdTvjob;
    @BindView(R.id.jobd_tvxq)
    TextView jobdTvxq;
   /* @BindView(R.id.jobd_tvpx)
    TextView jobdTvpx;
    @BindView(R.id.jobd_tvzpjy)
    TextView jobdTvzpjy;*/
    @BindView(R.id.jobd_iv_back)
    ImageView jobdIvBack;
    private GetJobinfoPresent getJobinfoPresent;

    @Override
    public int getId() {
        return R.layout.activity_job_details;
    }

    @Override
    public void InIt() {
        String jobname = getIntent().getStringExtra("jobname");

        jobdTvjob.setText(jobname);

        getJobinfoPresent = new GetJobinfoPresent(this);
        getJobinfoPresent.getJobInfo(jobname);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getJobinfoPresent.onDestory();
    }

    @OnClick(R.id.jobd_iv_back)
    public void onViewClicked() {

        finish();
    }

    @Override
    public void GetJobinfoSuccess(List<JobInforBean> list) {
        if(list!=null&&list.size()>0){
            JobInforBean jobInforBean = list.get(0);
            if(jobInforBean.getJobInfo().equals(""))
            {
                jobdTvxq.setText("暂无数据");
                return;
            }
            jobdTvxq.setText(jobInforBean.getJobInfo());
           /* jobdTvpx.setText(jobInforBean.getJobEducation());
            jobdTvzpjy.setText(jobInforBean.getJobRequirement());*/
        }
    }

    @Override
    public void GetJobinfoFail(String msg) {

    }
}

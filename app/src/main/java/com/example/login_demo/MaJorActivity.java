package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import adapter.MyMajorlRecycle;
import base.BaseActivity;
import bean.MajorBean;
import bean.SchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.MySchoolPresent;
import view.MySchoolView;

public class MaJorActivity extends BaseActivity implements  MySchoolView {
    @BindView(R.id.major_iv_back)
    ImageView majorIvBack;
    @BindView(R.id.major_xrecycle)
    XRecyclerView majorXrecycle;
    @BindView(R.id.major_hint)
    TextView majorHint;
    @BindView(R.id.major_see)
    TextView majorSee;
    @BindView(R.id.major_re)
    RelativeLayout  majorre;
    private MySchoolPresent mySchoolPresent;
    private String token;

    @Override
    public int getId() {
        return R.layout.activity_ma_jor;
    }

    @Override
    public void InIt() {
        token = getIntent().getStringExtra("token");
        mySchoolPresent = new MySchoolPresent(this);
        majorXrecycle.setVisibility(View.GONE);
        majorXrecycle.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        mySchoolPresent.getmajorCollection(token);
    }

    @OnClick({R.id.major_iv_back, R.id.major_see})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.major_iv_back:
                finish();
                break;
            case R.id.major_see:
                intent(this,MoreMajorActivity.class);
                break;
        }
    }

    @Override
    public void getSchoolsuccess(List<SchoolBean> list, String msg) {

    }

    @Override
    public void getSchoolfail(String msg) {

    }

    @Override
    public void getMajorsuccess(List<MajorBean> list, String msg) {
      if(list!=null&&list.size()>0){
          majorre.setVisibility(View.GONE);
          majorXrecycle.setVisibility(View.VISIBLE);
          MyMajorlRecycle adpter=new MyMajorlRecycle(this,list);
          majorXrecycle.setAdapter(adpter);
      }else {
          majorre.setVisibility(View.VISIBLE);
          majorXrecycle.setVisibility(View.GONE);
      }
    }

    @Override
    public void getMajorfail(String msg) {
        mySchoolPresent.getmajorCollection(token);
    }
}

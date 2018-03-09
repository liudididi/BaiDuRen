package com.example.login_demo;


import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import adapter.MySchoolRecycle;
import base.BaseActivity;
import bean.MajorBean;
import bean.SchoolBean;
import butterknife.BindView;

import butterknife.OnClick;
import presenter.MySchoolPresent;

import view.MySchoolView;

public class MySchoolActivity extends BaseActivity implements MySchoolView, XRecyclerView.LoadingListener {
    @BindView(R.id.myschool_iv_back)
    ImageView myschoolIvBack;
    @BindView(R.id.myschool_hint)
    TextView myschoolHint;
    @BindView(R.id.myschool_see)
    TextView myschoolSee;
    @BindView(R.id.myschool_xrecycle)
    XRecyclerView myschoolXrecycle;
    @BindView(R.id.myschool_re)
    RelativeLayout  myschoolre;
    private MySchoolPresent mySchoolPresent;
    private MySchoolRecycle mySchoolAdapter;
    private String token;

    @Override
    public int getId() {
        return R.layout.activity_my_school;
    }

    @Override
    public void InIt() {
        myschoolXrecycle.setVisibility(View.GONE);
        token = getIntent().getStringExtra("token");
        mySchoolPresent = new MySchoolPresent(this);

        //设置布局管理器
        myschoolXrecycle.setLayoutManager(new LinearLayoutManager(this));
        myschoolXrecycle.setRefreshProgressStyle(16);
        myschoolXrecycle.setLoadingListener(this);
        myschoolXrecycle.setLoadingMoreEnabled(false);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mySchoolPresent.getSchollCollection(token);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mySchoolPresent.onDestory();
    }

    @OnClick({R.id.myschool_iv_back, R.id.myschool_see})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myschool_iv_back:
                finish();
                break;
            case R.id.myschool_see:
                intent(this,MoreSchoolActivity.class);
                finish();
                break;
        }
    }

    @Override
    public void getSchoolsuccess(List<SchoolBean> list, String msg) {
        if(list!=null&&list.size()>=1){
         myschoolre.setVisibility(View.GONE);
         myschoolXrecycle.setVisibility(View.VISIBLE);
            if(mySchoolAdapter==null){
                mySchoolAdapter = new MySchoolRecycle(this,list);
                myschoolXrecycle.setAdapter(mySchoolAdapter);
            }else {
                mySchoolAdapter.Reftch(list);
            }
        }else {
            //布局初始化
            myschoolre.setVisibility(View.VISIBLE);
            myschoolXrecycle.setVisibility(View.GONE);
        }
    }

    @Override
    public void getSchoolfail(String msg) {
        mySchoolPresent.getSchollCollection(token);
    }

    @Override
    public void getMajorsuccess(List<MajorBean> list, String msg) {

    }

    @Override
    public void getMajorfail(String msg) {

    }

    @Override
    public void onRefresh() {
       Handler handler=new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               mySchoolPresent.getSchollCollection(token);
               myschoolXrecycle.refreshComplete();
           }
       }, 1000);

    }

    @Override
    public void onLoadMore() {


    }
}

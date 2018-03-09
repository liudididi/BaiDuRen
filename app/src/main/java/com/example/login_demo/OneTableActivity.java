package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.OneTableAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.OneTableBean;

import butterknife.BindView;

import butterknife.OnClick;
import presenter.OneTablePresent;
import untils.SPUtils;
import view.OneTableView;

public class OneTableActivity extends BaseActivity implements OneTableView{


    @BindView(R.id.onetable_iv_back)
    ImageView onetableIvBack;
    @BindView(R.id.onetable_iv)
    ImageView onetable_iv;
    @BindView(R.id.onetable_tv_arts)
    TextView onetableTvArts;
    @BindView(R.id.view_arts)
    View viewArts;
    @BindView(R.id.onetable_tv_science)
    TextView onetableTvScience;
    @BindView(R.id.view_science)
    View viewScience;

    @BindView(R.id.onetable_rl_arts)
    RelativeLayout onetable_rl_arts;
    @BindView(R.id.onetable_rl_science)
    RelativeLayout onetable_rl_science;
    @BindView(R.id.onetable_rv)
    RecyclerView onetable_rv;
    @BindView(R.id.pb)
    ProgressBar pb;
    private String tbarea;
    public static  String s="文科";
    private OneTablePresent oneTablePresent;
    private List<OneTableBean> data=new ArrayList<>();

    @Override
    public int getId() {
        return R.layout.activity_one_table;
    }

    @Override
    public void InIt() {
        onetableTvArts.setTextColor(Color.BLACK);
        oneTablePresent = new OneTablePresent(this);
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "北京市");

        oneTablePresent.OneTablePresent("文科",tbarea);
    }




    @OnClick({R.id.onetable_rl_arts,R.id.onetable_rl_science,R.id.onetable_iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.onetable_iv_back:
                finish();
                break;
            case R.id.onetable_rl_arts:
                onetableTvArts.setTextColor(Color.BLACK);
                onetableTvScience.setTextColor(Color.GRAY);
                viewArts.setVisibility(View.VISIBLE);
                viewScience.setVisibility(View.GONE);
                s="文科";

                data.clear();
                oneTablePresent.OneTablePresent("文科",tbarea);
                break;
            case R.id.onetable_rl_science:
                onetableTvArts.setTextColor(Color.GRAY);
                onetableTvScience.setTextColor(Color.BLACK);
                viewArts.setVisibility(View.GONE);
                viewScience.setVisibility(View.VISIBLE);
                s="理科";
                data.clear();
                oneTablePresent.OneTablePresent("理科",tbarea);
                break;
        }
    }

    //一分一段表
    @Override
    public void OneTablesuccess(BaseBean<List<OneTableBean>> listBaseBean) {
        onetable_rv.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
        data = listBaseBean.data;

        if(data!=null&&data.size()>0)
        {
            OneTableAdapter oneTableAdapter=new OneTableAdapter(data,OneTableActivity.this);
            onetable_rv.setLayoutManager(new LinearLayoutManager(OneTableActivity.this));
            onetable_rv.setAdapter(oneTableAdapter);
        }
        else
        {
            onetable_iv.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void OneTablefail(Throwable t) {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        oneTablePresent.onDestory();

    }
}

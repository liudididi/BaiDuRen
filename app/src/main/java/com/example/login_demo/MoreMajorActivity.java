package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.List;

import adapter.SimpleExpandableListViewAdapter;
import base.BaseActivity;
import bean.SelectMajorBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.SelectMajorPresent;
import view.SelectMajorView;

public class MoreMajorActivity extends BaseActivity implements SelectMajorView {

    @BindView(R.id.mschool_iv_back)
    ImageView mschoolIvBack;
    @BindView(R.id.mmajor_tvben)
    RelativeLayout mmajorTvben;
    @BindView(R.id.mmajor_tvzhuan)
    RelativeLayout mmajorTvzhuan;
    @BindView(R.id.mmajor_vzhuan)
    View mmajorVzhuan;
    @BindView(R.id.mmajor_vben)
    View mmajorVben;
    @BindView(R.id.tree_view_simple)
    ExpandableListView treeViewSimple;
    @BindView(R.id.mmajor_pb)
    ProgressBar mmajorPb;
    @BindView(R.id.tree_view_zhuan)
    ExpandableListView treeViewZhuan;
    private int zb = 0;


    private   Boolean ben=false;
    private  Boolean zhuan=false;


    private SelectMajorPresent selectMajorPresent;
    private SimpleExpandableListViewAdapter adapter;

    @Override
    public int getId() {
        return R.layout.activity_more_major;
    }

    @Override
    public void InIt() {
        selectMajorPresent = new SelectMajorPresent(this);
        selectMajorPresent.selectAllMajor("0");

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        selectMajorPresent.onDestory();


    }

    @Override
    public void SelectMajorSuccess(List<SelectMajorBean> list) {
        mmajorPb.setVisibility(View.GONE);
        if(zb==0){
            ben=true;
            treeViewSimple.setVisibility(View.VISIBLE);
            treeViewZhuan.setVisibility(View.GONE);
            adapter = new SimpleExpandableListViewAdapter(list, this);
            treeViewSimple.setAdapter(adapter);
        }else {
            zhuan=true;
            treeViewSimple.setVisibility(View.GONE);
            treeViewZhuan.setVisibility(View.VISIBLE);
            SimpleExpandableListViewAdapter  adapter = new SimpleExpandableListViewAdapter(list, this);
            treeViewZhuan.setAdapter(adapter);
        }

        // 设置适配器


    }

    @Override
    public void SelectMajorFail(String msg) {
        if (zb == 0) {
            selectMajorPresent.selectAllMajor("0");
        } else {
            selectMajorPresent.selectAllMajor("1");
        }

    }


    @OnClick({R.id.mschool_iv_back, R.id.mmajor_tvben, R.id.mmajor_tvzhuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mschool_iv_back:
                finish();
                break;
            case R.id.mmajor_tvben:
                mmajorVben.setVisibility(View.VISIBLE);
                mmajorVzhuan.setVisibility(View.GONE);
                if(ben){
                    treeViewZhuan.setVisibility(View.GONE);
                    treeViewSimple.setVisibility(View.VISIBLE);
                    return;
                }
                if (zb == 1) {
                    mmajorPb.setVisibility(View.VISIBLE);
                    selectMajorPresent.selectAllMajor("0");
                }
                zb = 0;
                break;
            case R.id.mmajor_tvzhuan:
                mmajorVben.setVisibility(View.GONE);
                mmajorVzhuan.setVisibility(View.VISIBLE);
                if(zhuan){
                    treeViewZhuan.setVisibility(View.VISIBLE);
                    treeViewSimple.setVisibility(View.GONE);
                    return;
                }
                if (zb == 0) {
                    mmajorPb.setVisibility(View.VISIBLE);
                    selectMajorPresent.selectAllMajor("1");
                }
                zb = 1;
                break;
        }
    }



}

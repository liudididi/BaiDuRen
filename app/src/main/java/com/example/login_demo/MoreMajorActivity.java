package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    public void SelectMajorSuccess(List<SelectMajorBean> list) {
        mmajorPb.setVisibility(View.GONE);
        if (adapter == null) {
            adapter = new SimpleExpandableListViewAdapter(list, this);
            treeViewSimple.setAdapter(adapter);
        } else {
            adapter.Refresh(list);
        }
        // 设置适配器


    }

    @Override
    public void SelectMajorFail(String msg) {

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
                mmajorPb.setVisibility(View.VISIBLE);
                selectMajorPresent.selectAllMajor("0");
                break;
            case R.id.mmajor_tvzhuan:
                mmajorVben.setVisibility(View.GONE);
                mmajorVzhuan.setVisibility(View.VISIBLE);
                mmajorPb.setVisibility(View.VISIBLE);
                selectMajorPresent.selectAllMajor("1");
                break;
        }
    }


}

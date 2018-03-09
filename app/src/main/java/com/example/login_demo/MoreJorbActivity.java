package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import adapter.MoreJobExpandableListViewAdapter;
import adapter.SimpleExpandableListViewAdapter;
import base.BaseActivity;
import bean.MoreJobBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.MoreJobPresent;
import view.MorJobView;

public class MoreJorbActivity extends BaseActivity  implements MorJobView {


    @BindView(R.id.mschool_iv_back)
    ImageView mschoolIvBack;
    @BindView(R.id.tree_view_simple)
    ExpandableListView treeViewSimple;

    @BindView(R.id.morjob_pb)
    ProgressBar mojob_pb;
    private MoreJobPresent moreJobPresent;
    private MoreJobExpandableListViewAdapter adapter;

    @Override
    public int getId() {
        return R.layout.activity_more_jorb;
    }

    @Override
    public void InIt() {
        moreJobPresent = new MoreJobPresent(this);
        moreJobPresent.selectAllJob();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moreJobPresent.onDestory();

    }

    @OnClick(R.id.mschool_iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void MorJobSuccess(List<MoreJobBean> list) {
        mojob_pb.setVisibility(View.GONE);
        if (adapter == null) {
            adapter = new MoreJobExpandableListViewAdapter(list,this);
            treeViewSimple.setAdapter(adapter);
        } else {
            adapter.Refresh(list);
        }
    }

    @Override
    public void MorJobFail(String msg) {
        moreJobPresent.selectAllJob();
    }
}

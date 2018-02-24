package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.List;

import adapter.HelpAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.HelpBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.HelpPresenter;
import view.HelpView;

public class AsForBaiDuRenActivity extends BaseActivity implements HelpView {


    @BindView(R.id.asfor_rv)
    RecyclerView asfor_rv;
    @BindView(R.id.asfor_iv_back)
    ImageView asforIvBack;
    private HelpPresenter helpPresenter;

    @Override
    public int getId() {
        return R.layout.activity_as_for_bai_du_ren;
    }

    @Override
    public void InIt() {

        helpPresenter = new HelpPresenter(this);
        helpPresenter.HelpPresenter("0", "1");
    }


    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        asfor_rv.setLayoutManager(new LinearLayoutManager(AsForBaiDuRenActivity.this));
        asfor_rv.setAdapter(new HelpAdapter(data, AsForBaiDuRenActivity.this));
    }

    @Override
    public void Helpfail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helpPresenter.onDestory();
    }



    @OnClick(R.id.asfor_iv_back)
    public void onViewClicked() {
        finish();
    }
}

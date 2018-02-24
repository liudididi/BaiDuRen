package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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

public class AddServeActivity extends BaseActivity implements HelpView{


    @BindView(R.id.addserve_iv_back)
    ImageView addserveIvBack;
    @BindView(R.id.add_rv)
    RecyclerView add_rv;

    private HelpPresenter helpPresenter;
    @Override
    public int getId() {
        return R.layout.activity_add_serve;
    }

    @Override
    public void InIt() {
        helpPresenter = new HelpPresenter(this);
        helpPresenter.HelpPresenter("0","4");
    }




    @OnClick({R.id.addserve_iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addserve_iv_back:
                finish();
                break;

        }
    }

    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        add_rv.setLayoutManager(new LinearLayoutManager(AddServeActivity.this));
        add_rv.setAdapter(new HelpAdapter(data,AddServeActivity.this));
    }

    @Override
    public void Helpfail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helpPresenter.onDestory();
    }
}

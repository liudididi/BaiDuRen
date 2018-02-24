package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import adapter.HelpAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.HelpBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import presenter.HelpPresenter;
import view.HelpView;

public class UserAgreenActivity extends BaseActivity implements HelpView {


    @BindView(R.id.user_rv)
    RecyclerView userRv;
    private HelpPresenter helpPresenter;

    @Override
    public int getId() {
        return R.layout.activity_user_agreen;
    }

    @Override
    public void InIt() {
        ImageView back = findViewById(R.id.useragreen_iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        helpPresenter = new HelpPresenter(this);
        helpPresenter.HelpPresenter("0", "5");
    }

    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        userRv.setLayoutManager(new LinearLayoutManager(UserAgreenActivity.this));
        userRv.setAdapter(new HelpAdapter(data,UserAgreenActivity.this));
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

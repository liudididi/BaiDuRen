package com.example.login_demo;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.weavey.loading.lib.LoadingLayout;

import java.util.List;

import adapter.HelpAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.HelpBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.HelpPresenter;
import untils.NetCheck;
import view.HelpView;

public class AsForBaiDuRenActivity extends BaseActivity implements HelpView {


    @BindView(R.id.asfor_rv)
    RecyclerView asfor_rv;
    @BindView(R.id.asfor_iv_back)
    ImageView asforIvBack;
    @BindView(R.id.lodiing)
    LoadingLayout lodiing;
    private HelpPresenter helpPresenter;
    private ConnectionChangeReceiver myReceiver;
    @Override
    public int getId() {
        return R.layout.activity_as_for_bai_du_ren;
    }

    @Override
    public void InIt() {
        loadingLayout=lodiing;
        registerReceiver();
        helpPresenter = new HelpPresenter(this);
        if(!NetCheck.isNetConnected(this)) {
            loadingLayout.setStatus(LoadingLayout.No_Network);
            return;
        }
        helpPresenter.HelpPresenter("0", "1");
    }


    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;

        if (data != null || data.size() > 0) {
            loadingLayout.setStatus(LoadingLayout.Success);
            asfor_rv.setLayoutManager(new LinearLayoutManager(AsForBaiDuRenActivity.this));
            asfor_rv.setAdapter(new HelpAdapter(data, AsForBaiDuRenActivity.this));
        }

    }

    @Override
    public void Helpfail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helpPresenter.onDestory();
        unregisterReceiver();
    }


    @OnClick(R.id.asfor_iv_back)
    public void onViewClicked() {
        finish();
    }


    public void registerReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //设置网络状态提示布局的状态
//无网的时候，无网提示的展示View展示出来
//重新联接上网络时，自动加载数据
//这个是onresume中实现了数据的刷新，即是，网络连接后，重新拉取数据
        myReceiver = new ConnectionChangeReceiver() {
            @Override
            public void changeNetStatus(boolean flag) {
                //设置网络状态提示布局的状态
                if (flag) {
                    loadingLayout.setStatus(LoadingLayout.No_Network);
                    asfor_rv.setVisibility(View.GONE);
                } else {
                    //有网
                    asfor_rv.setVisibility(View.VISIBLE);
                    helpPresenter.HelpPresenter("0", "1");
                }
            }
        };
        this.registerReceiver(myReceiver, filter);
    }

    public void unregisterReceiver() {
        if (myReceiver != null) {
            this.unregisterReceiver(myReceiver);
        }
    }


}

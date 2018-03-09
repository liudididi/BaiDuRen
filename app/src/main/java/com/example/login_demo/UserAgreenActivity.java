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
import presenter.HelpPresenter;
import untils.NetCheck;
import view.HelpView;

public class UserAgreenActivity extends BaseActivity implements HelpView {


    @BindView(R.id.user_rv)
    RecyclerView userRv;
    @BindView(R.id.lodiing)
    LoadingLayout lodiing;
    private HelpPresenter helpPresenter;
    private ConnectionChangeReceiver myReceiver;
    @Override
    public int getId() {
        return R.layout.activity_user_agreen;
    }

    @Override
    public void InIt() {
        loadingLayout=lodiing;
        registerReceiver();
        ImageView back = findViewById(R.id.useragreen_iv_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        helpPresenter = new HelpPresenter(this);
        if(!NetCheck.isNetConnected(this)) {
            loadingLayout.setStatus(LoadingLayout.No_Network);
            return;
        }
        helpPresenter.HelpPresenter("0", "5");
    }

    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        userRv.setLayoutManager(new LinearLayoutManager(UserAgreenActivity.this));
        userRv.setAdapter(new HelpAdapter(data, UserAgreenActivity.this));
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

                } else {
                    //有网
                    helpPresenter.HelpPresenter("0", "5");
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

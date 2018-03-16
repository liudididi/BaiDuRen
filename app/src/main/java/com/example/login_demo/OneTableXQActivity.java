package com.example.login_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.weavey.loading.lib.LoadingLayout;

import java.util.List;

import base.BaseActivity;
import base.BaseBean;
import bean.OneTableXQBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.OnTableXQPresent;
import untils.MyTableTextView;
import view.OnTableXQView;

public class OneTableXQActivity extends BaseActivity implements OnTableXQView {

    @BindView(R.id.onetablexq_iv_back)
    ImageView onetablexqIvBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.lodiing)
    LoadingLayout lodiing;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.scroll)
    ScrollView scroll;
    @BindView(R.id.pgb)
    ProgressBar pgb;
    private OnTableXQPresent onTableXQPresent;
    private LinearLayout mainLinerLayout;
    private RelativeLayout relativeLayout;
    private String[] name = {"分数", "本段人数", "累计人数"};

    private ConnectionChangeReceiver myReceiver;
    private String type;
    private String province;
    private String year;

    @Override
    public int getId() {
        return R.layout.activity_one_table_xq;
    }

    @Override
    public void InIt() {
        loadingLayout = lodiing;
        registerReceiver();
        loadingLayout.setStatus(LoadingLayout.Loading);
        pgb.setVisibility(View.VISIBLE);
        scroll.setVisibility(View.GONE);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        province = intent.getStringExtra("province");
        year = intent.getStringExtra("year");

        onTableXQPresent = new OnTableXQPresent(this);
        onTableXQPresent.OneTableXQPresent(type, province, year);
        mainLinerLayout = this.findViewById(R.id.MyTable);


    }

    private void initData() {
        //初始化标题
        relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.table, null);
        MyTableTextView title = relativeLayout.findViewById(R.id.list_1_1);
        title.setText(name[0]);
        title.setTextColor(Color.BLACK);
        title = relativeLayout.findViewById(R.id.list_1_2);
        title.setText(name[1]);
        title.setTextColor(Color.BLACK);
        title = relativeLayout.findViewById(R.id.list_1_3);
        title.setText(name[2]);
        title.setTextColor(Color.BLACK);
        mainLinerLayout.addView(relativeLayout);
    }

    @Override
    public void OneTableXQsuccess(BaseBean<List<OneTableXQBean>> listBaseBean) {
        pgb.setVisibility(View.GONE);
        rl.setVisibility(View.VISIBLE);
        initData();
        List<OneTableXQBean> data = listBaseBean.data;
        if (data.size() > 0 && data != null) {
            loadingLayout.setStatus(LoadingLayout.Success);
            scroll.setVisibility(View.VISIBLE);
            for (int i = 0; i < data.size(); i++) {
                OneTableXQBean oneTableXQBean = data.get(i);
                tvTitle.setText(oneTableXQBean.getTitle());
                tvYear.setText(oneTableXQBean.getTime());
                relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.table, null);
                MyTableTextView txt = relativeLayout.findViewById(R.id.list_1_1);
                txt.setText(oneTableXQBean.getScore() + "");
                txt = relativeLayout.findViewById(R.id.list_1_2);
                txt.setText(oneTableXQBean.getPeople() + "");
                txt = relativeLayout.findViewById(R.id.list_1_3);
                txt.setText(oneTableXQBean.getAllpeople() + "");
                mainLinerLayout.addView(relativeLayout);
            }
        }

    }

    @Override
    public void OneTableXQfail(Throwable t) {
       Toast("网络不给力");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        onTableXQPresent.onDestory();
        unregisterReceiver();
    }
    @OnClick({R.id.onetablexq_iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.onetablexq_iv_back:
                finish();
                break;
        }
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
                    scroll.setVisibility(View.GONE);
                    pgb.setVisibility(View.GONE);
                } else {
                    loadingLayout.setStatus(LoadingLayout.Success);
                    pgb.setVisibility(View.GONE);
                    scroll.setVisibility(View.VISIBLE);
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

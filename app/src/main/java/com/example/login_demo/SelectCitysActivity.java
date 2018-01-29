package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import adapter.Citys_Adapter;
import base.BaseActivity;
import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import presenter.SelectSchoolPrsent;
import untils.JSONUtils;
import untils.SPUtils;
import view.SelectSchoolView;

public class SelectCitysActivity extends BaseActivity  implements SelectSchoolView {


    @BindView(R.id.city_iv_back)
    ImageView cityIvBack;
    @BindView(R.id.city_tvtitle)
    TextView cityTvtitle;
    @BindView(R.id.city_recycle)
    RecyclerView cityRecycle;
    private SelectSchoolPrsent selectSchoolPrsent;


    @Override
    public int getId() {
        return R.layout.activity_select_citys;
    }

    @Override
    public void InIt() {
        selectSchoolPrsent = new SelectSchoolPrsent(this);
        String province = getIntent().getStringExtra("province");
        SPUtils.put(MyApp.context,"province",province);
        cityTvtitle.setText(province);
        String provinceid = getIntent().getStringExtra("provinceid");
        selectSchoolPrsent.getcitys( provinceid);
        cityRecycle.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        selectSchoolPrsent.onDeach();
    }

    @OnClick(R.id.city_iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void getProvicesuccess(List<ProviceBean> list, String msg) {

    }

    @Override
    public void getProvicefail(String msg) {

    }

    @Override
    public void getCitysuccess(List<CityBean> list, String msg) {

        if(list!=null&&list.size()>=1){
            Citys_Adapter citys_adapter=new Citys_Adapter(SelectCitysActivity.this,list);
            cityRecycle.setAdapter(citys_adapter);
        }
    }

    @Override
    public void getCityfail(String msg) {

    }

    @Override
    public void getAreassuccess(List<AreaBean> list, String msg) {

    }

    @Override
    public void getAreasfail(String msg) {

    }

    @Override
    public void getSchoolssuccess(List<SelectSchoolBean> list, String msg) {

    }

    @Override
    public void getSchoolfail(String msg) {

    }
}

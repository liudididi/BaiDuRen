package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.List;

import adapter.Provice_Adapter;
import base.BaseActivity;
import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.SelectSchoolPrsent;
import view.SelectSchoolView;

public class SelectProviceActivity extends BaseActivity implements SelectSchoolView{

    @BindView(R.id.perfect_iv_back)
    ImageView perfectIvBack;
    @BindView(R.id.provice_recycle)
    RecyclerView proviceRecycle;
    private SelectSchoolPrsent selectSchoolPrsent;

    @Override
    public int getId() {
        return R.layout.activity_select_provice;
    }

    @Override
    public void InIt() {
        selectSchoolPrsent = new SelectSchoolPrsent(this);
        proviceRecycle.setLayoutManager(new LinearLayoutManager(this));
        selectSchoolPrsent.getprovinces();
    }

    @Override
    protected void onDestroy() {
        selectSchoolPrsent.onDeach();
        super.onDestroy();
    }

    @OnClick(R.id.perfect_iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void getProvicesuccess(List<ProviceBean> list, String msg) {
        if(list!=null&&list.size()>=1){
            Provice_Adapter provice_adapter=new Provice_Adapter(SelectProviceActivity.this,list);
            proviceRecycle.setAdapter(provice_adapter);
        }
    }

    @Override
    public void getProvicefail(String msg) {

    }

    @Override
    public void getCitysuccess(List<CityBean> list, String msg) {

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

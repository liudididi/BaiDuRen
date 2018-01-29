package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import adapter.Areas_Adapter;
import adapter.Citys_Adapter;
import base.BaseActivity;
import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.SelectSchoolPrsent;
import untils.SPUtils;
import view.SelectSchoolView;

public class SelectAreasActivity extends BaseActivity  implements SelectSchoolView {

    @BindView(R.id.area_iv_back)
    ImageView areaIvBack;
    @BindView(R.id.area_tvtitle)
    TextView areaTvtitle;
    @BindView(R.id.area_recycle)
    RecyclerView areaRecycle;
    private SelectSchoolPrsent selectSchoolPrsent;
    private String city;

    @Override
    public int getId() {
        return R.layout.activity_select_areas;
    }

    @Override
    public void InIt() {
        selectSchoolPrsent = new SelectSchoolPrsent(this);
        city = getIntent().getStringExtra("city");
        SPUtils.put(MyApp.context,"city",city);
        areaTvtitle.setText(city);
        String cityid = getIntent().getStringExtra("cityid");
        selectSchoolPrsent.getareas(cityid);
        areaRecycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        selectSchoolPrsent.onDeach();
    }

    @OnClick(R.id.area_iv_back)
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

    }

    @Override
    public void getCityfail(String msg) {

    }

    @Override
    public void getAreassuccess(List<AreaBean> list, String msg) {
   if(list!=null&&list.size()>=1){
       Areas_Adapter areas_adapter=new Areas_Adapter(SelectAreasActivity.this,list);
       areaRecycle.setAdapter(areas_adapter);
   }
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

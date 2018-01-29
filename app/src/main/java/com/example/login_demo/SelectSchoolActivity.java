package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import adapter.SelecSchool_Adapter;
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

public class SelectSchoolActivity extends BaseActivity  implements SelectSchoolView{


    @BindView(R.id.school_iv_back)
    ImageView schoolIvBack;
    @BindView(R.id.school_tvtitle)
    TextView schoolTvtitle;
    @BindView(R.id.school_recycle)
    RecyclerView schoolRecycle;
    private SelectSchoolPrsent selectSchoolPrsent;

    @Override
    public int getId() {
        return R.layout.activity_select_school;
    }

    @Override
    public void InIt() {

        String province = (String) SPUtils.get(MyApp.context, "province", "");
        String city = (String) SPUtils.get(MyApp.context, "city", "");
        String area = getIntent().getStringExtra("area");
        SPUtils.put(MyApp.context,"area",area);
        schoolTvtitle.setText(area);
        schoolRecycle.setLayoutManager(new LinearLayoutManager(this));
        selectSchoolPrsent = new SelectSchoolPrsent(this);
        selectSchoolPrsent.getschools(province,city,area);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        selectSchoolPrsent.onDestory();
    }

    @OnClick(R.id.school_iv_back)
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

    }

    @Override
    public void getAreasfail(String msg) {

    }

    @Override
    public void getSchoolssuccess(List<SelectSchoolBean> list, String msg) {
   if(list!=null&&list.size()>=1){
       SelecSchool_Adapter selecSchool_adapter=new SelecSchool_Adapter(this,list);
       schoolRecycle.setAdapter(selecSchool_adapter);
        }
    }

    @Override
    public void getSchoolfail(String msg) {

    }
}

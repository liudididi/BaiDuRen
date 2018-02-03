package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.MoreSchool_Adapter;
import base.BaseActivity;
import base.BaseBean;
import bean.CanSchoolBean;
import bean.CanSchoolBean3;
import bean.SlideshowBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.WishPresent;
import untils.SPUtils;
import view.WishView;

public class AdvancedActivity extends BaseActivity implements WishView {


    @BindView(R.id.advanced_iv_back)
    ImageView advancedIvBack;
    @BindView(R.id.advanced_minute)
    TextView advancedMinute;
    @BindView(R.id.advanced_sprint)
    TextView advancedSprint;
    @BindView(R.id.advanced_rl_sprint)
    RelativeLayout advancedRlSprint;
    @BindView(R.id.advanced_reliable)
    TextView advancedReliable;
    @BindView(R.id.advanced_rl_reliable)
    RelativeLayout advancedRlReliable;
    @BindView(R.id.advanced_minimum)
    TextView advancedMinimum;
    @BindView(R.id.advanced_rl_minimum)
    RelativeLayout advancedRlMinimum;

    @BindView(R.id.view_sprint)
    View view_sprint;
    @BindView(R.id.view_reliable)
    View view_reliable;
    @BindView(R.id.view_minimum)
    View view_minimum;

    @BindView(R.id.advanced_rl)
    RecyclerView advancedRl;
    @BindView(R.id.ad_tishi)
   ImageView adTishi;

    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;

    private WishPresent wishPresent;
    private ArrayList<CanSchoolBean3> list;

    @Override
    public int getId() {
        return R.layout.activity_advanced;
    }

    @Override
    public void InIt() {
        wishPresent = new WishPresent(this);
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "500");

        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "北京市");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "文科");

        if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
            wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", tbmaxfen, "1", "5");
        } else {
            wishPresent.CanSchoolPresente("北京", "文科", "0", "500", "1", "5");

        }
        advancedSprint.setTextColor(Color.BLACK);
        list = new ArrayList<>();


    }

    @Override
    protected void onResume() {
        super.onResume();

        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "500");

        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "北京市");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "文科");

        if(tbmaxfen==null&&tbmaxfen.equals("")){
            tbmaxfen="500";
        }

        if(tbarea==null&&tbarea.equals("")){
            tbarea="北京市";
        }
        if(tbsubtype==null&&tbsubtype.equals("")){
            tbsubtype="文科";
        }
    }

    @OnClick({R.id.advanced_iv_back, R.id.advanced_minute, R.id.advanced_rl_sprint, R.id.advanced_rl_reliable, R.id.advanced_rl_minimum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.advanced_iv_back:
                finish();
                break;
            case R.id.advanced_minute:
                //TODO 点击修改
                break;

            case R.id.advanced_rl_sprint:
                advancedSprint.setTextColor(Color.BLACK);
                advancedReliable.setTextColor(Color.GRAY);
                advancedMinimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.VISIBLE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.GONE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen) + 100) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "600", "1", "5");

                }
                break;

            case R.id.advanced_rl_reliable:
                advancedSprint.setTextColor(Color.GRAY);
                advancedReliable.setTextColor(Color.BLACK);
                advancedMinimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.VISIBLE);
                view_minimum.setVisibility(View.GONE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen)) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "500", "1", "5");

                }
                break;

            case R.id.advanced_rl_minimum:
                advancedSprint.setTextColor(Color.GRAY);
                advancedReliable.setTextColor(Color.GRAY);
                advancedMinimum.setTextColor(Color.BLACK);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.VISIBLE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen) - 100) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "400", "1", "5");

                }
                ;
                break;

        }
    }

    @Override
    public void Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean) {

    }

    @Override
    public void Wishfail(Throwable t) {

    }

    @Override
    public void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
        List<CanSchoolBean.ListBean> list1 = canSchoolBeanBaseBean.data.getList();
        if(list1.size()>0&&list1!=null){
            for (int i = 0; i < list1.size(); i++) {
                String url = list1.get(i).getUrl();
                String name = list1.get(i).getName();
                String address = list1.get(i).getAddress();
                String father = list1.get(i).getFather();
                String typeRank = list1.get(i).getTypeRank();
                list.add(new CanSchoolBean3(url, name, address, father, typeRank));
            }
            MoreSchool_Adapter moreSchool_adapter = new MoreSchool_Adapter(list, AdvancedActivity.this);
            advancedRl.setLayoutManager(new LinearLayoutManager(AdvancedActivity.this));
            advancedRl.setAdapter(moreSchool_adapter);
            advancedRl.setNestedScrollingEnabled(false);
        }else {
            adTishi.setVisibility(View.VISIBLE);

            advancedRl.setVisibility(View.GONE);
        }

    }

    @Override
    public void CanSchoolfail(Throwable t) {

    }


}

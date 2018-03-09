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

public class PrimaryActivity extends BaseActivity implements WishView {


    @BindView(R.id.primary_iv_back)
    ImageView primaryIvBack;
    @BindView(R.id.primary_minute)
    TextView primaryMinute;
    @BindView(R.id.primary_sprint)
    TextView primary_sprint;
    @BindView(R.id.primary_reliable)
    TextView primary_reliable;
    @BindView(R.id.primary_minimum)
    TextView primary_minimum;
    @BindView(R.id.view_sprint)
    View view_sprint;
    @BindView(R.id.view_reliable)
    View view_reliable;
    @BindView(R.id.view_minimum)
    View view_minimum;

    @BindView(R.id.rl_sprint)
    RelativeLayout rl_sprint;
    @BindView(R.id.rl_reliable)
    RelativeLayout rl_reliable;
    @BindView(R.id.rl_minimum)
    RelativeLayout rl_minimum;
    @BindView(R.id.primary_rl)
    RecyclerView primary_rl;
    @BindView(R.id.prima_tishi)
    ImageView primaTishi;
    private WishPresent wishPresent;
    private ArrayList<CanSchoolBean3> list;
    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;

    @Override
    public int getId() {
        return R.layout.activity_primary;
    }

    @Override
    public void InIt() {
        primary_sprint.setTextColor(Color.BLACK);
        list = new ArrayList<>();
        wishPresent = new WishPresent(this);



        String inarea = getIntent().getStringExtra("inarea");

        if(inarea!=null){
            tbarea=inarea;
           tbmaxfen= getIntent().getStringExtra("inmaxfen");
           tbsubtype= getIntent().getStringExtra("insubtype");
            wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", tbmaxfen, "1", "5");
        }else {

            tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
            tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
            tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");
            if (tbarea != null && tbarea !=""&& tbmaxfen !=""&&tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", tbmaxfen, "1", "5");
            } else {
                wishPresent.CanSchoolPresente("北京", "文科", "0", "500", "1", "5");
                primaryMinute.setText("北京" + "文科" + "500" + "分");
            }

        }





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wishPresent.onDestory();

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
        primaryMinute.setText(tbarea + tbsubtype + tbmaxfen + "分");

    }

    @OnClick({R.id.primary_iv_back, R.id.primary_minute, R.id.rl_sprint, R.id.rl_reliable, R.id.rl_minimum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.primary_iv_back:
                finish();
                break;
            case R.id.primary_minute:
                // TODO: 2018/1/26 地址文理科分数
                intent(PrimaryActivity.this, EstimateGradeActivity.class);
                break;
            //冲刺推荐
            case R.id.rl_sprint:
                primary_sprint.setTextColor(Color.BLACK);
                primary_reliable.setTextColor(Color.GRAY);
                primary_minimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.VISIBLE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.GONE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen) + 100) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "600", "1", "5");
                    primaryMinute.setText("北京" + "文科" + "500" + "分");
                }
                break;
            //稳妥推荐
            case R.id.rl_reliable:
                primary_sprint.setTextColor(Color.GRAY);
                primary_reliable.setTextColor(Color.BLACK);
                primary_minimum.setTextColor(Color.GRAY);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.VISIBLE);
                view_minimum.setVisibility(View.GONE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen)) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "500", "1", "5");
                    primaryMinute.setText("北京" + "文科" + "500" + "分");
                }
                break;
            //保底推荐
            case R.id.rl_minimum:
                primary_sprint.setTextColor(Color.GRAY);
                primary_reliable.setTextColor(Color.GRAY);
                primary_minimum.setTextColor(Color.BLACK);
                view_sprint.setVisibility(View.GONE);
                view_reliable.setVisibility(View.GONE);
                view_minimum.setVisibility(View.VISIBLE);
                list.clear();
                if (tbarea != null && tbarea != "" && tbmaxfen != "" && tbmaxfen != null && tbsubtype != null && tbsubtype != "") {
                    wishPresent.CanSchoolPresente(tbarea, tbsubtype, "0", (Integer.parseInt(tbmaxfen) - 100) + "", "1", "5");
                } else {
                    wishPresent.CanSchoolPresente("北京", "文科", "0", "400", "1", "5");
                    primaryMinute.setText("北京" + "文科" + "500" + "分");
                }
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

        if(list1!=null&&list1.size()>0){
            primaTishi.setVisibility(View.GONE);
            primary_rl.setVisibility(View.VISIBLE);
            for (int i = 0; i < list1.size(); i++) {
                String url = list1.get(i).getUrl();
                String name = list1.get(i).getName();
                String address = list1.get(i).getAddress();
                String father = list1.get(i).getFather();
                String typeRank = list1.get(i).getTypeRank();
                list.add(new CanSchoolBean3(url, name, address, father, typeRank));
            }
            MoreSchool_Adapter moreSchool_adapter = new MoreSchool_Adapter(list, PrimaryActivity.this);
            primary_rl.setLayoutManager(new LinearLayoutManager(PrimaryActivity.this));
            primary_rl.setAdapter(moreSchool_adapter);

        }else {
            primaTishi.setVisibility(View.VISIBLE);
            primary_rl.setVisibility(View.GONE);
        }

    }

    @Override
    public void CanSchoolfail(Throwable t) {

    }


}

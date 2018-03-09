package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import adapter.ProvinceAdapter2;

import base.BaseActivity;
import base.BaseBean;
import bean.ScoreBean1;
import bean.ScoreBean2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.ScorePresent;
import untils.SPUtils;
import view.ScoreView;

public class ScoreActivity extends BaseActivity implements ScoreView{


    @BindView(R.id.score_iv_back)
    ImageView scoreIvBack;

    @BindView(R.id.score_spinner1)
    Spinner scoreSpinner1;

    @BindView(R.id.score_spinner2)
    Spinner scoreSpinner2;

    @BindView(R.id.score_spinner3)
    Spinner scoreSpinner3;
    @BindView(R.id.score_rv_science1)
    RecyclerView score_rv_science1;
    @BindView(R.id.score_rv_science2)
    RecyclerView score_rv_science2;
    @BindView(R.id.score_rv_science3)
    RecyclerView score_rv_science3;
    @BindView(R.id.score_rv_science4)
    RecyclerView score_rv_science4;
    @BindView(R.id.score_rv_arts1)
    RecyclerView score_rv_arts1;
    @BindView(R.id.score_rv_arts2)
    RecyclerView score_rv_arts2;
    @BindView(R.id.score_rv_arts3)
    RecyclerView score_rv_arts3;
    @BindView(R.id.score_rv_arts4)
    RecyclerView score_rv_arts4;
    private ArrayAdapter<String> area_adapter;
    private String tbsubtype;
    private ScorePresent scorePresent;
    private ArrayList<String> list3;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private ArrayList<String> listthree;
    private ArrayList<String> list4;
    private ArrayList<String> list5;
    private ArrayList<String> list6;
    private ArrayList<String> list7;
    private ArrayList<String> list8;

    private String address="北京";
    private String school="北京大学";
    private List<ScoreBean2> data2;

    private boolean flag1=true;
    private boolean flag2=true;
    private boolean flag3=true;
    @Override
    public int getId() {
        return R.layout.activity_score;
    }

    @Override
    public void InIt() {

        initView();
        scorePresent = new ScorePresent(this);

        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "文科");

        scorePresent.ScorePresent("北京",tbsubtype);
        scorePresent.Score2Present("北京","北京大学");

    }

    @Override
    protected void onResume() {
        super.onResume();
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "文科");


    }

    private void initView() {

        final ArrayList<String> list = new ArrayList<>();
        list.add("北京市");
        list.add("天津市");
        list.add("河北省");
        list.add("山西省");
        list.add("内蒙古");
        list.add("辽宁省");
        list.add("吉林省");
        list.add("黑龙江");
        list.add("上海市");
        list.add("江苏省");
        list.add("浙江省");
        list.add("安徽省");
        list.add("福建省");
        list.add("江西省");
        list.add("山东省");
        list.add("河南省");
        list.add("湖北省");
        list.add("湖南省");
        list.add("广东省");
        list.add("广西省");
        list.add("海南省");
        list.add("重庆市");
        list.add("四川省");
        list.add("贵州省");
        list.add("云南省");
        list.add("西藏");
        list.add("陕西省");
        list.add("甘肃省");
        list.add("青海省");
        list.add("宁夏");
        list.add("新疆");
        list.add("台湾");
        list.add("澳门");

        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoreSpinner1.setAdapter(area_adapter);
        scoreSpinner1.setSelection(0, false);
        scoreSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ScoreActivity.this, list.get(i).toString(), Toast.LENGTH_SHORT).show();

                address = list.get(i).toString();

                scorePresent.Score2Present(address,school);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        scoreSpinner2.setAdapter(area_adapter);
        scoreSpinner2.setSelection(0, false);
        scoreSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                scorePresent.ScorePresent(list.get(i).toString(),tbsubtype);
             }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @OnClick(R.id.score_iv_back)
    public void onViewClicked() {
        finish();
    }
    //获取大学的接口
    @Override
    public void Score1success(BaseBean<List<ScoreBean1>> listBaseBean) {

        list3 = new ArrayList<>();
        List<ScoreBean1> data1 = listBaseBean.data;
        if(data1.size()>0&& data1 !=null)
        {
            for (int i = 0; i < data1.size(); i++) {
                String name = data1.get(i).getName();
                list3.add(name);
            }
            area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
            area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            scoreSpinner3.setAdapter(area_adapter);
            scoreSpinner3.setSelection(0, false);
            scoreSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    school = list3.get(i).toString();

                    scorePresent.Score2Present(address,school);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        else
        {
            area_adapter.notifyDataSetChanged();
            Toast.makeText(this, "无大学信息", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void Score1fail(Throwable t) {

    }

    //分数查询
    @Override
    public void Score2success(BaseBean<List<ScoreBean2>> listBaseBean) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        listthree = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        list7= new ArrayList<>();
        list8 = new ArrayList<>();
        data2 = listBaseBean.data;

            for (int i = 0; i < data2.size(); i++) {
                //文理科
                String classify = data2.get(i).getClassify();
                if(classify.equals("理科"))
                {
                    //几批
                    String time = data2.get(i).getTime();
                    list1.add(time);
                    flag1=true;
                    flag2=true;
                    flag3=true;
                    List<ScoreBean2.ScoresBean> scores = data2.get(i).getScores();
                    for (int i1 = 0; i1 < scores.size(); i1++) {
                        String year = scores.get(i1).getYear();
                        if(year.equals("2017"))
                        {
                            list2.add(scores.get(i1).getScoreAvg());
                            flag1=false;
                        }
                        if(year.equals("2016"))
                        {

                            listthree.add(scores.get(i1).getScoreAvg());
                            flag2=false;
                        }
                        if(year.equals("2015"))
                        {
                            list4.add(scores.get(i1).getScoreAvg());
                            flag3=false;
                        }
                    }
                    if(flag1==true)
                    {
                        list2.add("---");
                    }
                    if(flag2==true)
                    {
                        listthree.add("---");
                    }
                    if(flag3==true)
                    {
                        list4.add("---");
                    }
                }
                if(classify.equals("文科"))
                {
                    //几批
                    String time = data2.get(i).getTime();
                    list5.add(time);
                    flag1=true;
                    flag2=true;
                    flag3=true;
                    List<ScoreBean2.ScoresBean> scores = data2.get(i).getScores();
                    for (int i1 = 0; i1 < scores.size(); i1++) {
                        String year = scores.get(i1).getYear();
                        if(year.equals("2017"))
                        {
                            list6.add(scores.get(i1).getScoreAvg());
                            flag1=false;
                        }
                        if(year.equals("2016"))
                        {

                            list7.add(scores.get(i1).getScoreAvg());
                            flag2=false;
                        }
                        if(year.equals("2015"))
                        {
                            list8.add(scores.get(i1).getScoreAvg());
                            flag3=false;
                        }
                    }
                    if(flag1==true)
                    {
                        list6.add("---");
                    }
                    if(flag2==true)
                    {
                        list7.add("---");
                    }
                    if(flag3==true)
                    {
                        list8.add("---");
                    }
                }
            }


            //理科
            ProvinceAdapter2 provinceAdapter9 = new ProvinceAdapter2(list1,ScoreActivity.this);
            score_rv_science1.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
            score_rv_science1.setAdapter(provinceAdapter9);

            ProvinceAdapter2 provinceAdapter10=new ProvinceAdapter2(list2,ScoreActivity.this);
            score_rv_science2.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
            score_rv_science2.setAdapter(provinceAdapter10);

            ProvinceAdapter2 provinceAdapter11=new ProvinceAdapter2(listthree,ScoreActivity.this);
            score_rv_science3.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
            score_rv_science3.setAdapter(provinceAdapter11);

            ProvinceAdapter2 provinceAdapter12=new ProvinceAdapter2(list4,ScoreActivity.this);
            score_rv_science4.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
            score_rv_science4.setAdapter(provinceAdapter12);

            //文科
        ProvinceAdapter2 provinceAdapter13 = new ProvinceAdapter2(list5,ScoreActivity.this);
        score_rv_arts1.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
        score_rv_arts1.setAdapter(provinceAdapter13);

        ProvinceAdapter2 provinceAdapter14=new ProvinceAdapter2(list6,ScoreActivity.this);
        score_rv_arts2.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
        score_rv_arts2.setAdapter(provinceAdapter14);

        ProvinceAdapter2 provinceAdapter15=new ProvinceAdapter2(list7,ScoreActivity.this);
        score_rv_arts3.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
        score_rv_arts3.setAdapter(provinceAdapter15);

        ProvinceAdapter2 provinceAdapter16=new ProvinceAdapter2(list8,ScoreActivity.this);
        score_rv_arts4.setLayoutManager(new LinearLayoutManager(ScoreActivity.this));
        score_rv_arts4.setAdapter(provinceAdapter16);

        if(list1.size()==0)
        {
            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
        }

        if(list5.size()==0)
        {
            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Score2fail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scorePresent.onDestory();

    }
}

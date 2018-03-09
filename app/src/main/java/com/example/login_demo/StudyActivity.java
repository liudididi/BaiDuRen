package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.StudyAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.StudyBean;
import bean.StudyBean2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.StudyPresent;
import view.StudyView;

public class StudyActivity extends BaseActivity implements StudyView{
    @BindView(R.id.study_iv_back)
    ImageView studyIvBack;
    @BindView(R.id.study_tv_one)
    TextView studyTvOne;
    @BindView(R.id.view_study1)
    View viewStudy1;
    @BindView(R.id.study_rl_one)
    RelativeLayout studyRlOne;
    @BindView(R.id.study_tv_two)
    TextView studyTvTwo;
    @BindView(R.id.view_study2)
    View viewStudy2;
    @BindView(R.id.study_rl_two)
    RelativeLayout studyRlTwo;
    @BindView(R.id.study_tv_three)
    TextView studyTvThree;
    @BindView(R.id.view_study3)
    View viewStudy3;
    @BindView(R.id.study_rl_three)
    RelativeLayout studyRlThree;
    @BindView(R.id.study_spinner1)
    Spinner study_spinner1;
    @BindView(R.id.study_spinner2)
    Spinner study_spinner2;
    @BindView(R.id.study_spinner3)
    Spinner study_spinner3;
    @BindView(R.id.study_ll1)
    LinearLayout study_ll1;
    @BindView(R.id.study_ll2)
    LinearLayout study_ll2;
    @BindView(R.id.study_ll2_spinner1)
    Spinner study_ll2_spinner1;
    @BindView(R.id.study_ll2_spinner2)
    Spinner study_ll2_spinner2;

    @BindView(R.id.study_ll3)
    LinearLayout study_ll3;
    @BindView(R.id.study_ll3_spinner1)
    Spinner study_ll3_spinner1;

    @BindView(R.id.study_rv)
    RecyclerView study_rv;
    private ArrayAdapter<String> area_adapter;
    private StudyPresent studyPresent;
    private String s1="北京";
    private String s2="高一";
    private String s3="语文";

    private ArrayList<StudyBean2> list4;
    private StudyAdapter studyAdapter;

    @Override
    public int getId() {
        return R.layout.activity_study;
    }

    @Override
    public void InIt() {
        studyTvOne.setTextColor(Color.BLACK);
        init();
        studyPresent = new StudyPresent(this);
        studyPresent.StudyPresent("习题资料",s1,s3,s2,"1","10");
    }

    private void init() {
        final ArrayList<String> list = new ArrayList<>();
        list.add("北京");
        list.add("天津");
        list.add("河北");
        list.add("山西");
        list.add("内蒙古");
        list.add("辽宁");
        list.add("吉林");
        list.add("黑龙江");
        list.add("上海");
        list.add("江苏");
        list.add("浙江");
        list.add("安徽");
        list.add("福建");
        list.add("江西");
        list.add("山东");
        list.add("河南");
        list.add("湖北");
        list.add("湖南");
        list.add("广东");
        list.add("广西");
        list.add("海南");
        list.add("重庆");
        list.add("四川");
        list.add("贵州");
        list.add("云南");
        list.add("西藏");
        list.add("陕西");
        list.add("甘肃");
        list.add("青海");
        list.add("宁夏");
        list.add("新疆");
        list.add("台湾");
        list.add("澳门");

        //习题资料
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_spinner1.setAdapter(area_adapter);
        study_spinner1.setSelection(0, false);
        study_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s1 = list.get(i).toString();
                System.out.println("地址++++"+s1+s3+s2);
                studyPresent.StudyPresent("习题资料",s1,s3,s2,"1","10");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final ArrayList<String> list1=new ArrayList<>();
        list1.add("高一");
        list1.add("高二");
        list1.add("高三");
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_spinner2.setAdapter(area_adapter);
        study_spinner2.setSelection(0, false);
        study_spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s2 = list1.get(i).toString();
                studyPresent.StudyPresent("习题资料",s1,s3,s2,"1","10");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayList<String> list2=new ArrayList<>();
        list2.add("语文");
        list2.add("文数");
        list2.add("理数");
        list2.add("数学");
        list2.add("英语");
        list2.add("政治");
        list2.add("历史");
        list2.add("地理");
        list2.add("物理");
        list2.add("化学");
        list2.add("生物");
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_spinner3.setAdapter(area_adapter);
        study_spinner3.setSelection(0, false);
        study_spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s3= list2.get(i).toString();
                studyPresent.StudyPresent("习题资料",s1,s3,s2,"1","10");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //历年高考题  地区
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_ll2_spinner1.setAdapter(area_adapter);
        study_ll2_spinner1.setSelection(0, false);
        study_ll2_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s1 = list.get(i).toString();
                studyPresent.StudyPresent("历年高考题",s1,s3,"","1","10");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //历年高考题  科目
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_ll2_spinner2.setAdapter(area_adapter);
        study_ll2_spinner2.setSelection(0, false);
        study_ll2_spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s3= list2.get(i).toString();
                studyPresent.StudyPresent("历年高考题",s1,s3,"","1","10");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //真题演练
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        study_ll3_spinner1.setAdapter(area_adapter);
        study_ll3_spinner1.setSelection(0, false);
        study_ll3_spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                s3= list2.get(i).toString();
                studyPresent.StudyPresent("真题演练","全国",s3,"","1","10");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @OnClick({R.id.study_iv_back, R.id.study_rl_one, R.id.study_rl_two, R.id.study_rl_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.study_iv_back:
                finish();
                break;
            case R.id.study_rl_one:
                studyTvOne.setTextColor(Color.BLACK);
                studyTvTwo.setTextColor(Color.GRAY);
                studyTvThree.setTextColor(Color.GRAY);
                viewStudy1.setVisibility(View.VISIBLE);
                viewStudy2.setVisibility(View.GONE);
                viewStudy3.setVisibility(View.GONE);
                study_ll1.setVisibility(View.VISIBLE);
                study_ll2.setVisibility(View.GONE);
                study_ll3.setVisibility(View.GONE);
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                studyPresent.StudyPresent("习题资料",s1,s3,s2,"1","10");
                 break;
            case R.id.study_rl_two:
                studyTvOne.setTextColor(Color.GRAY);
                studyTvTwo.setTextColor(Color.BLACK);
                studyTvThree.setTextColor(Color.GRAY);
                viewStudy1.setVisibility(View.GONE);
                viewStudy2.setVisibility(View.VISIBLE);
                viewStudy3.setVisibility(View.GONE);

                study_ll1.setVisibility(View.GONE);
                study_ll2.setVisibility(View.VISIBLE);
                study_ll3.setVisibility(View.GONE);
                if(list4!=null){
                    list4.clear();
                }

                studyPresent.StudyPresent("历年高考题",s1,s3,"","1","10");

                break;
            case R.id.study_rl_three:
                studyTvOne.setTextColor(Color.GRAY);
                studyTvTwo.setTextColor(Color.GRAY);
                studyTvThree.setTextColor(Color.BLACK);
                viewStudy1.setVisibility(View.GONE);
                viewStudy2.setVisibility(View.GONE);
                viewStudy3.setVisibility(View.VISIBLE);

                study_ll1.setVisibility(View.GONE);
                study_ll2.setVisibility(View.GONE);
                study_ll3.setVisibility(View.VISIBLE);
                if(list4!=null&&list4.size()>0)
                {
                    list4.clear();
                }

                studyPresent.StudyPresent("真题演练","全国",s3,"","1","10");

                break;
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        studyPresent.onDestory();
    }

    @Override
    public void Studysuccess(BaseBean<StudyBean> studyBeanBaseBean) {

        list4 = new ArrayList<>();
        List<StudyBean.ListBean> list = studyBeanBaseBean.data.getList();
        System.out.println("地址集合++++"+list.size());
        if(list!=null&&list.size()>0)
        {
            for (int i = 0; i < list.size(); i++) {
                String title = list.get(i).getTitle();
                String body = list.get(i).getBody();
                List<StudyBean.ListBean.PictureBean> picture = list.get(i).getPicture();
                for (int i1 = 0; i1 < picture.size(); i1++) {
                    String url = picture.get(i1).getUrl();
                    list4.add(new StudyBean2(url,title,body));
                }
            }

            if(studyAdapter==null)
            {
                studyAdapter = new StudyAdapter(list4,StudyActivity.this);
                study_rv.setLayoutManager(new GridLayoutManager(StudyActivity.this,2));
                study_rv.setAdapter(studyAdapter);
            }
          else
            {
                studyAdapter.load(list4);
            }
        }
        else
        {

            studyAdapter.load(list4);
            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Studyfail(Throwable t) {

    }
}

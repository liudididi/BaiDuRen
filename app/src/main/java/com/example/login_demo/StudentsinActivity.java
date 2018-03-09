package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.Spinner_Adapter;
import adapter.StudentsinAdapter;
import adapter.StudentsinNewsAdapter;
import base.BaseActivity;
import base.BaseBean;
import bean.StudentsinBean;
import bean.StudentsinNewsBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.StudentsinPresent;
import view.StudentsinView;

public class StudentsinActivity extends BaseActivity implements StudentsinView{


    @BindView(R.id.studentin_iv_back)
    ImageView studentinIvBack;
    @BindView(R.id.studentin_tv_one)
    TextView studentinTvOne;
    @BindView(R.id.view_studentin1)
    View viewStudentin1;
    @BindView(R.id.studentin_rl_one)
    RelativeLayout studentinRlOne;
    @BindView(R.id.studentin_tv_two)
    TextView studentinTvTwo;
    @BindView(R.id.view_studentin)
    View viewStudentin;
    @BindView(R.id.studentin_rl_two)
    RelativeLayout studentinRlTwo;


    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.ll2)
    LinearLayout ll2;

    @BindView(R.id.tv1)
    Spinner tv1;
    @BindView(R.id.tv2)
    Spinner tv2;
    @BindView(R.id.tv3)
    Spinner tv3;

    @BindView(R.id.student2_rl1)
    RelativeLayout student2_rl1;
    @BindView(R.id.student2_rl2)
    RelativeLayout student2_rl2;
    @BindView(R.id.student2_rl3)
    RelativeLayout student2_rl3;

    @BindView(R.id.student2_tv1)
    TextView student2_tv1;
    @BindView(R.id.student2_tv2)
    TextView student2_tv2;
    @BindView(R.id.student2_tv3)
    TextView student2_tv3;
    @BindView(R.id.studentsin_rv)
    RecyclerView studentsin_rv;

    @BindView(R.id.studentsin_iv)
    ImageView studentsin_iv;
    private ArrayAdapter<String> area_adapter;
    private StudentsinPresent studentsinPresent;

    private String address="北京市";
    private String schooltype="艺术类";
    private List<StudentsinBean> data;
    private List<StudentsinNewsBean.ListBean> list;

    @Override
    public int getId() {
        return R.layout.activity_studentsin;
    }

    @Override
    public void InIt() {
        student2_tv1.setTextColor(Color.BLACK);
        studentinTvOne.setTextColor(Color.BLACK);
        studentsinPresent = new StudentsinPresent(this);
        studentsinPresent.StudentsinPresent(address,schooltype);
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
        tv1.setAdapter(area_adapter);
        tv1.setSelection(0, false);
        tv1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(data!=null&&data.size()>0)
                {
                    data.clear();
                }

                 address = list.get(i).toString();
                studentsinPresent.StudentsinPresent(address,schooltype);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final ArrayList<String> list2 = new ArrayList<>();
        list2.add("艺术类");
        list2.add("体育类");
        list2.add("军事类");
        list2.add("语言类");
        list2.add("民族类");

        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tv2.setAdapter(area_adapter);
        tv2.setSelection(0, false);
        tv2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(data!=null){
                    data.clear();
                }
                schooltype = list2.get(i).toString();
                studentsinPresent.StudentsinPresent(address,schooltype);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayList<String> list3 = new ArrayList<>();
        list3.add("是");
        list3.add("否");
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list3);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tv3.setAdapter(area_adapter);
        tv3.setSelection(0, false);
        tv3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //String address = list3.get(i).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }




    @OnClick({R.id.student2_rl1,R.id.student2_rl2,R.id.student2_rl3,R.id.studentin_iv_back, R.id.studentin_rl_one, R.id.studentin_rl_two })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.studentin_iv_back:
                finish();
                break;
            case R.id.studentin_rl_one:
                ll.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.GONE);
                studentinTvOne.setTextColor(Color.BLACK);
                studentinTvTwo.setTextColor(Color.GRAY);
                viewStudentin1.setVisibility(View.VISIBLE);
                viewStudentin.setVisibility(View.GONE);
                studentsinPresent.StudentsinPresent(address,schooltype);
                if(list!=null)
                {
                    list.clear();
                }

                break;
            case R.id.studentin_rl_two:
                ll.setVisibility(View.GONE);
                ll2.setVisibility(View.VISIBLE);
                studentinTvOne.setTextColor(Color.GRAY);
                studentinTvTwo.setTextColor(Color.BLACK);
                viewStudentin1.setVisibility(View.GONE);
                viewStudentin.setVisibility(View.VISIBLE);

                if(data!=null&&data.size()>0)
                {
                    data.clear();
                }

                student2_tv1.setTextColor(Color.BLACK);
                student2_tv2.setTextColor(Color.GRAY);
                student2_tv3.setTextColor(Color.GRAY);
                studentsinPresent.StudentsinNewsPresent("艺考百科","全国","1","10");
                break;
            case R.id.student2_rl1:
                student2_tv1.setTextColor(Color.BLACK);
                student2_tv2.setTextColor(Color.GRAY);
                student2_tv3.setTextColor(Color.GRAY);
                if(list.size()>0&&list!=null)
                {
                    list.clear();
                }

                studentsinPresent.StudentsinNewsPresent("艺考百科","全国","1","10");
                break;
            case R.id.student2_rl2:
                student2_tv1.setTextColor(Color.GRAY);
                student2_tv2.setTextColor(Color.BLACK);
                student2_tv3.setTextColor(Color.GRAY);
                if(list.size()>0&&list!=null)
                {
                    list.clear();
                }

                studentsinPresent.StudentsinNewsPresent("历年真题","全国","1","10");
                break;
            case R.id.student2_rl3:
                student2_tv1.setTextColor(Color.GRAY);
                student2_tv2.setTextColor(Color.GRAY);
                student2_tv3.setTextColor(Color.BLACK);
                if(list.size()>0&&list!=null)
                {
                    list.clear();
                }

                studentsinPresent.StudentsinNewsPresent("艺考资讯","全国","1","10");
                break;
        }
    }

    //特长生院校查询
    @Override
    public void Suggestsuccess(BaseBean<List<StudentsinBean>> listBaseBean) {
        data = listBaseBean.data;
        if(data.size()>0&&data!=null)
        {
            studentsin_iv.setVisibility(View.GONE);
            StudentsinAdapter studentsinAdapter=new StudentsinAdapter(data,StudentsinActivity.this);
            studentsin_rv.setLayoutManager(new LinearLayoutManager(StudentsinActivity.this));
            studentsin_rv.setAdapter(studentsinAdapter);
        }
       else
        {

            studentsin_iv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void Studentsinfail(Throwable t) {

    }

    //特长生资讯接口
    @Override
    public void StudentsinNewssuccess(BaseBean<StudentsinNewsBean> studentsinNewsBeanBaseBean) {
        list = studentsinNewsBeanBaseBean.data.getList();
        if(list.size()>0&& list !=null)
        {
            studentsin_iv.setVisibility(View.GONE);
            StudentsinNewsAdapter studentsinAdapter=new StudentsinNewsAdapter(list,StudentsinActivity.this);
            studentsin_rv.setLayoutManager(new LinearLayoutManager(StudentsinActivity.this));
            studentsin_rv.setAdapter(studentsinAdapter);
        }
        else
        {
            studentsin_iv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void StudentsinNewsfail(Throwable t) {

    }
}

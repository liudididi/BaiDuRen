package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreSchoolActivity extends BaseActivity {


    @BindView(R.id.mschool_iv_back)
    ImageView mschoolIvBack;
    @BindView(R.id.mschool_search)
    ImageView mschoolSearch;
    @BindView(R.id.mschool_area)
    Spinner mschoolArea;
    @BindView(R.id.mschool_sort)
    Spinner mschoolSort;
    @BindView(R.id.mschool_xlist)
    XRecyclerView mschoolXlist;
    private List<String> arealist;
    private List<String> sortlist;
    private ArrayAdapter<String> area_adapter;
    private ArrayAdapter<String> sort_adapter;
    private  String  area;
    private  String  sort;

    @Override
    public int getId() {
        return R.layout.activity_more_school;
    }

    @Override
    public void InIt() {
        initList();
        //地区Spinner
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arealist);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mschoolArea.setAdapter(area_adapter);
        mschoolArea.setSelection(0, false);
        //改变值
        mschoolArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                String  str = (String) mschoolArea.getSelectedItem();
                area=str;
                Toast(area);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        //类别spinner
        sort_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sortlist);
        sort_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mschoolSort.setAdapter(sort_adapter);
        mschoolSort.setSelection(0, false);
        //改变值
        mschoolSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                String  str = (String) mschoolSort.getSelectedItem();
                sort=str;
                Toast(sort);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }

    private void initList() {
        arealist = new ArrayList<>();
        arealist.add("地区");
        arealist.add("北京市");
        arealist.add("天津市");
        arealist.add("河北省");
        arealist.add("山西省");
        arealist.add("内蒙古");
        arealist.add("辽宁省");
        arealist.add("吉林省");
        arealist.add("黑龙江");
        arealist.add("上海市");
        arealist.add("江苏省");
        arealist.add("浙江省");
        arealist.add("安徽省");
        arealist.add("福建省");
        arealist.add("江西省");
        arealist.add("山东省");
        arealist.add("河南省");
        arealist.add("湖北省");
        arealist.add("湖南省");
        arealist.add("广东省");
        arealist.add("广西省");
        arealist.add("海南省");
        arealist.add("重庆市");
        arealist.add("四川省");
        arealist.add("贵州省");
        arealist.add("云南省");
        arealist.add("西藏");
        arealist.add("陕西省");
        arealist.add("甘肃省");
        arealist.add("青海省");
        arealist.add("宁夏");
        arealist.add("新疆");
        arealist.add("台湾");
        arealist.add("澳门");
        sortlist = new ArrayList<>();
        sortlist.add("类别");
        sortlist.add("综合");
        sortlist.add("理工");
        sortlist.add("师范");
        sortlist.add("农林");
        sortlist.add("医药");
        sortlist.add("民族");
        sortlist.add("财经");
        sortlist.add("政法");
        sortlist.add("语言");
        sortlist.add("军事");
        sortlist.add("艺术");
        sortlist.add("林业");
        sortlist.add("体育");


    }

    @OnClick({R.id.mschool_iv_back, R.id.mschool_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mschool_iv_back:
                finish();
                break;
            case R.id.mschool_search:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arealist=null;
        sortlist=null;
    }
}

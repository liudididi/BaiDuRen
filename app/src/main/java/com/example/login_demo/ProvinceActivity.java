package com.example.login_demo;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.ProvinceAdapter1;
import adapter.ProvinceAdapter2;

import adapter.Spinner_Adapter;
import base.BaseActivity;
import base.BaseBean;
import bean.ProvinceBean;
import butterknife.BindView;
import butterknife.OnClick;
import presenter.ProvincePresent;
import view.ProvinceView;

public class ProvinceActivity extends BaseActivity implements ProvinceView{
    @BindView(R.id.province_iv_back)
    ImageView provinceIvBack;
   /* @BindView(R.id.province_spinner)
    Spinner provinceSpinner;*/
    //理科1,2,3,4
    @BindView(R.id.province_rv_science1)
    RecyclerView province_rv_science1;
    @BindView(R.id.province_rv_science2)
    RecyclerView province_rv_science2;
    @BindView(R.id.province_rv_science3)
    RecyclerView province_rv_science3;
    @BindView(R.id.province_rv_science4)
    RecyclerView province_rv_science4;
    //文科1,2,3,4
    @BindView(R.id.province_rv_arts1)
    RecyclerView province_rv_arts1;
    @BindView(R.id.province_rv_arts2)
    RecyclerView province_rv_arts2;
    @BindView(R.id.province_rv_arts3)
    RecyclerView province_rv_arts3;
    @BindView(R.id.province_rv_arts4)
    RecyclerView province_rv_arts4;

    @BindView(R.id.spiiner_lv)
    ListView spiiner_lv;
   @BindView(R.id.tv_address)
   TextView tv_address;

    @BindView(R.id.iv_right)
    ImageView iv_right;
    @BindView(R.id.iv_next)
    ImageView iv_next;
    private ArrayAdapter<String> area_adapter;
    private ProvincePresent provincePresent;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private ArrayList<String> list3;
    private ArrayList<String> list4;
    private ArrayList<String> list5;
    private ArrayList<String> list6;
    private ArrayList<String> list7;
    private ArrayList<String> list8;
    private ProvinceAdapter1 provinceAdapter1;
    private  String s="北京市";
    private boolean msg=true;
    private boolean flag1=true;
    private boolean flag2=true;
    private boolean flag3=true;
    @Override
    public int getId() {
        return R.layout.activity_province;
    }

    @Override
    public void InIt() {
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

        final Spinner_Adapter spinner_adapter=new Spinner_Adapter(list,ProvinceActivity.this);
        tv_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(msg==true)
                {
                    spiiner_lv.setVisibility(View.VISIBLE);
                    spiiner_lv.setAdapter(spinner_adapter);
                    msg=false;
                    iv_right.setVisibility(View.GONE);
                    iv_next.setVisibility(View.VISIBLE);
                }
              else
                {
                    spiiner_lv.setVisibility(View.GONE);
                    msg=true;

                    iv_right.setVisibility(View.VISIBLE);
                    iv_next.setVisibility(View.GONE);
                }

            }
        });


        spiiner_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  s = list.get(i).toString();
                spiiner_lv.setVisibility(View.GONE);
                msg=true;
                iv_right.setVisibility(View.VISIBLE);
                iv_next.setVisibility(View.GONE);
                tv_address.setText( list.get(i).toString());
                list1.clear();
                list2.clear();
                list3.clear();
                list4.clear();
                list5.clear();
                list6.clear();
                list7.clear();
                list8.clear();
                provincePresent.ProvincePresent(s);
            }
        });

        provincePresent = new ProvincePresent(this);
        provincePresent.ProvincePresent("北京");
    }


    @OnClick({R.id.province_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.province_iv_back:
                finish();
                break;

        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        provincePresent.onDestory();

    }

    @Override
    public void Provincesuccess(BaseBean<List<ProvinceBean>> listBaseBean) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        list5 = new ArrayList<>();
        list6 = new ArrayList<>();
        list7= new ArrayList<>();
        list8 = new ArrayList<>();
        List<ProvinceBean> data = listBaseBean.data;
        if(data.size()>0&&data!=null)
        {
            for (int i = 0; i < data.size(); i++) {
                //文理科
                String classify = data.get(i).getClassify();
                if(classify.equals("理科"))
                {
                    //几批
                    String time = data.get(i).getTime();
                    list1.add(time);
                    flag1=true;
                    flag2=true;
                    flag3=true;
                    //2017
                    List<ProvinceBean.ScoresBean> scores = data.get(i).getScores();
                    for (int i1 = 0; i1 < scores.size(); i1++) {
                        if(scores.get(i1).getYear().equals("2017"))
                        {
                            list2.add(scores.get(i1).getScore());
                            flag1=false;
                        }
                        if(scores.get(i1).getYear().equals("2016"))
                        {
                            list3.add(scores.get(i1).getScore());
                            flag2=false;
                        }
                        if(scores.get(i1).getYear().equals("2015"))
                        {
                            list4.add(scores.get(i1).getScore());
                            flag3=false;
                        }
                    }
                    if(flag1==true)
                    {
                        list2.add("---");
                    }
                    if(flag2==true)
                    {
                        list3.add("---");
                    }
                    if(flag3==true)
                    {
                        list4.add("---");
                    }
                }

                if(classify.equals("文科"))
                {
                    //几批
                    String time = data.get(i).getTime();
                    list5.add(time);
                    flag1=true;
                    flag2=true;
                    flag3=true;
                    //2017
                    List<ProvinceBean.ScoresBean> scores = data.get(i).getScores();
                    for (int i1 = 0; i1 < scores.size(); i1++) {
                        if(scores.get(i1).getYear().equals("2017"))
                        {
                            list6.add(scores.get(i1).getScore());
                            flag1=false;
                        }
                        if(scores.get(i1).getYear().equals("2016"))
                        {
                            list7.add(scores.get(i1).getScore());
                            flag2=false;
                        }
                        if(scores.get(i1).getYear().equals("2015"))
                        {
                            list8.add(scores.get(i1).getScore());
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
            provinceAdapter1 = new ProvinceAdapter1(list1,ProvinceActivity.this);
            province_rv_science1.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_science1.setAdapter(provinceAdapter1);
            ProvinceAdapter2 provinceAdapter2=new ProvinceAdapter2(list2,ProvinceActivity.this);
            province_rv_science2.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_science2.setAdapter(provinceAdapter2);
            ProvinceAdapter2 provinceAdapter3=new ProvinceAdapter2(list3,ProvinceActivity.this);
            province_rv_science3.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_science3.setAdapter(provinceAdapter3);
            ProvinceAdapter2 provinceAdapter4=new ProvinceAdapter2(list4,ProvinceActivity.this);
            province_rv_science4.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_science4.setAdapter(provinceAdapter4);



            //文科
            ProvinceAdapter2 provinceAdapter5=new ProvinceAdapter2(list5,ProvinceActivity.this);
            province_rv_arts1.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_arts1.setAdapter(provinceAdapter5);
            ProvinceAdapter2 provinceAdapter6=new ProvinceAdapter2(list6,ProvinceActivity.this);
            province_rv_arts2.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_arts2.setAdapter(provinceAdapter6);
            ProvinceAdapter2 provinceAdapter7=new ProvinceAdapter2(list7,ProvinceActivity.this);
            province_rv_arts3.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_arts3.setAdapter(provinceAdapter7);
            ProvinceAdapter2 provinceAdapter8=new ProvinceAdapter2(list8,ProvinceActivity.this);
            province_rv_arts4.setLayoutManager(new LinearLayoutManager(ProvinceActivity.this));
            province_rv_arts4.setAdapter(provinceAdapter8);
        }
       else
        {
            provinceAdapter1.load(list1);
            Toast.makeText(this, "无数据", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void Provincefail(Throwable t) {

    }
}

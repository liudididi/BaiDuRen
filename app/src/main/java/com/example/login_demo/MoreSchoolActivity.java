package com.example.login_demo;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.weavey.loading.lib.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MoreSchoolRecycle;
import base.BaseActivity;
import bean.CheckSchoolBean;
import butterknife.BindView;
import butterknife.OnClick;
import presenter.MoreSchoolPresent;
import untils.NetCheck;
import untils.SPUtils;
import view.MoreSchoolView;

public class MoreSchoolActivity extends BaseActivity implements MoreSchoolView {
    @BindView(R.id.mschool_iv_back)
    ImageView mschoolIvBack;
    @BindView(R.id.mschool_search)
    ImageView mschoolSearch;
    @BindView(R.id.mschool_area)
    Spinner mschoolArea;

    @BindView(R.id.mschool_none)
    ImageView img_none;
    @BindView(R.id.mschool_sort)
    Spinner mschoolSort;
    @BindView(R.id.mschool_xlist)
    XRecyclerView mschoolXlist;

    private List<String> arealist;
    private List<String> sortlist;
    private ArrayAdapter<String> area_adapter;
    private ArrayAdapter<String> sort_adapter;
    private String area;
    private String sort;
    private MoreSchoolPresent moreSchoolPresent;
    private MoreSchoolRecycle adpter;
    private String token;
    private ConnectionChangeReceiver myReceiver;



    @Override
    public int getId() {
        return R.layout.activity_more_school;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void InIt() {
        initList();
        this.loadingLayout=findViewById(R.id.lodiing);
        registerReceiver();
        token = (String) SPUtils.get(MyApp.context, "token", "");
        mschoolXlist.setPullRefreshEnabled(false);
        mschoolXlist.setLayoutManager(new LinearLayoutManager(this));
        moreSchoolPresent = new MoreSchoolPresent(this);
        moreSchoolPresent.checkschool(area, sort + "类");
        //地区Spinner
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arealist);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mschoolArea.setAdapter(area_adapter);
        mschoolArea.setDropDownVerticalOffset(80);
        mschoolArea.setSelection(0, false);
        //改变值
        mschoolArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                String str = (String) mschoolArea.getSelectedItem();
                area = str;

                moreSchoolPresent.checkschool(area, sort + "类");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
        //类别spinner
        sort_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sortlist);
        sort_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mschoolSort.setAdapter(sort_adapter);
        mschoolSort.setDropDownVerticalOffset(80);
        mschoolSort.setSelection(0, false);
        //改变值
        mschoolSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                String str = (String) mschoolSort.getSelectedItem();
                sort = str;
                moreSchoolPresent.checkschool(area, sort + "类");


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

    }

    private void initList() {
        arealist = new ArrayList<>();
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
        area = "北京市";
        sort = "综合";
    }

    @OnClick({R.id.mschool_iv_back, R.id.mschool_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mschool_iv_back:
                finish();
                break;
            case R.id.mschool_search:

                intent(this, SearchParticularsActivity.class);

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arealist = null;
        sortlist = null;
        moreSchoolPresent.onDestory();
unregisterReceiver();
    }

    @Override
    public void CheckSuccess(List<CheckSchoolBean> list) {
        if (list != null & list.size() > 0) {
            img_none.setVisibility(View.GONE);
            mschoolXlist.setVisibility(View.VISIBLE);
            loadingLayout.setStatus(LoadingLayout.Success);
            if (adpter == null) {
                adpter = new MoreSchoolRecycle(this, list);

                mschoolXlist.setAdapter(adpter);
            } else {
                adpter.Refsh(list);
            }
        } else {

            img_none.setVisibility(View.VISIBLE);
            mschoolXlist.setVisibility(View.GONE);
        }
    }

    @Override
    public void CheckFail(String msg) {


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void registerReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //设置网络状态提示布局的状态
//无网的时候，无网提示的展示View展示出来
//重新联接上网络时，自动加载数据
//这个是onresume中实现了数据的刷新，即是，网络连接后，重新拉取数据
        myReceiver = new ConnectionChangeReceiver() {
            @Override
            public void changeNetStatus(boolean flag) {
                //设置网络状态提示布局的状态
                if (flag) {
             loadingLayout.setStatus(LoadingLayout.No_Network);
                    mschoolXlist.setVisibility(View.GONE);
                } else {
                    //有网
                    moreSchoolPresent.checkschool(area, sort + "类");

                }
            }
        };
        this.registerReceiver(myReceiver, filter);
    }

    public void unregisterReceiver() {
        if (myReceiver != null) {
            this.unregisterReceiver(myReceiver);
        }
    }
}

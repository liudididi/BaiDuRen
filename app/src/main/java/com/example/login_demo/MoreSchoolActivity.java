package com.example.login_demo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.MoreSchoolRecycle;
import base.BaseActivity;
import base.BaseBean;
import bean.CheckSchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import presenter.MoreSchoolPresent;
import untils.MyQusetUtils;
import untils.SPUtils;
import view.MoreSchoolView;

public class MoreSchoolActivity extends BaseActivity  implements MoreSchoolView, MoreSchoolRecycle.CollectBack {
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
    private  String  area;
    private  String  sort;
    private MoreSchoolPresent moreSchoolPresent;
    private MoreSchoolRecycle adpter;
    private String token;

    @Override
    public int getId() {
        return R.layout.activity_more_school;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void InIt() {
        initList();
        token = (String) SPUtils.get(MyApp.context, "token", "");
        mschoolXlist.setPullRefreshEnabled(false);
        mschoolXlist.setLayoutManager(new LinearLayoutManager(this));
        moreSchoolPresent = new MoreSchoolPresent(this);



        moreSchoolPresent.checkschool(area,sort+"类");
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
                String  str = (String) mschoolArea.getSelectedItem();
                area=str;

                moreSchoolPresent.checkschool(area,sort+"类");

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
                String  str = (String) mschoolSort.getSelectedItem();
                sort=str;
                moreSchoolPresent.checkschool(area,sort+"类");


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

   area="北京市";
   sort="综合";
    }

    @OnClick({R.id.mschool_iv_back, R.id.mschool_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mschool_iv_back:
                finish();
                break;
            case R.id.mschool_search:

                intent(this,SearchParticularsActivity.class);

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        arealist=null;
        sortlist=null;
        moreSchoolPresent.onDestory();
    }

    @Override
    public void CheckSuccess(List<CheckSchoolBean> list) {
        if(list!=null&list.size()>0){
            img_none.setVisibility(View.GONE);
            mschoolXlist.setVisibility(View.VISIBLE);
            if(adpter==null){
                adpter = new MoreSchoolRecycle(this,list);
                adpter.setCollectBack(this);
                mschoolXlist.setAdapter(adpter);
            }else {
                adpter.Refsh(list);
            }
        }else {

            img_none.setVisibility(View.VISIBLE);
            mschoolXlist.setVisibility(View.GONE);
        }
    }

    @Override
    public void CheckFail(String msg) {


    }

    @Override
    public void collecBack(final ImageView imgcollect, String name, int postion) {

        if(token==null||token.length()<4){
            Toast("用户未登录");
            return;
        }
          MyQusetUtils.getInstance()
                    .getQuestInterface().collect("0", name, token)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableSubscriber<BaseBean>() {
                        @Override
                        public void onNext(BaseBean baseBean) {
                            Toast.makeText(MyApp.context, baseBean.msg, Toast.LENGTH_SHORT).show();
                            if(baseBean.msg.equals("收藏成功")){
                                Glide.with(MoreSchoolActivity.this).load(R.drawable.collect_yes).into(imgcollect);
                            }else {
                                Glide.with(MoreSchoolActivity.this).load(R.drawable.collect_none).into(imgcollect);
                            }
                        }

                        @Override
                        public void onError(Throwable t) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }
}

package com.example.login_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.HotAdapter;
import adapter.Search_Adapter;
import base.BaseActivity;
import bean.HotBean;
import bean.SearchBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.SearchPresent;
import view.SearchView;

public class SearchParticularsActivity extends BaseActivity implements SearchView {


    @BindView(R.id.sh_iv_back)
    ImageView shIvBack;
    @BindView(R.id.sh_tvsearch)
    TextView shTvsearch;
    @BindView(R.id.sh_edparch)
    EditText shEdparch;
    @BindView(R.id.sh_recycle)
    RecyclerView shRecycle;

    @BindView(R.id.sh_rlrecommend)
    RelativeLayout sh_rlrecommend;

    @BindView(R.id.sh_imgnone)
    ImageView sh_imgnone;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.grid_school)
    GridView gridSchool;
    @BindView(R.id.grid_major)
    GridView gridMajor;

    private SearchPresent searchPresent;
    private Search_Adapter search_adapter;

    private List<HotBean> schoollist;
    private List<HotBean> majorlist;

    @Override
    public int getId() {
        return R.layout.activity_search_particulars;
    }

    @Override
    public void InIt() {
        schoollist=new ArrayList<>();
        majorlist=new ArrayList<>();
        searchPresent = new SearchPresent(this);
        searchPresent.queryHot();
        shRecycle.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        searchPresent.onDestory();
    }

    @OnClick({R.id.sh_iv_back, R.id.sh_tvsearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sh_iv_back:
                finish();
                break;
            case R.id.sh_tvsearch:
                String name = shEdparch.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast("关键字不能为空");
                    return;
                }
                searchPresent.searchmajorCollege(name);
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                break;
        }
    }

    @Override
    public void SearchSuccess(List<SearchBean> list) {
        sh_rlrecommend.setVisibility(View.GONE);
        shRecycle.setVisibility(View.VISIBLE);
        if (list != null && list.size() > 0) {
            sh_imgnone.setVisibility(View.GONE);
            if (search_adapter == null) {
                search_adapter = new Search_Adapter(this, list);
                shRecycle.setAdapter(search_adapter);
            } else {
                search_adapter.Refresh(list);
            }
            searchPresent.hotsave(shEdparch.getText().toString());
        } else {
            shRecycle.setVisibility(View.GONE);
            sh_imgnone.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void SearchFail(String msg) {
        Toast(msg);
    }

    @Override
    public void HotSuccess(List<HotBean> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getHotType().equals("0")) {
                    schoollist.add(list.get(i));
                } else {
                    majorlist.add(list.get(i));
                }
            }
        }
        HotAdapter school = new HotAdapter(this, schoollist);
        HotAdapter major = new HotAdapter(this, majorlist);

        gridSchool.setAdapter(school);
        gridMajor.setAdapter(major);


    }

    @Override
    public void HotFail(String msg) {

    }



}

package com.example.login_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import adapter.RecommendRecycleViewAdapter;
import base.BaseActivity;
import base.BaseApi;
import base.BaseBean;
import bean.NewsBean;
import bean.RecommendBean;
import bean.SlideshowBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.CollegeTitlePresent;
import view.CollegeTitleView;

public class CollegeTitleActivity extends BaseActivity implements CollegeTitleView {


    @BindView(R.id.college_iv_back)
    ImageView collegeIvBack;
    @BindView(R.id.college_xbanner)
    XBanner collegeXbanner;
    @BindView(R.id.college_tv_one)
    TextView collegeTvOne;
    @BindView(R.id.view_studentin1)
    View viewStudentin1;
    @BindView(R.id.college_rl_one)
    RelativeLayout collegeRlOne;
    @BindView(R.id.college_tv_two)
    TextView collegeTvTwo;
    @BindView(R.id.view_studentin)
    View viewStudentin;
    @BindView(R.id.college_rl_two)
    RelativeLayout collegeRlTwo;
    @BindView(R.id.college_ll)
    LinearLayout collegeLl;
    @BindView(R.id.college_rv)
    RecyclerView collegeRv;
    @BindView(R.id.rll_da)
    RelativeLayout rllDa;
    @BindView(R.id.college_progress)
    ProgressBar collegeProgress;
    private CollegeTitlePresent collegeTitlePresent;
    private ArrayList<RecommendBean> recommendList;

    @Override
    public int getId() {
        return R.layout.activity_college_title;
    }

    @Override
    public void InIt() {
        rllDa.setVisibility(View.GONE);
        collegeTitlePresent = new CollegeTitlePresent(this);
        collegeTitlePresent.CollegeTitlePresent(6);
        collegeTitlePresent.CollegeNewsPresent("高考新闻", "全国", "1", "6");
    }

    @OnClick(R.id.college_iv_back)
    public void onViewClicked() {
        finish();
    }


    @OnClick({R.id.college_rl_one, R.id.college_rl_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.college_rl_one:
                collegeProgress.setVisibility(View.VISIBLE);
                collegeTvOne.setTextColor(Color.BLACK);
                collegeTvTwo.setTextColor(Color.GRAY);
                viewStudentin1.setVisibility(View.VISIBLE);
                viewStudentin.setVisibility(View.GONE);
                if (recommendList != null && recommendList.size() > 0) {
                    recommendList.clear();
                }
                collegeTitlePresent.CollegeNewsPresent("高考新闻", "全国", "1", "6");
                break;

            case R.id.college_rl_two:
                collegeProgress.setVisibility(View.VISIBLE);
                collegeTvOne.setTextColor(Color.GRAY);
                collegeTvTwo.setTextColor(Color.BLACK);
                viewStudentin1.setVisibility(View.GONE);
                viewStudentin.setVisibility(View.VISIBLE);
                if (recommendList != null && recommendList.size() > 0) {
                    recommendList.clear();
                }
                collegeTitlePresent.CollegeNewsPresent("高考轶事", "全国", "1", "6");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        collegeTitlePresent.onDestory();
    }

    @Override
    public void CollegeTitlesuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
        final ArrayList<String> list = new ArrayList<>();
        List<SlideshowBean> data = listBaseBean.data;
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getExtimg().toString());
        }
        collegeXbanner.setData(list, null);
        collegeXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(CollegeTitleActivity.this).load(BaseApi.ImgApi + list.get(position).toString()).into((ImageView) view);
            }
        });
    }

    @Override
    public void CollegeTitlefail(Throwable t) {

    }

    @Override
    public void CollegeNewssuccess(BaseBean<NewsBean> newsBeanBaseBean) {

        recommendList = new ArrayList<>();
        NewsBean data = newsBeanBaseBean.data;

        List<NewsBean.ListBean> list = data.getList();
        if(list!=null&&list.size()>0){
            collegeProgress.setVisibility(View.GONE);
            rllDa.setVisibility(View.VISIBLE);
            for (int i = 0; i < list.size(); i++) {
                recommendList.add(new RecommendBean(BaseApi.ImgApi + list.get(i).getPicture(), list.get(i).getTitle(), list.get(i).getNewsId(), list.get(i).getDate(), list.get(i).getGeneral()));
            }
            RecommendRecycleViewAdapter recommendRecycleViewAdapter = new RecommendRecycleViewAdapter(recommendList, CollegeTitleActivity.this);
            collegeRv.setLayoutManager(new LinearLayoutManager(CollegeTitleActivity.this));
            collegeRv.setAdapter(recommendRecycleViewAdapter);
            collegeRv.setNestedScrollingEnabled(false);
        }

    }

    @Override
    public void CollegeNewsfail(Throwable t) {

    }


}

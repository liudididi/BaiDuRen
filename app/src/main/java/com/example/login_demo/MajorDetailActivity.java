package com.example.login_demo;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.weavey.loading.lib.LoadingLayout;

import java.util.List;

import base.BaseActivity;
import base.BaseBean;
import bean.CollerMajorBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.Majorgk_Fragment;
import fragment.Majorqj_Fragment;
import fragment.Majorschool_Fragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;
import untils.SPUtils;

public class MajorDetailActivity extends BaseActivity {
    @BindView(R.id.md_tvtitle)
    TextView mdTvtitle;
    @BindView(R.id.mschool_iv_back)
    ImageView mschoolIvBack;
    @BindView(R.id.md_vgk)
    View mdVgk;
    @BindView(R.id.md_rlgk)
    RelativeLayout mdRlgk;
    @BindView(R.id.md_vqj)
    View mdVqj;
    @BindView(R.id.md_rlqj)
    RelativeLayout mdRlqj;
    @BindView(R.id.md_vyx)
    View mdVyx;
    @BindView(R.id.md_rlyx)
    RelativeLayout mdRlyx;
    @BindView(R.id.md_fl)
    FrameLayout mdfl;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    @BindView(R.id.mmajorll)
    LinearLayout mmajorll;
    @BindView(R.id.lodiing)
    LoadingLayout lodiing;
    private String major;
    public static String majorid;
    private Majorgk_Fragment majorgk_fragment;
    private Fragment currentFragment;
    private Majorqj_Fragment majorqj_fragment;
    private Majorschool_Fragment majorschool_fragment;
    private String token;
    private DisposableSubscriber<BaseBean> disposableSubscriber;
    private DisposableSubscriber<BaseBean<List<CollerMajorBean>>> disposableSubscriber2;
    private ConnectionChangeReceiver myReceiver;

    @Override
    public int getId() {
        return R.layout.activity_major_detail;
    }

    @Override
    public void InIt() {
        loadingLayout=lodiing;
        registerReceiver();
        major = getIntent().getStringExtra("major");
        majorid = getIntent().getStringExtra("majorid");
        mdTvtitle.setText(major);
        initfragment();
        switchFragment(majorgk_fragment).commitAllowingStateLoss();
        token = (String) SPUtils.get(MyApp.context, "token", "");
        iscollect();
    }

    private void initfragment() {
        majorgk_fragment = new Majorgk_Fragment();
        majorqj_fragment = new Majorqj_Fragment();
        majorschool_fragment = new Majorschool_Fragment();

    }


    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.md_fl, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

    @OnClick({R.id.mschool_iv_back, R.id.md_rlgk, R.id.md_rlqj, R.id.md_rlyx, R.id.img_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mschool_iv_back:
                finish();
                break;
            case R.id.img_collect:
                collect();
                break;
            case R.id.md_rlgk:
                mdVgk.setVisibility(View.VISIBLE);
                mdVqj.setVisibility(View.GONE);
                mdVyx.setVisibility(View.GONE);
                switchFragment(majorgk_fragment).commitAllowingStateLoss();

                break;
            case R.id.md_rlqj:
                mdVgk.setVisibility(View.GONE);
                mdVqj.setVisibility(View.VISIBLE);
                mdVyx.setVisibility(View.GONE);
                switchFragment(majorqj_fragment).commitAllowingStateLoss();

                break;
            case R.id.md_rlyx:
                mdVgk.setVisibility(View.GONE);
                mdVqj.setVisibility(View.GONE);
                mdVyx.setVisibility(View.VISIBLE);
                switchFragment(majorschool_fragment).commitAllowingStateLoss();
                break;
        }
    }

    private void collect() {
        if (token.length() > 4) {
            collecta("1", majorid, token);
        } else {
            Toast("登录后才能收藏哦~");
        }
    }

    public void collecta(String type, String name, String token) {

        disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().collect(type, name, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        Toast.makeText(MyApp.context, baseBean.msg, Toast.LENGTH_SHORT).show();
                        if (baseBean.msg.equals("收藏成功")) {
                            Glide.with(MajorDetailActivity.this).load(R.drawable.collect_yes).into(imgCollect);
                        } else {
                            Glide.with(MajorDetailActivity.this).load(R.drawable.collect_none).into(imgCollect);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposableSubscriber != null) {
            disposableSubscriber.dispose();
        }
        if (disposableSubscriber2 != null) {
            disposableSubscriber2.dispose();
        }
        unregisterReceiver();
    }

    public void iscollect() {
        disposableSubscriber2 = MyQusetUtils.getInstance()
                .getQuestInterface().getiscollet(majorid, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean<List<CollerMajorBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<CollerMajorBean>> listBaseBean) {

                        if (listBaseBean.code == 0) {
                            List<CollerMajorBean> data = listBaseBean.data;
                            if (data != null && data.size() > 0) {
                                String collectionTime = data.get(0).getCollectionTime();
                                if (collectionTime != null && collectionTime.length() > 2) {
                                    Glide.with(MajorDetailActivity.this).load(R.drawable.collect_yes).into(imgCollect);
                                } else {
                                    Glide.with(MajorDetailActivity.this).load(R.drawable.collect_none).into(imgCollect);
                                }
                            }

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
                    mdfl.setVisibility(View.GONE);
                } else {
                    mdfl.setVisibility(View.VISIBLE);
                    loadingLayout.setStatus(LoadingLayout.Success);
                    mdVgk.setVisibility(View.VISIBLE);
                    mdVqj.setVisibility(View.GONE);
                    mdVyx.setVisibility(View.GONE);
                    initfragment();
                    switchFragment(majorgk_fragment).commitAllowingStateLoss();
                    token = (String) SPUtils.get(MyApp.context, "token", "");
                    iscollect();
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

package com.example.login_demo;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;
import com.weavey.loading.lib.LoadingLayout;

import java.util.List;

import base.BaseActivity;
import base.BaseApi;
import base.BaseBean;
import bean.CollerSchoolBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.School_Brochures;
import fragment.School_Enroll;
import fragment.School_Summary;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;
import untils.SPUtils;

public class SchoolDetailActivity extends BaseActivity {

    @BindView(R.id.schoold_name)
    TextView schooldName;

    @BindView(R.id.schoold_iv_back)
    ImageView schooldIvBack;
    @BindView(R.id.schoold_address)
    TextView schooldAddress;
    @BindView(R.id.schoold_two)
    TextView schooldTwo;
    @BindView(R.id.schoold_nine)
    TextView schooldNine;
    @BindView(R.id.schoold_yjs)
    TextView schooldYjs;
    @BindView(R.id.schoold_gfs)
    TextView schooldGfs;
    @BindView(R.id.schoold_zyjh)
    TextView schooldZyjh;

    @BindView(R.id.schoold_lq)
    TextView schooldLq;
    @BindView(R.id.schoold_jj)
    TextView schooldJj;
    @BindView(R.id.schoold_zsjz)
    TextView schooldZsjz;
    @BindView(R.id.school_fl)
    FrameLayout schoolFl;
    @BindView(R.id.schoold_collect)
    ImageView schooldCollect;
    @BindView(R.id.schooldIvdoor)
    ImageView shoolidIvdoor;

    @BindView(R.id.schoold_icon)
    CustomShapeImageView schoolicon;
    @BindView(R.id.lodiing)
    LoadingLayout lodiing;
    @BindView(R.id.schoold_rl)
    RelativeLayout schooldRl;
    @BindView(R.id.schoold_v)
    View schooldV;
    @BindView(R.id.schoold_rl2)
    RelativeLayout schooldRl2;
    private School_Summary school_summary;
    private Fragment currentFragment;
    private String token;
    public static String schoolname;
    private DisposableSubscriber<BaseBean<List<CollerSchoolBean>>> disposableSubscriber;
    public static String shsd = null;
    public static String bhsd = null;
    private School_Enroll school_enroll;
    private School_Brochures school_brochures;

    private ConnectionChangeReceiver myReceiver;

    @Override
    public int getId() {
        return R.layout.activity_school_detail;
    }

    @Override
    public void InIt() {
        loadingLayout=lodiing;
        registerReceiver();
        initfragment();
        token = (String) SPUtils.get(MyApp.context, "token", "");
        schoolname = getIntent().getStringExtra("schoolname");
        schooldName.setText(schoolname);
        iscollect();
        info();
        switchFragment(school_enroll).commitAllowingStateLoss();

    }

    private void info() {

    }

    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.school_fl, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

    private void initfragment() {
        school_summary = new School_Summary();
        school_enroll = new School_Enroll();

        school_brochures = new School_Brochures();
    }


    @OnClick({R.id.schoold_iv_back, R.id.schoold_lq, R.id.schoold_jj, R.id.schoold_zsjz, R.id.schoold_collect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.schoold_iv_back:
                finish();
                break;
            case R.id.schoold_lq:
                schooldLq.setTextColor(Color.WHITE);
                schooldLq.setBackgroundResource(R.drawable.back_schooldlan);


                schooldJj.setTextColor(Color.BLACK);
                schooldJj.setBackgroundResource(R.drawable.back_schoold);

                schooldZsjz.setTextColor(Color.BLACK);
                schooldZsjz.setBackgroundResource(R.drawable.back_schoold);
                switchFragment(school_enroll).commitAllowingStateLoss();

                break;
            case R.id.schoold_jj:

                schooldLq.setTextColor(Color.BLACK);
                schooldLq.setBackgroundResource(R.drawable.back_schoold);


                schooldJj.setTextColor(Color.WHITE);
                schooldJj.setBackgroundResource(R.drawable.back_schooldlan);

                schooldZsjz.setTextColor(Color.BLACK);
                schooldZsjz.setBackgroundResource(R.drawable.back_schoold);


                switchFragment(school_summary).commitAllowingStateLoss();
                break;
            case R.id.schoold_zsjz:


                schooldLq.setTextColor(Color.BLACK);
                schooldLq.setBackgroundResource(R.drawable.back_schoold);


                schooldJj.setTextColor(Color.BLACK);
                schooldJj.setBackgroundResource(R.drawable.back_schoold);

                schooldZsjz.setTextColor(Color.WHITE);
                schooldZsjz.setBackgroundResource(R.drawable.back_schooldlan);

                switchFragment(school_brochures).commitAllowingStateLoss();

                break;


            case R.id.schoold_collect:
                collect();
                break;
        }
    }


    public void collect() {
        if (token == null || token.length() < 4) {
            Toast("用户未登录");
            return;
        }
        MyQusetUtils.getInstance()
                .getQuestInterface().collect("0", schoolname, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        Toast.makeText(MyApp.context, baseBean.msg, Toast.LENGTH_SHORT).show();
                        if (baseBean.msg.equals("收藏成功")) {
                            Glide.with(SchoolDetailActivity.this).load(R.drawable.collect_yes).into(schooldCollect);
                        } else {
                            Glide.with(SchoolDetailActivity.this).load(R.drawable.collect_none).into(schooldCollect);
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

    public void iscollect() {
        disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getchoolisscollet(schoolname, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<CollerSchoolBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<CollerSchoolBean>> listBaseBean) {
                        if (listBaseBean.code == 0) {
                            List<CollerSchoolBean> data = listBaseBean.data;
                            if (data != null && data.size() > 0) {
                                String collectionTime = data.get(0).getCollectionTime();
                                if (collectionTime != null && collectionTime.length() > 2) {
                                    Glide.with(SchoolDetailActivity.this).load(R.drawable.collect_yes).into(schooldCollect);
                                } else {
                                    Glide.with(SchoolDetailActivity.this).load(R.drawable.collect_none).into(schooldCollect);
                                }
                                String two = data.get(0).getTwo();
                                if (two != null && two.length() > 1) {
                                    schooldTwo.setVisibility(View.VISIBLE);
                                } else {
                                    schooldTwo.setVisibility(View.INVISIBLE);
                                }
                                String nine = data.get(0).getNine();
                                if (nine != null && nine.length() > 1) {
                                    schooldNine.setVisibility(View.VISIBLE);
                                } else {
                                    schooldNine.setVisibility(View.INVISIBLE);
                                }

                                String door = data.get(0).getDoor();

                                if (door != null) {
                                    Glide.with(SchoolDetailActivity.this).load(BaseApi.ImgApi + door).into(shoolidIvdoor);
                                }

                                String url = data.get(0).getUrl();
                                if (url != null) {
                                    Glide.with(SchoolDetailActivity.this).load(BaseApi.ImgApi + url).into(schoolicon);
                                }
                                String preeminentPlan = data.get(0).getPreeminentPlan();
                                if (preeminentPlan != null && preeminentPlan.length() > 1) {
                                    schooldZyjh.setVisibility(View.VISIBLE);
                                } else {
                                    schooldZyjh.setVisibility(View.INVISIBLE);
                                }
                                String defenseStudent = data.get(0).getDefenseStudent();
                                if (defenseStudent != null && defenseStudent.length() > 1) {
                                    schooldGfs.setVisibility(View.VISIBLE);
                                } else {
                                    schooldGfs.setVisibility(View.INVISIBLE);
                                }
                                String address = data.get(0).getAddress();
                                if (address != null && address.length() > 1) {
                                    schooldAddress.setText(address);
                                } else {
                                    schooldAddress.setText("");
                                }

                                String graduate = data.get(0).getGraduate();
                                if (graduate != null && graduate.length() > 1) {
                                    schooldYjs.setVisibility(View.VISIBLE);
                                } else {
                                    schooldYjs.setVisibility(View.INVISIBLE);
                                }
                                String shuoshi = data.get(0).getShuoshi();
                                if (shuoshi != null) {
                                    shsd = shuoshi;
                                }
                                String boshi = data.get(0).getBoshi();
                                if (boshi != null) {
                                    bhsd = boshi;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposableSubscriber != null) {
            disposableSubscriber.dispose();
        }
        unregisterReceiver();
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
                    schoolFl.setVisibility(View.GONE);
                } else {
                    schoolFl.setVisibility(View.VISIBLE);
                    schooldLq.setTextColor(Color.WHITE);
                    schooldLq.setBackgroundResource(R.drawable.back_schooldlan);


                    schooldJj.setTextColor(Color.BLACK);
                    schooldJj.setBackgroundResource(R.drawable.back_schoold);

                    schooldZsjz.setTextColor(Color.BLACK);
                    schooldZsjz.setBackgroundResource(R.drawable.back_schoold);
                    initfragment();
                    token = (String) SPUtils.get(MyApp.context, "token", "");
                    schoolname = getIntent().getStringExtra("schoolname");
                    schooldName.setText(schoolname);
                    iscollect();
                    info();
                    switchFragment(school_enroll).commitAllowingStateLoss();
                    loadingLayout.setStatus(LoadingLayout.Success);
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

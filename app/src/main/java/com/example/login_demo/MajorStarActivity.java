package com.example.login_demo;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import adapter.GridjobinfoAdapter;
import adapter.MarjorViewpageradpter;
import base.BaseActivity;
import base.BaseApi;
import base.BaseBean;
import bean.MajorstatXQBean;
import bean.jobStarBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.MajorStartFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import untils.MyQusetUtils;
import untils.NetInterceptor;
import untils.QuestInterface;
import untils.Rotatable;
import untils.SPUtils;

public class MajorStarActivity extends BaseActivity {


    @BindView(R.id.majorstar_iv_back)
    ImageView majorstarIvBack;
    @BindView(R.id.major_vp)
    ViewPager majorVp;
    @BindView(R.id.imtwjj)
    ImageView imtwjj;


    @BindView(R.id.mstartxzone)
    TextView mstartxzone;
    @BindView(R.id.mstartxhone)
    ImageView mstartxhone;
    @BindView(R.id.mstartywone)
    ImageView mstartywone;
    @BindView(R.id.mstartrlone)
    RelativeLayout mstartrlone;

    @BindView(R.id.mstartxztwo)
    TextView mstartxztwo;
    @BindView(R.id.mstartxhtwo)
    ImageView mstartxhtwo;
    @BindView(R.id.mstartywtwo)
    ImageView mstartywtwo;
    @BindView(R.id.mstartrltwo)
    RelativeLayout mstartrltwo;

    @BindView(R.id.mstartxzsan)
    TextView mstartxzsan;
    @BindView(R.id.mstartxhsan)
    ImageView mstartxhsan;
    @BindView(R.id.mstartywsan)
    ImageView mstartywsan;
    @BindView(R.id.mstartrlsan)
    RelativeLayout mstartrlsan;

    @BindView(R.id.mstartxzsi)
    TextView mstartxzsi;
    @BindView(R.id.mstartxhsi)
    ImageView mstartxhsi;
    @BindView(R.id.mstartywsi)
    ImageView mstartywsi;
    @BindView(R.id.mstartrlsi)
    RelativeLayout mstartrlsi;

    @BindView(R.id.mstartxzwu)
    TextView mstartxzwu;
    @BindView(R.id.mstartxhwu)
    ImageView mstartxhwu;
    @BindView(R.id.mstartywwu)
    ImageView mstartywwu;
    @BindView(R.id.mstartrlwu)
    RelativeLayout mstartrlwu;

    @BindView(R.id.mstartxzliu)
    TextView mstartxzliu;
    @BindView(R.id.mstartxhliu)
    ImageView mstartxhliu;
    @BindView(R.id.mstartywliu)
    ImageView mstartywliu;
    @BindView(R.id.mstartrlliu)
    RelativeLayout mstartrlliu;
    @BindView(R.id.mstartbtone)
    TextView mstartbtone;
    @BindView(R.id.mstartbttwo)
    TextView mstartbttwo;
    @BindView(R.id.mstartbtsan)
    TextView mstartbtsan;
    @BindView(R.id.mstartbtsi)
    TextView mstartbtsi;
    @BindView(R.id.mstartbtwu)
    TextView mstartbtwu;
    @BindView(R.id.mstartbtliu)
    TextView mstartbtliu;
    @BindView(R.id.tvmajor1)
    TextView tvmajor1;
    @BindView(R.id.maindex_yi)
    ImageView maindexYi;
    @BindView(R.id.maindex_er)
    ImageView maindexEr;
    @BindView(R.id.maindex_san)
    ImageView maindexSan;
    @BindView(R.id.rlyindao)
    RelativeLayout rlyindao;
    @BindView(R.id.majorstarbyes)
    Button majorstarbyes;
    @BindView(R.id.major_tvtishi)
    TextView majorTvtishi;


    private List<MajorStartFragment> fraglist;

    public static TextView scnum;


    private RelativeLayout rlCardRoot;
    private RelativeLayout imageViewBack;
    private RelativeLayout imageViewFront;
    private List<TextView> titlelist;
    private List<ImageView> xhlist;
    private List<ImageView> ywlist;
    private List<RelativeLayout> rllist;
    public static List<jobStarBean> answerllist = new ArrayList<>();
    private List<TextView> xzlist;
    private int a;


    @Override
    public int getId() {
        return R.layout.activity_major_star;
    }

    @Override
    public void InIt() {
        Boolean majorindex = (Boolean) SPUtils.get(MyApp.context, "majorindex", false);
        if (majorindex == false) {
            majorTvtishi.setVisibility(View.GONE);
            rlyindao.setVisibility(View.VISIBLE);
            majorstarbyes.setVisibility(View.GONE);
            rlyindao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (a == 0) {
                        maindexYi.setVisibility(View.GONE);
                        maindexEr.setVisibility(View.VISIBLE);
                        a += 1;
                    } else if (a == 1) {
                        maindexEr.setVisibility(View.GONE);
                        maindexSan.setVisibility(View.VISIBLE);
                        a += 1;
                    } else {
                        rlyindao.setVisibility(View.GONE);
                        majorstarbyes.setVisibility(View.VISIBLE);
                        majorTvtishi.setVisibility(View.VISIBLE);
                        SPUtils.put(MyApp.context, "majorindex", true);
                    }
                }
            });

        } else {
            rlyindao.setVisibility(View.GONE);
            majorstarbyes.setVisibility(View.VISIBLE);
            majorTvtishi.setVisibility(View.VISIBLE);
        }

        //卡片
        rlCardRoot = findViewById(R.id.rl_card_root);
        imageViewBack = findViewById(R.id.imageView_back);
        imageViewFront = findViewById(R.id.imageView_front);
        ImageView majorstar = findViewById(R.id.majorstar_iv_back);
        majorstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setCameraDistance();
        imtwjj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardTurnover();
            }
        });
        //集合
        initlist();
        scnum = findViewById(R.id.scnum);
        //请求专业
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < startfenleiActivity.fenlieanswerlist.size(); i++) {
            System.out.println("data==" + startfenleiActivity.fenlieanswerlist.get(i));
            map.put(startfenleiActivity.fenlieanswerlist.get(i), "");
        }
        Gson gson = new Gson();
        String route = gson.toJson(map);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR_LOG)
                .addInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)
                .addNetworkInterceptor(NetInterceptor.REWRITE_RESPONSE_INTERCEPTOR)
                .addInterceptor(NetInterceptor.REWRITE_RESPONSE_MYINTERCEPTOR)
                .connectTimeout(MyQusetUtils.TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(MyQusetUtils.TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(MyQusetUtils.TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseApi.Api)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QuestInterface questInterface = retrofit.create(QuestInterface.class);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), route);
        Call<BaseBean<List<jobStarBean>>> baseBeanCall = questInterface.jobsStarMajorMobil("CAS", "INFP", "1", body);
        baseBeanCall.enqueue(new Callback<BaseBean<List<jobStarBean>>>() {
            @Override
            public void onResponse(Call<BaseBean<List<jobStarBean>>> call, Response<BaseBean<List<jobStarBean>>> response) {
                final BaseBean<List<jobStarBean>> body = response.body();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (body.code == 0) {
                            List<jobStarBean> data = body.data;
                            if (data != null && data.size()>= 20) {
                                majorTvtishi.setVisibility(View.GONE);
                                List<jobStarBean> list1 = new ArrayList<>();
                                for (int i = 0; i < data.size(); i++) {
                                    data.get(i).xh = false;
                                    if (i >= 0 && i < 3) {
                                        list1.add(data.get(i));
                                    }
                                }
                                fraglist = new ArrayList<>();
                                List<jobStarBean> list2 = new ArrayList<>();
                                for (int i = 3; i < 6; i++) {
                                    list2.add(data.get(i));
                                }
                                List<jobStarBean> list3 = new ArrayList<>();
                                for (int i = 6; i < 9; i++) {
                                    list3.add(data.get(i));
                                }
                                List<jobStarBean> list4 = new ArrayList<>();
                                for (int i = 9; i < 12; i++) {
                                    list4.add(data.get(i));
                                }
                                List<jobStarBean> list5 = new ArrayList<>();
                                for (int i = 12; i < 15; i++) {
                                    list5.add(data.get(i));
                                }
                                List<jobStarBean> list6 = new ArrayList<>();
                                for (int i = 15; i < 18; i++) {
                                    list6.add(data.get(i));
                                }
                                List<jobStarBean> list7 = new ArrayList<>();
                                for (int i = 18; i < 20; i++) {
                                    list7.add(data.get(i));
                                }
                                MajorStartFragment majorStartFragment1 = new MajorStartFragment();
                                majorStartFragment1.setList(list1);
                                MajorStartFragment majorStartFragment2 = new MajorStartFragment();
                                majorStartFragment2.setList(list2);
                                MajorStartFragment majorStartFragment3 = new MajorStartFragment();
                                majorStartFragment3.setList(list3);
                                MajorStartFragment majorStartFragment4 = new MajorStartFragment();
                                majorStartFragment4.setList(list4);
                                MajorStartFragment majorStartFragment5 = new MajorStartFragment();
                                majorStartFragment5.setList(list5);
                                MajorStartFragment majorStartFragment6 = new MajorStartFragment();
                                majorStartFragment6.setList(list6);
                                MajorStartFragment majorStartFragment7 = new MajorStartFragment();
                                majorStartFragment7.setList(list7);
                                fraglist.add(majorStartFragment1);
                                fraglist.add(majorStartFragment2);
                                fraglist.add(majorStartFragment3);
                                fraglist.add(majorStartFragment4);
                                fraglist.add(majorStartFragment5);
                                fraglist.add(majorStartFragment6);
                                fraglist.add(majorStartFragment7);
                                MarjorViewpageradpter marjorViewpageradpter = new MarjorViewpageradpter(getSupportFragmentManager(), fraglist);
                                majorVp.setAdapter(marjorViewpageradpter);
                                majorVp.setOffscreenPageLimit(6);

                            }else {
                             intent(MajorStarActivity.this,ProfessionStarActivity.class);
                                finish();
                            }
                        } else {
                            Toast(body.msg);
                        }


                    }
                });

            }

            @Override
            public void onFailure(Call<BaseBean<List<jobStarBean>>> call, Throwable t) {
                Toast(t.toString());

            }
        });
        majorstarbyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              intent(MajorStarActivity.this,ComlitEFCActivity.class);
               finish();
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        answerllist.clear();
        startfenleiActivity.fenlieanswerlist.clear();
        startfenleiActivity.fenlieanswerlist = null;
    }

    private void initlist() {
        titlelist = new ArrayList<>();
        titlelist.add(mstartbtone);
        titlelist.add(mstartbttwo);
        titlelist.add(mstartbtsan);
        titlelist.add(mstartbtsi);
        titlelist.add(mstartbtwu);
        titlelist.add(mstartbtliu);
        xhlist = new ArrayList<>();
        xhlist.add(mstartxhone);
        xhlist.add(mstartxhtwo);
        xhlist.add(mstartxhsan);
        xhlist.add(mstartxhsi);
        xhlist.add(mstartxhwu);
        xhlist.add(mstartxhliu);
        for (int i = 0; i < xhlist.size(); i++) {
            final int finalI = i;
            xhlist.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    answerllist.get(finalI).xh = false;
                    answerllist.remove(finalI);
                    scnum.setText(answerllist.size() + "");
                    for (int i1 = 0; i1 < fraglist.size(); i1++) {
                        fraglist.get(i1).onResume();
                    }
                    for (int j = 0; j < rllist.size(); j++) {
                        xhlist.get(j).setImageResource(R.drawable.bgxq);
                        rllist.get(j).setVisibility(View.INVISIBLE);
                    }
                    if (answerllist.size() != 0) {
                        for (int i = 0; i < answerllist.size(); i++) {
                            titlelist.get(i).setText(answerllist.get(i).getMajor());
                            rllist.get(i).setVisibility(View.VISIBLE);
                            List<jobStarBean.MajorinfoBean> majorinfo = answerllist.get(i).getMajorinfo();
                            if (majorinfo != null && majorinfo.size() > 0) {
                                xzlist.get(i).setText("￥" + majorinfo.get(0).getAveragesalary());
                            }

                        }
                    }

                }
            });
        }
        ywlist = new ArrayList<>();
        ywlist.add(mstartywone);
        ywlist.add(mstartywtwo);
        ywlist.add(mstartywsan);
        ywlist.add(mstartywsi);
        ywlist.add(mstartywwu);
        ywlist.add(mstartywliu);
        for (int i = 0; i < ywlist.size(); i++) {
            final int finalI = i;
            ywlist.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<jobStarBean.MajorinfoBean> majorinfo = answerllist.get(finalI).getMajorinfo();
                    if (majorinfo != null && majorinfo.size() > 0) {
                        tanchuang(answerllist.get(finalI).getMajor_id(), titlelist.get(finalI).getText().toString(), majorinfo.get(0).getAveragesalary() + "", MajorStarActivity.this);
                    } else {
                        Toast("暂无信息");
                    }
                }
            });
        }
        xzlist = new ArrayList<>();
        xzlist.add(mstartxzone);
        xzlist.add(mstartxztwo);
        xzlist.add(mstartxzsan);
        xzlist.add(mstartxzsi);
        xzlist.add(mstartxzwu);
        xzlist.add(mstartxzliu);
        rllist = new ArrayList<>();
        rllist.add(mstartrlone);
        rllist.add(mstartrltwo);
        rllist.add(mstartrlsan);
        rllist.add(mstartrlsi);
        rllist.add(mstartrlwu);
        rllist.add(mstartrlliu);


    }


    public static void tanchuang(String id, final String zhuan, final String xz, final Context context) {
        MyQusetUtils.getInstance().getQuestInterface().zyxq(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<MajorstatXQBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<MajorstatXQBean>> listBaseBean) {
                        if (listBaseBean.code == 0) {
                            if (listBaseBean.data != null && listBaseBean.data.size() > 0) {

                                MajorstatXQBean majorstatXQBean = listBaseBean.data.get(0);
                                final Dialog dialog = new Dialog(context, R.style.Theme_Light_Dialog);
                                View dialogView = LayoutInflater.from(context).inflate(R.layout.dialoglayout, null);
                                //获得dialog的window窗口
                                Window window = dialog.getWindow();
                                //设置dialog在屏幕底部
                                window.setGravity(Gravity.BOTTOM);
                                //设置dialog弹出时的动画效果，从屏幕底部向上弹出
                                window.setWindowAnimations(R.style.dialogStyle);
                                window.getDecorView().setPadding(0, 0, 0, 0);
                                //获得window窗口的属性
                                WindowManager.LayoutParams lp = window.getAttributes();
                                //设置窗口宽度为充满全屏
                                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                                //设置窗口高度为包裹内容
                                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                                //将设置好的属性set回去
                                window.setAttributes(lp);
                                //将自定义布局加载到dialog上
                                dialog.setContentView(dialogView);
                                dialog.show();

                                TextView dlog_title = dialogView.findViewById(R.id.dlog_title);
                                dlog_title.setText(zhuan);
                                TextView dlog_xz = dialogView.findViewById(R.id.dlog_xz);
                                dlog_xz.setText("￥" + xz);

                                TextView tv_ranking = dialogView.findViewById(R.id.tv_ranking);
                                tv_ranking.setText(majorstatXQBean.getRanking());
                                TextView tv_address = dialogView.findViewById(R.id.tv_address);
                                tv_address.setText(majorstatXQBean.getNeed_address());

                                TextView tv_nearjob = dialogView.findViewById(R.id.tv_nearjob);
                                tv_nearjob.setText(majorstatXQBean.getNeed_major());
                                TextView tv_rank = dialogView.findViewById(R.id.tv_rank);
                                tv_rank.setText(majorstatXQBean.getRank());
                                TextView tv_pro_address = dialogView.findViewById(R.id.tv_pro_address);
                                tv_pro_address.setText(majorstatXQBean.getPro_address());
                                TextView tv_pro_job = dialogView.findViewById(R.id.tv_pro_job);
                                tv_pro_job.setText(majorstatXQBean.getPro_job());
                                TextView tv_direction_employment = dialogView.findViewById(R.id.tv_direction_employment);
                                tv_direction_employment.setText(majorstatXQBean.getDirection_employment());
                                TextView dlog_pymb = dialogView.findViewById(R.id.dlog_pymb);
                                dlog_pymb.setText(majorstatXQBean.getTraining_target());
                                List<MajorstatXQBean.JobinfoBean> jobinfo = majorstatXQBean.getJobinfo();
                                GridView grid_jobinfo = dialogView.findViewById(R.id.grid_jobinfo);
                                ImageView dilog_chahao = dialogView.findViewById(R.id.dilog_chahao);
                                dilog_chahao.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.cancel();
                                    }
                                });
                                if (jobinfo != null && jobinfo.size() > 0) {
                                    GridjobinfoAdapter gridjobinfoAdapter = new GridjobinfoAdapter(jobinfo, context);
                                    grid_jobinfo.setAdapter(gridjobinfoAdapter);
                                }
                            } else {
                                Toast.makeText(context, "暂无数据", Toast.LENGTH_SHORT).show();
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


    //卡片代码
    private void setCameraDistance() {
        int distance = 10000;
        float scale = getResources().getDisplayMetrics().density * distance;
        rlCardRoot.setCameraDistance(scale);
    }

    /**
     * 翻牌
     */
    public void cardTurnover() {
        if (View.VISIBLE == imageViewBack.getVisibility()) {
            //  ViewHelper.setRotationY(imageViewFront, 180f);//先翻转180，转回来时就不是反转的了
            for (int i = 0; i < rllist.size(); i++) {

                rllist.get(i).setVisibility(View.INVISIBLE);

            }

            for (int i = 0; i < answerllist.size(); i++) {
                titlelist.get(i).setText(answerllist.get(i).getMajor());
                rllist.get(i).setVisibility(View.VISIBLE);
                List<jobStarBean.MajorinfoBean> majorinfo = answerllist.get(i).getMajorinfo();
                if (majorinfo != null && majorinfo.size() > 0) {
                    xzlist.get(i).setText("￥" + majorinfo.get(0).getAveragesalary());
                }
            }
            ObjectAnimator icon_anim = ObjectAnimator.ofFloat(imageViewFront, "rotationY", 0.0F, 180.0F);
            icon_anim.setRepeatCount(1);
            icon_anim.setDuration(0);
            icon_anim.start();
            Rotatable rotatable = new Rotatable.Builder(rlCardRoot)
                    .sides(R.id.imageView_back, R.id.imageView_front)
                    .direction(Rotatable.ROTATE_Y)
                    .rotationCount(1)
                    .build();
            rotatable.setTouchEnable(false);
            rotatable.rotate(Rotatable.ROTATE_Y, -180, 1000);


        } else if (View.VISIBLE == imageViewFront.getVisibility()) {
            Rotatable rotatable = new Rotatable.Builder(rlCardRoot)
                    .sides(R.id.imageView_back, R.id.imageView_front)
                    .direction(Rotatable.ROTATE_Y)
                    .rotationCount(1)
                    .build();
            rotatable.setTouchEnable(false);
            rotatable.rotate(Rotatable.ROTATE_Y, 0, 1000);

        }
    }



}

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.MarjorViewpageradpter;
import base.BaseActivity;
import bean.MajorstatBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.MajorStartFragment;
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


    private List<MajorStartFragment> fraglist;

    public static TextView scnum;


    private RelativeLayout rlCardRoot;
    private RelativeLayout imageViewBack;
    private RelativeLayout imageViewFront;
    private List<TextView> titlelist;
    private List<ImageView> xhlist;
    private List<ImageView> ywlist;
    private List<RelativeLayout> rllist;
    public static List<MajorstatBean> answerllist = new ArrayList<>();
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
                        SPUtils.put(MyApp.context, "majorindex", true);
                    }
                }
            });

        } else {
            rlyindao.setVisibility(View.GONE);
            majorstarbyes.setVisibility(View.VISIBLE);
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

        // 加点
        scnum = findViewById(R.id.scnum);
        fraglist = new ArrayList<>();
        List<MajorstatBean> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "会计";
            majorstatBean.xinzi = "5665" + i;
            majorstatBean.xh = false;
            majorstatBean.mubiao = "一个亿";
            list1.add(majorstatBean);
        }
        List<MajorstatBean> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56652";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list2.add(majorstatBean);
        }

        List<MajorstatBean> list3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56653";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list3.add(majorstatBean);
        }

        List<MajorstatBean> list4 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56654";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list4.add(majorstatBean);
        }
        List<MajorstatBean> list5 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56655";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list5.add(majorstatBean);
        }
        List<MajorstatBean> list6 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56656";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list6.add(majorstatBean);
        }
        List<MajorstatBean> list7 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MajorstatBean majorstatBean = new MajorstatBean();
            majorstatBean.title = "程序员" + i;
            majorstatBean.xinzi = "56657";
            majorstatBean.mubiao = "二个亿";
            majorstatBean.xh = false;
            list7.add(majorstatBean);
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
                            titlelist.get(i).setText(answerllist.get(i).title);
                            rllist.get(i).setVisibility(View.VISIBLE);
                            xzlist.get(i).setText(answerllist.get(i).xinzi);
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
                    tanchuang(titlelist.get(finalI).getText().toString(), xzlist.get(finalI).getText().toString(), MajorStarActivity.this);
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


    public static void tanchuang(String zhuan, String xz, Context context) {
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
                titlelist.get(i).setText(answerllist.get(i).title);
                rllist.get(i).setVisibility(View.VISIBLE);
                xzlist.get(i).setText(answerllist.get(i).xinzi);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

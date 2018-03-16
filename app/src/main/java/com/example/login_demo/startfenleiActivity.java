package com.example.login_demo;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import bean.StartFl;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.StartFlPresent;
import view.StartFView;


public class startfenleiActivity extends BaseActivity  implements StartFView{
    @BindView(R.id.pro_iv_back)
    ImageView proIvBack;
    @BindView(R.id.start_imgfl)
    ImageView startImgfl;
    @BindView(R.id.pro_startv)
    TextView proStartv;
    @BindView(R.id.pro_startv1)
    TextView proStartv1;
    @BindView(R.id.starttv1)
    TextView starttv1;
    @BindView(R.id.starttv2)
    TextView starttv2;
    @BindView(R.id.starttv3)
    TextView starttv3;
    @BindView(R.id.starttv4)
    TextView starttv4;
    @BindView(R.id.starttv5)
    TextView starttv5;
    @BindView(R.id.starttv6)
    TextView starttv6;
    @BindView(R.id.starttv7)
    TextView starttv7;
    @BindView(R.id.starttv8)
    TextView starttv8;
    @BindView(R.id.starttv9)
    TextView starttv9;
    @BindView(R.id.starttv10)
    TextView starttv10;
    @BindView(R.id.starttv25)
    TextView starttv25;
    @BindView(R.id.starttv11)
    TextView starttv11;
    @BindView(R.id.starttv12)
    TextView starttv12;
    @BindView(R.id.starttv13)
    TextView starttv13;
    @BindView(R.id.starttv15)
    TextView starttv15;
    @BindView(R.id.starttv16)
    TextView starttv16;
    @BindView(R.id.starttv14)
    TextView starttv14;
    @BindView(R.id.starttv17)
    TextView starttv17;
    @BindView(R.id.starttv18)
    TextView starttv18;
    @BindView(R.id.starttv19)
    TextView starttv19;
    @BindView(R.id.starttv20)
    TextView starttv20;
    @BindView(R.id.starttv21)
    TextView starttv21;
    @BindView(R.id.starttv24)
    TextView starttv24;
    @BindView(R.id.starttv23)
    TextView starttv23;
    @BindView(R.id.starttv22)
    TextView starttv22;
    @BindView(R.id.pro_yes)
    Button proYes;
    @BindView(R.id.pro_rmzy)
    TextView proRmzy;
    @BindView(R.id.pro_shl)
    TextView proShl;
    @BindView(R.id.pro_lxgc)
    TextView proLxgc;
    @BindView(R.id.pro_ysrw)
    TextView proYsrw;
    @BindView(R.id.pro_zrl)
    TextView proZrl;
    @BindView(R.id.horizontalscroll)
    HorizontalScrollView horizontalscroll;
    private int min;
    private int max;
    private List<TextView> tvlist;
    public   static  List<String> fenlieanswerlist;
    private List<String> newlist;
    private String type;
    private String classify;
    private String fenlei="hot";
    private StartFlPresent startFlPresent;

    @Override
    public int getId() {
        return R.layout.activity_startfenlei;
    }

    @Override
    public void InIt() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int widthtPixels = dm.widthPixels;
        min = widthtPixels / 27;
        max = (int) (min * 1.5);
        inittvlist();
        type = getIntent().getStringExtra("type");
        classify = getIntent().getStringExtra("classify");
        startFlPresent = new StartFlPresent(this);
        startFlPresent.getStartfl(classify,type,fenlei);

        newlist = new ArrayList<>();
        fenlieanswerlist = new ArrayList<>();
        for (int i = 0; i < tvlist.size(); i++) {
            tvlist.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, min);
            tvlist.get(i).setText("");
            final int finalI = i;
            tvlist.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int textSize = (int) tvlist.get(finalI).getTextSize();
                    if (textSize == min) {
                        tvlist.get(finalI).setTextSize(TypedValue.COMPLEX_UNIT_PX, max);
                        fenlieanswerlist.add(tvlist.get(finalI).getText().toString());
                    } else {
                        tvlist.get(finalI).setTextSize(TypedValue.COMPLEX_UNIT_PX, min);
                        fenlieanswerlist.remove(tvlist.get(finalI).getText().toString());
                    }
                }
            });
        }
    }

    private void inittvlist() {
        tvlist = new ArrayList<>();
        tvlist.add(starttv1);
        tvlist.add(starttv2);
        tvlist.add(starttv3);
        tvlist.add(starttv4);
        tvlist.add(starttv5);
        tvlist.add(starttv6);
        tvlist.add(starttv7);
        tvlist.add(starttv8);
        tvlist.add(starttv9);
        tvlist.add(starttv10);
        tvlist.add(starttv11);
        tvlist.add(starttv12);
        tvlist.add(starttv13);
        tvlist.add(starttv14);
        tvlist.add(starttv15);
        tvlist.add(starttv16);
        tvlist.add(starttv17);
        tvlist.add(starttv18);
        tvlist.add(starttv19);
        tvlist.add(starttv20);
        tvlist.add(starttv21);
        tvlist.add(starttv22);
        tvlist.add(starttv23);
        tvlist.add(starttv24);
        tvlist.add(starttv25);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startFlPresent.onDestory();
    }

    @OnClick({R.id.pro_iv_back, R.id.start_imgfl, R.id.pro_yes, R.id.pro_rmzy, R.id.pro_shl, R.id.pro_lxgc, R.id.pro_ysrw, R.id.pro_zrl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pro_iv_back:
                finish();
                break;
            case R.id.start_imgfl:
              intent(this,ProfessionStarActivity.class);
              finish();
                break;
            case R.id.pro_yes:
                Intent intent=new Intent(this,MajorStarActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.pro_rmzy:
                fenlei="hot";
                startFlPresent.getStartfl(classify,type,fenlei);
                horizontalscroll.scrollTo(0,0);
                proRmzy.setTextColor(getResources().getColor(R.color.dialog_attention_explain_title));
                proShl.setTextColor(Color.WHITE);
                proLxgc.setTextColor(Color.WHITE);
                proYsrw.setTextColor(Color.WHITE);
                proZrl.setTextColor(Color.WHITE);
                break;
            case R.id.pro_shl:
                fenlei="society";
                startFlPresent.getStartfl(classify,type,fenlei);
                horizontalscroll.scrollTo(0,0);
                proShl.setTextColor(getResources().getColor(R.color.dialog_attention_explain_title));
                proRmzy.setTextColor(Color.WHITE);
                proLxgc.setTextColor(Color.WHITE);
                proYsrw.setTextColor(Color.WHITE);
                proZrl.setTextColor(Color.WHITE);
                break;
            case R.id.pro_lxgc:
                fenlei="engineer";
                startFlPresent.getStartfl(classify,type,fenlei);
                horizontalscroll.scrollTo(0,0);
                proLxgc.setTextColor(getResources().getColor(R.color.dialog_attention_explain_title));
                proShl.setTextColor(Color.WHITE);
                proRmzy.setTextColor(Color.WHITE);
                proYsrw.setTextColor(Color.WHITE);
                proZrl.setTextColor(Color.WHITE);
                break;
            case R.id.pro_ysrw:
                fenlei="art";
                startFlPresent.getStartfl(classify,type,fenlei);
                horizontalscroll.scrollTo(0,0);
                proYsrw.setTextColor(getResources().getColor(R.color.dialog_attention_explain_title));
                proLxgc.setTextColor(Color.WHITE);
                proShl.setTextColor(Color.WHITE);
                proRmzy.setTextColor(Color.WHITE);
                proZrl.setTextColor(Color.WHITE);
                break;
            case R.id.pro_zrl:
                fenlei="nature";
                startFlPresent.getStartfl(classify,type,fenlei);
                horizontalscroll.scrollTo(0,0);
                proZrl.setTextColor(getResources().getColor(R.color.dialog_attention_explain_title));
                proYsrw.setTextColor(Color.WHITE);
                proLxgc.setTextColor(Color.WHITE);
                proShl.setTextColor(Color.WHITE);
                proRmzy.setTextColor(Color.WHITE);
                break;
        }
    }


    @Override
    public void Stratjobsuccess(List<StartFl> list) {
     if(list!=null&&list.size()>0){
           newlist.clear();
         if(list.size()>25){
             for (int i = 0; i <25 ; i++) {
                 newlist.add(list.get(i).getJob());
             }
         }else {
             for (int i = 0; i <list.size() ; i++) {
                 newlist.add(list.get(i).getJob());
             }
         }
         for (int i = 0; i < newlist.size(); i++) {
             if (newlist.get(i) != null) {
                 tvlist.get(i).setText(newlist.get(i));
             }
             if (fenlieanswerlist.contains(newlist.get(i))) {
                 tvlist.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, max);
             } else {
                 tvlist.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, min);
             }
         }
     }

    }

    @Override
    public void Stratjobfail(String msg) {
Toast(msg);
    }
}

package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.Spinner_Adapter;
import base.BaseActivity;
import bean.GradePolyBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.GradePolyLinePresent;
import untils.SPUtils;
import untils.ZhiMaScoreViewDown;
import untils.ZhiMaScoreViewUP;
import view.GradePolyLineView;

public class GradePolyLineActivity extends BaseActivity  implements GradePolyLineView{

    @BindView(R.id.gradepl_iv_back)
    ImageView gradeplIvBack;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.re_up)
    RelativeLayout reUp;
    @BindView(R.id.re_down)
    RelativeLayout reDown;
    @BindView(R.id.tv_condition)
    TextView tvCondition;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_next)
    ImageView ivNext;

    private ZhiMaScoreViewUP zhiMaScoreViewUP;
    private String condtion;
    private ZhiMaScoreViewDown zhiMaScoreViewDown;
    private boolean msg=true;
    private ArrayList<String> list;
    private Spinner_Adapter spinner_adapter;
    @BindView(R.id.gradepl_lv)
    ListView gradepl_lv;
    private GradePolyLinePresent gradePolyLinePresent;
    private  int  min= 0;
    private  int  max= 150;
    private List<Integer> listfen;
    private int testType;
    private String token;

    @Override
    public int getId() {
        return R.layout.activity_grade_poly_line;
    }

    @Override
    public void InIt() {
        initlist();
        token = (String) SPUtils.get(MyApp.context, "token", "");
        gradePolyLinePresent = new GradePolyLinePresent(this);
        testType = getIntent().getIntExtra("testType",2);
        gradePolyLinePresent.getUserResultPng(testType,"", token);


     /*   if(listBaseBean!=null&&listBaseBean.size()>0){
            for (int i = 0; i <listBaseBean.size() ; i++) {
                if(listBaseBean.get(i).getScore()!=null){
                    listfen.set(i,Integer.parseInt(listBaseBean.get(0).getScore()));
                }
            }
        }*/



    }

    private void initlist() {
        list = new ArrayList<>();
        list.add("综合");
        list.add("语文");
        list.add("数学");
        list.add("外语");
        list.add("物理");
        list.add("化学");
        list.add("生物");
        list.add("历史");
        list.add("地理");
        list.add("政治");
        list.add("特长");
        listfen = new ArrayList<>();
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        listfen.add(0);
        spinner_adapter = new Spinner_Adapter(list, this);

        gradepl_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String str = list.get(i).toString();
                gradepl_lv.setVisibility(View.GONE);
                msg=true;
                ivRight.setVisibility(View.VISIBLE);
                ivNext.setVisibility(View.GONE);
                tvCondition.setText(str);
                listfen.clear();
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                listfen.add(0);
                if(tvCondition.getText().toString().equals("综合")){
                    gradePolyLinePresent.getUserResultPng(testType,"",token);
                }else {

                    gradePolyLinePresent.getUserResultPng(testType,tvCondition.getText().toString(),token);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list=null;
        listfen=null;
        gradePolyLinePresent.onDestory();
    }

    @OnClick({R.id.gradepl_iv_back, R.id.tv_condition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gradepl_iv_back:
                finish();
                break;
            case R.id.tv_condition:
                if(msg==true)
                {
                    gradepl_lv.setVisibility(View.VISIBLE);
                    gradepl_lv.setAdapter(spinner_adapter);
                    msg=false;
                    ivRight.setVisibility(View.GONE);
                    ivNext.setVisibility(View.VISIBLE);
                }
                else
                {
                    gradepl_lv.setVisibility(View.GONE);
                    msg=true;
                    ivRight.setVisibility(View.VISIBLE);
                    ivNext.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void GradePolysuccess(List<GradePolyBean> baseBean) {
     if(tvCondition.getText().toString().equals("综合")){
         max=750;
     }else {
         max=150;
     }
        reUp.removeAllViews();
        zhiMaScoreViewUP = new ZhiMaScoreViewUP(this);
        if(baseBean.size()>0&&baseBean!=null){
            for (int i = 0; i < baseBean.size(); i++) {
                listfen.set(baseBean.get(i).getTest_time()-1,baseBean.get(i).getNumber());
            }
        }
        ArrayList listup = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            listup.add(listfen.get(i));
        }
        zhiMaScoreViewUP.setlistfen(listup);
        zhiMaScoreViewUP.setMaxScore(max);
        zhiMaScoreViewUP.setMinScore(min);
        reUp.addView(zhiMaScoreViewUP);
        reDown.removeAllViews();
        zhiMaScoreViewDown = new ZhiMaScoreViewDown(this);
        List<Integer> listdown = new ArrayList<>();
        for (int i = 6; i <12 ; i++) {
            listdown.add(listfen.get(i));
        }
        zhiMaScoreViewDown.setlistfen(listdown);
        zhiMaScoreViewDown.setMaxScore(max);
        zhiMaScoreViewDown.setMinScore(min);
        reDown.addView(zhiMaScoreViewDown);
    }

    @Override
    public void GradePolyfail(String t) {

        if(tvCondition.getText().toString().equals("综合")){
            max=750;
        }else {
            max=150;
        }
        reUp.removeAllViews();
        zhiMaScoreViewUP = new ZhiMaScoreViewUP(this);
        ArrayList listup = new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            listup.add(listfen.get(i));
        }
        zhiMaScoreViewUP.setlistfen(listup);
        zhiMaScoreViewUP.setMaxScore(max);
        zhiMaScoreViewUP.setMinScore(min);
        reUp.addView(zhiMaScoreViewUP);
        reDown.removeAllViews();
        zhiMaScoreViewDown = new ZhiMaScoreViewDown(this);
        List<Integer> listdown = new ArrayList<>();
        for (int i = 6; i <12 ; i++) {
            listdown.add(listfen.get(i));
        }
        zhiMaScoreViewDown.setlistfen(listdown);
        zhiMaScoreViewDown.setMaxScore(max);
        zhiMaScoreViewDown.setMinScore(min);
        reDown.addView(zhiMaScoreViewDown);

    }
}

package com.example.login_demo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.SPUtils;

public class EstimateGradeActivity extends BaseActivity {

    @BindView(R.id.estimate_iv_back)
    ImageView estimateIvBack;
    @BindView(R.id.estimate_sparea)
    Spinner estimateSparea;
    @BindView(R.id.estimate_tvwen)
    TextView estimateTvwen;
    @BindView(R.id.estimate_tvli)
    TextView estimateTvli;
    @BindView(R.id.estimate_edgradefen)
    EditText estimateEdgradefen;
    @BindView(R.id.estimate_edgradepaiming)
    EditText estimateEdgradepaiming;
    @BindView(R.id.estimate_tvben)
    TextView estimateTvben;
    @BindView(R.id.estimate_tvzhuan)
    TextView estimateTvzhuan;
    @BindView(R.id.estimate_submit)
    TextView estimateSubmit;

    private List<String> arealist;
    private ArrayAdapter<String> area_adapter;
    private  String tbarea;
    private  String tbsubtype;
    private String  tbmaxfen;

    @Override
    public int getId() {
        return R.layout.activity_estimate_grade;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        if(tbmaxfen!=null&&tbmaxfen!=""){

        }else
        {
            tbmaxfen="500";
        }

        estimateEdgradefen.setText(tbmaxfen);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void InIt() {
    initsum();


        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arealist);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estimateSparea.setAdapter(area_adapter);
        estimateSparea.setDropDownVerticalOffset(100);
        estimateSparea.setSelection(0, false);
        estimateSparea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //拿到被选择项的值
                String  str = (String) estimateSparea.getSelectedItem();
                tbarea=str;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }

    private void initsum() {
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
        tbarea="北京市";
        tbsubtype="文科";

    }


    @OnClick({R.id.estimate_iv_back, R.id.estimate_tvwen, R.id.estimate_tvli, R.id.estimate_tvben, R.id.estimate_tvzhuan, R.id.estimate_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.estimate_iv_back:
                finish();
                break;
            case R.id.estimate_tvwen:
                estimateTvwen.setBackgroundResource(R.drawable.bg_subject3);
                estimateTvli.setBackgroundResource(R.drawable.bg_subject2);
                tbsubtype="文科";
                break;
            case R.id.estimate_tvli:
                estimateTvwen.setBackgroundResource(R.drawable.bg_subject2);
                estimateTvli.setBackgroundResource(R.drawable.bg_subject3);
                tbsubtype="理科";
                break;
            case R.id.estimate_tvben:
                 estimateTvben.setBackgroundResource(R.drawable.bg_subject3);
                 estimateTvzhuan.setBackgroundResource(R.drawable.bg_subject2);
                break;
            case R.id.estimate_tvzhuan:
                estimateTvben.setBackgroundResource(R.drawable.bg_subject2);
                estimateTvzhuan.setBackgroundResource(R.drawable.bg_subject3);
                break;
            case R.id.estimate_submit:
                String edfen = estimateEdgradefen.getText().toString();
                if(TextUtils.isEmpty(edfen)){
                    Toast("请填写预估分");
                    break;
                }
                if(Integer.parseInt(edfen)>750){
                    Toast("分数过高，糊弄自己呢");
                    break;
                }

                tbmaxfen=edfen;
             SPUtils.put(MyApp.context,"tbarea",tbarea);
             SPUtils.put(MyApp.context,"tbmaxfen",tbmaxfen);
             SPUtils.put(MyApp.context,"tbsubtype",tbsubtype);
             Intent intent=new Intent(EstimateGradeActivity.this,PrimaryActivity.class);
             intent.putExtra("inarea",tbarea);
             intent.putExtra("inmaxfen",tbmaxfen);
             intent.putExtra("insubtype",tbsubtype);
             startActivity(intent);
             finish();
             break;
        }
    }
}

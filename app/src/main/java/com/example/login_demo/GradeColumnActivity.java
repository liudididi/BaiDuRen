package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import untils.HistogramGrade;

public class GradeColumnActivity extends BaseActivity {

    @BindView(R.id.gradeColumn_iv_back)
    ImageView gradeColumnIvBack;
    @BindView(R.id.grade_column_tv)
    TextView gradeColumnTv;
    @BindView(R.id.column1)
    HistogramGrade column1;
    @BindView(R.id.column2)
    HistogramGrade column2;
    @BindView(R.id.column3)
    HistogramGrade column3;
    @BindView(R.id.column4)
    HistogramGrade column4;
    @BindView(R.id.column5)
    HistogramGrade column5;
    @BindView(R.id.column6)
    HistogramGrade column6;
    @BindView(R.id.column7)
    HistogramGrade column7;
    @BindView(R.id.column8)
    HistogramGrade column8;
    @BindView(R.id.column9)
    HistogramGrade column9;
    @BindView(R.id.column10)
    HistogramGrade column10;


    @Override
    public int getId() {
        return R.layout.activity_grade_column;
    }

    @Override
    public void InIt() {
        Intent intent = getIntent();
        String yue = intent.getStringExtra("yue");
        gradeColumnTv.setText(yue+"成绩对比");
        double num1 = intent.getDoubleExtra("num1", 0.0);
        double num2 = intent.getDoubleExtra("num2", 0.0);
        double num3 = intent.getDoubleExtra("num3", 0.0);
        double num4 = intent.getDoubleExtra("num4", 0.0);
        double num5 = intent.getDoubleExtra("num5", 0.0);
        double num6 = intent.getDoubleExtra("num6", 0.0);
        double num7 = intent.getDoubleExtra("num7", 0.0);
        double num8 = intent.getDoubleExtra("num8", 0.0);
        double num9 = intent.getDoubleExtra("num9", 0.0);
        double num10 = intent.getDoubleExtra("num10", 0.0);
        Double d1=new Double(num1);
        Double d2=new Double(num2);
        Double d3=new Double(num3);
        Double d4=new Double(num4);
        Double d5=new Double(num5);
        Double d6=new Double(num6);
        Double d7=new Double(num7);
        Double d8=new Double(num8);
        Double d9=new Double(num9);
        Double d10=new Double(num10);
        int i1 = d1.intValue();
        int i2 = d2.intValue();
        int i3 = d3.intValue();
        int i4 = d4.intValue();
        int i5 = d5.intValue();
        int i6 = d6.intValue();
        int i7 = d7.intValue();
        int i8 = d8.intValue();
        int i9 = d9.intValue();
        int i10 = d10.intValue();
        column1.setData( i1 , 150);
        column2.setData( i2 , 150);
        column3.setData( i3 , 150);
        column4.setData( i4 , 100);
        column5.setData( i5 , 100);
        column6.setData( i6 , 100);
        column7.setData( i7 , 100);
        column8.setData( i8 , 100);
        column9.setData( i9 , 100);
        column10.setData( i10 , 100);


        column1.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column2.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column3.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
         column4.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column5.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column6.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column7.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column8.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column9.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        column10.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
    }

    @OnClick({R.id.gradeColumn_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gradeColumn_iv_back:
                finish();
                break;

        }
    }
}

package com.example.login_demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import base.BaseActivity;
import base.BaseBean;
import bean.InquireBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.GradePresent;
import untils.SPUtils;
import view.GradeView;

public class GradeActivity extends BaseActivity implements GradeView{
    @BindView(R.id.grade_iv_back)
    ImageView gradeIvBack;
    @BindView(R.id.grade_month)
    TextView gradeMonth;


    @BindView(R.id.grade_language)
    EditText gradeLanguage;
    @BindView(R.id.grade_mathematics)
    EditText gradeMathematics;
    @BindView(R.id.grade_English)
    EditText gradeEnglish;

    @BindView(R.id.grade_physics)
    EditText gradePhysics;
    @BindView(R.id.grade_chemistry)
    EditText gradeChemistry;
    @BindView(R.id.grade_biology)
    EditText gradeBiology;


    @BindView(R.id.grade_history)
    EditText gradeHistory;
    @BindView(R.id.grade_geography)
    EditText gradeGeography;
    @BindView(R.id.grade_politics)
    EditText gradePolitics;

    @BindView(R.id.grade_speciality)
    EditText gradeSpeciality;

    @BindView(R.id.grade_confirm)
    TextView gradeConfirm;
    private int form_int;
    private int month_index;
    private String token;
    private GradePresent gradePresent;
    private Intent intent;
    private String month;

    private boolean flag=true;
    private boolean flag2=true;
    @Override
    public int getId() {
        return R.layout.activity_grade;
    }

    @Override
    public void InIt() {

        intent = getIntent();
        month = intent.getStringExtra("month");
        String form = intent.getStringExtra("form");
        gradeMonth.setText(month + form);

        //考试的类型
        form_int = intent.getIntExtra("form_int", 0);
        //月份类型
        month_index = intent.getIntExtra("month_index", 0);
         token = (String) SPUtils.get(MyApp.context, "token", "");
        gradePresent = new GradePresent(this);

      /*  //查询成绩的接口
        gradePresent.InquirePresente(form_int,month_index,token);*/
    }

    @OnClick({R.id.grade_iv_back , R.id.grade_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.grade_iv_back:
                finish();
                break;
            case R.id.grade_confirm:
                if(flag==true)
                {
                    if(gradeSpeciality.getText().toString().equals("")||gradePolitics.getText().toString().equals("")||
                            gradeGeography.getText().toString().equals("")||gradeHistory.getText().toString().equals("")||
                            gradeBiology.getText().toString().equals("")||gradeChemistry.getText().toString().equals("")||
                            gradePhysics.getText().toString().equals("")||gradeEnglish.getText().toString().equals("")||
                            gradeMathematics.getText().toString().equals("")||gradeLanguage.getText().toString().equals(""))
                    {
                        Toast.makeText(this, "分数不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double v1 = Double.parseDouble(gradeLanguage.getText().toString());
                    double v2 = Double.parseDouble(gradeMathematics.getText().toString());
                    double v3 = Double.parseDouble(gradeEnglish.getText().toString());
                    double v4 = Double.parseDouble(gradePhysics.getText().toString());
                    double v5 = Double.parseDouble(gradeChemistry.getText().toString());
                    double v6 = Double.parseDouble(gradeBiology.getText().toString());
                    double v7 = Double.parseDouble(gradeHistory.getText().toString());
                    double v8 = Double.parseDouble(gradeGeography.getText().toString());
                    double v9= Double.parseDouble(gradePolitics.getText().toString());
                    double v10 = Double.parseDouble(gradeSpeciality.getText().toString());
                    System.out.println("特长生+"+gradeSpeciality.getText().toString());

                        gradePresent.GradePresente(form_int,month_index,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,token);
                        Intent intent=new Intent(GradeActivity.this,GradeColumnActivity.class);
                        intent.putExtra("yue",month);
                        intent.putExtra("num1",v1);
                        intent.putExtra("num2",v2);
                        intent.putExtra("num3",v3);
                        intent.putExtra("num4",v4);
                        intent.putExtra("num5",v5);
                        intent.putExtra("num6",v6);
                        intent.putExtra("num7",v7);
                        intent.putExtra("num8",v8);
                        intent.putExtra("num9",v9);
                        intent.putExtra("num10",v10);
                        startActivity(intent);

                }
                else
                {
                    Toast.makeText(this, "无法生成折线图", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void Gradesuccess(BaseBean baseBean) {
        finish();
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Gradefail(Throwable t) {
        Toast.makeText(this, "网络有误，添加失败", Toast.LENGTH_SHORT).show();
    }

    //查询成绩
    @Override
    public void Inquiresuccess(BaseBean<InquireBean> inquireBeanBaseBean) {

        if(inquireBeanBaseBean.data!=null)
        {
            Toast.makeText(this, "查询成功", Toast.LENGTH_SHORT).show();
            gradeLanguage.setText(inquireBeanBaseBean.data.getChinese()+"");
            gradeMathematics.setText(inquireBeanBaseBean.data.getMath()+"");
            gradeEnglish.setText(inquireBeanBaseBean.data.getLanguages()+"");
            gradePhysics.setText(inquireBeanBaseBean.data.getPhysics()+"");
            gradeChemistry.setText(inquireBeanBaseBean.data.getChemistry()+"");
            gradeBiology.setText(inquireBeanBaseBean.data.getBiology()+"");
            gradeHistory.setText(inquireBeanBaseBean.data.getHistory()+"");
            gradeGeography.setText(inquireBeanBaseBean.data.getGeography()+"");
            gradePolitics.setText( inquireBeanBaseBean.data.getPolitics()+"");
            gradeSpeciality.setText(inquireBeanBaseBean.data.getSpecialty()+"");
            System.out.println("特长生查询+"+inquireBeanBaseBean.data.getSpecialty()+"");
            flag=true;
        }


    }

    @Override
    public void Inquirefail(Throwable t) {
        flag=false;
        gradePresent.InquirePresente(form_int,month_index,token);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gradePresent.onDestory();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //查询成绩的接口
        gradePresent.InquirePresente(form_int,month_index,token);
    }
}

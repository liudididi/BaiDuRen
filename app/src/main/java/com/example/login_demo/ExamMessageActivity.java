package com.example.login_demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.ExamGlideAdapter;
import base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import untils.SPUtils;

public class ExamMessageActivity extends BaseActivity {
    @BindView(R.id.examMessage_iv_back)
    ImageView examMessageIvBack;
    @BindView(R.id.message_gv)
    GridView messageGv;
    @BindView(R.id.tv_create)
    TextView tv_create;
    private String token;
    private int form_int;

    @Override
    public int getId() {
        return R.layout.activity_exam_message;
    }

    @Override
    public void InIt() {

        final ArrayList<String> list=new ArrayList<>();
         list.add("一月");
        list.add("二月");
        list.add("三月");
        list.add("四月");
        list.add("五月");
        list.add("六月");
        list.add("七月");
        list.add("八月");
        list.add("九月");
        list.add("十月");
        list.add("十一月");
        list.add("十二月");
        ExamGlideAdapter examGlideAdapter=new ExamGlideAdapter(list,this);
        messageGv.setAdapter(examGlideAdapter);
        final Intent intent = getIntent();

        form_int = intent.getIntExtra("form_int", 0);


        messageGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               /* if(token.equals(""))
                {
                    Toast.makeText(ExamMessageActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                Boolean aBoolean = checLogin();
                if(aBoolean==true)
                {
                    String form = intent.getStringExtra("form");
                    Intent intent1=new Intent(ExamMessageActivity.this,GradeActivity.class);
                    intent1.putExtra("month",list.get(i).toString());
                    intent1.putExtra("form",form);

                    intent1.putExtra("form_int", form_int);
                    intent1.putExtra("month_index",i+1);
                    startActivity(intent1);
                }
             }
        });
    }


    private Boolean checLogin() {
        if(token.length()<4){
            new AlertDialog.Builder(ExamMessageActivity.this)
                    .setTitle("提示")
                    .setMessage("该功能需要登录后才能使用")
                    .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           Intent intent=new Intent(ExamMessageActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return  false;
        }else {
            return true;
        }
    }
    @OnClick({R.id.examMessage_iv_back,R.id.tv_create})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.examMessage_iv_back:
                finish();
                break;
            case R.id.tv_create:
                //TODO  生成数据折线对比图

                Boolean aBoolean = checLogin();
                if(aBoolean){
                    Intent intent=new Intent(this,GradePolyLineActivity.class);
                    intent.putExtra("testType",form_int);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        token = (String) SPUtils.get(MyApp.context, "token", "");
    }
}

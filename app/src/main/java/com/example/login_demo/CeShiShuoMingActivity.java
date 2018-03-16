package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CeShiShuoMingActivity extends BaseActivity {


    @BindView(R.id.xlcs_iv_back)
    ImageView xlcsIvBack;
    @BindView(R.id.ceshi_title)
    TextView ceshiTitle;
    @BindView(R.id.iv_ceshi)
    ImageView ivCeshi;
    @BindView(R.id.bt_lsbg)
    Button btLsbg;
    @BindView(R.id.bt_kscs)
    Button btKscs;
  private  String title;
    @Override
    public int getId() {
        return R.layout.activity_ce_shi_shuo_ming;
    }

    @Override
    public void InIt() {
        if (MentalityActivity.xlcp.equals("MBTI")) {
            ivCeshi.setImageResource(R.drawable.mbtics);
            title="MBTI测试说明";
        } else {
            ivCeshi.setImageResource(R.drawable.hldcs);
            title="霍兰德测试说明";
        }
        ceshiTitle.setText(title);
    }



    @OnClick({R.id.xlcs_iv_back, R.id.bt_lsbg, R.id.bt_kscs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xlcs_iv_back:
         finish();
                break;
            case R.id.bt_lsbg:
                if (MentalityActivity.xlcp.equals("MBTI")) {
                    Intent intent=new Intent(CeShiShuoMingActivity.this,MBI_CSActivity.class);
                    startActivity(intent);
                } else {
                    /*Intent intent=new Intent(CeShiShuoMingActivity.this,MBI_CSActivity.class);
                    startActivity(intent);*/
                }
                break;
            case R.id.bt_kscs:

                break;
        }
    }
}

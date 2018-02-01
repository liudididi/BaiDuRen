package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AsForBaiDuRenActivity extends BaseActivity {


    @BindView(R.id.asfor_iv_back)
    ImageView asforIvBack;
    @BindView(R.id.asfor_one)
    RelativeLayout asforOne;
    @BindView(R.id.asfor_two)
    RelativeLayout asforTwo;
    @BindView(R.id.asfor_three)
    RelativeLayout asforThree;
    @BindView(R.id.asfor_four)
    RelativeLayout asforFour;
    @BindView(R.id.asfor_five)
    RelativeLayout asforFive;

    @Override
    public int getId() {
        return R.layout.activity_as_for_bai_du_ren;
    }

    @Override
    public void InIt() {

    }



    @OnClick({R.id.asfor_iv_back, R.id.asfor_one, R.id.asfor_two, R.id.asfor_three, R.id.asfor_four, R.id.asfor_five})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.asfor_iv_back:
                finish();
                break;
            case R.id.asfor_one:
                //摆渡人是什么

                break;
            case R.id.asfor_two:
                //为什么选择摆渡人

                break;
            case R.id.asfor_three:
                //我们的品牌故事
                break;
            case R.id.asfor_four:
                //联系我们

                break;
            case R.id.asfor_five:
                //免责声明

                break;
        }
    }
}

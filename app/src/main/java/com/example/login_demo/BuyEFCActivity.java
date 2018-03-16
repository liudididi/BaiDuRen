package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import base.BaseActivity;
import base.BaseBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.WishFragMent;
import presenter.CountdownPresent;
import view.CountdownView;

public class BuyEFCActivity extends BaseActivity implements CountdownView {

    @BindView(R.id.buyefc_iv_back)
    ImageView buyefcIvBack;
    @BindView(R.id.tv_money1)
    TextView tvMoney1;
    @BindView(R.id.buyefc_tvdjs)
    TextView buyefcTvdjs;
    @BindView(R.id.tv_goumai3)
    TextView tvGoumai3;
    private CountdownPresent countdownPresent;
    @Override
    public int getId() {
        return R.layout.activity_buy_efc;
    }

    @Override
    public void InIt() {

        String price = getIntent().getStringExtra("price");
        if(price!=null){
            tvMoney1.setText(price);
        }
        countdownPresent = new CountdownPresent(this);
    }

    @OnClick({R.id.buyefc_iv_back, R.id.tv_goumai3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buyefc_iv_back:
                finish();
                break;
            case R.id.tv_goumai3:
                Intent intent=new Intent(this,Buy2Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (WishFragMent.djs != null) {
            buyefcTvdjs.setText(WishFragMent.djs);
        }else {
            countdownPresent.CountdownPresent();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countdownPresent.onDestory();
    }

    @Override
    public void Countdownsuccess(BaseBean baseBean) {
        WishFragMent. djs = baseBean.data.toString();
        buyefcTvdjs.setText(WishFragMent.djs);
    }

    @Override
    public void Countdownfail(Throwable t) {

    }
}

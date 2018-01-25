package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import base.BaseActivity;
import base.BaseBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.SuggestPresent;
import view.SuggestView;

public class SuggestActivity extends BaseActivity implements SuggestView {


    @BindView(R.id.suggest_iv_back)
    ImageView suggestIvBack;
    @BindView(R.id.suggest_et)
    EditText suggestEt;
    @BindView(R.id.suggest_way)
    EditText suggestWay;
    @BindView(R.id.suggest_tv_commit)
    TextView suggestTvCommit;

    private SuggestPresent suggestPresent;
    private String s;


    @Override
    public int getId() {
        return R.layout.activity_suggest;
    }

    @Override
    public void InIt() {

        suggestPresent = new SuggestPresent(this);
        ininOnClick();
    }

    private void ininOnClick() {

    }


    @OnClick({R.id.suggest_iv_back,R.id.suggest_et, R.id.suggest_way, R.id.suggest_tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.suggest_iv_back:
                finish();
                break;
            case R.id.suggest_et:
                break;
            case R.id.suggest_way:
                break;
            case R.id.suggest_tv_commit:
                s = suggestEt.getText().toString();
                String s1 = suggestWay.getText().toString();
                if(s.equals(""))
                {
                    Toast.makeText(this, "建议内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(s1.equals(""))
                {
                    Toast.makeText(this, "联系方式不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                suggestPresent.SuggestPresent(s,s1);
                break;

        }
    }

    @Override
    public void Suggestsuccess(BaseBean baseBean) {
        Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void Suggestfail(Throwable t) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        suggestPresent.onDestory();
    }
}

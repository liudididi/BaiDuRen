package com.example.login_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import base.BaseActivity;
import base.BaseBean;
import bean.HelpBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.HelpPresenter;
import view.HelpView;

public class Help3Activity extends BaseActivity implements HelpView{

    @BindView(R.id.help_iv_back)
    ImageView helpIvBack;
    @BindView(R.id.help3_tv)
    TextView help3Tv;
    @BindView(R.id.help3_title)
    TextView help3_title;
    private HelpPresenter helpPresenter;

    @Override
    public int getId() {
        return R.layout.activity_help3;
    }

    @Override
    public void InIt() {
        String title = getIntent().getStringExtra("title2");
        String id = getIntent().getStringExtra("id");

        help3_title.setText(title);
        helpPresenter = new HelpPresenter(this);
        helpPresenter.HelpPresenter("0",id);
    }



    @OnClick({R.id.help_iv_back, R.id.help3_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.help_iv_back:
                finish();
                break;

        }
    }

    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        if(data!=null&&data.size()>0){
            for (int i = 0; i < data.size(); i++) {
                String book = data.get(i).getBook();

                help3Tv.setText(book);
            }
        }

    }

    @Override
    public void Helpfail(Throwable t) {

    }
}

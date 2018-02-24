package com.example.login_demo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import adapter.Help2Adapter;
import base.BaseActivity;
import base.BaseBean;
import bean.HelpBean;
import butterknife.BindView;
import butterknife.OnClick;
import presenter.HelpPresenter;
import view.HelpView;

public class Help2Activity extends BaseActivity implements HelpView{

    @BindView(R.id.help_iv_back)
    ImageView helpIvBack;
    @BindView(R.id.basics_rv)
    RecyclerView basics_rv;
    @BindView(R.id.tv_basics_title)
    TextView tv_basics_title;
    private HelpPresenter helpPresenter;
    private String title;
    private String id;

    @Override
    public int getId() {
        return R.layout.activity_basics;
    }

    @Override
    public void InIt() {
        title = getIntent().getStringExtra("title1");
        id = getIntent().getStringExtra("id");
        tv_basics_title.setText(title);

        helpPresenter = new HelpPresenter(this);
        helpPresenter.HelpPresenter("0", id);
    }

    @OnClick(R.id.help_iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
        List<HelpBean> data = listBaseBean.data;
        if(data.size()>1&&data!=null)
        {
            basics_rv.setLayoutManager(new LinearLayoutManager(Help2Activity.this));
            Help2Adapter help2Adapter = new Help2Adapter(data, Help2Activity.this, title);
            help2Adapter.setSetHelpBack(new Help2Adapter.SetHelpBack() {
                @Override
                public void HelpBack(View view, String title, String id) {
                    Intent intent=new Intent(Help2Activity.this, Help3Activity.class);
                    intent.putExtra("title2",title);
                    intent.putExtra("id",id+"");
                     startActivity(intent);
                     finish();
                }
            });
            basics_rv.setAdapter(help2Adapter);
        }

    }

    @Override
    public void Helpfail(Throwable t) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helpPresenter.onDestory();
    }
}

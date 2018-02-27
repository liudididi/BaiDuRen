package com.example.login_demo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.MoreSchool_Adapter;
import base.BaseActivity;
import base.BaseBean;
import bean.CanSchoolBean;
import bean.CanSchoolBean3;
import bean.SlideshowBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.WishPresent;
import untils.SPUtils;
import view.WishView;

public class More_SchoolActivity extends BaseActivity implements WishView {


    @BindView(R.id.more_iv_back)
    ImageView moreIvBack;
    @BindView(R.id.more_address)
    TextView moreAddress;
    @BindView(R.id.more_classify)
    TextView moreClassify;
    @BindView(R.id.more_score)
    TextView moreScore;
    @BindView(R.id.more_rv)
    RecyclerView moreRv;
    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;

    private WishPresent wishPresent;

    @Override
    public int getId() {
        return R.layout.activity_more__school;
    }

    @Override
    protected void onResume() {
        super.onResume();

        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");

        if(tbmaxfen!=null&&tbmaxfen!=""){
            moreScore.setText(tbmaxfen+"分");
        }else
        {
            moreScore.setText(500+"分");
        }
        if(tbarea!=null&&tbmaxfen!=""){
            moreAddress.setText(tbarea);
        }else {
            moreAddress.setText("北京市");
        }
        if(tbsubtype!=null&&tbmaxfen!=""){
            moreClassify.setText(tbsubtype);
        }else
        {
            moreClassify.setText("文科");
        }




    }

    @Override
    public void InIt() {
        wishPresent = new WishPresent(this);
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");
        if(tbarea!=null&&tbarea!=""&&tbmaxfen!=""&&tbmaxfen!=null&&tbsubtype!=null&&tbsubtype!=""){
            wishPresent.CanSchoolPresente(tbarea,tbsubtype,"0",tbmaxfen,"1","10");
        }else {
            wishPresent.CanSchoolPresente("北京","文科","0","500","1","10");

        }
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_item, null);
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view).show();
        ImageView dialog_iv=view.findViewById(R.id.dialog_iv);
        TextView dialog_tv=view.findViewById(R.id.dialog_tv);
        dialog_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                intent(More_SchoolActivity.this,ReportedActivity.class);
            }
        });
    }


    @Override
    public void Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean) {

    }

    @Override
    public void Wishfail(Throwable t) {

    }

    @Override
    public void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
        ArrayList<CanSchoolBean3> list = new ArrayList<>();
        List<CanSchoolBean.ListBean> list1 = canSchoolBeanBaseBean.data.getList();
        for (int i = 0; i < list1.size(); i++) {
            String url = list1.get(i).getUrl();
            String name = list1.get(i).getName();
            String address = list1.get(i).getAddress();
            String father = list1.get(i).getFather();
            String typeRank = list1.get(i).getTypeRank();
            list.add(new CanSchoolBean3(url, name, address, father, typeRank));
        }
        MoreSchool_Adapter moreSchool_adapter = new MoreSchool_Adapter(list, More_SchoolActivity.this);
        moreRv.setLayoutManager(new LinearLayoutManager(More_SchoolActivity.this));
        moreRv.setAdapter(moreSchool_adapter);
    }

    @Override
    public void CanSchoolfail(Throwable t) {
        if(tbarea!=null&&tbarea!=""&&tbmaxfen!=""&&tbmaxfen!=null&&tbsubtype!=null&&tbsubtype!=""){
            wishPresent.CanSchoolPresente(tbarea,tbsubtype,"0",tbmaxfen,"1","10");
        }else {
            wishPresent.CanSchoolPresente("北京","文科","0","500","1","10");

        }
    }
    @OnClick({R.id.more_iv_back })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_iv_back:
                finish();
                break;

        }
    }
}

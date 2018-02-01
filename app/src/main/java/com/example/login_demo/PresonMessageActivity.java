package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;

import base.BaseActivity;
import base.BaseBean;
import bean.MyUserBean;
import bean.UserBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;
import untils.SPUtils;

public class PresonMessageActivity extends BaseActivity {


    @BindView(R.id.preson_iv_back)
    ImageView presonIvBack;
    @BindView(R.id.preson_complie)
    ImageView presonComplie;
    @BindView(R.id.preson_title)
    RelativeLayout presonTitle;
    @BindView(R.id.preson_picon)
    CustomShapeImageView presonIcon;
    @BindView(R.id.preson_name)
    TextView presonName;
    @BindView(R.id.preson_six)
    TextView presonSix;
    @BindView(R.id.preson_type)
    TextView presonType;
    @BindView(R.id.preson_near)
    TextView presonNear;
    @BindView(R.id.preson_highschool)
    TextView presonHighschool;

    @Override
    public int getId() {
        return R.layout.activity_preson_message;
    }

    @Override
    public void InIt() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        String token = (String) SPUtils.get(MyApp.context, "token", "");
              MyQusetUtils.getInstance()
                .getQuestInterface().getUserinfo(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<UserBean>>() {
                    @Override
                    public void onNext(BaseBean<UserBean> baseBean) {
                        if(baseBean.code==0){
                            UserBean data = baseBean.data;
                            MyUserBean.setUserBean(data);
                            if(data.getName()!=null){
                                presonName.setText(data.getName());
                            }
                            if(data.getSex()!=null){
                                presonSix.setText(data.getSex());
                            }


                            if(data.getSex()!=null){
                                if(data.getSex().equals("女")){
                                    Glide.with(PresonMessageActivity.this).load(R.drawable.gril).into(presonIcon);
                                }else {
                                    Glide.with(PresonMessageActivity.this).load(R.drawable.boy).into(presonIcon);
                                }
                            }else {
                                Glide.with(PresonMessageActivity.this).load(R.drawable.boy).into(presonIcon);
                            }
                           if(data.getStuType()!=null){
                               presonType.setText(data.getStuType());
                           }
                           if(data.getExamYear()!=null){
                               presonNear.setText(data.getExamYear());
                           }
                           if(data.getMidSchool()!=null){
                               presonHighschool.setText(data.getMidSchool());
                           }


                        }else {
                            Toast.makeText(MyApp.context,"token超时，请重新登录",Toast.LENGTH_SHORT);
                        }
                    }
                    @Override
                    public void onError(Throwable t) {
                        Toast("获取信息失败，请稍后重试");
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick({R.id.preson_iv_back, R.id.preson_complie, R.id.preson_icon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.preson_iv_back:
                finish();
                break;
            case R.id.preson_complie:
                intent(this,perfectMessageActivity.class);
                break;
            case R.id.preson_icon:

                break;
        }
    }
}

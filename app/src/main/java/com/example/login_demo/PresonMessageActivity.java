package com.example.login_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.meg7.widget.CustomShapeImageView;
import com.weavey.loading.lib.LoadingLayout;

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
    private ConnectionChangeReceiver myReceiver;
    @Override
    public int getId() {
        return R.layout.activity_preson_message;
    }

    @Override
    public void InIt() {
        registerReceiver();
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



    public void registerReceiver() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        //设置网络状态提示布局的状态
//无网的时候，无网提示的展示View展示出来
//重新联接上网络时，自动加载数据
//这个是onresume中实现了数据的刷新，即是，网络连接后，重新拉取数据
        myReceiver = new ConnectionChangeReceiver() {
            @Override
            public void changeNetStatus(boolean flag) {
                //设置网络状态提示布局的状态
                if (flag) {

                } else {
                    //有网
                   onResume();

                }
            }
        };
        this.registerReceiver(myReceiver, filter);
    }

    public void unregisterReceiver() {
        if (myReceiver != null) {
            this.unregisterReceiver(myReceiver);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }
}

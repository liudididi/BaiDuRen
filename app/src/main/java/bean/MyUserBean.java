package bean;

import android.content.Context;
import android.widget.Toast;

import com.example.login_demo.MyApp;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;
import untils.SPUtils;

/**
 * Created by 地地 on 2018/1/23.
 * 邮箱：461211527@qq.com.
 */

public class MyUserBean  {
    private static UserBean userBean=null;
    private static DisposableSubscriber<BaseBean<UserBean>> disposableSubscriber;



    public  static void setUserBean(UserBean nuserBean) {
        userBean = nuserBean;
    }

    public  static  UserBean getUserBeanInstans(){
        if(userBean!=null){
           return userBean;
        }
        return  null;
    }

    public  static   void checkLogin(){
       String token = (String) SPUtils.get(MyApp.context, "token", "");
       if(token.length()>4){
           disposableSubscriber = MyQusetUtils.getInstance()
                   .getQuestInterface().getUserinfo(token)
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribeOn(Schedulers.io())
                   .subscribeWith(new DisposableSubscriber<BaseBean<UserBean>>() {
                       @Override
                       public void onNext(BaseBean<UserBean> baseBean) {
                           if(baseBean.code==0){
                               userBean=baseBean.data;
                           }else {
                               Toast.makeText(MyApp.context,"token超时，请重新登录",Toast.LENGTH_SHORT);
                           }
                       }
                       @Override
                       public void onError(Throwable t) {

                       }

                       @Override
                       public void onComplete() {

                       }
                   });
       }

    }



    public  static  void   onDestory(){
        if(disposableSubscriber!=null){
            disposableSubscriber.dispose();
        }

    }




}

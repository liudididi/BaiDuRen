package presenter;

import android.widget.Toast;

import java.util.HashMap;

import base.BaseBean;
import base.Basepresent;
import bean.UserBean;
import moudle.LogInMoudle;
import view.LoginView;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class LogInPresenter  extends Basepresent {
    private LogInMoudle logInMoudle;
    private LoginView loginView;

    public LogInPresenter(Object view) {
        super(view);
        if(logInMoudle==null){
            logInMoudle=new LogInMoudle();
        }
        loginView= (LoginView) view;
    }

    /**
     * 账号密码登录
     * @param mobile
     * @param password
     */
    public  void  Login(String mobile,String password){
        logInMoudle.Login(mobile,password, new LogInMoudle.RequestBack() {
            @Override
            public void Loginsuccess(BaseBean<UserBean> baseBean) {
                String msg = baseBean.msg;
                if(baseBean.code==0){
                     loginView.loginsuccess(msg,baseBean);
                }else {
                    loginView.loginfail(msg);
                }
            }

            @Override
            public void Loginfail(Throwable t) {
                loginView.loginfail("网络有误");
            }
        });
    }

    /**
     * 快速登录
     * @param mobile
     * @param captcha
     */
    public  void  phoneLogin (String mobile,String captcha){
        logInMoudle.phoneLogin(mobile, captcha, new LogInMoudle.RequestBack() {
            @Override
            public void Loginsuccess(BaseBean<UserBean> listBasebean) {
                String msg = listBasebean.msg;
                if(listBasebean.code==0){
                    loginView.loginsuccess(msg,listBasebean);
                }else {
                    loginView.loginfail(msg);
                }
            }
            @Override
            public void Loginfail(Throwable t) {

            }
        });
    }


    /**
     * 注册
     * @param mobile
     * @param password
     * @param captcha
     */
    public  void  Register (String mobile,String password,String captcha){
        logInMoudle.Register(mobile,password,captcha, new LogInMoudle.RequestBack() {
            @Override
            public void Loginsuccess(BaseBean<UserBean> listBasebean) {
                     String msg = listBasebean.msg;
                    if(listBasebean.code==0){
                        loginView.loginsuccess(msg,listBasebean);
                    }else {
                        loginView.loginfail(msg);
                    }


            }
            @Override
            public void Loginfail(Throwable t) {
                loginView.loginfail("发送失败，请稍后重试");
            }
        });
    }
    /**
     * 获取验证码
     * @param moble
     */
    public  void  LogCaptcha(String moble){
     logInMoudle.LogCaptcha(moble, new LogInMoudle.CaptChaBack() {
         @Override
         public void CaptChasuccess(BaseBean listBasebean) {
                 String msg = listBasebean.msg;
                 if(listBasebean.code==0){
                     loginView.CaptChasuccess(msg);
                 }else {
                     loginView.CaptChaFail(msg);
                 }


         }
         @Override
         public void CaptChafail(Throwable t) {
             loginView.CaptChaFail("请稍后重试");
         }
     });
    }
    public  void  RegisterCaptcha(String moble){
        logInMoudle.RegisterCaptcha(moble, new LogInMoudle.CaptChaBack() {
            @Override
            public void CaptChasuccess(BaseBean listBasebean) {
                String msg = listBasebean.msg;
           if(listBasebean.code==0){
               loginView.CaptChasuccess(msg);
           }else {
               loginView.loginfail(msg);
           }
            }
            @Override
            public void CaptChafail(Throwable t) {
                loginView.loginfail("请稍后重试");
            }
        });
    }



    public   void   onDestory(){
        this.onDeach();
        logInMoudle.onDestory();
    }



}

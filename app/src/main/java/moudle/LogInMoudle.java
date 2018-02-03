package moudle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.BaseBean;
import bean.UserBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import untils.JSONUtils;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class LogInMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public  void  Login(String mobile,String password, final RequestBack requestBack){
        DisposableSubscriber<BaseBean<UserBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().loginByMobilePwd(mobile, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<UserBean>>() {
                    @Override
                    public void onNext(BaseBean<UserBean> baseBean) {
                        requestBack.Loginsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        requestBack.Loginfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
}



    public  void  LogCaptcha(String mobile, final CaptChaBack captChaBack){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().LogCaptcha(mobile)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        captChaBack.CaptChasuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        captChaBack.CaptChafail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }



    public  void  RegisterCaptcha(String mobile, final CaptChaBack captChaBack){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().RegisterCaptcha(mobile)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        captChaBack.CaptChasuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        captChaBack.CaptChafail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    /**
     * 注册
     * @param mobile
     */

    public  void  Register(String mobile,String password,String captcha, final  RequestBack requestBack){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().register(mobile,password,captcha)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        requestBack.Loginsuccess(baseBean);
                    }
                    @Override
                    public void onError(Throwable t) {
                        requestBack.Loginfail(t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }

    public  void  phoneLogin(String mobile,String captcha, final  RequestBack requestBack){
        DisposableSubscriber<BaseBean<UserBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().phoneLogin(mobile, captcha)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean<UserBean>>() {
                    @Override
                    public void onNext(BaseBean<UserBean> baseBean) {
                        requestBack.Loginsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        requestBack.Loginfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    public  interface  RequestBack{
        void  Loginsuccess(BaseBean<UserBean> listBasebean);
        void  Loginfail(Throwable t);
    }

    public  interface  CaptChaBack{
        void  CaptChasuccess(BaseBean listBasebean);
        void  CaptChafail(Throwable t);
    }
    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }

}

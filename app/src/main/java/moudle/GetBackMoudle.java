package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/22.
 * 邮箱：461211527@qq.com.
 */

public class GetBackMoudle  {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public  void  UpdateCaptcha(String mobile, final UpdataCaptChaBack captChaBack){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().UpdateCaptcha(mobile)
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

    public  void  findPwdByMobile(String mobile,String captcha,String newspassword ,final findPwdByMobileBack findPwdByMobileBack){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().findPwdByMobile(mobile,captcha,newspassword)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        findPwdByMobileBack.CaptChasuccess(baseBean);
                    }
                    @Override
                    public void onError(Throwable t) {
                        findPwdByMobileBack.CaptChafail(t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }


    public  interface  UpdataCaptChaBack{
        void  CaptChasuccess(BaseBean listBasebean);
        void  CaptChafail(Throwable t);

    }

    public  interface  findPwdByMobileBack{
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

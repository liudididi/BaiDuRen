package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/24.
 * 邮箱：461211527@qq.com.
 */

public class ChangePhoneMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public  void  mobileUpdateCaptcha(String mobile, final ChangePhoneCaptChaBack changePhoneCaptChaBack) {
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().mobileUpdateCaptcha(mobile)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                       changePhoneCaptChaBack.CaptChasuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                       changePhoneCaptChaBack.CaptChafail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }


    public  interface  ChangePhoneCaptChaBack{
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

package moudle;

import android.view.View;

import base.BaseBean;
import bean.MajorgkBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class MajorgkMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void  getMajorgk(String marjorid, final MajorgkBack majorgkBack){
        DisposableSubscriber<BaseBean<MajorgkBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getmajorgk(marjorid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<MajorgkBean>>() {
                    @Override
                    public void onNext(BaseBean<MajorgkBean> majorgkBeanBaseBean) {
                        majorgkBack.Majorgksuccess(majorgkBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                      majorgkBack.Majorgkfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }
    public  interface  MajorgkBack{
        void  Majorgksuccess(BaseBean<MajorgkBean> listBasebean);
        void  Majorgkfail(Throwable t);
    }
    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }
}

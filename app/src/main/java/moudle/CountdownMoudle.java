package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class CountdownMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //倒计时
    public void Countdown(final CountdownBack countdownBack)
    {
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().Countdown()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        countdownBack.Countdownsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        countdownBack.Countdownfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //倒计时
    public interface CountdownBack
    {
        void Countdownsuccess(BaseBean baseBean);
        void Countdownfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

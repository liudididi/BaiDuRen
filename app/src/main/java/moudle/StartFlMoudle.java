package moudle;

import java.util.List;

import base.BaseBean;
import bean.StartFl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public class StartFlMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();
   public  void   getStartfl(String classify, String type, String fenlei, final StratjobBack stratjobBack){

       DisposableSubscriber<BaseBean<List<StartFl>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().jobsStarMobil(classify, type, fenlei)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new DisposableSubscriber<BaseBean<List<StartFl>>>() {
                   @Override
                   public void onNext(BaseBean<List<StartFl>> listBaseBean) {
                       stratjobBack.Stratjobsuccess(listBaseBean);
                   }

                   @Override
                   public void onError(Throwable t) {
                       stratjobBack.Stratjobfail(t);
                   }

                   @Override
                   public void onComplete() {

                   }
               });
       compositeDisposable.add(disposableSubscriber);
   }

    public interface StratjobBack
    {
        void  Stratjobsuccess(BaseBean<List<StartFl>> listBaseBean);
        void  Stratjobfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

}

package moudle;

import java.util.List;

import base.BaseBean;
import bean.MoreJobBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class MoreJobMoudle  {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public  void  selectAllJob(final MoreJobChaBack moreJobChaBack){
        DisposableSubscriber<BaseBean<List<MoreJobBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().selectAllJob()

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<MoreJobBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<MoreJobBean>> listBaseBean) {
moreJobChaBack.MoreJobsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
moreJobChaBack.MoreJobfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    public  interface  MoreJobChaBack{
        void  MoreJobsuccess(BaseBean<List<MoreJobBean>> listBasebean);
        void  MoreJobfail(Throwable t);
    }
    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }
}

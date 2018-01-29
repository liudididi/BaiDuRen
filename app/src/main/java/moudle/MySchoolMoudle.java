package moudle;

import java.util.List;

import base.BaseBean;
import bean.MajorBean;
import bean.SchoolBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/26.
 * 邮箱：461211527@qq.com.
 */

public class MySchoolMoudle   {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
     public  void  getSchollCollection(String token, final SchoolBack schoolBack){
         DisposableSubscriber<BaseBean<List<SchoolBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                 .getQuestInterface().getCollection(0, token)
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean<List<SchoolBean>>>() {
                     @Override
                     public void onNext(BaseBean<List<SchoolBean>> listBaseBean) {
                         schoolBack.Schoolsuccess(listBaseBean);
                     }

                     @Override
                     public void onError(Throwable t) {
                         schoolBack.Schoolfail(t);
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
         compositeDisposable.add(disposableSubscriber);

     }
    public  void  getmajorCollection(String token, final marjorBack marjorBack){
        DisposableSubscriber<BaseBean<List<MajorBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getmajorCollection(1, token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<MajorBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<MajorBean>> listBaseBean) {
                      marjorBack.majorsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                       marjorBack.majorfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }
    public  interface  SchoolBack{
        void  Schoolsuccess(BaseBean<List<SchoolBean>> Basebean);
        void  Schoolfail(Throwable t);
    }
    public  interface  marjorBack{
        void  majorsuccess(BaseBean<List<MajorBean>> Basebean);
        void  majorfail(Throwable t);
    }

    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }

}

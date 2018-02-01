package moudle;

import java.util.List;

import base.BaseBean;
import bean.CheckSchoolBean;
import bean.SchoolBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class MoreSchoolMoudle  {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

      public  void  checkschool(String address, String schooltype, final CheckBeanBack checkBeanBack){

          DisposableSubscriber<BaseBean<List<CheckSchoolBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                  .getQuestInterface().checkschool(address, schooltype, "", "", "", "", "")
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribeOn(Schedulers.io())
                  .subscribeWith(new DisposableSubscriber<BaseBean<List<CheckSchoolBean>>>() {
                      @Override
                      public void onNext(BaseBean<List<CheckSchoolBean>> listBaseBean) {
                          checkBeanBack.CheckBeansuccess(listBaseBean);
                      }

                      @Override
                      public void onError(Throwable t) {
                        checkBeanBack.CheckBeanfail(t);
                      }

                      @Override
                      public void onComplete() {

                      }
                  });
          compositeDisposable.add(disposableSubscriber);
      }


    public  interface  CheckBeanBack{
        void  CheckBeansuccess(BaseBean<List<CheckSchoolBean>> Basebean);
        void  CheckBeanfail(Throwable t);
    }

    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }


}

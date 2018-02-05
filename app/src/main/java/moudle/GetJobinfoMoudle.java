package moudle;

import java.util.List;

import base.BaseBean;
import bean.JobInforBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class GetJobinfoMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public  void  getJobInfo(String jobName, final JobInfoBack jobInfoBack){

        DisposableSubscriber<BaseBean<List<JobInforBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getjobinfo(jobName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<JobInforBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<JobInforBean>> listBaseBean) {
                        jobInfoBack.JobInfosuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                       jobInfoBack.JobInfofail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

    }


    public  interface  JobInfoBack{
        void  JobInfosuccess(BaseBean<List<JobInforBean>> listBaseBean);
        void  JobInfofail(Throwable t);
    }
    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }
}

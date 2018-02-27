package moudle;

import java.util.List;

import base.BaseBean;
import bean.MajorSchoolBean;
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

public class MajorSchoolMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void  getMajorSchool(String marjorid, final MajorSchoolBack majorSchoolBack){
        DisposableSubscriber<BaseBean<List<MajorSchoolBean>>> disposableSubscriber =
                MyQusetUtils.getInstance()
                .getQuestInterface().getmajorschool(marjorid, "2017")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<MajorSchoolBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<MajorSchoolBean>> listBaseBean) {
                       majorSchoolBack.MajorSchoolsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                    majorSchoolBack.MajorSchoolfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);

    }
    public  interface  MajorSchoolBack{
        void  MajorSchoolsuccess(BaseBean<List<MajorSchoolBean>> listBasebean);
        void  MajorSchoolfail(Throwable t);
    }
    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }
}

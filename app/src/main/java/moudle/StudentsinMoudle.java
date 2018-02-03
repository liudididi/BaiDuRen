package moudle;

import java.util.List;

import base.BaseBean;
import bean.StudentsinBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/3.
 */

public class StudentsinMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //特长生
    public void Studentsin(String address, String schooltype , final StudentsinBack studentsinBack)
    {
        DisposableSubscriber<BaseBean<List<StudentsinBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().studentsschool(address, schooltype)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<StudentsinBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<StudentsinBean>> listBaseBean) {
                        studentsinBack.Suggestsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        studentsinBack.Studentsinfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //特长生院校的接口
    public interface StudentsinBack
    {
        void Suggestsuccess(BaseBean<List<StudentsinBean>> listBaseBean);
        void  Studentsinfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

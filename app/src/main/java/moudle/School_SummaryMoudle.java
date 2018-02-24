package moudle;

import java.util.List;

import base.BaseBean;
import bean.StudentFromBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/23.
 * 邮箱：461211527@qq.com.
 */

public class School_SummaryMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    private DisposableSubscriber<BaseBean<List<StudentFromBean>>> disposableSubscriber;

    public void  studentFrom(String name, final StudentFromBack studentFromBack){

        disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface()
                .studentfrom(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<StudentFromBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<StudentFromBean>> listBaseBean) {
                        studentFromBack.Studentsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        studentFromBack.Studentfail(t);
                    }
                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);

   }
    public interface StudentFromBack
    {
        void Studentsuccess(BaseBean<List<StudentFromBean>>  BeanBaseBean);
        void Studentfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

}

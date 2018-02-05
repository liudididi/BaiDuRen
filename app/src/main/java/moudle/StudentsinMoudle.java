package moudle;

import java.util.List;

import base.BaseBean;
import bean.StudentsinBean;
import bean.StudentsinNewsBean;
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
    //特长生艺术院校
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
    //特长生艺考资讯
    public void StudentsinNews(String category, String province, String page, String limit, final StudentsinNewsBack studentsinNewsBack)
    {
        DisposableSubscriber<BaseBean<StudentsinNewsBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().studentsnews(category, province, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<StudentsinNewsBean>>() {
                    @Override
                    public void onNext(BaseBean<StudentsinNewsBean> studentsinNewsBeanBaseBean) {
                        studentsinNewsBack.StudentsinNewssuccess(studentsinNewsBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        studentsinNewsBack.StudentsinNewsfail(t);
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
    //特长生资讯的接口
    public interface StudentsinNewsBack
    {
        void StudentsinNewssuccess(BaseBean<StudentsinNewsBean> studentsinNewsBeanBaseBean);
        void  StudentsinNewsfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

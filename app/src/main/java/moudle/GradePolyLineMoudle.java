package moudle;

import java.util.List;

import base.BaseBean;
import bean.GradePolyBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/2/24.
 * 邮箱：461211527@qq.com.
 */

public class GradePolyLineMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public  void  getUserResultPng(int type, String course, String token, final GradePolyBack gradePolyBack){
        DisposableSubscriber<BaseBean<List<GradePolyBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface()
                .getUserResultPng(type, course, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<GradePolyBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<GradePolyBean>> listBaseBean) {
                        gradePolyBack.GradePolysuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        gradePolyBack.GradePolyfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }


    public interface GradePolyBack
    {
        void GradePolysuccess(BaseBean<List<GradePolyBean>> baseBean);
        void GradePolyfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

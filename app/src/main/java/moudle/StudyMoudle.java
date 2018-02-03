package moudle;

import base.BaseBean;
import bean.StudyBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class StudyMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //提交建议
    public void Study(String category, String province , String subject, String grade, String page, String limit, final StudyBack studyBack)
    {
        DisposableSubscriber<BaseBean<StudyBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().study(category, province, subject, grade, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<StudyBean>>() {
                    @Override
                    public void onNext(BaseBean<StudyBean> studyBeanBaseBean) {
                        studyBack.Studysuccess(studyBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        studyBack.Studyfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface StudyBack
    {
        void Studysuccess(BaseBean<StudyBean> studyBeanBaseBean);
        void Studyfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

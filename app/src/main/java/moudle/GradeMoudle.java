package moudle;

import base.BaseBean;
import bean.CanSchoolBean;
import bean.InquireBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/27.
 */

public class GradeMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //添写成绩
    public void Grade(int testType, int time, Double chinese, Double math, Double languages, Double physics, Double chemistry, Double biology, Double history, Double geography, Double politics, Double specialty, String token, final GradeBack gradeBack)
    {
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().grade(testType, time, chinese, math, languages, physics, chemistry, biology, history, geography, politics, specialty, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        gradeBack.Gradesuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        gradeBack.Gradefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //查询成绩
    public void Inquire(int testType, int testTime,  String token, final InquireBack inquireBack)
    {
        DisposableSubscriber<BaseBean<InquireBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().inquiregrade(testType, testTime, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<InquireBean>>() {
                    @Override
                    public void onNext(BaseBean<InquireBean> inquireBeanBaseBean) {
                        inquireBack.Inquiresuccess(inquireBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        inquireBack.Inquirefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }


    //查询分数的接口
    public interface InquireBack
    {
        void Inquiresuccess(BaseBean<InquireBean> inquireBeanBaseBean);
        void Inquirefail(Throwable t);
    }
    //添加分数的接口
    public interface GradeBack
    {
        void Gradesuccess(BaseBean baseBean);
        void Gradefail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

package moudle;

import java.util.List;

import base.BaseBean;
import bean.CampusBean;
import bean.FingerpostBean;
import bean.SchoolIntroduceBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/25.
 */

public class SchoolIntroduceMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //校园介绍
    public void Introduce(String name, final IntroduceBack introduceBack)
    {
        DisposableSubscriber<BaseBean<List<SchoolIntroduceBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().schoolIntroduce(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SchoolIntroduceBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SchoolIntroduceBean>> listBaseBean) {
                        introduceBack.Introducesuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        introduceBack.Introducefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //报考指南
    public void Fingerpost(String name, final FingerpostBack fingerpostBack)
    {
        DisposableSubscriber<BaseBean<List<FingerpostBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().fingerpost(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<FingerpostBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<FingerpostBean>> listBaseBean) {
                        fingerpostBack.Fingerpostsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        fingerpostBack.Fingerpostfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    //校园生活
    public void Campus(String name, final CampusBack campusBack)
    {
        DisposableSubscriber<BaseBean<List<CampusBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().campus(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<CampusBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<CampusBean>> listBaseBean) {
                        campusBack.Campussuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        campusBack.Campusfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    //校园生活
    public interface CampusBack
    {
        void Campussuccess(BaseBean<List<CampusBean>> listBaseBean);
        void Campusfail(Throwable t);
    }
    //报考指南的接口
    public interface FingerpostBack
    {
        void Fingerpostsuccess(BaseBean<List<FingerpostBean>> listBaseBean);
        void Fingerpostfail(Throwable t);
    }
    //校园介绍的接口
    public interface IntroduceBack
    {
        void Introducesuccess(BaseBean<List<SchoolIntroduceBean>> listBaseBean);
        void Introducefail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

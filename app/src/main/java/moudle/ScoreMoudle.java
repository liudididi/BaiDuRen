package moudle;

import java.util.List;

import base.BaseBean;
import bean.ScoreBean1;
import bean.ScoreBean2;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class ScoreMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //大学查询
    public void Score(String province, String classify  , final Score1Back score1Back)
    {
        DisposableSubscriber<BaseBean<List<ScoreBean1>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().score1(province, classify)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<ScoreBean1>>>() {
                    @Override
                    public void onNext(BaseBean<List<ScoreBean1>> listBaseBean) {
                        score1Back.Score1success(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        score1Back.Score1fail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //分数查询
    public void Score2(String province, String university  , final Score2Back score2Back)
    {
        DisposableSubscriber<BaseBean<List<ScoreBean2>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().score2(province, university)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<ScoreBean2>>>() {
                    @Override
                    public void onNext(BaseBean<List<ScoreBean2>> listBaseBean) {
                        score2Back.Score2success(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        score2Back.Score2fail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //大学查询的接口
    public interface Score1Back
    {
        void Score1success(BaseBean<List<ScoreBean1>> listBaseBean);
        void Score1fail(Throwable t);
    }
    //分数查询的接口
    public interface Score2Back
    {
        void Score2success(BaseBean<List<ScoreBean2>> listBaseBean);
        void Score2fail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

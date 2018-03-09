package moudle;

import java.util.List;

import base.BaseBean;
import bean.CanSchoolBean;
import bean.SlideshowBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/25.
 */

public class WishMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public void Wish(int board_id, final WishBack wishBack)
    {
        DisposableSubscriber<BaseBean<List<SlideshowBean>>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface().Wish(board_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SlideshowBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SlideshowBean>> listBaseBean) {
                        wishBack.Wishsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        wishBack.Wishfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //根据分数推荐的学校
    public void canSchool(String province, String classify, String score_min, String score_max, String page, String limit, final CanSchoolBack canSchoolBack)
    {
        DisposableSubscriber<BaseBean<CanSchoolBean>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface()
                        .canschool(province, classify, score_min, score_max, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<CanSchoolBean>>() {
                    @Override
                    public void onNext(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
                        canSchoolBack.CanSchoolsuccess(canSchoolBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        canSchoolBack.CanSchoolfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }


    //根据分数推荐的学校
    public void completcanSchool(String minScore, String maxScore, String cityType, String isAccept, String schoolType, String isMS,String province,String classify, final CanSchoolBack canSchoolBack)
    {
        DisposableSubscriber<BaseBean<CanSchoolBean>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface()
                        .completecanschool(minScore, maxScore,cityType, isAccept, schoolType,isMS,province,classify)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<BaseBean<CanSchoolBean>>() {
                            @Override
                            public void onNext(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
                                canSchoolBack.CanSchoolsuccess(canSchoolBeanBaseBean);
                            }

                            @Override
                            public void onError(Throwable t) {
                                canSchoolBack.CanSchoolfail(t);
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
        compositeDisposable.add(disposableSubscriber);
    }
    //能上的学校
    public interface CanSchoolBack
    {
        void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean);
        void CanSchoolfail(Throwable t);
    }
    public interface WishBack
    {
        void  Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean);
        void  Wishfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

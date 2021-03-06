package moudle;

import base.BaseBean;
import bean.RanKingSchoolBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class RankingMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //提交建议
    public void RanKing(int page, int limit, final RanKingBack ranKingBack)
    {
        DisposableSubscriber<BaseBean<RanKingSchoolBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().ranking(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<RanKingSchoolBean>>() {
                    @Override
                    public void onNext(BaseBean<RanKingSchoolBean> ranKingSchoolBeanBaseBean) {
                        ranKingBack.RanKingsuccess(ranKingSchoolBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        ranKingBack.RanKingfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface RanKingBack
    {
        void RanKingsuccess(BaseBean<RanKingSchoolBean> ranKingSchoolBeanBaseBean);
        void RanKingfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

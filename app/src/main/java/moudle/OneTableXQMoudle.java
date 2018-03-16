package moudle;

import java.util.List;

import base.BaseBean;
import bean.OneTableXQBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/3/6.
 */

public class OneTableXQMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //一分一表的详情
    public void OnTableXQ(String type, String province, String year, final OneTableXQBack oneTableXQBack)
    {
        DisposableSubscriber<BaseBean<List<OneTableXQBean>>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface().onetableXQ(type, province, year)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<OneTableXQBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<OneTableXQBean>> listBaseBean) {
                        oneTableXQBack.OneTableXQsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        oneTableXQBack.OneTableXQfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //一分一表详情的接口
    public interface OneTableXQBack
    {
        void OneTableXQsuccess(BaseBean<List<OneTableXQBean>> listBaseBean);
        void OneTableXQfail(Throwable t);
    }

    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

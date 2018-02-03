package moudle;

import java.util.List;

import base.BaseBean;
import bean.OneTableBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class OneTableMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //提交建议
    public void OnTable(String type, String province, final OneTableBack oneTableBack)
    {
        DisposableSubscriber<BaseBean<List<OneTableBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().onetable(type, province)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<OneTableBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<OneTableBean>> listBaseBean) {
                        oneTableBack.OneTablesuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        oneTableBack.OneTablefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface OneTableBack
    {
        void OneTablesuccess(BaseBean<List<OneTableBean>> listBaseBean);
        void OneTablefail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

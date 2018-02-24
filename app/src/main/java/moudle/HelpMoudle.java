package moudle;

import java.util.List;

import base.BaseBean;
import bean.HelpBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class HelpMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //提交建议
    public void Help(String type, String pid, final HelpBack helpBack)
    {
        DisposableSubscriber<BaseBean<List<HelpBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().helping(type, pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<HelpBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<HelpBean>> listBaseBean) {
                        helpBack.Helpsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        helpBack.Helpfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface HelpBack
    {
        void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean);
        void Helpfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

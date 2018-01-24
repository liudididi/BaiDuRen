package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/24.
 */

public class SuggestMoudle  {

    private  CompositeDisposable compositeDisposable=new CompositeDisposable();
    //提交建议
    public void Suggest(String proposal, String contactInformation , final SuggestBack suggestBack)
    {
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().suggest(proposal, contactInformation)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                        suggestBack.Suggestsuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        suggestBack.Suggestfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface SuggestBack
    {
        void Suggestsuccess(BaseBean baseBean);
        void Suggestfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

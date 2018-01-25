package moudle;

import java.util.List;

import base.BaseBean;
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
        DisposableSubscriber<BaseBean<List<SlideshowBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().Wish(board_id)
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

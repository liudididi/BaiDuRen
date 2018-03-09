package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/3/2.
 * 邮箱：461211527@qq.com.
 */

public class PayMoudle {


    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    public  void  productorder(final OrderBack orderBack){
        DisposableSubscriber<BaseBean<String>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface()
                .productorder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<String>>() {
                    @Override
                    public void onNext(BaseBean<String> stringBaseBean) {
                        orderBack.Ordersuccess(stringBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        orderBack.Orderfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }


    public interface OrderBack
    {
        void  Ordersuccess(BaseBean<String>  BaseBean);
        void  Orderfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

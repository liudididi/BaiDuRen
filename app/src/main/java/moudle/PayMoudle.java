package moudle;

import base.BaseBean;
import bean.WeiXinBean;
import bean.XDingdanBean;
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
    public  void  productorder(String token,String productId,String payType,final OrderBack orderBack){
        DisposableSubscriber<BaseBean<XDingdanBean>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface()
                .productorder(token,productId, 3 + "", payType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSubscriber<BaseBean<XDingdanBean>>() {
                    @Override
                    public void onNext(BaseBean<XDingdanBean> xDingdanBeanBaseBean) {
                        orderBack.Ordersuccess(xDingdanBeanBaseBean);
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


    public  void  ZFBpay(String outTradeNo,final ZFBpayBack zfBpayBack){
        DisposableSubscriber<BaseBean<String>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface()
                .ZFBpay(outTradeNo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<String>>() {
                    @Override
                    public void onNext(BaseBean<String> stringBaseBean) {
                        zfBpayBack.ZFBpaysuccess(stringBaseBean);
                    }
                    @Override
                    public void onError(Throwable t) {
                        zfBpayBack.ZFBpayfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    public  void  WXBpay(String outTradeNo,final WXpayBack wXpayBack){
        DisposableSubscriber<BaseBean<WeiXinBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface()
                .WXpay(outTradeNo,"aa")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<WeiXinBean>>() {
                    @Override
                    public void onNext(BaseBean<WeiXinBean> weiXinBeanBaseBean) {
                        wXpayBack.WXpaysuccess(weiXinBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
wXpayBack.WXBpayfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        compositeDisposable.add(disposableSubscriber);
    }

    public interface ZFBpayBack
    {
        void  ZFBpaysuccess(BaseBean<String>  BaseBean);
        void  ZFBpayfail(Throwable t);
    }

    public interface WXpayBack
    {
        void  WXpaysuccess(BaseBean<WeiXinBean>  BaseBean);
        void  WXBpayfail(Throwable t);
    }
    public interface OrderBack
    {
        void  Ordersuccess(BaseBean<XDingdanBean>  BaseBean);
        void  Orderfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

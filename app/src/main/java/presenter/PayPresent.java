package presenter;

import base.BaseBean;
import base.Basepresent;
import bean.WeiXinBean;
import bean.XDingdanBean;
import moudle.PayMoudle;
import view.PayView;

/**
 * Created by 地地 on 2018/3/10.
 * 邮箱：461211527@qq.com.
 */

public class PayPresent extends Basepresent {

    private PayMoudle payMoudle;
    private PayView payView;

    public PayPresent(Object view) {
        super(view);
        if(payMoudle==null){
            payMoudle=new PayMoudle();
        }
        payView= (PayView) view;
    }

    public  void  XiaDan(String token,String productId,String payType){

        payMoudle.productorder(token,productId,payType, new PayMoudle.OrderBack() {
            @Override
            public void Ordersuccess(BaseBean<XDingdanBean> BaseBean) {
                if(BaseBean.code==0){
                    payView.XDsuccess(BaseBean.data);
                }else {
                    payView.XDFail(BaseBean.msg);
                }
            }

            @Override
            public void Orderfail(Throwable t) {
                payView.XDFail("网络不给力");
            }
        });
    }

    public  void  ZFBpay(String outTradeNo){

        payMoudle.ZFBpay(outTradeNo, new PayMoudle.ZFBpayBack() {
            @Override
            public void ZFBpaysuccess(BaseBean<String> BaseBean) {
                if(BaseBean.code==0){
                    payView.ZFBPaysuccess(BaseBean.data);
                }else {
                    payView.XDFail(BaseBean.msg);
                }
            }

            @Override
            public void ZFBpayfail(Throwable t) {
                payView.XDFail("网络不给力");
            }
        });

    }

    public  void  WXpay(String outTradeNo){
        payMoudle.WXBpay(outTradeNo, new PayMoudle.WXpayBack() {
            @Override
            public void WXpaysuccess(BaseBean<WeiXinBean> BaseBean) {
                if(BaseBean.code==0){
                    payView.WXPaysuccess(BaseBean.data);
                }else {
                    payView.XDFail(BaseBean.msg);
                }
            }

            @Override
            public void WXBpayfail(Throwable t) {
                payView.XDFail(t.toString());
                System.out.println("ttt"+t.toString());
            }
        });



    }


    public   void   onDestory(){
        this.onDeach();
        payMoudle.onDestory();
    }

}

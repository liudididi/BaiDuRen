package com.example.login_demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.example.login_demo.wxapi.WXPayUtils;

import java.io.IOException;
import java.util.Map;

import base.BaseActivity;
import base.BaseApi;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import untils.MyQusetUtils;
import untils.QuestInterface;
import zfbpay.AliPayResult;
import zfbpay.PayResult;

import static java.security.AccessController.getContext;

//TODO 心理测评
public class MentalityActivity extends BaseActivity {


    @BindView(R.id.mentality_iv_back)
    ImageView mentalityIvBack;
    @BindView(R.id.rl1)
    ImageView rl1;
    @BindView(R.id.rl2)
    ImageView rl2;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case SDK_PAY_FLAG:

                    AliPayResult payResult = new AliPayResult((Map<String, String>) msg.obj);

                    System.out.println("支付宝支付返回："+payResult.toString());

                    switch (payResult.getResultStatus()) {
                        case "9000":
                            Toast.makeText(MentalityActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
                            System.out.println("---------------------支付成功了");
                            break;
                        case "8000":
                            Toast.makeText(MentalityActivity.this,"正在处理中",Toast.LENGTH_SHORT).show();
                            break;
                        case "4000":
                            Toast.makeText(MentalityActivity.this,"订单支付失败",Toast.LENGTH_SHORT).show();
                            break;
                        case "5000":
                            Toast.makeText(MentalityActivity.this,"重复请求",Toast.LENGTH_SHORT).show();
                            break;
                        case "6001":
                            Toast.makeText(MentalityActivity.this,"已取消支付",Toast.LENGTH_SHORT).show();
                            break;
                        case "6002":
                            Toast.makeText(MentalityActivity.this,"网络连接出错",Toast.LENGTH_SHORT).show();
                            break;
                        case "6004":
                            Toast.makeText(MentalityActivity.this,"正在处理中",Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(MentalityActivity.this,"支付失败",Toast.LENGTH_SHORT).show();
                            break;
                    }



                    break;

            }
//            返回码	含义
//            9000	订单支付成功
//            8000	正在处理中，支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
//            4000	订单支付失败
//            5000	重复请求
//            6001	用户中途取消
//            6002	网络连接出错
//            6004	支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
//            其它	其它支付错误

        }
    };

    @Override
    public int getId() {
        return R.layout.activity_mentality;
    }

    @Override
    public void InIt() {

    }

    @OnClick({R.id.mentality_iv_back, R.id.rl1, R.id.rl2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mentality_iv_back:
                finish();
                break;
            case R.id.rl1:
                //final String orderInfo = "alipay_sdk=alipay-sdk-php-20161101&app_id=2017081008126355&biz_content=%7B%22body%22%3A%22%E6%88%90%E4%B8%BA%E5%87%BA%E5%80%9F%E4%BA%BA%22%2C%22subject%22%3A+%22%E6%88%90%E4%B8%BA%E5%87%BA%E5%80%9F%E4%BA%BA%22%2C%22out_trade_no%22%3A+%22201802281500368848896011%22%2C%22timeout_express%22%3A+%2230m%22%2C%22total_amount%22%3A+%220.01%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F59.110.240.72%3A8081%2FHome%2FPayCallBack%2FalipayNotify&sign_type=RSA2&timestamp=2018-02-28+15%3A00%3A36&version=1.0&sign=fmgA16uMMqJjy5iRnzsthd1StSwD6OZkzui26PePI4pa24l1bnuQnjh86asvt6X%2BaxuE7SV024f1142B7CrQEpZcq4jVNAEIuR7UWgyIHgnM5QD8fGfJ6C%2FV7PTuKc%2F23jKPDfrEpWcpJQAu0uuWDGuhg7picDoSiAIIwA7jOBxlqdVqFzofAUD0JDmowCTfNqhulq%2BI16VFu0hkUtFVpgHT%2F%2BohrntMYfGVIaYAHnQVRlCZ7BaWeMl4pY7p4c4Q7syOjoMU8PyvZ6DvCfpT88Lzty6mIhc2klnypBn3fHG4ROuDE4KT%2F9yF6Bb18cChHKlHOS6s0%2F%2FQAeCA0ea3xA%3D%3D";   // 订单信息
                // final String orderInfo ="alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2016091100482610&biz_content=%7B%22out_trade_no%22%3A%2211242425454%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fd5khgr.natappfree.cc%3A8098%2Falipay%2Fpay&sign=B5RZhgVZazPqKXu%2B2BE%2BpBGpyP%2BqF5CCpvNvgS22l8Pk9t7Rzjo4sZcKPKzdWfgX45l88O3zgyUUETgP2Qk2OK7Itub%2FYW6qCtVIH6wDr2WEfGJpJzvSDBf5qwUXxMUYeWBfHcynx4nWY%2F80DYlt9BwOfPtpCfj7JkVLuze1PtfIzpEcMYAGg0jEgH11ixJUF%2FaMf5AkttZBdLD5lYUl2KamTvvBxT6wagM4vDIkb%2FQB2OYxD0zZLTIOCLKe2q8xckgwmjvq%2FWm7yjkID7iVE%2FemQfGEm%2FWT7sgxI4LogIh7ND63cVP67S2BtX%2F3n%2BYgtLBlrsrqZPSafGF5ujph9g%3D%3D&sign_type=RSA2&timestamp=2018-03-01+13%3A28%3A47&version=1.0&sign=B5RZhgVZazPqKXu%2B2BE%2BpBGpyP%2BqF5CCpvNvgS22l8Pk9t7Rzjo4sZcKPKzdWfgX45l88O3zgyUUETgP2Qk2OK7Itub%2FYW6qCtVIH6wDr2WEfGJpJzvSDBf5qwUXxMUYeWBfHcynx4nWY%2F80DYlt9BwOfPtpCfj7JkVLuze1PtfIzpEcMYAGg0jEgH11ixJUF%2FaMf5AkttZBdLD5lYUl2KamTvvBxT6wagM4vDIkb%2FQB2OYxD0zZLTIOCLKe2q8xckgwmjvq%2FWm7yjkID7iVE%2FemQfGEm%2FWT7sgxI4LogIh7ND63cVP67S2BtX%2F3n%2BYgtLBlrsrqZPSafGF5ujph9g%3D%3D";
          final  String orderInfo="alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2016091100482610&biz_content=%7B%22out_trade_no%22%3A%224564651235646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%91%86%E6%B8%A1%E4%BA%BA%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fd5khgr.natappfree.cc%3A8098%2Falipay%2Fpay&sign=sA%2B4w6clYQ6PoqW454MmG6MH38RQ2SYwsnlizcGj7qCZfYwqDwsIwZ%2BPQOkZw7a1U6NkryQo8%2FXkaiK5Urqj69Bz14DshISdVpG2AaCu6lJ1A93ZSWw0L5lnjTcD%2BM6VRdico%2FAPQS0Veut6rINQXKFNu2G5p2WPXZNnnHZiM6YDYr48vLKAgMaiINzr85nqSQkfFWH7M%2B9xR7bjwspzw4ptZNcxepbai0MwtuDpFx5YLH%2BIgh7fD4mpWT9wr9UkgcKMrD0wLXzikhUAkambAdme2j8tX0tp2jIjd3qHiFph%2B7wlIAsQrVsi%2F%2BPSBGqub70Gn%2B08Q5A8wBc137G8uA%3D%3D&sign_type=RSA2&timestamp=2018-03-01+13%3A50%3A23&version=1.0&sign=sA%2B4w6clYQ6PoqW454MmG6MH38RQ2SYwsnlizcGj7qCZfYwqDwsIwZ%2BPQOkZw7a1U6NkryQo8%2FXkaiK5Urqj69Bz14DshISdVpG2AaCu6lJ1A93ZSWw0L5lnjTcD%2BM6VRdico%2FAPQS0Veut6rINQXKFNu2G5p2WPXZNnnHZiM6YDYr48vLKAgMaiINzr85nqSQkfFWH7M%2B9xR7bjwspzw4ptZNcxepbai0MwtuDpFx5YLH%2BIgh7fD4mpWT9wr9UkgcKMrD0wLXzikhUAkambAdme2j8tX0tp2jIjd3qHiFph%2B7wlIAsQrVsi%2F%2BPSBGqub70Gn%2B08Q5A8wBc137G8uA%3D%3D";
                Runnable payRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(MentalityActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo,true);
                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                // 必须异步调用
                Thread payThread = new Thread(payRunnable);
                payThread.start();

       /*     {
                "msg": "success",
                    "code": 0,
                    "data": {
                "appId": "wx6a6810597dadc392",
                        "nonceStr": "1345008214",
                        "package": "Sign=WXPay",
                        "partnerId": "1496598622",
                        "prepayId": "wx20180303134458805252",
                        "sign": "28F70F7923B17D091C4EEBA72155B648",
                        "timeStamp": "1520055901"
            }
            }*/
         //微信
               /* WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                builder.setAppId("wxe2968cf994de5a67")
                        .setPartnerId("1488556492")
                        .setPrepayId("wx20180305115200089f2b68430197967460")
                        .setPackageValue("Sign=WXPay")
                        .setNonceStr("amLaW1aivpqSWV2HYLtVD")
                        .setTimeStamp("1520221920")
                        .setSign("0CAAA0C2D769541827D688503A668EB3")
                        .build().toWXPayNotSign(this,"wxe2968cf994de5a67");*/
                break;
            case R.id.rl2:
               intent(this,ProfessionStarActivity.class);

                //专业星空
              // intent(this,MajorStarActivity.class);



                break;
        }
    }
}

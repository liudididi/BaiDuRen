package com.example.login_demo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.login_demo.wxapi.WXPayUtils;

import java.util.Map;

import base.BaseActivity;
import bean.WeiXinBean;
import bean.XDingdanBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.WishFragMent;
import presenter.PayPresent;
import untils.SPUtils;
import view.PayView;
import zfbpay.AliPayResult;

public class Buy2Activity extends BaseActivity implements PayView {


    @BindView(R.id.buy2_iv_back)
    ImageView buy2IvBack;
    @BindView(R.id.tv_goumai2)
    TextView tvGoumai2;
    @BindView(R.id.buy2_tvdjs)
    TextView buy2Tvdjs;
    private PayPresent payPresent;

    private int pay = 2;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case SDK_PAY_FLAG:

                    AliPayResult payResult = new AliPayResult((Map<String, String>) msg.obj);

                    System.out.println("支付宝支付返回：" + payResult.toString());

                    switch (payResult.getResultStatus()) {
                        case "9000":
                            Toast.makeText(Buy2Activity.this, "支付成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Buy2Activity.this, EFCJieSuoActivity.class);
                            startActivity(intent);
                            finish();
                            break;
                        case "8000":
                            Toast.makeText(Buy2Activity.this, "正在处理中", Toast.LENGTH_SHORT).show();
                            break;
                        case "4000":
                            Toast.makeText(Buy2Activity.this, "订单支付失败", Toast.LENGTH_SHORT).show();
                            break;
                        case "5000":
                            Toast.makeText(Buy2Activity.this, "重复请求", Toast.LENGTH_SHORT).show();
                            break;
                        case "6001":
                            Toast.makeText(Buy2Activity.this, "已取消支付", Toast.LENGTH_SHORT).show();
                            break;
                        case "6002":
                            Toast.makeText(Buy2Activity.this, "网络连接出错", Toast.LENGTH_SHORT).show();
                            break;
                        case "6004":
                            Toast.makeText(Buy2Activity.this, "正在处理中", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(Buy2Activity.this, "支付失败", Toast.LENGTH_SHORT).show();
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
    private String token;

    @Override
    public int getId() {
        return R.layout.activity_buy2;
    }

    @Override
    public void InIt() {
        payPresent = new PayPresent(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        payPresent.onDestory();
    }

    public void tanchuang(Context context, final String outTradeNo) {
        pay = 2;
        final Dialog dialog = new Dialog(context, R.style.Theme_Light_Dialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dingdan_layout, null);
        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.dialogStyle);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        //将自定义布局加载到dialog上
        dialog.setContentView(dialogView);
        dialog.show();
        ImageView iv_chahao = dialogView.findViewById(R.id.iv_chahao);
        RelativeLayout rl5 = dialogView.findViewById(R.id.rl5);
        RelativeLayout rl6 = dialogView.findViewById(R.id.rl6);
        final ImageView iv_weixin_dui = dialogView.findViewById(R.id.iv_weixin_dui);
        final ImageView iv_zhifubao_dui = dialogView.findViewById(R.id.iv_zhifubao_dui);
        TextView tv_queren = dialogView.findViewById(R.id.tv_queren);
        TextView diangdan_money = dialogView.findViewById(R.id.diangdan_money);
        TextView tv_bianhao = dialogView.findViewById(R.id.tv_bianhao);
        TextView tv_mingcheng = dialogView.findViewById(R.id.tv_mingcheng);
        tv_mingcheng.setText("EFC学业规划");
        tv_bianhao.setText(outTradeNo);
        diangdan_money.setText("698");
        iv_chahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        rl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_weixin_dui.setVisibility(View.VISIBLE);
                iv_zhifubao_dui.setVisibility(View.GONE);
                pay = 2;
            }
        });
        rl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_weixin_dui.setVisibility(View.GONE);
                iv_zhifubao_dui.setVisibility(View.VISIBLE);
                pay = 1;
            }
        });
        tv_queren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pay == 1) {
                    payPresent.ZFBpay(outTradeNo);
                } else {
                    payPresent.WXpay("2018031214532415355763");
                }

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
                dialog.cancel();
            }
        });
    }

    @OnClick({R.id.buy2_iv_back, R.id.tv_goumai2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buy2_iv_back:
                Intent intent = new Intent(this, BuyActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_goumai2:
                if(token.length()>4){
                  //  payPresent.XiaDan(token,"3",pay+"");
                   Toast.makeText(Buy2Activity.this, "支付成功", Toast.LENGTH_SHORT).show();
                   Intent intent3 = new Intent(Buy2Activity.this, EFCJieSuoActivity.class);
                   startActivity(intent3);
                   finish();
                }else {
              Toast("用户未登录");

                }
                break;
        }
    }

    @Override
    public void XDsuccess(XDingdanBean xDingdanBean) {
        if (xDingdanBean != null) {
            String outTradeNo = xDingdanBean.getOutTradeNo();
            tanchuang(Buy2Activity.this,outTradeNo);
        }

    }

    @Override
    public void ZFBPaysuccess(final String orderinfo) {
        //  final  String orderInfo="alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2016091100482610&biz_content=%7B%22body%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22out_trade_no%22%3A%222018031016260614933445%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22pay%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F6ya7kc.natappfree.cc%2Falipay%2Fpay&sign=NqORNz%2BNXCciqd8oFc1G3DYfUznjZYkfOiMU8RKs09FWq5o%2Fp2Pmg64M3HoRAHNOLabdkVyRlEVakRBorzPXI%2B1KBF7bkzX5Z9Dfy1w7bz6%2BiFX0BRptzk6u2fpn0M965BHxsj3y8q4%2FJ%2BhdhL%2B0%2BQd0Yp8qfFtxv9M9jN7ixRgLJ%2BfeQ1HIkM9O7cwxfYFo6tgTfgMSzjVM8heLKfZ3KUQkHIEDaaeOt%2FhOwhSbWZFHKvIdrz2v8orsqEJAIaKAM%2BpSlxmEUnw7TPCihEU8TghG8MIzhecas17GlmzjfBJQgOWxypP46VonUKdehcezechrhEsF3J%2BVyY6LFUVmMw%3D%3D&sign_type=RSA2&timestamp=2018-03-10+16%3A26%3A16&version=1.0&sign=NqORNz%2BNXCciqd8oFc1G3DYfUznjZYkfOiMU8RKs09FWq5o%2Fp2Pmg64M3HoRAHNOLabdkVyRlEVakRBorzPXI%2B1KBF7bkzX5Z9Dfy1w7bz6%2BiFX0BRptzk6u2fpn0M965BHxsj3y8q4%2FJ%2BhdhL%2B0%2BQd0Yp8qfFtxv9M9jN7ixRgLJ%2BfeQ1HIkM9O7cwxfYFo6tgTfgMSzjVM8heLKfZ3KUQkHIEDaaeOt%2FhOwhSbWZFHKvIdrz2v8orsqEJAIaKAM%2BpSlxmEUnw7TPCihEU8TghG8MIzhecas17GlmzjfBJQgOWxypP46VonUKdehcezechrhEsF3J%2BVyY6LFUVmMw%3D%3D";
        if (orderinfo != null) {

            Runnable payRunnable = new Runnable() {
                @Override
                public void run() {
                    PayTask alipay = new PayTask(Buy2Activity.this);
                    Map<String, String> result = alipay.payV2(orderinfo, true);
                    Message msg = new Message();
                    msg.what = SDK_PAY_FLAG;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                }
            };
            // 必须异步调用
            Thread payThread = new Thread(payRunnable);
            payThread.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (WishFragMent.djs != null) {
            buy2Tvdjs.setText(WishFragMent.djs);
        }
        token = (String) SPUtils.get(MyApp.context, "token", "");
    }
    @Override
    public void WXPaysuccess(WeiXinBean weiXinBean) {
        if (weiXinBean != null) {
            WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
            builder.setAppId(weiXinBean.getAppId())
                    .setPartnerId(weiXinBean.getPartnerId())
                    .setPrepayId(weiXinBean.getPrepayId())
                    .setPackageValue(weiXinBean.getPackageX())
                    .setNonceStr(weiXinBean.getNonceStr())
                    .setTimeStamp(weiXinBean.getTimeStamp())
                    .setSign(weiXinBean.getSign())
                    .build().toWXPayNotSign(this, weiXinBean.getAppId());
        }
    }

    @Override
    public void XDFail(String s) {
        Toast(s);
    }


}

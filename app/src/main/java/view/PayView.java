package view;

import bean.WeiXinBean;
import bean.XDingdanBean;

/**
 * Created by 地地 on 2018/3/10.
 * 邮箱：461211527@qq.com.
 */

public interface PayView {
  void  XDsuccess(XDingdanBean xDingdanBean);
  void  ZFBPaysuccess(String orderinfo);
  void  WXPaysuccess(WeiXinBean weiXinBean);
  void  XDFail(String s);



}

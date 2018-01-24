package view;

import base.BaseBean;
import bean.UserBean;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public interface LoginView {
    void  loginsuccess(String msg, BaseBean<UserBean> baseBean);
    void  loginfail(String msg);
    void  CaptChasuccess(String msg);
    void  CaptChaFail(String msg);
}

package view;

import java.util.List;

import base.BaseBean;
import bean.GailvBean;
import bean.LuquXianBean;
import bean.SchoolEnrollBean;

/**
 * Created by 祝文 on 2018/2/5.
 */

public interface SchoolEnrollView {
    void SchoolEnrollsuccess(BaseBean<List<SchoolEnrollBean>> listBaseBean);
    void SchoolEnrollfail(Throwable t);

    void GetlvBeansuccess(List<GailvBean> listBaseBean);
    void GetlvBeanfail(String msg);




    void LuquXianBeansuccess(List<LuquXianBean> listBaseBean);
    void LuquXianBeanfail(String msg);
}

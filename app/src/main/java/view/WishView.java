package view;

import java.util.List;

import base.BaseBean;
import bean.CanSchoolBean;
import bean.SlideshowBean;

/**
 * Created by 祝文 on 2018/1/25.
 */

public interface WishView {
    void  Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean);
    void  Wishfail(Throwable t);

    //能上的大学
    void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean);
    void CanSchoolfail(Throwable t);






}

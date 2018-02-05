package view;

import java.util.List;

import base.BaseBean;
import bean.NewsBean;
import bean.SlideshowBean;
import bean.TitleBean;

/**
 * Created by 祝文 on 2018/1/20.
 */

public interface SlideshowView {
    //轮播图
    void  Slideshowsuccess(BaseBean<List<SlideshowBean>> listBaseBean);
    void  Slideshowfail(Throwable t);
    //九宫格
    void  Sudokusuccess(BaseBean<List<SlideshowBean>> listBaseBean);
    void  Sudokufail(Throwable t);

    //热门专题
    void   HotTopsuccess(BaseBean<NewsBean> listBaseBean);
    void   HotTopfail(Throwable t);
    //精选专题
    void   Recommendsuccess(BaseBean<NewsBean> listBaseBean);
    void   Recommendfail(Throwable t);
    //高考头条专题
    void   Collegesuccess(BaseBean<TitleBean> titleBeanBaseBean);
    void   Collegefail(Throwable t);
}

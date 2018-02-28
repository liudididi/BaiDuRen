package view;

import java.util.List;

import base.BaseBean;
import bean.NewsBean;
import bean.SlideshowBean;

/**
 * Created by 祝文 on 2018/2/27.
 */

public interface CollegeTitleView {
    void CollegeTitlesuccess(BaseBean<List<SlideshowBean>> listBaseBean);
    void CollegeTitlefail(Throwable t);

    void CollegeNewssuccess(BaseBean<NewsBean> newsBeanBaseBean);
    void CollegeNewsfail(Throwable t);
}

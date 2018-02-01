package view;

import java.util.List;

import bean.HotBean;
import bean.SearchBean;

/**
 * Created by 地地 on 2018/1/31.
 * 邮箱：461211527@qq.com.
 */

public interface SearchView {

    void  SearchSuccess(List<SearchBean> list);
    void  SearchFail(String msg);



    void  HotSuccess(List<HotBean> list);
    void  HotFail(String msg);

}

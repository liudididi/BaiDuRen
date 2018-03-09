package view;

import java.util.List;

import base.BaseBean;
import bean.OneTableXQBean;

/**
 * Created by 祝文 on 2018/3/6.
 */

public interface OnTableXQView {
    void OneTableXQsuccess(BaseBean<List<OneTableXQBean>> listBaseBean);
    void OneTableXQfail(Throwable t);
}

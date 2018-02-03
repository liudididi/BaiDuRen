package view;

import java.util.List;

import base.BaseBean;
import bean.OneTableBean;

/**
 * Created by 祝文 on 2018/2/2.
 */

public interface OneTableView {
    void OneTablesuccess(BaseBean<List<OneTableBean>> listBaseBean);
    void OneTablefail(Throwable t);
}

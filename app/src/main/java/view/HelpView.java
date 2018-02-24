package view;

import java.util.List;

import base.BaseBean;
import bean.HelpBean;

/**
 * Created by 祝文 on 2018/2/23.
 */

public interface HelpView {
    void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean);
    void Helpfail(Throwable t);
}

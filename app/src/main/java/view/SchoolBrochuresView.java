package view;

import java.util.List;

import base.BaseBean;
import bean.SchoolBrochuresBean;

/**
 * Created by 祝文 on 2018/2/7.
 */

public interface SchoolBrochuresView {
    void Brochuressuccess(BaseBean<List<SchoolBrochuresBean>> listBaseBean);
    void Brochuresfail(Throwable t);
}

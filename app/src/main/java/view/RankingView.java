package view;

import base.BaseBean;
import bean.RanKingSchoolBean;

/**
 * Created by 祝文 on 2018/1/30.
 */

public interface RankingView {
    void RanKingsuccess(BaseBean<RanKingSchoolBean> ranKingSchoolBeanBaseBean);
    void RanKingfail(Throwable t);
}

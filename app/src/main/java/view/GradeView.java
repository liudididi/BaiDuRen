package view;

import base.BaseBean;
import bean.CanSchoolBean;
import bean.InquireBean;

/**
 * Created by 祝文 on 2018/1/27.
 */

public interface GradeView {
    //添加成绩
    void Gradesuccess(BaseBean baseBean);
    void Gradefail(Throwable t);
    //查询成绩
    void Inquiresuccess(BaseBean<InquireBean> inquireBeanBaseBean);
    void Inquirefail(Throwable t);

}

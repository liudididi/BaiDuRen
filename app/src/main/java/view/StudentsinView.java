package view;

import java.util.List;

import base.BaseBean;
import bean.StudentsinBean;
import bean.StudentsinNewsBean;

/**
 * Created by 祝文 on 2018/2/3.
 */

public interface StudentsinView {
    void Suggestsuccess(BaseBean<List<StudentsinBean>> listBaseBean);
    void  Studentsinfail(Throwable t);
    void StudentsinNewssuccess(BaseBean<StudentsinNewsBean> studentsinNewsBeanBaseBean);
    void  StudentsinNewsfail(Throwable t);
}

package view;

import java.util.List;

import base.BaseBean;
import bean.StudentsinBean;

/**
 * Created by 祝文 on 2018/2/3.
 */

public interface StudentsinView {
    void Suggestsuccess(BaseBean<List<StudentsinBean>> listBaseBean);
    void  Studentsinfail(Throwable t);
}

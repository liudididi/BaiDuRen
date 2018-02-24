package view;

import java.util.List;

import base.BaseBean;
import bean.StudentFromBean;

/**
 * Created by 地地 on 2018/2/23.
 * 邮箱：461211527@qq.com.
 */

public interface School_SummaryView {

    void  Studentfromsuccess( List<StudentFromBean> listBaseBean);
    void  StudentfromFail(String msg);

}

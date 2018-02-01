package view;

import java.util.List;

import bean.CheckSchoolBean;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public interface MoreSchoolView  {


    void  CheckSuccess(List<CheckSchoolBean> list);
    void  CheckFail(String msg);
}

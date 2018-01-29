package view;

import java.util.List;

import bean.MajorBean;
import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public interface MySchoolView {
    void  getSchoolsuccess(List<SchoolBean> list , String msg);
    void  getSchoolfail(String msg);


    void  getMajorsuccess(List<MajorBean> list , String msg);
    void  getMajorfail(String msg);
}

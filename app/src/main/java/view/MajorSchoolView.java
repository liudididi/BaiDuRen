package view;

import java.util.List;

import bean.MajorSchoolBean;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public  interface MajorSchoolView {


    void  MarjorSchoolSuccess(List<MajorSchoolBean> list);
    void  MarjorSchoolFail(String msg);
}

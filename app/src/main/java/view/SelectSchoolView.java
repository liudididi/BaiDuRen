package view;

import java.util.List;

import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public interface SelectSchoolView {
    void  getProvicesuccess(List<ProviceBean> list, String msg);
    void  getProvicefail(String msg);

    void  getCitysuccess(List<CityBean> list, String msg);
    void  getCityfail(String msg);


    void  getAreassuccess(List<AreaBean> list, String msg);
    void  getAreasfail(String msg);

    void  getSchoolssuccess(List<SelectSchoolBean> list, String msg);
    void  getSchoolfail(String msg);

}

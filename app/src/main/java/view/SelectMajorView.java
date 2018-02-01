package view;

import java.util.List;

import bean.SelectMajorBean;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public interface SelectMajorView {

    void  SelectMajorSuccess(List<SelectMajorBean>  list);
    void  SelectMajorFail(String msg );

}

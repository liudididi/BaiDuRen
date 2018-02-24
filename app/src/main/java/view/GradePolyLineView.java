package view;

import java.util.List;

import base.BaseBean;
import bean.GradePolyBean;

/**
 * Created by 地地 on 2018/2/24.
 * 邮箱：461211527@qq.com.
 */

public interface GradePolyLineView {
    void GradePolysuccess( List<GradePolyBean> baseBean);
    void GradePolyfail(String t);


}

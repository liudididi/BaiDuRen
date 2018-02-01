package view;

import java.util.List;

import bean.MoreJobBean;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public interface MorJobView {

    void  MorJobSuccess(List<MoreJobBean> list);
    void  MorJobFail(String msg);
}

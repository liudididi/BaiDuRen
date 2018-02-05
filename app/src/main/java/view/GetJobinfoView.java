package view;

import java.util.List;

import bean.JobInforBean;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public interface GetJobinfoView {
    void  GetJobinfoSuccess(List<JobInforBean> list);
    void  GetJobinfoFail(String msg);


}

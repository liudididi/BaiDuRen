package view;

import java.util.List;

import bean.StartFl;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public interface StartFView  {
    void  Stratjobsuccess( List<StartFl> list);
    void  Stratjobfail(String msg);

}

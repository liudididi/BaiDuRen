package view;

import java.util.List;

import bean.VisionBean;

/**
 * Created by 地地 on 2018/3/2.
 * 邮箱：461211527@qq.com.
 */

public interface VerSionView {
    void  VersionSuccess(List<VisionBean> list);
    void  VersionFail(String s);
}

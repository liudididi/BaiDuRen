package view;

import java.util.List;

import base.BaseBean;
import bean.CampusBean;
import bean.FingerpostBean;
import bean.SchoolIntroduceBean;

/**
 * Created by 祝文 on 2018/2/25.
 */

public interface SchoolIntroduceView {
    //院校介绍
    void Introducesuccess(BaseBean<List<SchoolIntroduceBean>> listBaseBean);
    void Introducefail(Throwable t);
    //报考指南
    void Fingerpostsuccess(BaseBean<List<FingerpostBean>> listBaseBean);
    void Fingerpostfail(Throwable t);
    //校园生活
    void Campussuccess(BaseBean<List<CampusBean>> listBaseBean);
    void Campusfail(Throwable t);
}

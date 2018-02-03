package view;

import base.BaseBean;
import bean.StudyBean;

/**
 * Created by 祝文 on 2018/2/1.
 */

public interface StudyView {
    void Studysuccess(BaseBean<StudyBean> studyBeanBaseBean);
    void Studyfail(Throwable t);
}


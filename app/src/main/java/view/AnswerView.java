package view;

import java.util.List;

import base.BaseBean;
import bean.AnswerBean;

/**
 * Created by 祝文 on 2018/3/3.
 */

public interface AnswerView {
    void Answersuccess(BaseBean<List<AnswerBean>> listBaseBean);
    void Answerfail(Throwable t);
}

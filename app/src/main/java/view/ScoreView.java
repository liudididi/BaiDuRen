package view;

import java.util.List;

import base.BaseBean;
import bean.ScoreBean1;
import bean.ScoreBean2;

/**
 * Created by 祝文 on 2018/2/2.
 */

public interface ScoreView {
    void Score1success(BaseBean<List<ScoreBean1>> listBaseBean);
    void Score1fail(Throwable t);

    void Score2success(BaseBean<List<ScoreBean2>> listBaseBean);
    void Score2fail(Throwable t);
}

package view;

import base.BaseBean;

/**
 * Created by 祝文 on 2018/1/30.
 */

public interface CountdownView {
    void Countdownsuccess(BaseBean baseBean);
    void Countdownfail(Throwable t);
}

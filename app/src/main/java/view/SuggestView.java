package view;

import base.BaseBean;

/**
 * Created by 祝文 on 2018/1/24.
 */

public interface SuggestView {
    void Suggestsuccess(BaseBean baseBean);
    void Suggestfail(Throwable t);
}

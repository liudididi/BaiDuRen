package view;

import java.util.List;

import base.BaseBean;
import bean.ProviceBean;
import bean.ProvinceBean;

/**
 * Created by 祝文 on 2018/1/31.
 */

public interface ProvinceView {
    void Provincesuccess(BaseBean<List<ProvinceBean>> listBaseBean);
    void Provincefail(Throwable t);


}

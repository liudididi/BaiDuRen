package view;

import java.util.List;

import base.BaseBean;
import bean.ForecastBean;

/**
 * Created by 祝文 on 2018/2/23.
 */

public interface ForecastView {
    void Forecastsuccess(BaseBean<List<ForecastBean>> listBaseBean);
    void Forecastfail(Throwable t);
}

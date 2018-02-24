package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.ForecastBean;
import moudle.ForecastMoudle;
import view.ForecastView;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class ForecastPresent extends Basepresent {
    private ForecastView forecastView;
    private ForecastMoudle forecastMoudle;
    public ForecastPresent(Object view) {
        super(view);
        if(forecastMoudle==null)
        {
            forecastMoudle=new ForecastMoudle();
        }
        forecastView= (ForecastView) view;
    }

    public void ForecastPresent(String province, String classify , String university)
    {
        forecastMoudle.Forecast(province, classify, university, new ForecastMoudle.ForecastBack() {
            @Override
            public void Forecastsuccess(BaseBean<List<ForecastBean>> listBaseBean) {
                forecastView.Forecastsuccess(listBaseBean);
            }

            @Override
            public void Forecastfail(Throwable t) {
                forecastView.Forecastfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        forecastMoudle.onDestory();
    }
}

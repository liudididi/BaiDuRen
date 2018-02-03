package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.ProviceBean;
import bean.ProvinceBean;
import moudle.ProvinceMoudle;
import view.ProvinceView;

/**
 * Created by 祝文 on 2018/1/31.
 */

public class ProvincePresent extends Basepresent {
    private ProvinceMoudle provinceMoudle;
    private ProvinceView provinceView;
    public ProvincePresent(Object view) {
        super(view);
       if(provinceMoudle==null)
       {
           provinceMoudle=new ProvinceMoudle();
       }
        provinceView= (ProvinceView) view;
    }

    public void ProvincePresent(String province)
    {
        provinceMoudle.Province(province,new ProvinceMoudle.ProvinceBack() {
            @Override
            public void Provincesuccess(BaseBean<List<ProvinceBean>> listBaseBean) {
                provinceView.Provincesuccess(listBaseBean);
            }

            @Override
            public void Provincefail(Throwable t) {
                provinceView.Provincefail(t);
            }
        });
    }

    public   void  onDestory(){
        this.onDeach();
        provinceMoudle.onDestory();
    }
}

package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.GailvBean;
import bean.SchoolEnrollBean;
import moudle.SchoolEnrollMoudle;
import view.SchoolEnrollView;

/**
 * Created by 祝文 on 2018/2/5.
 */

public class SchoolEnrollPresent extends Basepresent {
    private SchoolEnrollMoudle schoolEnrollMoudle;
    private SchoolEnrollView schoolEnrollView;
    public SchoolEnrollPresent(Object view) {
        super(view);
        if(schoolEnrollMoudle==null)
        {
            schoolEnrollMoudle=new SchoolEnrollMoudle();
        }
        schoolEnrollView= (SchoolEnrollView) view;
    }
    public void SchoolEnrollPresent(String name, String province, String type)
    {
        schoolEnrollMoudle.SchoolEnroll(name, province, type, new SchoolEnrollMoudle.SchoolEnrollBack() {
            @Override
            public void SchoolEnrollsuccess(BaseBean<List<SchoolEnrollBean>> listBaseBean) {
                schoolEnrollView.SchoolEnrollsuccess(listBaseBean);
            }

            @Override
            public void SchoolEnrollfail(Throwable t) {
                schoolEnrollView.SchoolEnrollfail(t);
            }
        });
    }

    public  void  getscoreCompareMobil(String province, String classify, String  schoolname){
        schoolEnrollMoudle.getscoreCompareMobil(province, classify, schoolname, new SchoolEnrollMoudle.GailvBeanBack() {
            @Override
            public void SchoolEnrollsuccess(BaseBean<List<GailvBean>> listBaseBean) {
                if(listBaseBean.code==0){
                    schoolEnrollView.GetlvBeansuccess(listBaseBean.data );
                }else {
                    schoolEnrollView.GetlvBeanfail(listBaseBean.msg);
                }
            }

            @Override
            public void SchoolEnrollfail(Throwable t) {
                schoolEnrollView.GetlvBeanfail(t.toString());
            }
        });




    }

    public   void  onDestory(){
        this.onDeach();
        schoolEnrollMoudle.onDestory();
    }
}

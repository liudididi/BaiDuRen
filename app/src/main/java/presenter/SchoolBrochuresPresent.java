package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.SchoolBrochuresBean;
import moudle.SchoolBrochuresMoudle;
import view.SchoolBrochuresView;

/**
 * Created by 祝文 on 2018/2/7.
 */

public class SchoolBrochuresPresent extends Basepresent {
    private SchoolBrochuresMoudle schoolBrochuresMoudle;
    private SchoolBrochuresView schoolBrochuresView;

    public SchoolBrochuresPresent(Object view) {
        super(view);
        if(schoolBrochuresMoudle==null)
        {
            schoolBrochuresMoudle=new SchoolBrochuresMoudle();
        }
        schoolBrochuresView= (SchoolBrochuresView) view;
    }
    public void SchoolBrochuresPresent(String name)
    {
        schoolBrochuresMoudle.Brochures(name, new SchoolBrochuresMoudle.BrochuresBack() {
            @Override
            public void Brochuressuccess(BaseBean<List<SchoolBrochuresBean>> listBaseBean) {
                schoolBrochuresView.Brochuressuccess(listBaseBean);
            }

            @Override
            public void Brochuresfail(Throwable t) {
                schoolBrochuresView.Brochuresfail(t);
            }
        });
    }
}

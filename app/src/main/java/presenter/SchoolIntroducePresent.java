package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.CampusBean;
import bean.FingerpostBean;
import bean.SchoolIntroduceBean;
import moudle.SchoolIntroduceMoudle;
import view.SchoolIntroduceView;
import view.School_SummaryView;

/**
 * Created by 祝文 on 2018/2/25.
 */

public class SchoolIntroducePresent extends Basepresent {
    private SchoolIntroduceView schoolIntroduceView;
    private SchoolIntroduceMoudle schoolIntroduceMoudle;

    public SchoolIntroducePresent(Object view) {
        super(view);
        if(schoolIntroduceMoudle==null)
        {
            schoolIntroduceMoudle=new SchoolIntroduceMoudle();
        }
        schoolIntroduceView= (SchoolIntroduceView) view;
    }
    //校园介绍
    public void SchoolIntroducePresent(String name)
    {
        schoolIntroduceMoudle.Introduce(name, new SchoolIntroduceMoudle.IntroduceBack() {
            @Override
            public void Introducesuccess(BaseBean<List<SchoolIntroduceBean>> listBaseBean) {
                schoolIntroduceView.Introducesuccess(listBaseBean);
            }

            @Override
            public void Introducefail(Throwable t) {
                schoolIntroduceView.Introducefail(t);
            }
        });
    }
    //报考指南
    public void FingerpostPresent(String name)
    {
        schoolIntroduceMoudle.Fingerpost(name, new SchoolIntroduceMoudle.FingerpostBack() {
            @Override
            public void Fingerpostsuccess(BaseBean<List<FingerpostBean>> listBaseBean) {
                schoolIntroduceView.Fingerpostsuccess(listBaseBean);
            }

            @Override
            public void Fingerpostfail(Throwable t) {
                schoolIntroduceView.Fingerpostfail(t);
            }
        });
    }
    //校园生活
    public void CampusPresent(String name)
    {
        schoolIntroduceMoudle.Campus(name, new SchoolIntroduceMoudle.CampusBack() {
            @Override
            public void Campussuccess(BaseBean<List<CampusBean>> listBaseBean) {
                schoolIntroduceView.Campussuccess(listBaseBean);
            }

            @Override
            public void Campusfail(Throwable t) {
                schoolIntroduceView.Campusfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        schoolIntroduceMoudle.onDestory();
    }
}

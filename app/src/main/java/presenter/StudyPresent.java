package presenter;

import base.BaseBean;
import base.Basepresent;
import bean.StudyBean;
import moudle.StudyMoudle;
import moudle.SuggestMoudle;
import view.StudyView;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class StudyPresent extends Basepresent {
    private StudyMoudle studyMoudle;
    private StudyView studyView;

    public StudyPresent(Object view) {
        super(view);
        if(studyMoudle==null)
        {
            studyMoudle=new StudyMoudle();
        }
        studyView= (StudyView) view;
    }
    public void StudyPresent(String category, String province , String subject, String grade, String page, String limit)
    {
        studyMoudle.Study(category, province, subject, grade, page, limit, new StudyMoudle.StudyBack() {
            @Override
            public void Studysuccess(BaseBean<StudyBean> studyBeanBaseBean) {
                studyView.Studysuccess(studyBeanBaseBean);
            }

            @Override
            public void Studyfail(Throwable t) {
                studyView.Studyfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        studyMoudle.onDestory();
    }

}

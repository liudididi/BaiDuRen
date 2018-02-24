package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.StudentFromBean;
import moudle.School_SummaryMoudle;
import view.School_SummaryView;

/**
 * Created by 地地 on 2018/2/23.
 * 邮箱：461211527@qq.com.
 */

public class School_SummaryPresent  extends Basepresent{
    private School_SummaryMoudle school_summaryMoudle;
    private School_SummaryView school_summaryView;

    public School_SummaryPresent(Object view) {
        super(view);
        if(school_summaryMoudle==null){
            school_summaryMoudle=new School_SummaryMoudle();
        }
        school_summaryView= (School_SummaryView) view;
    }


    public  void  StudentFrom(String name){

        school_summaryMoudle.studentFrom(name, new School_SummaryMoudle.StudentFromBack() {
            @Override
            public void Studentsuccess(BaseBean<List<StudentFromBean>> BeanBaseBean) {
                if(BeanBaseBean.code==0){
                    school_summaryView.Studentfromsuccess(BeanBaseBean.data);
                }else {
                    school_summaryView.StudentfromFail(BeanBaseBean.msg);
                }
            }

            @Override
            public void Studentfail(Throwable t) {
                school_summaryView.StudentfromFail(t.toString());
            }
        });


    }



}

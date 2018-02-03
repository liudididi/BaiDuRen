package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.StudentsinBean;
import moudle.StudentsinMoudle;
import view.StudentsinView;

/**
 * Created by 祝文 on 2018/2/3.
 */

public class StudentsinPresent extends Basepresent {
    private StudentsinMoudle studentsinMoudle;
    private StudentsinView studentsinView;

    public StudentsinPresent(Object view) {
        super(view);
        if(studentsinMoudle==null)
        {
            studentsinMoudle=new StudentsinMoudle();
        }
        studentsinView= (StudentsinView) view;
    }
    public void StudentsinPresent(String address, String schooltype)
    {
        studentsinMoudle.Studentsin(address, schooltype, new StudentsinMoudle.StudentsinBack() {
            @Override
            public void Suggestsuccess(BaseBean<List<StudentsinBean>> listBaseBean) {
                studentsinView.Suggestsuccess(listBaseBean);
            }

            @Override
            public void Studentsinfail(Throwable t) {
                studentsinView.Studentsinfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        studentsinMoudle.onDestory();
    }
}

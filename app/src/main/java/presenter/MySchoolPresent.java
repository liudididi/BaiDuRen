package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.MajorBean;
import bean.SchoolBean;
import moudle.MySchoolMoudle;
import view.MySchoolView;

/**
 * Created by 地地 on 2018/1/26.
 * 邮箱：461211527@qq.com.
 */

public class MySchoolPresent extends Basepresent {
    private  MySchoolMoudle mySchoolMoudle;
    private MySchoolView mySchoolView;
    public MySchoolPresent(Object view) {
        super(view);
        if( mySchoolMoudle==null){
         mySchoolMoudle=new MySchoolMoudle();
        }
        mySchoolView= (MySchoolView) view;
    }

    public  void  getSchollCollection(String token) {
        mySchoolMoudle.getSchollCollection(token, new MySchoolMoudle.SchoolBack() {
            @Override
            public void Schoolsuccess(BaseBean<List<SchoolBean>> Basebean) {
                if (Basebean.code == 0) {
                    mySchoolView.getSchoolsuccess(Basebean.data, Basebean.msg);
                } else {
                    mySchoolView.getSchoolfail(Basebean.msg);
                }

            }

            @Override
            public void Schoolfail(Throwable t) {
                mySchoolView.getSchoolfail(t.toString());
            }
        });
    }
    public  void  getmajorCollection(String token){
        mySchoolMoudle.getmajorCollection(token, new MySchoolMoudle.marjorBack() {
            @Override
            public void majorsuccess(BaseBean<List<MajorBean>> Basebean) {
                System.out.println("baseben"+Basebean.code);
                if (Basebean.code == 0) {
                    mySchoolView.getMajorsuccess(Basebean.data, Basebean.msg);
                } else {
                    mySchoolView.getSchoolfail(Basebean.msg);
                }
            }

            @Override
            public void majorfail(Throwable t) {
                mySchoolView.getSchoolfail(t.toString());
            }
        });
    }
    public   void   onDestory(){
        this.onDeach();
        mySchoolMoudle.onDestory();
    }
}

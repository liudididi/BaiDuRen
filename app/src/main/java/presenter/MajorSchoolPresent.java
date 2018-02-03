package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.MajorSchoolBean;
import moudle.MajorSchoolMoudle;
import view.MajorSchoolView;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class MajorSchoolPresent  extends Basepresent{
  private MajorSchoolMoudle majorSchoolMoudle;
 private MajorSchoolView majorSchoolView;

    public MajorSchoolPresent(Object view) {
        super(view);
        if(majorSchoolMoudle==null){
            majorSchoolMoudle=new MajorSchoolMoudle();
        }
        majorSchoolView= (MajorSchoolView) view;
    }


    public void  getMajorschool(String majorid){

      majorSchoolMoudle.getMajorSchool(majorid, new MajorSchoolMoudle.MajorSchoolBack() {
          @Override
          public void MajorSchoolsuccess(BaseBean<List<MajorSchoolBean>> listBasebean) {
              if(listBasebean.code==0){
                  majorSchoolView.MarjorSchoolSuccess(listBasebean.data);
              }else {
                  majorSchoolView.MarjorSchoolFail(listBasebean.msg);
              }

          }

          @Override
          public void MajorSchoolfail(Throwable t) {
              majorSchoolView.MarjorSchoolFail(t.toString());
          }
      });

    }



    public   void  onDestory(){
        this.onDeach();
        majorSchoolMoudle.onDestory();
    }

}

package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.GradePolyBean;
import moudle.GradePolyLineMoudle;
import view.GradePolyLineView;

/**
 * Created by 地地 on 2018/2/24.
 * 邮箱：461211527@qq.com.
 */

public class GradePolyLinePresent extends Basepresent {

    public GradePolyLineMoudle gradePolyLineMoudle;
   public GradePolyLineView gradePolyLineView;
    public GradePolyLinePresent(Object view) {
        super(view);
        if(gradePolyLineMoudle==null){
            gradePolyLineMoudle=new GradePolyLineMoudle();
        }
        gradePolyLineView= (GradePolyLineView) view;
    }
    public  void  getUserResultPng(int type, String course, String token){
        gradePolyLineMoudle.getUserResultPng(type, course, token, new GradePolyLineMoudle.GradePolyBack() {
            @Override
            public void GradePolysuccess(BaseBean<List<GradePolyBean>> baseBean) {
                if(baseBean.code==0){
                    gradePolyLineView.GradePolysuccess(baseBean.data);
                }else {
                    gradePolyLineView.GradePolyfail(baseBean.msg);
                }

            }

            @Override
            public void GradePolyfail(Throwable t) {
                gradePolyLineView.GradePolyfail(t.toString());
            }
        });



    }
    public   void   onDestory(){
        this.onDeach();
        gradePolyLineMoudle.onDestory();
    }

}

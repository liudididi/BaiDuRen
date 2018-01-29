package presenter;

import com.example.login_demo.MyApp;

import base.BaseBean;
import base.Basepresent;
import bean.CanSchoolBean;
import bean.InquireBean;
import moudle.GradeMoudle;
import untils.SPUtils;
import view.GradeView;

/**
 * Created by 祝文 on 2018/1/27.
 */

public class GradePresent extends Basepresent {
    private GradeView gradeView;
    private GradeMoudle gradeMoudle;
    public GradePresent(Object view) {
        super(view);
        if(gradeMoudle==null)
        {
            gradeMoudle=new GradeMoudle();
        }
        gradeView= (GradeView) view;
    }
    //添加成绩单
    public void GradePresente(int testType, int time, Double chinese, Double math, Double languages, Double physics, Double chemistry, Double biology, Double history, Double geography, Double politics, Double specialty, String token)
    {

        gradeMoudle.Grade(testType, time, chinese, math, languages, physics, chemistry, biology, history, geography, politics, specialty, token, new GradeMoudle.GradeBack() {
            @Override
            public void Gradesuccess(BaseBean baseBean) {
                gradeView.Gradesuccess(baseBean);
            }

            @Override
            public void Gradefail(Throwable t) {
                gradeView.Gradefail(t);
            }
        });
    }
    //查询成绩
    public void InquirePresente(int testType, int testTime,String token)
    {
        gradeMoudle.Inquire(testType, testTime, token, new GradeMoudle.InquireBack() {
            @Override
            public void Inquiresuccess(BaseBean<InquireBean> inquireBeanBaseBean) {
                gradeView.Inquiresuccess(inquireBeanBaseBean);
            }

            @Override
            public void Inquirefail(Throwable t) {
                gradeView.Inquirefail(t);
            }
        });
    }


    public   void  onDestory(){
        this.onDeach();
        gradeMoudle.onDestory();
    }
}

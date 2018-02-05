package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.JobInforBean;
import moudle.GetJobinfoMoudle;
import view.GetJobinfoView;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class GetJobinfoPresent extends Basepresent {
   private GetJobinfoMoudle getJobinfoMoudle;
   private  GetJobinfoView  getJobinfoView;

    public GetJobinfoPresent(Object view) {
        super(view);
        if(getJobinfoMoudle==null){
            getJobinfoMoudle=new GetJobinfoMoudle();
        }
    getJobinfoView= (GetJobinfoView) view;
    }

    public  void  getJobInfo(String jobName){

        getJobinfoMoudle.getJobInfo(jobName, new GetJobinfoMoudle.JobInfoBack() {
            @Override
            public void JobInfosuccess(BaseBean<List<JobInforBean>> listBaseBean) {
                if(listBaseBean.code==0){
                    getJobinfoView.GetJobinfoSuccess(listBaseBean.data);
                }else {
                    getJobinfoView.GetJobinfoFail(listBaseBean.msg);
                }
            }

            @Override
            public void JobInfofail(Throwable t) {
                getJobinfoView.GetJobinfoFail(t.toString());
            }
        });

    }
    public   void   onDestory(){
        this.onDeach();
        getJobinfoMoudle.onDestory();
    }


}

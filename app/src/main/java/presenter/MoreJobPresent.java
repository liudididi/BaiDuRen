package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.MoreJobBean;
import moudle.MoreJobMoudle;
import view.MorJobView;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class MoreJobPresent  extends Basepresent{
    private MoreJobMoudle moreJobMoudle;
    private MorJobView  morJobView;


    public MoreJobPresent(Object view) {
        super(view);
        if(moreJobMoudle==null){
            moreJobMoudle=new MoreJobMoudle();
        }
       morJobView= (MorJobView) view;
    }


    public  void  selectAllJob(){
        moreJobMoudle.selectAllJob(new MoreJobMoudle.MoreJobChaBack() {
            @Override
            public void MoreJobsuccess(BaseBean<List<MoreJobBean>> listBasebean) {
                if(listBasebean.code==0){
                    morJobView.MorJobSuccess(listBasebean.data);
                }else {
                    morJobView.MorJobFail(listBasebean.msg);
                }
            }

            @Override
            public void MoreJobfail(Throwable t) {
       morJobView.MorJobFail(t.toString());
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        moreJobMoudle.onDestory();
    }
}

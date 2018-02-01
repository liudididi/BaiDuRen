package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.CheckSchoolBean;
import moudle.MoreSchoolMoudle;
import view.MoreSchoolView;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class MoreSchoolPresent  extends Basepresent {

    private MoreSchoolMoudle moreSchoolMoudle;
    private MoreSchoolView moreSchoolView;
    public MoreSchoolPresent(Object view) {
        super(view);
        if(moreSchoolMoudle==null){
            moreSchoolMoudle=new MoreSchoolMoudle();
        }
      moreSchoolView= (MoreSchoolView) view;
    }

    public  void  checkschool(String address,String type){

        moreSchoolMoudle.checkschool(address, type, new MoreSchoolMoudle.CheckBeanBack() {
            @Override
            public void CheckBeansuccess(BaseBean<List<CheckSchoolBean>> Basebean) {

                if(Basebean.code==0){
                    moreSchoolView.CheckSuccess(Basebean.data);
                }else {
                    moreSchoolView.CheckFail(Basebean.msg);
                }

            }
            @Override
            public void CheckBeanfail(Throwable t) {
                moreSchoolView.CheckFail(t.toString());
            }
        });
    }

    public   void  onDestory(){
        this.onDeach();
        moreSchoolMoudle.onDestory();
    }

}

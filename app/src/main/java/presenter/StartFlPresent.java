package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.StartFl;
import moudle.StartFlMoudle;
import view.StartFView;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public class StartFlPresent  extends Basepresent{
    private StartFlMoudle startFlMoudle;
    private StartFView startFView;

    public StartFlPresent(Object view) {
        super(view);
        if(startFlMoudle==null){
            startFlMoudle=new StartFlMoudle();
        }
        startFView= (StartFView) view;
    }


  public  void  getStartfl(String classify, String type, String fenlei){

      startFlMoudle.getStartfl(classify, type, fenlei, new StartFlMoudle.StratjobBack() {
          @Override
          public void Stratjobsuccess(BaseBean<List<StartFl>> listBaseBean) {
              if(listBaseBean.code==0){
                  startFView.Stratjobsuccess(listBaseBean.data);
              }else {
                  startFView.Stratjobfail(listBaseBean.msg);
              }
          }

          @Override
          public void Stratjobfail(Throwable t) {
              startFView.Stratjobfail("网络较差");
          }
      });


  }
    public   void  onDestory(){
        this.onDeach();
        startFlMoudle.onDestory();
    }

}

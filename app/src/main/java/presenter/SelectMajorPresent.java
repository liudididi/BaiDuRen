package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.SelectMajorBean;
import moudle.SlectMajorForMoudle;
import view.SelectMajorView;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public class SelectMajorPresent  extends Basepresent{

  private  SlectMajorForMoudle slectMajorForMoudle;
  private SelectMajorView selectMajorView;


    public SelectMajorPresent(Object view) {
        super(view);
        if(slectMajorForMoudle==null){
            slectMajorForMoudle=new SlectMajorForMoudle();
        }
        selectMajorView= (SelectMajorView) view;
    }

    public  void  selectAllMajor(String majortype){

        slectMajorForMoudle.selectAllMajor(majortype, new SlectMajorForMoudle.SelectMajorBack() {
            @Override
            public void Areaasssuccess(BaseBean<List<SelectMajorBean>> Basebean) {
                if(Basebean.code==0){
                    selectMajorView.SelectMajorSuccess(Basebean.data);
                }else {
                    selectMajorView.SelectMajorFail(Basebean.msg);
                }

            }

            @Override
            public void Areasfail(Throwable t) {
                selectMajorView.SelectMajorFail(t.toString());
            }
        });

    }
    public   void   onDestory(){
        this.onDeach();
      slectMajorForMoudle.onDestory();
    }

}

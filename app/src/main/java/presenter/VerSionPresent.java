package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.VisionBean;
import moudle.VerSionMoudle;
import view.VerSionView;

/**
 * Created by 地地 on 2018/3/2.
 * 邮箱：461211527@qq.com.
 */

public class VerSionPresent  extends Basepresent {

    private VerSionMoudle verSionMoudle;
   private VerSionView verSionView;
    public VerSionPresent(Object view) {
        super(view);
        if(verSionMoudle==null){
            verSionMoudle=new VerSionMoudle();
        }
        verSionView= (VerSionView) view;
    }


    public  void  versioninfo(String vertype){

        verSionMoudle.getVersioninfo(vertype, new VerSionMoudle.VersionBack() {
            @Override
            public void Versionsuccess(BaseBean<List<VisionBean>> listBaseBean) {
                if(listBaseBean.code==0){
                    verSionView.VersionSuccess(listBaseBean.data);
                }else {
                    verSionView.VersionFail(listBaseBean.msg);
                }
            }

            @Override
            public void Versionfail(Throwable t) {
                verSionView.VersionFail(t.toString());
            }
        });


    }
    public   void  onDestory(){
        this.onDeach();
        verSionMoudle.onDestory();
    }
}

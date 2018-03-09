package presenter;

import android.widget.Toast;

import base.BaseBean;
import base.Basepresent;
import moudle.GetBackMoudle;
import moudle.LogInMoudle;
import view.GetBackView;

/**
 * Created by 地地 on 2018/1/22.
 * 邮箱：461211527@qq.com.
 */

public class GetBackPresent extends Basepresent {
     private GetBackMoudle getBackMoudle;
     private GetBackView getBackView;
    public GetBackPresent(Object view) {
        super(view);
        if(getBackMoudle==null){
            getBackMoudle=new GetBackMoudle();
        }
        getBackView= (GetBackView) view;
    }

   public  void   UpdateCaptcha(String mobile){
        getBackMoudle.UpdateCaptcha(mobile, new GetBackMoudle.UpdataCaptChaBack() {
            @Override
            public void CaptChasuccess(BaseBean listBasebean) {
                String msg = listBasebean.msg;
                System.out.println("msg========="+msg);
                    getBackView.getBackSuccess(msg);

            }

            @Override
            public void CaptChafail(Throwable t) {
             getBackView.getBackfail(t.toString());
        }
        });
   }
    public  void   findPwdByMobile(String mobile,String captcha,String newspassword ){
       getBackMoudle.findPwdByMobile(mobile, captcha, newspassword, new GetBackMoudle.findPwdByMobileBack() {
           @Override
           public void CaptChasuccess(BaseBean listBasebean) {
               String msg = listBasebean.msg;

                   getBackView.getBackUpsuccess(msg);

           }

           @Override
           public void CaptChafail(Throwable t) {
               getBackView.getBackUpfail(t.toString());
           }
       });

    }


    public   void   onDestory(){
        this.onDeach();
        getBackMoudle.onDestory();
    }


}

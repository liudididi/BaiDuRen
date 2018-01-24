package presenter;

import base.BaseBean;
import base.Basepresent;
import moudle.ChangePhoneMoudle;
import view.ChangePhoneView;

/**
 * Created by 地地 on 2018/1/24.
 * 邮箱：461211527@qq.com.
 */

public class ChangePhonePresent extends Basepresent {
    private ChangePhoneMoudle changePhoneMoudle;
   private ChangePhoneView  changePhoneView;

    public ChangePhonePresent(Object view) {
        super(view);
        if(changePhoneMoudle==null){
            changePhoneMoudle=new ChangePhoneMoudle();
        }
       this.changePhoneView= (ChangePhoneView) view;
    }

    public  void  mobileUpdateCaptcha(String mobile){
        changePhoneMoudle.mobileUpdateCaptcha(mobile, new ChangePhoneMoudle.ChangePhoneCaptChaBack() {
            @Override
            public void CaptChasuccess(BaseBean listBasebean) {
                String msg = listBasebean.msg;
                if(listBasebean.code==0){
                    changePhoneView.getCaptChaSuccess(msg);
                }else {
                    changePhoneView.getCaptChafail(msg);
                }
            }

            @Override
            public void CaptChafail(Throwable t) {
                changePhoneView.getCaptChafail(t.toString());
            }
        });
    }

    public   void   onDestory(){
        this.onDeach();
       changePhoneMoudle.onDestory();
    }

}

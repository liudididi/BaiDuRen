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
                changePhoneView.getCaptChafail("请稍后重试");
            }
        });
    }

    public  void  updateMobileVerifyOld(String mobile,String captcha,String token){
        changePhoneMoudle.updateMobileVerifyOld(mobile, captcha, token, new ChangePhoneMoudle.OldphoneCaptChaBack() {
            @Override
            public void CaptChasuccess(BaseBean Basebean) {
                if(Basebean.code==0){
                    changePhoneView.oldPhonesuccess(Basebean.msg);
                }else {
                    changePhoneView.oldPhonefail(Basebean.msg);
                }
            }

            @Override
            public void CaptChafail(Throwable t) {
               changePhoneView.oldPhonefail("请稍后重试");
            }
        });
    }

    public  void  updateMobile(String mobile,String captcha,String token){

        changePhoneMoudle.updateMobile(mobile, captcha, token, new ChangePhoneMoudle.NewphoneCaptChaBack() {
            @Override
            public void CaptChasuccess(BaseBean Basebean) {
                if(Basebean.code==0){
                    changePhoneView.newPhonesuccess(Basebean.msg);
                }else {
                    changePhoneView.newPhonefail(Basebean.msg);
                }
            }

            @Override
            public void CaptChafail(Throwable t) {
                 changePhoneView.newPhonefail("请稍后重试");
            }
        });

    }

    public   void   onDestory(){
        this.onDeach();
       changePhoneMoudle.onDestory();
    }

}

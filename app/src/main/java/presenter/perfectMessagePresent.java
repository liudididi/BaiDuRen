package presenter;

import android.widget.Toast;

import base.BaseBean;
import base.Basepresent;
import moudle.perfectMessageMoudle;
import view.perfectMessageView;

/**
 * Created by 地地 on 2018/1/28.
 * 邮箱：461211527@qq.com.
 */

public class perfectMessagePresent  extends Basepresent {

   private perfectMessageMoudle perfectMessageMoudle;
   private perfectMessageView  perfectMessageView;



    public perfectMessagePresent(Object view) {
        super(view);
        if(perfectMessageMoudle==null){
            perfectMessageMoudle=new perfectMessageMoudle();
        }
        this.perfectMessageView= (view.perfectMessageView) view;
    }


    public  void modifyUserinfoMoble(String provice, String city, String area,
                                 String midSchool, String grade, String name,
                                 String sex, String examYear, String stuType,
                                 boolean isSpecial, String token)
    {

        perfectMessageMoudle.modifyUserinfoMoble(provice, city, area, midSchool, grade, name, sex, examYear, stuType, isSpecial, token, new perfectMessageMoudle.UserinfoBack() {
            @Override
            public void Userinfosuccess(BaseBean listBaseBean) {
                if(listBaseBean.code==0){
                    perfectMessageView.UserinfoSuccess(listBaseBean.msg);
                }else {
                   perfectMessageView.UserinfoFail(listBaseBean.msg);
                }
            }

            @Override
            public void Userinfofail(Throwable t) {
                perfectMessageView.UserinfoFail(t.toString());
            }
        });

    }
}

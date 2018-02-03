package presenter;

import base.BaseBean;
import base.Basepresent;
import bean.MajorgkBean;
import moudle.MajorgkMoudle;
import view.MajorgkView;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class MajorgkPresent  extends Basepresent{

    private MajorgkMoudle majorgkMoudle;
    private MajorgkView majorgkView;

    public MajorgkPresent(Object view) {
        super(view);
        if(majorgkMoudle==null){
            majorgkMoudle=new MajorgkMoudle();
        }
        majorgkView= (MajorgkView) view;
    }

    public void  getMajorgk(String majorgkid){

        majorgkMoudle.getMajorgk(majorgkid, new MajorgkMoudle.MajorgkBack() {
            @Override
            public void Majorgksuccess(BaseBean<MajorgkBean> listBasebean) {
                if(listBasebean.code==0){
                    majorgkView.MajorgkSusccess(listBasebean.data);
                }else {
                    majorgkView.MajorgkFail(listBasebean.msg);
                }
            }

            @Override
            public void Majorgkfail(Throwable t) {
                majorgkView.MajorgkFail(t.toString());
            }
        });


    }

    public   void   onDestory(){
        this.onDeach();
       majorgkMoudle.onDestory();
    }



}

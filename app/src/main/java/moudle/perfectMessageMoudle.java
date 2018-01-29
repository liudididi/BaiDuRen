package moudle;

import base.BaseBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/28.
 * 邮箱：461211527@qq.com.
 */

public class perfectMessageMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();


    public  void  modifyUserinfoMoble(String provice, String city, String area,
                                      String midSchool, String grade, String name,
                                      String sex, String examYear, String stuType,
                                      boolean isSpecial, String token, final UserinfoBack userinfoBack)
    {

        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance().
                getQuestInterface().modifyUserinfoMoble(provice,city,area,midSchool,grade,"null",name,sex,examYear,stuType,isSpecial,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {
                         userinfoBack.Userinfosuccess(baseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                      userinfoBack.Userinfofail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }


    public interface UserinfoBack
    {
        void  Userinfosuccess(BaseBean listBaseBean);
        void  Userinfofail(Throwable t);
    }

    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

}

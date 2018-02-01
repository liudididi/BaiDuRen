package moudle;

import java.util.List;

import base.BaseBean;
import bean.AreaBean;
import bean.SelectMajorBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public class SlectMajorForMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public  void  selectAllMajor(String majorType, final SelectMajorBack selectMajorBack){
        DisposableSubscriber<BaseBean<List<SelectMajorBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().selectAllMajor(majorType)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SelectMajorBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SelectMajorBean>> listBaseBean) {
                        selectMajorBack.Areaasssuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                    selectMajorBack.Areasfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }


    public  interface  SelectMajorBack{
        void  Areaasssuccess(BaseBean<List<SelectMajorBean>> Basebean);
        void  Areasfail(Throwable t);
    }


    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }
}

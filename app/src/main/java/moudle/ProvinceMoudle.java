package moudle;

import java.util.List;

import base.BaseBean;
import bean.ProviceBean;
import bean.ProvinceBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/31.
 */

public class ProvinceMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //省控线查询
    public void Province(String province ,final ProvinceBack provinceBack)
    {
        DisposableSubscriber<BaseBean<List<ProvinceBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().province(province)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<ProvinceBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<ProvinceBean>> listBaseBean) {
                        provinceBack.Provincesuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        provinceBack.Provincefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }


    //省控线查询的接口
    public interface ProvinceBack
    {
        void Provincesuccess(BaseBean<List<ProvinceBean>> listBaseBean);
        void Provincefail(Throwable t);
    }

    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

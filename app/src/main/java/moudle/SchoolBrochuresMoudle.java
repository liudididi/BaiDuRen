package moudle;

import java.util.List;

import base.BaseBean;
import bean.SchoolBrochuresBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/7.
 */

public class SchoolBrochuresMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //招生简章
    public void Brochures(String name, final BrochuresBack brochuresBack)
    {
        DisposableSubscriber<BaseBean<List<SchoolBrochuresBean>>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface().schoolbrochures(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SchoolBrochuresBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SchoolBrochuresBean>> listBaseBean) {
                        brochuresBack.Brochuressuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        brochuresBack.Brochuresfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    //提交建议的接口
    public interface BrochuresBack
    {
        void Brochuressuccess(BaseBean<List<SchoolBrochuresBean>> listBaseBean);
        void Brochuresfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

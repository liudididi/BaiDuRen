package moudle;

import java.util.List;

import base.BaseBean;
import bean.VisionBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/3/2.
 * 邮箱：461211527@qq.com.
 */

public class VerSionMoudle {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();
  public  void  getVersioninfo(String versiontype, final VersionBack versionBack){


      DisposableSubscriber<BaseBean<List<VisionBean>>> disposableSubscriber =
              MyQusetUtils.getInstance().getQuestInterface().getversioninfo(versiontype)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(new DisposableSubscriber<BaseBean<List<VisionBean>>>() {
                  @Override
                  public void onNext(BaseBean<List<VisionBean>> listBaseBean) {
                      versionBack.Versionsuccess(listBaseBean);
                  }

                  @Override
                  public void onError(Throwable t) {
                      versionBack.Versionfail(t);
                  }

                  @Override
                  public void onComplete() {

                  }
              });
      compositeDisposable.add(disposableSubscriber);

  }

    public interface VersionBack
    {
        void  Versionsuccess(BaseBean<List<VisionBean>> listBaseBean);
        void  Versionfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

}

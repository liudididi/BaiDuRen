package moudle;

import java.util.List;

import base.BaseBean;
import bean.HotBean;
import bean.SearchBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/31.
 * 邮箱：461211527@qq.com.
 */

public class SearchMoudle  {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

  public  void  searchmajorCollege(String name, final SearchBack searchBack){
      DisposableSubscriber<BaseBean<List<SearchBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().searchmajorCollege(name)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(new DisposableSubscriber<BaseBean<List<SearchBean>>>() {
                  @Override
                  public void onNext(BaseBean<List<SearchBean>> listBaseBean) {
                      searchBack.Searchsuccess(listBaseBean);
                  }

                  @Override
                  public void onError(Throwable t) {
                      searchBack.Searchfail(t);
                  }

                  @Override
                  public void onComplete() {

                  }
              });

      compositeDisposable.add(disposableSubscriber);
  }



  public  void  queryHot(final HotBack hotBack){
      DisposableSubscriber<BaseBean<List<HotBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().queryHot()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribeWith(new DisposableSubscriber<BaseBean<List<HotBean>>>() {
                  @Override
                  public void onNext(BaseBean<List<HotBean>> listBaseBean) {
                      hotBack.Hotsuccess(listBaseBean);
                  }

                  @Override
                  public void onError(Throwable t) {
                    hotBack.Hotchfail(t);

                  }

                  @Override
                  public void onComplete() {

                  }
              });

      compositeDisposable.add(disposableSubscriber);
  }



    public  void  hotsave(String name){
        DisposableSubscriber<BaseBean> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().
                  hotsave(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean>() {
                    @Override
                    public void onNext(BaseBean baseBean) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    public interface SearchBack
    {
        void Searchsuccess(BaseBean<List<SearchBean>> BaseBean);
        void Searchfail(Throwable t);
    }


    public interface HotBack
    {
        void Hotsuccess(BaseBean<List<HotBean>> BaseBean);
        void Hotchfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }


}

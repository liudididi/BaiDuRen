package moudle;

import java.util.List;

import base.BaseBean;
import bean.NewsBean;
import bean.SlideshowBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/27.
 */

public class CollegeTitleMoudle {


    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //新闻高考头条轮播图
    public void CollegeTitle(int board_id, final CollegeTitleBack collegeTitleBack)
    {
        DisposableSubscriber<BaseBean<List<SlideshowBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().Slideshow(board_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SlideshowBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SlideshowBean>> listBaseBean) {
                        collegeTitleBack.CollegeTitlesuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        collegeTitleBack.CollegeTitlefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //高考新闻
    public void CollegeNews(String category, String province, String page, String limit, final CollegeNewsBack collegeNewsBack)
    {
        DisposableSubscriber<BaseBean<NewsBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().News(category, province, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<NewsBean>>() {
                    @Override
                    public void onNext(BaseBean<NewsBean> newsBeanBaseBean) {
                        collegeNewsBack.CollegeNewssuccess(newsBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        collegeNewsBack.CollegeNewsfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }
    //高考新闻
    public interface CollegeNewsBack
    {
        void CollegeNewssuccess(BaseBean<NewsBean> newsBeanBaseBean);
        void CollegeNewsfail(Throwable t);
    }
    //新闻高考头条轮播图的接口
    public interface CollegeTitleBack
    {
        void CollegeTitlesuccess(BaseBean<List<SlideshowBean>> listBaseBean);
        void CollegeTitlefail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

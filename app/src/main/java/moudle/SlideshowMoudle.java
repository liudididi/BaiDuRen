package moudle;

import java.util.List;

import base.BaseBean;
import bean.NewsBean;
import bean.SlideshowBean;
import bean.TitleBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/1/20.
 */

public class SlideshowMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //首页轮播图模块
    public void Slideshow(int board_id, final SlideshowBack slideshowBack)
    {
        DisposableSubscriber<BaseBean<List<SlideshowBean>>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface().Slideshow(board_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SlideshowBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SlideshowBean>> listBaseBean) {
                        slideshowBack.Slideshowsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        slideshowBack.Slideshowfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //首页九宫格模块
    public void Sudoku(int board_id, final SudokuBack sudokuBack)
    {
        DisposableSubscriber<BaseBean<List<SlideshowBean>>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().Slideshow(board_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SlideshowBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SlideshowBean>> listBaseBean) {
                        sudokuBack.Sudokusuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        sudokuBack.Sudokufail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }


    //首页热门专题回调接口
    public void HotTop(String category, String province, String page, String limit, final HotTopBack hotTopBack)
    {
        DisposableSubscriber<BaseBean<NewsBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().News(category, province, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<NewsBean>>() {
                    @Override
                    public void onNext(BaseBean<NewsBean> listBaseBean) {
                        hotTopBack.HotTopsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        hotTopBack.HotTopfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    //首页精选专题回调接口
    public void Recommend(String category, String province, String page, String limit, final RecommendBack recommendBack)
    {
        DisposableSubscriber<BaseBean<NewsBean>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().News(category, province, page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<NewsBean>>() {
                    @Override
                    public void onNext(BaseBean<NewsBean> listBaseBean) {
                        recommendBack.Recommendsuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        recommendBack.Recommendfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }

    //高考头条专题回调接口
    public void College(String page, String limit, final CollegeBack collegeBack)
    {
        DisposableSubscriber<BaseBean<TitleBean>> disposableSubscriber = MyQusetUtils.getInstance().getQuestInterface().TitleNews(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<TitleBean>>() {
                    @Override
                    public void onNext(BaseBean<TitleBean> titleBeanBaseBean) {
                        collegeBack.Collegesuccess(titleBeanBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        collegeBack.Collegefail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    //高考头条专题
    public  interface  CollegeBack{
        void   Collegesuccess(BaseBean<TitleBean> titleBeanBaseBean);
        void   Collegefail(Throwable t);
    }
    //精选推荐专题
    public  interface  RecommendBack{
        void   Recommendsuccess(BaseBean<NewsBean> listBaseBean);
        void   Recommendfail(Throwable t);
    }
    //热门专题
    public  interface  HotTopBack{
        void   HotTopsuccess(BaseBean<NewsBean> listBaseBean);
        void   HotTopfail(Throwable t);
    }
    //首页九宫格回调接口
    public  interface  SudokuBack{
        void  Sudokusuccess(BaseBean<List<SlideshowBean>> listBaseBean);
        void  Sudokufail(Throwable t);
    }
    //首页轮播图回调接口
    public  interface  SlideshowBack{
        void  Slideshowsuccess(BaseBean<List<SlideshowBean>> listBaseBean);
        void  Slideshowfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

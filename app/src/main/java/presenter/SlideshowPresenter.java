package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.NewsBean;
import bean.SlideshowBean;
import bean.TitleBean;
import moudle.SlideshowMoudle;
import view.SlideshowView;

/**
 * Created by 祝文 on 2018/1/20.
 */

public class SlideshowPresenter extends Basepresent {
    private SlideshowMoudle slideshowMoudle;
    private SlideshowView slideshowView;
    public SlideshowPresenter(Object view) {
        super(view);
        if(slideshowMoudle==null)
        {
            slideshowMoudle=new SlideshowMoudle();
        }
        slideshowView= (SlideshowView) view;
    }

    //XBanner
    public void SlideshowPresenter(int board_id)
    {
        slideshowMoudle.Slideshow(board_id, new SlideshowMoudle.SlideshowBack() {
            @Override
            public void Slideshowsuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
                slideshowView.Slideshowsuccess(listBaseBean);
            }

            @Override
            public void Slideshowfail(Throwable t) {
                slideshowView.Slideshowfail(t);
            }
        });
    }
    //九宫格
    public void SudokuPresenter(int board_id)
    {
         slideshowMoudle.Sudoku(board_id, new SlideshowMoudle.SudokuBack() {
             @Override
             public void Sudokusuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
                 slideshowView.Sudokusuccess(listBaseBean);
             }

             @Override
             public void Sudokufail(Throwable t) {
                 slideshowView.Sudokufail(t);
             }
         });
    }
    //热门专题
    public void HotTopPresenter(String category, String province, String page, String limit)
    {
        slideshowMoudle.HotTop(category, province, page, limit, new SlideshowMoudle.HotTopBack() {
            @Override
            public void HotTopsuccess(BaseBean<NewsBean> listBaseBean) {
                slideshowView.HotTopsuccess(listBaseBean);
            }

            @Override
            public void HotTopfail(Throwable t) {
                slideshowView.HotTopfail(t);
            }
        });
    }
    //精选推荐
    public void RecommenPresenter(String category, String province, String page, String limit)
    {
        slideshowMoudle.Recommend(category, province, page, limit, new SlideshowMoudle.RecommendBack() {
            @Override
            public void Recommendsuccess(BaseBean<NewsBean> listBaseBean) {
                slideshowView.Recommendsuccess(listBaseBean);
            }

            @Override
            public void Recommendfail(Throwable t) {
                slideshowView.Recommendfail(t);
            }
        });
    }
    //高考头条
    public void CollegePresenter(String page, String limit)
    {
        slideshowMoudle.College( page, limit, new SlideshowMoudle.CollegeBack() {
            @Override
            public void Collegesuccess(BaseBean<TitleBean> listBaseBean) {
                slideshowView.Collegesuccess(listBaseBean);
            }

            @Override
            public void Collegefail(Throwable t) {
                slideshowView.Collegefail(t);
            }
        });
    }
    public   void   onDestory(){
        this.onDeach();
        slideshowMoudle.onDestory();
    }
}

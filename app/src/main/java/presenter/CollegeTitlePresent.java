package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.NewsBean;
import bean.SlideshowBean;
import moudle.CollegeTitleMoudle;
import view.CollegeTitleView;

/**
 * Created by 祝文 on 2018/2/27.
 */

public class CollegeTitlePresent extends Basepresent {
    private CollegeTitleMoudle collegeTitleMoudle;
    private CollegeTitleView collegeTitleView;

    public CollegeTitlePresent(Object view) {
        super(view);
        if(collegeTitleMoudle==null)
        {
            collegeTitleMoudle=new CollegeTitleMoudle();
        }
        collegeTitleView= (CollegeTitleView) view;
    }
    public void CollegeTitlePresent(int board_id)
    {
        collegeTitleMoudle.CollegeTitle(board_id, new CollegeTitleMoudle.CollegeTitleBack() {
            @Override
            public void CollegeTitlesuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
                collegeTitleView.CollegeTitlesuccess(listBaseBean);
            }

            @Override
            public void CollegeTitlefail(Throwable t) {
                collegeTitleView.CollegeTitlefail(t);
            }
        });
    }
    public void CollegeNewsPresent(String category, String province, String page, String limit)
    {
        collegeTitleMoudle.CollegeNews(category, province, page, limit, new CollegeTitleMoudle.CollegeNewsBack() {
            @Override
            public void CollegeNewssuccess(BaseBean<NewsBean> newsBeanBaseBean) {
                collegeTitleView.CollegeNewssuccess(newsBeanBaseBean);
            }

            @Override
            public void CollegeNewsfail(Throwable t) {
                collegeTitleView.CollegeNewsfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        collegeTitleMoudle.onDestory();
    }
}

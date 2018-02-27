package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.CanSchoolBean;
import bean.SlideshowBean;
import moudle.GradeMoudle;
import moudle.WishMoudle;
import view.WishView;

/**
 * Created by 祝文 on 2018/1/25.
 */

public class WishPresent extends Basepresent {
    private WishMoudle wishMoudle;
    private WishView wishView;
    public WishPresent(Object view) {
        super(view);
        if(wishMoudle==null)
        {
            wishMoudle=new WishMoudle();
        }
        wishView= (WishView) view;
    }

    public void WishPresenter(int board_id)
    {
        wishMoudle.Wish(board_id, new WishMoudle.WishBack() {
            @Override
            public void Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
                wishView.Wishsuccess(listBaseBean);
            }

            @Override
            public void Wishfail(Throwable t) {
                wishView.Wishfail(t);
            }
        });
    }

    //能上的学校
    public void CanSchoolPresente(String province, String classify, String score_min, String score_max, String page, String limit)
    {
        wishMoudle.canSchool(province, classify, score_min, score_max, page, limit, new WishMoudle.CanSchoolBack() {
            @Override
            public void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
                wishView.CanSchoolsuccess(canSchoolBeanBaseBean);
            }

            @Override
            public void CanSchoolfail(Throwable t) {
                wishView.CanSchoolfail(t);
            }
        });

    }
    public void CompleCanSchoolPresente(String minScore, String maxScore, String cityType, String isAccept,  String schoolType,String isMS,String province,String classify)
    {
       wishMoudle.completcanSchool(minScore, maxScore,cityType, isAccept, schoolType,isMS,province,classify, new WishMoudle.CanSchoolBack() {
           @Override
           public void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
               wishView.CanSchoolsuccess(canSchoolBeanBaseBean);
           }

           @Override
           public void CanSchoolfail(Throwable t) {
               wishView.CanSchoolfail(t);
           }
       });

    }
    public   void   onDestory(){
        this.onDeach();
        wishMoudle.onDestory();
    }
}

package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.SlideshowBean;
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

    public   void   onDestory(){
        this.onDeach();
        wishMoudle.onDestory();
    }
}

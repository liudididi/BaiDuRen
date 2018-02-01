package presenter;

import base.BaseBean;
import base.Basepresent;
import bean.RanKingSchoolBean;
import moudle.RankingMoudle;
import moudle.SuggestMoudle;
import view.RankingView;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class RanKingPresent extends Basepresent {
    private RankingMoudle rankingMoudle;
    private RankingView rankingView;

    public RanKingPresent(Object view) {
        super(view);
        if(rankingMoudle==null)
        {
            rankingMoudle=new RankingMoudle();
        }
        rankingView= (RankingView) view;
    }
    public void RanKingPresent(int page, int limit)
    {
        rankingMoudle.RanKing(page, limit, new RankingMoudle.RanKingBack() {
            @Override
            public void RanKingsuccess(BaseBean<RanKingSchoolBean> ranKingSchoolBeanBaseBean) {
                rankingView.RanKingsuccess(ranKingSchoolBeanBaseBean);
            }

            @Override
            public void RanKingfail(Throwable t) {
                rankingView.RanKingfail(t);
            }
        });
    }

    public   void  onDestory(){
        this.onDeach();
        rankingMoudle.onDestory();
    }
}

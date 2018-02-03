package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.ScoreBean1;
import bean.ScoreBean2;
import moudle.ScoreMoudle;
import view.ScoreView;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class ScorePresent extends Basepresent {
    private ScoreMoudle scoreMoudle;
    private ScoreView scoreView;

    public ScorePresent(Object view) {
        super(view);
        if(scoreMoudle==null)
        {
            scoreMoudle=new ScoreMoudle();
        }
        scoreView= (ScoreView) view;
    }

    public void ScorePresent(String province, String classify)
    {
        scoreMoudle.Score(province, classify, new ScoreMoudle.Score1Back() {
            @Override
            public void Score1success(BaseBean<List<ScoreBean1>> listBaseBean) {
                scoreView.Score1success(listBaseBean);
            }

            @Override
            public void Score1fail(Throwable t) {
                scoreView.Score1fail(t);
            }
        });
    }
    public void Score2Present(String province, String university )
    {
        scoreMoudle.Score2(province, university, new ScoreMoudle.Score2Back() {
            @Override
            public void Score2success(BaseBean<List<ScoreBean2>> listBaseBean) {
                scoreView.Score2success(listBaseBean);
            }

            @Override
            public void Score2fail(Throwable t) {
                scoreView.Score2fail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        scoreMoudle.onDestory();
    }
}

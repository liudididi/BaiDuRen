package presenter;

import base.BaseBean;
import base.Basepresent;
import moudle.CountdownMoudle;
import moudle.SuggestMoudle;
import view.CountdownView;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class CountdownPresent extends Basepresent {
    private CountdownMoudle countdownMoudle;
    private CountdownView countdownView;
    public CountdownPresent(Object view) {
        super(view);
        if(countdownMoudle==null)
        {
            countdownMoudle=new CountdownMoudle();
        }
        countdownView= (CountdownView) view;
    }
    public void CountdownPresent( )
    {
        countdownMoudle.Countdown(new CountdownMoudle.CountdownBack() {
            @Override
            public void Countdownsuccess(BaseBean baseBean) {
                countdownView.Countdownsuccess(baseBean);
            }

            @Override
            public void Countdownfail(Throwable t) {
                countdownView.Countdownfail(t);
            }
        });
    }

    public   void  onDestory(){
        this.onDeach();
        countdownMoudle.onDestory();
    }
}

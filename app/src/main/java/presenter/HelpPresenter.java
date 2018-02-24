package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.HelpBean;
import moudle.HelpMoudle;
import view.HelpView;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class HelpPresenter extends Basepresent {
    private HelpMoudle helpMoudle;
    private HelpView helpView;

    public HelpPresenter(Object view) {
        super(view);
        if(helpMoudle==null)
        {
            helpMoudle=new HelpMoudle();
        }
        helpView= (HelpView) view;
    }

    public void HelpPresenter(String type, String pid)
    {
        helpMoudle.Help(type, pid, new HelpMoudle.HelpBack() {
            @Override
            public void Helpsuccess(BaseBean<List<HelpBean>> listBaseBean) {
                helpView.Helpsuccess(listBaseBean);
            }

            @Override
            public void Helpfail(Throwable t) {
                helpView.Helpfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        helpMoudle.onDestory();
    }
}

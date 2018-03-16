package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.OneTableXQBean;
import moudle.OneTableMoudle;
import moudle.OneTableXQMoudle;
import view.OnTableXQView;

/**
 * Created by 祝文 on 2018/3/6.
 */

public class OnTableXQPresent extends Basepresent{

    private OneTableXQMoudle oneTableXQMoudle;
    private OnTableXQView onTableXQView;
    public OnTableXQPresent(Object view) {
        super(view);
        if(oneTableXQMoudle==null)
        {
            oneTableXQMoudle=new OneTableXQMoudle();
        }
        onTableXQView= (OnTableXQView) view;
    }

    public void OneTableXQPresent(String type, String province, String year)
    {
        oneTableXQMoudle.OnTableXQ(type, province, year, new OneTableXQMoudle.OneTableXQBack() {
            @Override
            public void OneTableXQsuccess(BaseBean<List<OneTableXQBean>> listBaseBean) {
                onTableXQView.OneTableXQsuccess(listBaseBean);

            }

            @Override
            public void OneTableXQfail(Throwable t) {
                onTableXQView.OneTableXQfail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        oneTableXQMoudle.onDestory();
    }
}

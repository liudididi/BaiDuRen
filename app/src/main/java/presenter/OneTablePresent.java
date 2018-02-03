package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.OneTableBean;
import moudle.OneTableMoudle;
import view.OneTableView;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class OneTablePresent extends Basepresent {
    private OneTableMoudle oneTableMoudle;
    private OneTableView oneTableView;

    public OneTablePresent(Object view) {
        super(view);
        if(oneTableMoudle==null)
        {
            oneTableMoudle=new OneTableMoudle();
        }
        oneTableView= (OneTableView) view;
    }

    public void OneTablePresent(String type, String province)
    {
        oneTableMoudle.OnTable(type, province, new OneTableMoudle.OneTableBack() {
            @Override
            public void OneTablesuccess(BaseBean<List<OneTableBean>> listBaseBean) {
                oneTableView.OneTablesuccess(listBaseBean);
            }

            @Override
            public void OneTablefail(Throwable t) {
                oneTableView.OneTablefail(t);
            }
        });
    }
    public   void  onDestory(){
        this.onDeach();
        oneTableMoudle.onDestory();
    }
}

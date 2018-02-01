package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.HotBean;
import bean.SearchBean;
import moudle.SearchMoudle;
import view.SearchView;

/**
 * Created by 地地 on 2018/1/31.
 * 邮箱：461211527@qq.com.
 */

public class SearchPresent  extends Basepresent{
    private SearchMoudle searchMoudle;
    private SearchView searchView;

    public SearchPresent(Object view) {
        super(view);
        if(searchMoudle==null){

            searchMoudle=new SearchMoudle();
        }
      searchView= (SearchView) view;
    }

    public  void  searchmajorCollege(String name){

        searchMoudle.searchmajorCollege(name, new SearchMoudle.SearchBack() {
            @Override
            public void Searchsuccess(BaseBean<List<SearchBean>> BaseBean) {
                if(BaseBean.code==0){
                    searchView.SearchSuccess(BaseBean.data);
                }else {
                    searchView.SearchFail(BaseBean.msg);
                }
            }

            @Override
            public void Searchfail(Throwable t) {
                searchView.SearchFail(t.toString());
            }
        });

    }


    public  void  hotsave(String name){

            searchMoudle.hotsave(name);

    }

    public  void   queryHot(){
        searchMoudle.queryHot(new SearchMoudle.HotBack() {
            @Override
            public void Hotsuccess(BaseBean<List<HotBean>> BaseBean) {
                if(BaseBean.code==0){
                    searchView.HotSuccess(BaseBean.data);
                }else {
                    searchView.HotFail(BaseBean.msg);
                }
            }

            @Override
            public void Hotchfail(Throwable t) {
                searchView.HotFail(t.toString());
            }
        });



    }

    public   void  onDestory(){
        this.onDeach();
        searchMoudle.onDestory();
    }
}

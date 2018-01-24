package presenter;

import base.BaseBean;
import base.Basepresent;
import moudle.SlideshowMoudle;
import moudle.SuggestMoudle;
import view.SlideshowView;
import view.SuggestView;

/**
 * Created by 祝文 on 2018/1/24.
 */

public class SuggestPresent extends Basepresent{
    private SuggestMoudle suggestMoudle;
    private SuggestView suggestView;
    public SuggestPresent(Object view) {
        super(view);
        if(suggestMoudle==null)
        {
            suggestMoudle=new SuggestMoudle();
        }
        suggestView= (SuggestView) view;
    }
    public void SuggestPresent(String proposal, String contactInformation)
    {
        suggestMoudle.Suggest(proposal, contactInformation, new SuggestMoudle.SuggestBack() {
            @Override
            public void Suggestsuccess(BaseBean baseBean) {
                suggestView.Suggestsuccess(baseBean);
            }

            @Override
            public void Suggestfail(Throwable t) {
                suggestView.Suggestfail(t);
            }
        });
    }

    public   void  onDestory(){
        this.onDeach();
        suggestMoudle.onDestory();
    }
}

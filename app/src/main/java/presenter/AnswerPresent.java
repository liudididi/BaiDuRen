package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.AnswerBean;
import moudle.AnswerMoudle;
import view.AnswerView;

/**
 * Created by 祝文 on 2018/3/3.
 */

public class AnswerPresent extends Basepresent {
    private AnswerMoudle answerMoudle;
    private AnswerView answerView;
    public AnswerPresent(Object view) {
        super(view);
        if(answerMoudle==null)
        {
            answerMoudle=new AnswerMoudle();
        }
        answerView= (AnswerView) view;
    }

    public void AnswerPresent(String pe_type)
    {
        answerMoudle.Answer(pe_type, new AnswerMoudle.AnswerBack() {
            @Override
            public void Answersuccess(BaseBean<List<AnswerBean>> listBaseBean) {
                answerView.Answersuccess(listBaseBean);
            }

            @Override
            public void Answerfail(Throwable t) {
                answerView.Answerfail(t);
            }
        });
    }
    public   void   onDestory(){
        this.onDeach();
        answerMoudle.onDestory();
    }
}

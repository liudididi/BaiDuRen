package moudle;

import java.util.List;

import base.BaseBean;
import bean.AnswerBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/3/3.
 */

public class AnswerMoudle {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();
    //心理测试题
    public void Answer(String pe_type, final AnswerBack answerBack)
    {
        DisposableSubscriber<BaseBean<List<AnswerBean>>> disposableSubscriber =
                MyQusetUtils.getInstance().getQuestInterface().answer(pe_type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<AnswerBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<AnswerBean>> listBaseBean) {
                        answerBack.Answersuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        answerBack.Answerfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    //心理测试的接口
    public interface AnswerBack
    {
        void Answersuccess(BaseBean<List<AnswerBean>> listBaseBean);
        void Answerfail(Throwable t);
    }
    public void  onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}

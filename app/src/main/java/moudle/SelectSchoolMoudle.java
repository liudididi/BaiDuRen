package moudle;

import java.util.List;

import base.BaseBean;
import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class SelectSchoolMoudle   {
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    public void  getprovinces(final ProvincesBack provincesBack){
        DisposableSubscriber<BaseBean<List<ProviceBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getprovinces()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean<List<ProviceBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<ProviceBean>> listBaseBean) {
                        provincesBack.Provincessuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        provincesBack.Provincesfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        compositeDisposable.add(disposableSubscriber);
    }

    public void  getcitys(String provinceid,final CitysBack citysBack){
        DisposableSubscriber<BaseBean<List<CityBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getcitys(provinceid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(new DisposableSubscriber<BaseBean<List<CityBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<CityBean>> listBaseBean) {
                        citysBack.Cityssuccess(listBaseBean);
                }

                    @Override
                    public void onError(Throwable t) {
                      citysBack.Citysfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    public void  getareas(String cityid,final AreasBack areasBack){
        DisposableSubscriber<BaseBean<List<AreaBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getareas(cityid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<AreaBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<AreaBean>> listBaseBean) {

                        areasBack.Areaasssuccess(listBaseBean);

                    }

                    @Override
                    public void onError(Throwable t) {
                 areasBack.Areasfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        compositeDisposable.add(disposableSubscriber);
    }
    public void  getschools(String province, String city, String area, final SchoolBack schoolBack){
        DisposableSubscriber<BaseBean<List<SelectSchoolBean>>> disposableSubscriber = MyQusetUtils.getInstance()
                .getQuestInterface().getschools(province, city, area)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<BaseBean<List<SelectSchoolBean>>>() {
                    @Override
                    public void onNext(BaseBean<List<SelectSchoolBean>> listBaseBean) {
                   schoolBack.Schoolssuccess(listBaseBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                     schoolBack.Schoolcesfail(t);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        compositeDisposable.add(disposableSubscriber);
    }

    public  interface  ProvincesBack{
        void  Provincessuccess(BaseBean<List<ProviceBean>> Basebean);
        void  Provincesfail(Throwable t);
    }
    public  interface  SchoolBack{
        void  Schoolssuccess(BaseBean<List<SelectSchoolBean>> Basebean);
        void  Schoolcesfail(Throwable t);
    }
    public  interface  CitysBack{
        void  Cityssuccess(BaseBean<List<CityBean>> Basebean);
        void  Citysfail(Throwable t);
    }
    public  interface  AreasBack{
        void  Areaasssuccess(BaseBean<List<AreaBean>> Basebean);
        void  Areasfail(Throwable t);
    }


    public void   onDestory(){
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
            compositeDisposable=null;
        }
    }

}

package presenter;

import java.util.List;

import base.BaseBean;
import base.Basepresent;
import bean.AreaBean;
import bean.CityBean;
import bean.ProviceBean;
import bean.SelectSchoolBean;
import moudle.SelectSchoolMoudle;
import view.SelectSchoolView;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class SelectSchoolPrsent extends Basepresent {
    private   SelectSchoolMoudle selectSchoolMoudle;

    private SelectSchoolView selectSchoolView;
    public SelectSchoolPrsent(Object view) {
        super(view);
        if(selectSchoolMoudle==null){
            selectSchoolMoudle=new SelectSchoolMoudle();
        }
        selectSchoolView= (SelectSchoolView) view;
    }

    public void  getprovinces(){
        selectSchoolMoudle.getprovinces(new SelectSchoolMoudle.ProvincesBack() {
            @Override
            public void Provincessuccess(BaseBean<List<ProviceBean>> Basebean) {
                if(Basebean.code==0){
                    selectSchoolView.getProvicesuccess(Basebean.data,Basebean.msg);
                }else {
                  selectSchoolView.getProvicefail(Basebean.msg);
                }

            }
            @Override
            public void Provincesfail(Throwable t) {
                selectSchoolView.getProvicefail(t.toString());
            }
        });
    }

    public void getcitys(String provinceid){

        selectSchoolMoudle.getcitys(provinceid, new SelectSchoolMoudle.CitysBack() {
            @Override
            public void Cityssuccess(BaseBean<List<CityBean>> Basebean) {
                if(Basebean.code==0){
                    selectSchoolView.getCitysuccess(Basebean.data,Basebean.msg);
                }else {
                    selectSchoolView.getCityfail(Basebean.msg);
                }
            }

            @Override
            public void Citysfail(Throwable t) {
                selectSchoolView.getCityfail(t.toString());
            }
        });
    }


    public void getareas(String cityid){

        selectSchoolMoudle.getareas(cityid, new SelectSchoolMoudle.AreasBack() {
            @Override
            public void Areaasssuccess(BaseBean<List<AreaBean>> Basebean) {
                if(Basebean.code==0){
                    selectSchoolView.getAreassuccess(Basebean.data,Basebean.msg);
                }else {
                    selectSchoolView.getAreasfail(Basebean.msg);
                }
            }

            @Override
            public void Areasfail(Throwable t) {
                selectSchoolView.getAreasfail(t.toString());
            }
        });
    }

    public void getschools(String province, String city, String area){
    selectSchoolMoudle.getschools(province, city, area, new SelectSchoolMoudle.SchoolBack() {
        @Override
        public void Schoolssuccess(BaseBean<List<SelectSchoolBean>> Basebean) {
            if(Basebean.code==0){
                selectSchoolView.getSchoolssuccess(Basebean.data,Basebean.msg);
            }else {
                selectSchoolView.getSchoolfail(Basebean.msg);

            }
        }
        @Override
        public void Schoolcesfail(Throwable t) {
            selectSchoolView.getSchoolfail(t.toString());
        }
    });




    }
    public   void   onDestory(){
        this.onDeach();
        selectSchoolMoudle.onDestory();
    }

}

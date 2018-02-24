package fragment;

import android.widget.TextView;

import com.example.login_demo.MajorDetailActivity;
import com.example.login_demo.R;

import base.Basefragment;
import bean.MajorgkBean;
import presenter.MajorgkPresent;
import view.MajorgkView;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class Majorgk_Fragment  extends Basefragment implements MajorgkView{


    private MajorgkPresent majorgkPresent;
    private TextView fmgk_tvdaima;
    private TextView fmgk_tvcckemu;
    private TextView fmgk_tvssdl;
    private TextView fmgk_ccyear;
    private TextView fmgk_tvxw;
    private TextView fmgk_tvzykc;
    private TextView fmgk_tvpyxq;
    private TextView fmgk_nearzy;



    public  static  String jyqj=null;
    public  static  String jyfx=null;
    @Override
    public int getLayoutid() {
        return R.layout.majorgk;
    }

    @Override
    public void initView() {

         initid();

        majorgkPresent = new MajorgkPresent(this);

        majorgkPresent.getMajorgk(MajorDetailActivity.majorid);
        fmgk_tvdaima.setText(MajorDetailActivity.majorid);
        String substring = MajorDetailActivity.majorid.substring(0, 2);
        int i = Integer.parseInt(substring);
        if(i<50){
            fmgk_tvcckemu.setText("本科");
        }else {
            fmgk_tvcckemu.setText("文科");
        }

    }

    private void initid() {

        fmgk_tvdaima = view.findViewById(R.id.fmgk_tvdaima);
        fmgk_tvcckemu = view.findViewById(R.id.fmgk_tvcckemu);
        fmgk_tvssdl = view.findViewById(R.id.fmgk_tvssdl);
        fmgk_ccyear = view.findViewById(R.id.fmgk_ccyear);
        fmgk_tvxw = view.findViewById(R.id.fmgk_tvxw);
        fmgk_tvzykc = view.findViewById(R.id.fmgk_tvzykc);
        fmgk_tvpyxq = view.findViewById(R.id.fmgk_tvpyxq);
        fmgk_nearzy = view.findViewById(R.id.fmgk_nearzy);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        majorgkPresent.onDestory();
    }

    @Override
    public void MajorgkSusccess(MajorgkBean majorgkBean) {
        if(majorgkBean!=null){


            if(majorgkBean.getBigType()!=null){
                fmgk_tvssdl.setText(majorgkBean.getBigType());

            }
            if(majorgkBean.getYearSchool()!=null){
                fmgk_ccyear.setText(majorgkBean.getYearSchool());

            }
            if(majorgkBean.getAwardDegree()!=null){

                fmgk_tvxw.setText(majorgkBean.getAwardDegree());
            }
            if(majorgkBean.getCourse()!=null){

                fmgk_tvzykc.setText(majorgkBean.getCourse());
            }
            if(majorgkBean.getTrainingRequirements()!=null){
                fmgk_tvpyxq.setText(majorgkBean.getTrainingRequirements());

            }

            if(majorgkBean.getNearMajor()!=null){
                fmgk_nearzy.setText(majorgkBean.getNearMajor());
            }


               if(majorgkBean.getEmploymentProspects()!=null){
                //就业前景
                jyqj=majorgkBean.getEmploymentProspects();
               }

         if(majorgkBean.getDirectionEmployment()!=null){
                   jyfx=majorgkBean.getDirectionEmployment();
         }


        }




    }

    @Override
    public void MajorgkFail(String msg) {

    }
}

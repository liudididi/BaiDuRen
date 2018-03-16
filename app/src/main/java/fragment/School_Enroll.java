package fragment;

import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.MyApp;
import com.example.login_demo.ProvinceActivity;
import com.example.login_demo.R;

import java.util.ArrayList;
import java.util.List;

import adapter.SchoolEnrollAdapter;
import adapter.Spinner_Adapter;
import adapter.Spinner_Adapter2;
import base.BaseBean;
import base.Basefragment;
import bean.ForecastBean;
import bean.GailvBean;
import bean.LuquXianBean;
import bean.SchoolEnrollBean;
import presenter.ForecastPresent;
import presenter.SchoolEnrollPresent;
import untils.Histogram;
import untils.SPUtils;
import untils.ZhiMaScoreView;
import view.ForecastView;
import view.SchoolEnrollView;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class School_Enroll  extends Basefragment implements SchoolEnrollView, ForecastView{

    private RecyclerView se_rv;
    private SchoolEnrollPresent schoolEnrollPresent;
    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;
    private ImageView iv_right;
    private TextView tv_pici;
    private ImageView iv_next;
    private boolean msg=true;
    private boolean msg2=true;
    private ListView school_lv1;
    private ListView school_lv2;
    private TextView tv_skx;
    private ImageView iv_right2;
    private ImageView iv_next2;
    private ZhiMaScoreView zhiMaScoreView;
    private TextView tv_tvarea;
    private TextView se_tvtype;
    private TextView se_tvmaxfen;
    private LinearLayout zhexian_ll;
    private TextView school_enroll_tv;
    private TextView school_enroll_tvtime;
    private String schoolname;
    private ForecastPresent forecastPresent;

    @Override
    public int getLayoutid() {
        return R.layout.school_enroll;
    }

    @Override
    public void initView() {

        init();
        schoolname = getActivity().getIntent().getStringExtra("schoolname");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "北京市");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "文科");
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "500");
        schoolEnrollPresent = new SchoolEnrollPresent(this);
        schoolEnrollPresent.SchoolEnrollPresent(schoolname,tbarea,tbsubtype);
        schoolEnrollPresent.getscoreCompareMobil(tbarea,tbsubtype, schoolname);


        Histogram column_two =  view.findViewById(R.id.column_two);
        column_two.setData(Integer.parseInt(tbmaxfen), 750);
        column_two.mPaint.setColor(getResources().getColor(R.color.zhu2)); //改变柱状图的颜色
        forecastPresent = new ForecastPresent(this);
        forecastPresent.ForecastPresent(tbarea,tbsubtype,schoolname);
        tv_tvarea.setText(tbarea);
        se_tvtype.setText(tbsubtype);
        se_tvmaxfen.setText(tbmaxfen);


        schoolEnrollPresent.getluquxian(tbarea, schoolname,tbsubtype,tv_pici.getText().toString(),tv_skx.getText().toString());



        final ArrayList<String> list=new ArrayList<>();
        list.add("本科一批");
        list.add("本科二批");
        list.add("本科三批");
        list.add("提前期");
        list.add("专科批");
        final ArrayList<String> list2=new ArrayList<>();
        list2.add("省控线");
        list2.add("平均分");
        list2.add("最高分");
        list2.add("最低分");

        final Spinner_Adapter2 spinner_adapter=new Spinner_Adapter2(list,getContext());
        final Spinner_Adapter2 spinner_adapter2=new Spinner_Adapter2(list2,getContext());

        tv_pici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(msg==true)
                {
                    school_lv1.setVisibility(View.VISIBLE);
                    school_lv1.setAdapter(spinner_adapter);
                    msg=false;
                    iv_right.setVisibility(View.GONE);
                    iv_next.setVisibility(View.VISIBLE);
                }
                else
                {
                    school_lv1.setVisibility(View.GONE);
                    msg=true;
                    iv_right.setVisibility(View.VISIBLE);
                    iv_next.setVisibility(View.GONE);
                }

            }
        });

        tv_skx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(msg2==true)
                {
                    school_lv2.setVisibility(View.VISIBLE);
                    school_lv2.setAdapter(spinner_adapter2);
                    msg2=false;
                    iv_right2.setVisibility(View.GONE);
                    iv_next2.setVisibility(View.VISIBLE);
                }
                else
                {
                    school_lv2.setVisibility(View.GONE);
                    msg2=true;
                    iv_right2.setVisibility(View.VISIBLE);
                    iv_next2.setVisibility(View.GONE);
                }

            }
        });

        school_lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = list.get(i).toString();
                tv_pici.setText(s);
                school_lv1.setVisibility(View.GONE);
                msg=true;
                iv_right.setVisibility(View.VISIBLE);
                iv_next.setVisibility(View.GONE);
                schoolEnrollPresent.getluquxian(tbarea, schoolname,tbsubtype,tv_pici.getText().toString(),tv_skx.getText().toString());

            }
        });
        school_lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = list2.get(i).toString();
                tv_skx.setText(s);
                school_lv2.setVisibility(View.GONE);
                msg2=true;
                iv_right2.setVisibility(View.VISIBLE);
                iv_next2.setVisibility(View.GONE);
                schoolEnrollPresent.getluquxian(tbarea, schoolname,tbsubtype,tv_pici.getText().toString(),tv_skx.getText().toString());
            }
        });






    }

    private void init() {
            initid();
        school_enroll_tv = view.findViewById(R.id.school_enroll_tv);


    }

    private void initid() {
        se_rv = view.findViewById(R.id.se_rv);
        school_lv1 = view.findViewById(R.id.school_lv1);
        school_lv2= view.findViewById(R.id.school_lv2);
        tv_pici = view.findViewById(R.id.tv_pici);
        iv_right = view.findViewById(R.id.iv_right);
        iv_next = view.findViewById(R.id.iv_next);
        tv_skx = view.findViewById(R.id.tv_skx);
        iv_right2 = view.findViewById(R.id.iv_right2);
        iv_next2 = view.findViewById(R.id.iv_next2);
        tv_tvarea = view.findViewById(R.id.se_tvarea);
        se_tvtype = view.findViewById(R.id.se_tvtype);
        school_enroll_tvtime = view.findViewById(R.id.school_enroll_tvtime);
        se_tvmaxfen = view.findViewById(R.id.se_tvmaxfen);
        zhexian_ll = view.findViewById(R.id.zhexian_ll);

    }

    //大学录取的专业招生计划
    @Override
    public void SchoolEnrollsuccess(BaseBean<List<SchoolEnrollBean>> listBaseBean) {
        List<SchoolEnrollBean> data = listBaseBean.data;
        SchoolEnrollAdapter schoolEnrollAdapter=new SchoolEnrollAdapter(data,getContext());
        se_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        se_rv.setAdapter(schoolEnrollAdapter);
    }

    @Override
    public void SchoolEnrollfail(Throwable t) {

    }

    @Override
    public void GetlvBeansuccess(List<GailvBean> listBaseBean) {
        if(listBaseBean!=null&&listBaseBean.size()>0){
            String time = listBaseBean.get(0).getTime();
            school_enroll_tvtime.setText(time+"录取率");
            String scoreAvg = listBaseBean.get(0).getScoreAvg();
            int selffen = Integer.parseInt(tbmaxfen);
            int fenshuxian = Integer.parseInt(scoreAvg);
            if(selffen<fenshuxian){
                int i = 40-(fenshuxian - selffen)*2;
                if(i<10){
                    school_enroll_tv.setText("10%");
                }else {
                    school_enroll_tv.setText(i+"%");
                }
            }else if(selffen>fenshuxian){
                int i = 40+(selffen - fenshuxian)*2;
                if(i>=100){
                    school_enroll_tv.setText("100%");
                }else {
                    school_enroll_tv.setText(i+"%");
                }
            }else if(selffen==fenshuxian){
                school_enroll_tv.setText("40%");
            }
        }


    }

    @Override
    public void GetlvBeanfail(String msg) {

    }

    @Override
    public void LuquXianBeansuccess(List<LuquXianBean> listBaseBean) {
        zhexian_ll.removeAllViews();
         int max=0;
         int min=0;
        zhiMaScoreView = new ZhiMaScoreView(getActivity());
        List<Integer> listfen=new ArrayList<>();
        listfen.add(0);
        listfen.add(0);
        if(listBaseBean!=null&&listBaseBean.size()>0){
            for (int i = 0; i <listBaseBean.size() ; i++) {
                if(listBaseBean.get(i).getScore()!=null){
                    listfen.set(i,Integer.parseInt(listBaseBean.get(i).getScore()));
                }
            }
        }
        if(listfen.get(0)>=listfen.get(1)){
            max=listfen.get(0)+100;
            min=listfen.get(1)-50;
        }else {
            max=listfen.get(1)+100;
            min=listfen.get(0)-50;
        }
        if(min<0){
            min=0;
        }
        if(max>700){
            max=700;
        }
        zhiMaScoreView.setlistfen(listfen);
        zhiMaScoreView.setMaxScore(max);
        zhiMaScoreView.setMinScore(min);
        zhexian_ll.addView(zhiMaScoreView);
    }

    @Override
    public void LuquXianBeanfail(String msg) {
        zhexian_ll.removeAllViews();
        int max=0;
        int min=0;
        zhiMaScoreView = new ZhiMaScoreView(getActivity());
        List<Integer> listfen=new ArrayList<>();
        listfen.add(0);
        listfen.add(0);

        if(listfen.get(0)>=listfen.get(1)){
            max=listfen.get(0)+100;
            min=listfen.get(1)-50;
        }else {
            max=listfen.get(1)+100;
            min=listfen.get(0)-50;
        }
        if(min<0){
            min=0;
        }
        if(max>700){
            max=700;
        }
        zhiMaScoreView.setlistfen(listfen);
        zhiMaScoreView.setMaxScore(max);
        zhiMaScoreView.setMinScore(min);
        zhexian_ll.addView(zhiMaScoreView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        schoolEnrollPresent.onDestory();
        forecastPresent.onDestory();
    }

    @Override
    public void Forecastsuccess(BaseBean<List<ForecastBean>> listBaseBean) {
        List<ForecastBean> data = listBaseBean.data;

        if(data!=null&&data.size()>0)
        {
            String scoreAvg = data.get(0).getScoreAvg();
            Histogram column_one =  view.findViewById(R.id.column_one);
            column_one.setData( Integer.parseInt(scoreAvg), 750);
            column_one.mPaint.setColor(getResources().getColor(R.color.zhu1)); //改变柱状图的颜色

        }

    }

    @Override
    public void Forecastfail(Throwable t) {

    }
}

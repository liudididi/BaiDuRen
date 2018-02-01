package fragment;



import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login_demo.ExamMessageActivity;
import com.example.login_demo.MyApp;
import com.example.login_demo.R;
import com.example.login_demo.ReportedActivity;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import adapter.Wash_School_adapter;
import base.BaseApi;
import base.BaseBean;
import base.Basefragment;
import bean.CanSchoolBean;
import bean.CanSchoolBean2;
import bean.SlideshowBean;
import presenter.CountdownPresent;
import presenter.WishPresent;
import untils.SPUtils;
import view.CountdownView;
import view.WishView;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class WishFragMent extends Basefragment implements WishView, CountdownView{


    private RecyclerView school_recycle;
    private XBanner ws_xbanner;
    private ArrayList<String> list;
    private LinearLayout ll_back;
    private TextView wish_monthly;
    private TextView wish_midterm;
    private TextView wish_end;
    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;
    private WishPresent wishPresent;
    private LinearLayout wish_ll1;
    private LinearLayout wish_ll2;
    private LinearLayout wish_ll3;
    private TextView wish_day1;
    private TextView wish_day2;
    private TextView wish_day3;
    private CountdownPresent countdownPresent;
    private ImageView wish_school_none;

    @Override
    public int getLayoutid() {
        return R.layout.wish_fragment;
    }

    @Override
    public void initView() {
    initId();
    }

    @Override
    public void onResume() {
        super.onResume();
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");

        if(tbmaxfen!=null&&tbmaxfen!=""){

        }else
        {
            tbmaxfen="500";
        }
        if(tbarea!=null&&tbmaxfen!=""){

        }else {
            tbarea="北京市";
        }
        if(tbsubtype!=null&&tbmaxfen!=""){

        }else
        {
            tbsubtype="文科";
        }
        wishPresent.CanSchoolPresente(tbarea,tbsubtype,"0",tbmaxfen,"1","5");


    }

    @Override
    public void onStop() {
        super.onStop();
        ws_xbanner.stopAutoPlay();
    }
    private void initId() {
        school_recycle = view.findViewById(R.id.wish_school_recycle);
        ws_xbanner = view.findViewById(R.id.ws_xbanner);
        ll_back = view.findViewById(R.id.ll_back);
        wish_monthly = view.findViewById(R.id.wish_monthly);
        wish_midterm = view.findViewById(R.id.wish_midterm);
        wish_end = view.findViewById(R.id.wish_end);

        wish_school_none = view.findViewById(R.id.wish_school_none);


        wish_ll1 = view.findViewById(R.id.wish_ll1);
         wish_ll2= view.findViewById(R.id.wish_ll2);
        wish_ll3 = view.findViewById(R.id.wish_ll3);
        wish_day1 = view.findViewById(R.id.wish_day1);
        wish_day2 = view.findViewById(R.id.wish_day2);
        wish_day3 = view.findViewById(R.id.wish_day3);
        list = new ArrayList<>();
        //动态设置高度
        View view_bottom=view.findViewById(R.id.view_bottom);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;
        ViewGroup.LayoutParams layoutParams = view_bottom.getLayoutParams();
        layoutParams.width=dm.widthPixels;
        layoutParams.height=heightPixels/12;
        view_bottom.setLayoutParams(layoutParams);
        //轮播图
        wishPresent = new WishPresent(this);
        wishPresent.WishPresenter(5);
        //倒计时
        countdownPresent = new CountdownPresent(this);
        countdownPresent.CountdownPresent();
        //能上的学校
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");
        if(tbarea!=null&&tbarea!=""&&tbmaxfen!=""&&tbmaxfen!=null&&tbsubtype!=null&&tbsubtype!=""){
            wishPresent.CanSchoolPresente(tbarea,tbsubtype,"0",tbmaxfen,"1","5");
        }else {
            wishPresent.CanSchoolPresente("北京","文科","0","500","1","5");
        }



        onClick();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wishPresent.onDestory();
        countdownPresent.onDestory();
    }

    private void onClick() {
        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), ReportedActivity.class));
            }
        });

        wish_monthly.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ExamMessageActivity.class);
                intent.putExtra("form","月考");
                intent.putExtra("form_int",0);
                getContext().startActivity(intent);


            }
        });
        wish_midterm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ExamMessageActivity.class);
                intent.putExtra("form","期中");
                intent.putExtra("form_int",1);
                getContext().startActivity(intent);

             }
        });
        wish_end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), ExamMessageActivity.class);
                intent.putExtra("form","期末");
                intent.putExtra("form_int",2);
                getContext().startActivity(intent);
            }
        });


    }

    //志愿表轮播图
    @Override
    public void Wishsuccess(BaseBean<List<SlideshowBean>> listBaseBean) {

        List<SlideshowBean> data = listBaseBean.data;
        for (int i = 0; i < data.size(); i++) {
            list.add(BaseApi.ImgApi+data.get(i).getExtimg());
        }
        ws_xbanner.setData(list,null);
        ws_xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                ws_xbanner.removeView(view);
                Glide.with(getContext()).load(list.get(position)).into((ImageView) view);
                if(position==1)
                {
                    wish_ll1.setVisibility(View.VISIBLE);
                    wish_ll2.setVisibility(View.GONE);
                    wish_ll3.setVisibility(View.GONE);
                }
                else if (position==2)
                {
                    wish_ll1.setVisibility(View.GONE);
                    wish_ll2.setVisibility(View.GONE);
                    wish_ll3.setVisibility(View.VISIBLE);
                }
                else
                {
                    wish_ll1.setVisibility(View.GONE);
                    wish_ll2.setVisibility(View.VISIBLE);
                    wish_ll3.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void Wishfail(Throwable t) {

    }

    //能上的学校
    @Override
    public void CanSchoolsuccess(BaseBean<CanSchoolBean> canSchoolBeanBaseBean) {
        //能上的学校
        List<CanSchoolBean2> list=new ArrayList<>();
        List<CanSchoolBean.ListBean> list1 = canSchoolBeanBaseBean.data.getList();
        if(list1!=null&&list1.size()>0){
            wish_school_none.setVisibility(View.GONE);

            for (int i = 0; i < list1.size(); i++) {
                list.add(new CanSchoolBean2(list1.get(i).getUrl(),list1.get(i).getName(),list1.get(i).getAddress(),list1.get(i).getRanking()));
            }
            Wash_School_adapter wash_school_adapter=new Wash_School_adapter(list,getActivity());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            school_recycle.setLayoutManager(linearLayoutManager);
            school_recycle.setAdapter(wash_school_adapter);
        }else {

            wish_school_none.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void CanSchoolfail(Throwable t) {

    }

    //倒计时
    @Override
    public void Countdownsuccess(BaseBean baseBean) {
        String s = baseBean.data.toString();
        wish_day1.setText(s);
        wish_day3.setText((Integer.parseInt(s)+85)+"");
        wish_day2.setText((Integer.parseInt(s)+2)+"");
    }

    @Override
    public void Countdownfail(Throwable t) {

    }
}

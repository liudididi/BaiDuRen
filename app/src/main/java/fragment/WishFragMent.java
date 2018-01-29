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
import presenter.WishPresent;
import view.WishView;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class WishFragMent extends Basefragment implements WishView{


    private RecyclerView school_recycle;
    private XBanner ws_xbanner;
    private ArrayList<String> list;
    private LinearLayout ll_back;
    private TextView wish_monthly;
    private TextView wish_midterm;
    private TextView wish_end;


    @Override
    public int getLayoutid() {
        return R.layout.wish_fragment;
    }

    @Override
    public void initView() {
    initId();
    }

    private void initId() {
        school_recycle = view.findViewById(R.id.wish_school_recycle);
        ws_xbanner = view.findViewById(R.id.ws_xbanner);
        ll_back = view.findViewById(R.id.ll_back);
        wish_monthly = view.findViewById(R.id.wish_monthly);
        wish_midterm = view.findViewById(R.id.wish_midterm);
        wish_end = view.findViewById(R.id.wish_end);
        list = new ArrayList<>();
        //动态设置高度
        View view_bottom=view.findViewById(R.id.view_bottom);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;
        ViewGroup.LayoutParams layoutParams = view_bottom.getLayoutParams();
        layoutParams.width=dm.widthPixels;
        layoutParams.height=heightPixels/12;
        view_bottom.setLayoutParams(layoutParams);

        WishPresent wishPresent= new WishPresent(this);
        wishPresent.WishPresenter(5);
        //能上的学校
        wishPresent.CanSchoolPresente("北京","文科","100","500","1","5");
        onClick();



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
                Glide.with(getContext()).load(list.get(position)).into((ImageView) view);
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
        for (int i = 0; i < list1.size(); i++) {
            list.add(new CanSchoolBean2(list1.get(i).getUrl(),list1.get(i).getName(),list1.get(i).getAddress(),list1.get(i).getRanking()));
        }
        Wash_School_adapter wash_school_adapter=new Wash_School_adapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        school_recycle.setLayoutManager(linearLayoutManager);
        school_recycle.setAdapter(wash_school_adapter);
    }

    @Override
    public void CanSchoolfail(Throwable t) {

    }
}

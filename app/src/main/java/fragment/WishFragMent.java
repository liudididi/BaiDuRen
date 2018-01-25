package fragment;



import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.bumptech.glide.Glide;
import com.example.login_demo.R;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import adapter.Wash_School_adapter;
import base.BaseApi;
import base.BaseBean;
import base.Basefragment;
import bean.SchoolBean;
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
        list = new ArrayList<>();

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
        List<SchoolBean> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SchoolBean schoolBean=new SchoolBean();
            list.add(schoolBean);
        }
        Wash_School_adapter wash_school_adapter=new Wash_School_adapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        school_recycle.setLayoutManager(linearLayoutManager);
        school_recycle.setAdapter(wash_school_adapter);

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
}

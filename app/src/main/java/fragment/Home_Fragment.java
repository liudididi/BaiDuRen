package fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.login_demo.EstimateGradeActivity;
import com.example.login_demo.MyApp;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.R;
import com.example.login_demo.ReportedActivity;
import com.example.login_demo.SearchParticularsActivity;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import adapter.HotTopRecyCleViewAdapter;
import adapter.RecommendRecycleViewAdapter;
import adapter.SudokuGlideAdapter;
import adapter.SudokuPagerAdapter;
import base.BaseApi;
import base.BaseBean;
import base.Basefragment;
import bean.HotTopBean;
import bean.NewsBean;
import bean.RecommendBean;
import bean.SlideshowBean;
import bean.SlideshowChildBean;
import presenter.SlideshowPresenter;

import untils.SPUtils;
import view.ObservableScrollView;
import view.SlideshowView;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class Home_Fragment extends Basefragment implements SlideshowView, ObservableScrollView.ScrollViewListener{

    private SlideshowPresenter slideshowPresenter;
    private  List<String> list;
    private XBanner xbanner;
    private ObservableScrollView scrollview;
    private RelativeLayout rl_title;
    private int hight;
    private TextView tv_search;
    private ImageView iv_news;
    private ViewPager viewpager;

    private ArrayList<SlideshowChildBean> sudokuList;
    private RecyclerView rv_hot;
    private RecyclerView rv_recommend;
    private LinearLayout ll_dot;
    private ImageView iv_dian;
    private ArrayList<ImageView> iv_list;
    private RelativeLayout rl_search;
    private ViewFlipper viewflipper;
    private LinearLayout home_enter;
    private TextView homegrade;
    private String tbmaxfen;
    private String tbarea;
    private String tbsubtype;
    private TextView homearea;
    private TextView homesubtype;
    private LinearLayout home_table;


    @Override
    public int getLayoutid() {
        return R.layout.home_fragment;
    }

    @Override
    public void initView() {
        slideshowPresenter = new SlideshowPresenter(this);
        //首页轮播图
        slideshowPresenter.SlideshowPresenter(2);
        //首页九宫格
        slideshowPresenter.SudokuPresenter(3);
        //热门专题
        slideshowPresenter.HotTopPresenter("热门专题","全国","1","6");
        //精选推荐
        slideshowPresenter.RecommenPresenter("精选推荐","全国","1","6");
        //高考头条
        slideshowPresenter.CollegePresenter("高考新闻","全国","1","6");

        inin();
        //加点
        initPunctuate();
    }

    private void initPunctuate() {

        for (int i = 0; i <2 ; i++) {
            iv_dian = new ImageView(getContext());
            if(i==0)
            {
                iv_dian.setImageResource(R.mipmap.hong);
            }
            else
            {
                iv_dian.setImageResource(R.mipmap.bai);
            }
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(10,10);
            layoutParams.setMargins(5,0,5,0);
            ll_dot.addView(iv_dian,layoutParams);
            iv_list.add(iv_dian);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        tbmaxfen = (String) SPUtils.get(MyApp.context, "tbmaxfen", "");
        tbarea = (String) SPUtils.get(MyApp.context, "tbarea", "");
        tbsubtype = (String) SPUtils.get(MyApp.context, "tbsubtype", "");

        if(tbmaxfen!=null&&tbmaxfen!=""){
            homegrade.setText(tbmaxfen);
          }else
        {
            homegrade.setText("500");
        }
        if(tbarea!=null&&tbmaxfen!=""){
         homearea.setText(tbarea);
        }else {
            homearea.setText("北京市");
        }
        if(tbsubtype!=null&&tbmaxfen!=""){
         homesubtype.setText(tbsubtype);
        }else
        {
            homesubtype.setText("文科");
        }
    }

    private void inin() {

        xbanner = view.findViewById(R.id.xbanner);
        scrollview = view.findViewById(R.id.scrollview);
        rl_title = view.findViewById(R.id.rl_title);
        tv_search = view.findViewById(R.id.tv_search);
        iv_news = view.findViewById(R.id.iv_news);
        //搜索框
        rl_search = view.findViewById(R.id.rl_search);

        viewpager = view.findViewById(R.id.viewpager);
        rv_hot =  view.findViewById(R.id.rv_hot);
        rv_recommend = view.findViewById(R.id.rv_recommend);
        ll_dot = view.findViewById(R.id.ll_dot);
        viewflipper = view.findViewById(R.id.viewflipper);

        homegrade = view.findViewById(R.id.home_ed_grade);
        homearea = view.findViewById(R.id.home_area);
        homesubtype = view.findViewById(R.id.home_subtype);

        home_enter = view.findViewById(R.id.home_enter);

        home_table = view.findViewById(R.id.home_table);
        home_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ReportedActivity.class);
                startActivity(intent);
            }
        });
                list = new ArrayList<>();
        iv_list = new ArrayList<>();

        //点击事件
        initOnClick();

    }

    private void initOnClick() {

        home_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), EstimateGradeActivity.class);
                startActivity(intent);
            }
        });
        ViewTreeObserver vto =xbanner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                xbanner.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                hight =   xbanner.getHeight();
                int height1 = rl_title.getHeight();
                hight=hight-height1;
                xbanner.getWidth();
                scrollview.setScrollViewListener(Home_Fragment.this);
            }
        });

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i <2 ; i++) {
                    if(i==position)
                    {
                        iv_list.get(i).setImageResource(R.mipmap.hong);
                    }
                    else
                    {
                        iv_list.get(i).setImageResource(R.mipmap.bai);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rl_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(getContext(), SearchParticularsActivity.class));
            }
        });
    }


    //首页轮播图模块
    @Override
    public void Slideshowsuccess(final BaseBean<List<SlideshowBean>> listBaseBean) {

        for (int i = 0; i < listBaseBean.data.size(); i++) {
            list.add(BaseApi.ImgApi+listBaseBean.data.get(i).getExtimg());
        }
        xbanner.setData(list,null);
       xbanner.setmAdapter(new XBanner.XBannerAdapter() {
           @Override
           public void loadBanner(XBanner banner, View view, int position) {
               Glide.with(getContext()).load(list.get(position)).into((ImageView) view);
           }
       });
        xbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
               Intent intent= new Intent(getContext(), ParticularsActivity.class);
                 intent.putExtra("url",listBaseBean.data.get(position).getUrl());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void Slideshowfail(Throwable t) {
     }

    //首页九宫格模块
    @Override
    public void Sudokusuccess(BaseBean<List<SlideshowBean>> listBaseBean) {
        sudokuList = new ArrayList<>();

        for (int i = 0; i < listBaseBean.data.size(); i++) {
            sudokuList.add(new SlideshowChildBean(listBaseBean.data.get(i).getName(), listBaseBean.data.get(i).getExtimg().toString(), listBaseBean.data.get(i).getUrl()));

          }

        viewpager.setAdapter(new SudokuPagerAdapter(sudokuList,getContext()));


    }

    @Override
    public void Sudokufail(Throwable t) {

    }

    //热门专题数据
    @Override
    public void HotTopsuccess(BaseBean<NewsBean> listBaseBean) {
        ArrayList<HotTopBean> HotTopList=new ArrayList<>();

        NewsBean data = listBaseBean.data;
        List<NewsBean.ListBean> list = data.getList();
        for (int i = 0; i <list.size(); i++) {
            HotTopList.add(new HotTopBean(BaseApi.ImgApi+ list.get(i).getPicture(),list.get(i).getTitle(),""));
         }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_hot.setLayoutManager(linearLayoutManager);
        HotTopRecyCleViewAdapter hotTopRecyCleViewAdapter=new HotTopRecyCleViewAdapter(HotTopList,getContext());
        rv_hot.setAdapter(hotTopRecyCleViewAdapter);


    }

    @Override
    public void HotTopfail(Throwable t) {

    }

    //精选推荐
    @Override
    public void Recommendsuccess(BaseBean<NewsBean> listBaseBean) {
        ArrayList<RecommendBean> RecommendList=new ArrayList<>();
        NewsBean data = listBaseBean.data;
        List<NewsBean.ListBean> list = data.getList();
        for (int i = 0; i < list.size(); i++) {
            RecommendList.add(new RecommendBean(BaseApi.ImgApi+ list.get(i).getPicture(),list.get(i).getTitle() ,"",list.get(i).getDate(),list.get(i).getGeneral()));
        }
        RecommendRecycleViewAdapter recommendRecycleViewAdapter=new RecommendRecycleViewAdapter(RecommendList,getContext());
        rv_recommend.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_recommend.setAdapter(recommendRecycleViewAdapter);
        rv_recommend.setNestedScrollingEnabled(false);
    }

    @Override
    public void Recommendfail(Throwable t) {

    }

    //高考新闻
    @Override
    public void Collegesuccess(BaseBean<NewsBean> listBaseBean) {
        NewsBean data = listBaseBean.data;
        List<NewsBean.ListBean> list = data.getList();
        for (int i = 0; i < list.size(); i++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.college_item, null);
            TextView tv_college_title=inflate.findViewById(R.id.tv_college_title);
            TextView tv_college_count=inflate.findViewById(R.id.tv_college_count);
            tv_college_title.setText(list.get(i).getTitle());
            tv_college_count.setText(list.get(i).getGeneral());

            viewflipper.addView(inflate);
        }
        viewflipper.startFlipping();
    }

    @Override
    public void Collegefail(Throwable t) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        slideshowPresenter.onDestory();
    }


    //控制搜索框颜色渐变
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {

        if(y<=hight){
            float scale =(float) y /hight;
            float alpha =  (255 * scale);
            iv_news.setBackground(getResources().getDrawable(R.mipmap.inform));
            tv_search.setTextColor(Color.GRAY);
            rl_title.setBackgroundColor(Color.argb((int) alpha, 0xfd, 0xfd, 0xfd));
        }else {
            rl_title.setBackgroundColor(Color.WHITE);
            iv_news.setBackground(getResources().getDrawable(R.mipmap.inform));
            tv_search.setTextColor(Color.GRAY);
        }

    }
}

package fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import base.Basefragment;
import bean.StudentFromBean;
import presenter.School_SummaryPresent;
import view.PieChatView;
import view.School_SummaryView;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class School_Summary  extends Basefragment implements School_SummaryView {

    private TextView ss_tvshd;
    private TextView ss_bsd;
    private RelativeLayout ss_rlbin;
    private LinkedHashMap kindsMap = new LinkedHashMap<String, Integer>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private School_SummaryPresent school_summaryPresent;
    private TextView tvwomen_bfb;
    private TextView tvman_bfb;

    @Override
    public int getLayoutid() {
        return R.layout.school_summary;
    }

    @Override
    public void initView() {
        initid();
        if(SchoolDetailActivity.bhsd!=null){
            ss_bsd.setText(SchoolDetailActivity.bhsd);
        }
        if(SchoolDetailActivity.shsd!=null){
            ss_tvshd.setText(SchoolDetailActivity.shsd);
        }

        school_summaryPresent = new School_SummaryPresent(this);

        school_summaryPresent.StudentFrom(SchoolDetailActivity.schoolname);

    }

    private void initid() {
        ss_tvshd = view.findViewById(R.id.ss_tvshd);
        ss_bsd = view.findViewById(R.id.ss_bsd);
        ss_rlbin = view.findViewById(R.id.ss_rlbin);
        tvwomen_bfb = view.findViewById(R.id.tvwomen_bfb);
        tvman_bfb = view.findViewById(R.id.tvman_bfb);
    }

    @Override
    public void Studentfromsuccess(List<StudentFromBean> listBaseBean) {
     if(listBaseBean.size()>0&&listBaseBean!=null){
         StudentFromBean studentFromBean = listBaseBean.get(0);
         PieChatView pieChatView=new PieChatView(getContext());
         pieChatView.setPadding(80,50,50,50);
         kindsMap.put("华北", studentFromBean.getHn());
         kindsMap.put("东北", studentFromBean.getEn());
         kindsMap.put("华东", studentFromBean.getHe());
         kindsMap.put("华南", studentFromBean.getHn());
         kindsMap.put("西北", studentFromBean.getWn());
         kindsMap.put("西南",studentFromBean.getWs());
         colors.add(Color.BLUE);//蓝色
         colors.add(Color.YELLOW);//黄色
         colors.add(-12067354);//浅蓝
         colors.add(-5808646);//紫色
         colors.add(Color.GREEN);//绿色
         colors.add(Color.RED);//红色
         pieChatView.setCenterTitle(" ");
         pieChatView.setDataMap(kindsMap);
         pieChatView.setColors(colors);
         pieChatView.setMinAngle(50);
         pieChatView.startDraw();
         ss_rlbin.addView(pieChatView);
         tvwomen_bfb.setText(studentFromBean.getWoman()+"%");
         tvman_bfb.setText(studentFromBean.getMan()+"%");
     }
    }

    @Override
    public void StudentfromFail(String msg) {

    }
}

package fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import base.Basefragment;
import view.PieChatView;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class School_Summary  extends Basefragment {

    private TextView ss_tvshd;
    private TextView ss_bsd;
    private RelativeLayout ss_rlbin;
    private LinkedHashMap kindsMap = new LinkedHashMap<String, Integer>();
    private ArrayList<Integer> colors = new ArrayList<>();
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

        PieChatView pieChatView=new PieChatView(getContext());
        pieChatView.setPadding(130,80,80,80);
        kindsMap.put("华北", 15);
        kindsMap.put("东北", 15);
        kindsMap.put("华东", 15);
        kindsMap.put("华南", 15);
        kindsMap.put("西北", 15);
        kindsMap.put("西南",25);

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


    }

    private void initid() {

        ss_tvshd = view.findViewById(R.id.ss_tvshd);
        ss_bsd = view.findViewById(R.id.ss_bsd);
        ss_rlbin = view.findViewById(R.id.ss_rlbin);
    }
}

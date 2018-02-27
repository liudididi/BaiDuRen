package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.login_demo.MentalityActivity;
import com.example.login_demo.MoreJorbActivity;
import com.example.login_demo.MoreMajorActivity;
import com.example.login_demo.MoreSchoolActivity;
import com.example.login_demo.OneTableActivity;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.ProvinceActivity;
import com.example.login_demo.R;
import com.example.login_demo.RankingActivity;
import com.example.login_demo.ScoreActivity;
import com.example.login_demo.StudentsinActivity;
import com.example.login_demo.StudyActivity;

import java.util.ArrayList;

import base.BaseApi;
import bean.SlideshowChildBean;

/**
 * Created by 祝文 on 2018/1/21.
 */

public class SudokuGlideAdapter extends BaseAdapter {
    private ArrayList<SlideshowChildBean> list;
    private Context context;

    public SudokuGlideAdapter(ArrayList<SlideshowChildBean> list, Context context) {
        this.list=list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(list.size()>8)
        {
            return 8;
        }
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.sodoku_gride_item,null);
        }
        ImageView sodoku_item_iv=view.findViewById(R.id.sodoku_item_iv);
        sodoku_item_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(i).getName().equals("院校库")){
                  Intent intent=new Intent(context, MoreSchoolActivity.class);
                  context.startActivity(intent);
                } else if(list.get(i).getName().equals("专业库")){
                    Intent intent=new Intent(context, MoreMajorActivity.class);
                    context.startActivity(intent);
                }  else if(list.get(i).getName().equals("心理测评"))
                {
                    Intent intent=new Intent(context, MentalityActivity.class);
                    context.startActivity(intent);

                }
                else if(list.get(i).getName().equals("大学排名"))
                {
                    Intent intent=new Intent(context, RankingActivity.class);
                    context.startActivity(intent);
                }
                else if(list.get(i).getName().equals("职业库"))
                {
                    Intent intent=new Intent(context, MoreJorbActivity.class);
                    context.startActivity(intent);
                } else if(list.get(i).getName().equals("省控线"))
                {
                    Intent intent=new Intent(context, ProvinceActivity.class);
                    context.startActivity(intent);
                }
                else if(list.get(i).getName().equals("学习资料"))
                {
                    Intent intent=new Intent(context, StudyActivity.class);
                    context.startActivity(intent);
                }
                else if(list.get(i).getName().equals("分数线"))
                {
                    Intent intent=new Intent(context, ScoreActivity.class);
                    context.startActivity(intent);
                }
                else if(list.get(i).getName().equals("一分一表"))
                {
                    Intent intent=new Intent(context, OneTableActivity.class);
                    context.startActivity(intent);
                }

                else if(list.get(i).getName().equals("特长生"))
                {
                    Intent intent=new Intent(context, StudentsinActivity.class);
                    context.startActivity(intent);
                }


            }
        });
        Glide.with(context).load(BaseApi.ImgApi+list.get(i).getExtimg())
                .priority( Priority.HIGH )
                .into(sodoku_item_iv);
        return view;
    }
}

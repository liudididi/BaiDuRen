package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login_demo.R;

import java.util.ArrayList;

import base.BaseApi;
import bean.StudyBean;
import bean.StudyBean2;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.MyViewHolder> {
    private ArrayList<StudyBean2> list;
    private Context context;

    public StudyAdapter(ArrayList<StudyBean2> list, Context context) {
        this.list = list;
        this.context = context;
    }


    public void load(ArrayList<StudyBean2> newlist)
    {
        if(list!=null){
           list.clear();
           list=newlist;
           notifyDataSetChanged();
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.study_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(BaseApi.ImgApi+list.get(position).getUrl()).into(holder.study_url);
        holder.study_title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView study_url;
        private final TextView study_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            study_url = itemView.findViewById(R.id.study_url);
            study_title = itemView.findViewById(R.id.study_title);
        }
    }
}

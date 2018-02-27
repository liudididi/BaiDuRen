package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.R;

import java.util.List;

import base.BaseApi;
import bean.StudentsinBean;
import bean.StudentsinNewsBean;

/**
 * Created by 祝文 on 2018/2/3.
 */

public class StudentsinNewsAdapter extends RecyclerView.Adapter<StudentsinNewsAdapter.MyViewHolder> {
    private List<StudentsinNewsBean.ListBean> list;
    private Context context;

    public StudentsinNewsAdapter(List<StudentsinNewsBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.studentsinnews_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        Glide.with(context).load(BaseApi.ImgApi+list.get(position).getPicture()).into(holder.studentsin_iv);
        holder.studentsin_title.setText(list.get(position).getTitle());
        holder.studentsin_cont.setText(list.get(position).getGeneral());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ParticularsActivity.class);
                intent.putExtra("url", "http://39.106.32.50/#/entrancenews?newsId="+list.get(position).getNewsId());
                intent.putExtra("particulars_title", list.get(position).getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView studentsin_iv;
        private final TextView studentsin_title;
        private final TextView studentsin_cont;
        private  View view;

        public MyViewHolder(View itemView) {
            super(itemView);
          this.view=itemView;
            studentsin_iv = itemView.findViewById(R.id.studentsinnews_iv);
            studentsin_title = itemView.findViewById(R.id.studentsinnews_title);
            studentsin_cont = itemView.findViewById(R.id.studentsinnews_cont);

        }
    }
}

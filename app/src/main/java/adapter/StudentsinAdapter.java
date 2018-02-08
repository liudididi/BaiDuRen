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
import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;

import java.util.ArrayList;
import java.util.List;

import base.BaseApi;
import bean.StudentsinBean;

/**
 * Created by 祝文 on 2018/2/3.
 */

public class StudentsinAdapter extends RecyclerView.Adapter<StudentsinAdapter.MyViewHolder> {
    private List<StudentsinBean> list;
    private Context context;

    public StudentsinAdapter(List<StudentsinBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.studentsin_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Glide.with(context).load(BaseApi.ImgApi+list.get(position).getUrl()).into(holder.studentsin_iv);
        holder.studentsin_name.setText(list.get(position).getName());
        holder.studentsin_type.setText(list.get(position).getRanking());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SchoolDetailActivity.class);
                intent.putExtra("schoolname",list.get(position).getName());
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
        private final TextView studentsin_name;
        private final TextView studentsin_type;
        private  View view;


        public MyViewHolder(View itemView) {
            super(itemView);

            studentsin_iv = itemView.findViewById(R.id.studentsin_iv);
            studentsin_name = itemView.findViewById(R.id.studentsin_name);
            studentsin_type = itemView.findViewById(R.id.studentsin_type);
            view=itemView;

        }
    }
}

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
import com.bumptech.glide.Priority;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.R;

import java.util.ArrayList;

import base.GlideCircleTransform;
import bean.HotTopBean;

/**
 * Created by 祝文 on 2018/1/22.
 */

public class HotTopRecyCleViewAdapter extends RecyclerView.Adapter<HotTopRecyCleViewAdapter.MyViewHolder> {
    private ArrayList<HotTopBean> list;
    private Context context;
    public HotTopRecyCleViewAdapter(ArrayList<HotTopBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hottop_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //设置圆角图片
       // Glide.with(context).load(list.get(position).img).transform(new GlideCircleTransform(context)).into(holder.iv_hottop);
        Glide.with(context).load(list.get(position).img)
                .priority( Priority.HIGH )
                .into(holder.iv_hottop);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, ParticularsActivity.class);
                intent.putExtra("url", "http://39.106.32.50/#/entrancenews?newsId="+list.get(position).newsId);
                intent.putExtra("particulars_title", list.get(position).tv_title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_hottop;

       private  View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.view=itemView;
            iv_hottop = itemView.findViewById(R.id.iv_hottop);

        }
    }
}

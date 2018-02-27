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

import java.util.ArrayList;

import base.GlideCircleTransform;
import bean.RecommendBean;

/**
 * Created by 祝文 on 2018/1/22.
 */

public class RecommendRecycleViewAdapter extends RecyclerView.Adapter<RecommendRecycleViewAdapter.MyViewHolder> {
    private ArrayList<RecommendBean> list;
    private Context context;

    public RecommendRecycleViewAdapter(ArrayList<RecommendBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_item, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Glide.with(context).load(list.get(position).img).transform(new GlideCircleTransform(context)).into(holder.recommend_iv);
        holder.recommend_tv_title.setText(list.get(position).tv_title);
        holder.recommend_time.setText(list.get(position).time);
        holder.recommend_count.setText(list.get(position).count);

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

        private final ImageView recommend_iv;
        private final TextView recommend_tv_title;
        private final TextView recommend_time;
        private final TextView recommend_count;
        private  View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.view=itemView;
            recommend_iv = itemView.findViewById(R.id.recommend_iv);
            recommend_tv_title = itemView.findViewById(R.id.recommend_tv_title);
            recommend_time = itemView.findViewById(R.id.recommend_time);
            recommend_count = itemView.findViewById(R.id.recommend_count);
        }
    }
}

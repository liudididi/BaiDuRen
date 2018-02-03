package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;
import com.meg7.widget.CustomShapeImageView;

import java.util.ArrayList;

import base.BaseApi;
import bean.CanSchoolBean3;

/**
 * Created by 祝文 on 2018/1/28.
 */

public class MoreSchool_Adapter extends RecyclerView.Adapter<MoreSchool_Adapter.MyViewHolder> {
   private  ArrayList<CanSchoolBean3> list;
   private Context context;

    public MoreSchool_Adapter(ArrayList<CanSchoolBean3> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.moreschool_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Glide.with(context).load(BaseApi.ImgApi+list.get(position).getImgurl()).into(holder.moreschool_iv);
        holder.more_name.setText(list.get(position).getName());
        holder.more_address.setText(list.get(position).getAddress()+"/"+list.get(position).getFather());
        holder.more_zh.setText(list.get(position).getTypeRank());
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

        private final CustomShapeImageView moreschool_iv;
        private final TextView more_name;
        private final TextView more_address;
        private final TextView more_zh;
        private  View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            moreschool_iv = itemView.findViewById(R.id.moreschool_iv);
            more_name = itemView.findViewById(R.id.more_name);
            more_address = itemView.findViewById(R.id.more_address);
            more_zh = itemView.findViewById(R.id.more_zh);


        }
    }
}

package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;
import com.meg7.widget.CustomShapeImageView;

import java.util.List;

import base.BaseApi;
import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/26.
 * 邮箱：461211527@qq.com.
 */

public class MySchoolRecycle extends RecyclerView.Adapter {

    private Context context;
    private List<SchoolBean> list;

    public MySchoolRecycle(Context context, List<SchoolBean> list) {
        this.context = context;
        this.list = list;
    }

    public  void  Reftch(List<SchoolBean> newlist){
        list.clear();
        list=newlist;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.myschool_listitem, null);
        MySchoolViewHolder mySchoolViewHolder=new MySchoolViewHolder(view);
        return mySchoolViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MySchoolViewHolder mySchoolViewHolder= (MySchoolViewHolder) holder;
        mySchoolViewHolder.schoolitem_name.setText(list.get(position).getName());
        mySchoolViewHolder.schoolitem_typerank.setText(list.get(position).getVlaue2());
        mySchoolViewHolder.schoolitem_address.setText(list.get(position).getValue1());
        String url = list.get(position).getValue3();
        if(url!=null){
            Glide.with(context).load(BaseApi.ImgApi+url).into(mySchoolViewHolder.schoolitem_url);
        }

        mySchoolViewHolder.view.setOnClickListener(new View.OnClickListener() {
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

    class  MySchoolViewHolder extends  RecyclerView.ViewHolder {
        private TextView    schoolitem_name;
        private TextView    schoolitem_address;
        private TextView    schoolitem_typerank;
        private CustomShapeImageView schoolitem_url;
        private  View view;
        public MySchoolViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            schoolitem_name=itemView.findViewById(R.id.schoolitem_name);
            schoolitem_address=itemView.findViewById(R.id.schoolitem_address);
            schoolitem_typerank=itemView.findViewById(R.id.schoolitem_typerank);
            schoolitem_url=itemView.findViewById(R.id.schoolitem_url);
        }
    }
}

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
import bean.CheckSchoolBean;
import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/26.
 * 邮箱：461211527@qq.com.
 */

public class MoreSchoolRecycle extends RecyclerView.Adapter {

    private Context context;
    private List<CheckSchoolBean> list;



    public MoreSchoolRecycle(Context context, List<CheckSchoolBean> list) {
        this.context = context;
        this.list = list;
    }

    public  void  Refsh(List<CheckSchoolBean> newlist){
        list.clear();
        list=newlist;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.moreschool_listitem, null);
        MySchoolViewHolder mySchoolViewHolder=new MySchoolViewHolder(view);
        return mySchoolViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String  fujia="";
        final MySchoolViewHolder mySchoolViewHolder= (MySchoolViewHolder) holder;
        mySchoolViewHolder.schoolitem_name.setText(list.get(position).getName());
        mySchoolViewHolder.schoolitem_typerank.setText(list.get(position).getRanking());
        mySchoolViewHolder.schoolitem_address.setText(list.get(position).getAddress());
        final String url = list.get(position).getUrl();
        String two = list.get(position).getTwo();
        String defenseStudent = list.get(position).getDefenseStudent();
        String nine = list.get(position).getNine();
        String recruit = list.get(position).getRecruit();
        if(two!=null){
            fujia+=" "+two;
        }
        if(defenseStudent!=null){
            fujia+=" "+defenseStudent;
        }
        if(nine!=null){
            fujia+=" "+nine;
        }
        if(recruit!=null){
            fujia+=" "+recruit;
        }
        if(url!=null){
            Glide.with(context).load(BaseApi.ImgApi+url).into(mySchoolViewHolder.schoolitem_url);
        }
        mySchoolViewHolder.schoolitem_fujia.setText(fujia);
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
        private TextView    schoolitem_fujia;
        private CustomShapeImageView schoolitem_url;

        private  View view;



        public MySchoolViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            schoolitem_name=itemView.findViewById(R.id.schoolitem_name);
            schoolitem_address=itemView.findViewById(R.id.schoolitem_address);
            schoolitem_typerank=itemView.findViewById(R.id.schoolitem_typerank);
            schoolitem_fujia=itemView.findViewById(R.id.schoolitem_fujia);
            schoolitem_url=itemView.findViewById(R.id.schoolitem_url);

        }
    }



}

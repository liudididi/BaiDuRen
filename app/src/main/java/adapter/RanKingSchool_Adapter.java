package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;

import java.util.ArrayList;

import bean.RanKingSchoolBean2;

/**
 * Created by 祝文 on 2018/1/30.
 */

public class RanKingSchool_Adapter extends RecyclerView.Adapter<RanKingSchool_Adapter.MyViewHolder> {
   private ArrayList<RanKingSchoolBean2> list;
   private Context context;

    public RanKingSchool_Adapter(ArrayList<RanKingSchoolBean2> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void LoadMore(ArrayList<RanKingSchoolBean2> newlist) {
        if(list!=null){
            list.addAll(newlist);
            this.notifyDataSetChanged();
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rankingschool_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.ranking_tv_num.setText(position+1+"");
        holder.ranking_tv_name.setText(list.get(position).getName());
        holder.ranking_tv_address.setText(list.get(position).getAddress());
        holder.ranking_tv_typeRank.setText(list.get(position).getTypeRank());

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

        private final TextView ranking_tv_num;
        private final TextView ranking_tv_name;
        private final TextView ranking_tv_address;
        private final TextView ranking_tv_typeRank;
        private  View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            ranking_tv_num = itemView.findViewById(R.id.ranking_tv_num);
            ranking_tv_name = itemView.findViewById(R.id.ranking_tv_name);
            ranking_tv_address = itemView.findViewById(R.id.ranking_tv_address);
            ranking_tv_typeRank = itemView.findViewById(R.id.ranking_tv_typeRank);
            view=itemView;

        }
    }
}

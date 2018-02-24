package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.login_demo.More_SchoolActivity;
import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;
import com.meg7.widget.CustomShapeImageView;

import java.util.List;

import base.BaseApi;
import base.BaseBean;
import bean.CanSchoolBean;
import bean.CanSchoolBean2;
import view.WishView;

/**
 * Created by 地地 on 2018/1/21.
 * 邮箱：461211527@qq.com.
 */

public class Wash_School_adapter  extends RecyclerView.Adapter{
     private List<CanSchoolBean2> list;
     private Context context;
     private int a=0;
     private int b=1;
    public Wash_School_adapter(List<CanSchoolBean2> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder=null;
        switch (viewType)
        {
            case 0:
                view = View.inflate(context, R.layout.more_item, null);
                holder=new School_viewHoder1(view);
                break;
            case 1:
                view = View.inflate(context, R.layout.my_wish_school_item, null);
                        holder=new School_viewHoder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position))
        {
            case 0:
                School_viewHoder1 school_viewHoder1= (School_viewHoder1) holder;
                school_viewHoder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(context, More_SchoolActivity.class));
                     }
                });
                break;
            case 1:
                final School_viewHoder school_viewHoder= (School_viewHoder) holder;
                Glide.with(context).load(BaseApi.ImgApi+list.get(position).getImgurl()).into(school_viewHoder.item_school_icon);
                school_viewHoder.item_school_name.setText(list.get(position).getName());
                school_viewHoder.item_school_address.setText(list.get(position).getAddress()+"  "+list.get(position).getTypeRank());


                school_viewHoder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context, SchoolDetailActivity.class);
                        intent.putExtra("schoolname",list.get(position).getName());
                        context.startActivity(intent);
                    }
                });
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==4)
        {
            return a;
        }
        else
        {
            return b;
        }
    }



    class  School_viewHoder extends  RecyclerView.ViewHolder {

        CustomShapeImageView item_school_icon;
         TextView item_school_name;
          TextView item_school_address;
          View view;

       public School_viewHoder(View itemView) {
           super(itemView);
           item_school_icon = itemView.findViewById(R.id.item_school_icon);
           item_school_name = itemView.findViewById(R.id.item_school_name);
           item_school_address = itemView.findViewById(R.id.item_school_address);
           view=itemView;
       }
   }
    class  School_viewHoder1 extends  RecyclerView.ViewHolder {

        public School_viewHoder1(View itemView) {
            super(itemView);

        }
    }
}

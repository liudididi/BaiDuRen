package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.OneTableActivity;
import com.example.login_demo.OneTableXQActivity;
import com.example.login_demo.R;

import java.util.List;

import bean.OneTableBean;

/**
 * Created by 祝文 on 2018/2/2.
 */

public class OneTableAdapter extends RecyclerView.Adapter<OneTableAdapter.MyViewHolder>{
    private List<OneTableBean> list;
    private Context context;

    public OneTableAdapter(List<OneTableBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.onetable_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        //年份
        holder.onetable_tv_years.setText(list.get(position).getYear()+"年");
        //地址
        holder.onetable_tv_address.setText(list.get(position).getProvince());
        holder.onetable_tv_type.setText(list.get(position).getYear()+list.get(position).getProvince()+"高考一分一段表("+ OneTableActivity.s+")");
        holder.onetable_tv_years2.setText(list.get(position).getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, OneTableXQActivity.class);
                intent.putExtra("type",OneTableActivity.s);
                intent.putExtra("province",list.get(position).getProvince());
                intent.putExtra("year",list.get(position).getYear()+"");
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView onetable_tv_years;
        private final TextView onetable_tv_address;
        private final TextView onetable_tv_type;
        private final TextView onetable_tv_years2;

        public MyViewHolder(View itemView) {
            super(itemView);
            onetable_tv_years = itemView.findViewById(R.id.onetable_tv_years);
            onetable_tv_address = itemView.findViewById(R.id.onetable_tv_address);
            onetable_tv_type = itemView.findViewById(R.id.onetable_tv_type);
            onetable_tv_years2 = itemView.findViewById(R.id.onetable_tv_years2);
        }
    }
}

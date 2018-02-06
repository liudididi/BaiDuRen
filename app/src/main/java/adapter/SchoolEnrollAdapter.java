package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.List;

import bean.SchoolEnrollBean;

/**
 * Created by 祝文 on 2018/2/5.
 */

public class SchoolEnrollAdapter extends RecyclerView.Adapter<SchoolEnrollAdapter.MyViewHolder> {
    private List<SchoolEnrollBean> list;
    private Context context;

    public SchoolEnrollAdapter(List<SchoolEnrollBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schoolenroll_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.school_enroll_tv1.setText(list.get(position).getMajorName());
        holder.school_enroll_tv2.setText(list.get(position).getYear()+"年计划招生"+list.get(position).getNumber()+"人");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView school_enroll_tv1;
        private final TextView school_enroll_tv2;

        public MyViewHolder(View itemView) {
            super(itemView);
            school_enroll_tv1 = itemView.findViewById(R.id.school_enroll_tv1);
            school_enroll_tv2 = itemView.findViewById(R.id.school_enroll_tv2);

        }
    }
}

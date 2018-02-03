package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.ArrayList;

import bean.StudyBean2;

/**
 * Created by 祝文 on 2018/2/1.
 */

public class ProvinceAdapter1 extends RecyclerView.Adapter<ProvinceAdapter1.MyViewHolder> {
    private ArrayList<String> list;
    private Context context;

    public ProvinceAdapter1(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void load(ArrayList<String> newlist)
    {
        if(list!=null){
            list.clear();
            list=newlist;
            notifyDataSetChanged();
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.provinceitem1, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_batch.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_batch;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_batch = itemView.findViewById(R.id.tv_batch);
        }
    }
}

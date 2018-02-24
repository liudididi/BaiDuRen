package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.Help2Activity;
import com.example.login_demo.Help3Activity;
import com.example.login_demo.R;

import java.util.List;

import bean.HelpBean;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class Help2Adapter extends RecyclerView.Adapter<Help2Adapter.MyViewHolder>{
    private List<HelpBean> list;
    private Context context;
    private String title;
    private  SetHelpBack setHelpBack;
    public Help2Adapter(List<HelpBean> list, Context context,String title) {
        this.list = list;
        this.context = context;
        this.title=title;
    }

    public void setSetHelpBack(SetHelpBack setHelpBack) {
        this.setHelpBack = setHelpBack;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.help_item, null);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.help_tv.setText(list.get(position).getBook());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = list.get(position).getId();
                setHelpBack.HelpBack(holder.itemView,title,id+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView help_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            help_tv = itemView.findViewById(R.id.help_tv);
        }
    }

    public  interface  SetHelpBack{
        void   HelpBack(View view, String title, String id);
    }
}

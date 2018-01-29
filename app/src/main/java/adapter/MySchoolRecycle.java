package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.List;

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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.myschool_listitem, null);
        MySchoolViewHolder mySchoolViewHolder=new MySchoolViewHolder(view);
        return mySchoolViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MySchoolViewHolder mySchoolViewHolder= (MySchoolViewHolder) holder;
        mySchoolViewHolder.tv_school_name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MySchoolViewHolder extends  RecyclerView.ViewHolder {
        private ImageView   img_school_icon;
        private TextView    tv_school_name;
        public MySchoolViewHolder(View itemView) {
            super(itemView);
            img_school_icon=itemView.findViewById(R.id.img_school_icon);
            tv_school_name=itemView.findViewById(R.id.tv_school_name);
        }
    }
}

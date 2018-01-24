package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.login_demo.R;

import java.util.List;

import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/21.
 * 邮箱：461211527@qq.com.
 */

public class Wash_School_adapter  extends RecyclerView.Adapter{
     private List<SchoolBean> list;
     private Context context;

    public Wash_School_adapter(List<SchoolBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.my_wish_school_item, null);
        School_viewHoder school_viewHoder=new School_viewHoder(view);
        return school_viewHoder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

   class  School_viewHoder extends  RecyclerView.ViewHolder {
       public School_viewHoder(View itemView) {
           super(itemView);
       }
   }

}

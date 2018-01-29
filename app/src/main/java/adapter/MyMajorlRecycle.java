package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.List;

import bean.MajorBean;
import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/26.
 * 邮箱：461211527@qq.com.
 */

public class MyMajorlRecycle extends RecyclerView.Adapter {

    private Context context;
    private List<MajorBean> list;

    public MyMajorlRecycle(Context context, List<MajorBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.myjor_listitem, null);
        MaJorViewHolder myjorviewholder=new MaJorViewHolder(view);
        return myjorviewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MaJorViewHolder myjorviewholder= (MaJorViewHolder) holder;
        myjorviewholder.major_tv_big.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MaJorViewHolder extends  RecyclerView.ViewHolder {
        private TextView    major_tv_small;
        private TextView    major_tv_big;

        public MaJorViewHolder(View itemView) {
            super(itemView);
            major_tv_big= itemView.findViewById(R.id.majoritem_tv_big);
            major_tv_small= itemView.findViewById(R.id.majoritem_tv_small);
        }
    }
}

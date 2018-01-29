package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.MyApp;
import com.example.login_demo.R;
import com.example.login_demo.perfectMessageActivity;

import java.util.List;

import bean.AreaBean;
import bean.SelectSchoolBean;
import untils.SPUtils;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class SelecSchool_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<SelectSchoolBean> list;

    public SelecSchool_Adapter(Context context, List<SelectSchoolBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.selectschool_item, null);
        ProvieceViewHolder provieceViewHolder=new ProvieceViewHolder(view);
        return provieceViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
      ProvieceViewHolder  provieceViewHolder= (ProvieceViewHolder) holder;
      provieceViewHolder.selecschoolitem_name.setText(list.get(position).getHighschool());
      provieceViewHolder.selecschoolitem_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(context, perfectMessageActivity.class);
            SPUtils.put(MyApp.context,"highschool",list.get(position).getHighschool());
            context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ProvieceViewHolder extends  RecyclerView.ViewHolder {
        private TextView selecschoolitem_name;
        public ProvieceViewHolder(View itemView) {
            super(itemView);
            selecschoolitem_name=itemView.findViewById(R.id.selecschoolitem_name);
        }
    }
}

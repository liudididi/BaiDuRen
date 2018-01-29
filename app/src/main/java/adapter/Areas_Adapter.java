package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SelectSchoolActivity;

import java.util.List;

import bean.AreaBean;
import bean.CityBean;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class Areas_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<AreaBean> list;

    public Areas_Adapter(Context context, List<AreaBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.area_item, null);
        ProvieceViewHolder provieceViewHolder=new ProvieceViewHolder(view);
        return provieceViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
      ProvieceViewHolder  provieceViewHolder= (ProvieceViewHolder) holder;
      provieceViewHolder.areaitem_name.setText(list.get(position).getArea());
      provieceViewHolder.areaitem_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SelectSchoolActivity.class);

                intent.putExtra("area",list.get(position).getArea());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ProvieceViewHolder extends  RecyclerView.ViewHolder {
        private TextView areaitem_name;
        public ProvieceViewHolder(View itemView) {
            super(itemView);
            areaitem_name=itemView.findViewById(R.id.areaitem_name);
        }
    }
}

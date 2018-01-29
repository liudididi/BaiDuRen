package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SelectAreasActivity;

import java.util.List;

import bean.CityBean;
import bean.ProviceBean;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class Citys_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<CityBean> list;

    public Citys_Adapter(Context context, List<CityBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.city_item, null);
        ProvieceViewHolder provieceViewHolder=new ProvieceViewHolder(view);
        return provieceViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
      ProvieceViewHolder  provieceViewHolder= (ProvieceViewHolder) holder;
      provieceViewHolder.cityitem_name.setText(list.get(position).getCity());
      provieceViewHolder.cityitem_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SelectAreasActivity.class);
                intent.putExtra("city",list.get(position).getCity());
                intent.putExtra("cityid",list.get(position).getCityid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ProvieceViewHolder extends  RecyclerView.ViewHolder {
        private TextView cityitem_name;
        public ProvieceViewHolder(View itemView) {
            super(itemView);
            cityitem_name=itemView.findViewById(R.id.cityitem_name);
        }
    }
}

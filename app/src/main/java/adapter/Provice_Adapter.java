package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SelectCitysActivity;

import java.util.List;

import bean.ProviceBean;

/**
 * Created by 地地 on 2018/1/27.
 * 邮箱：461211527@qq.com.
 */

public class Provice_Adapter extends RecyclerView.Adapter {

    private Context context;
    private List<ProviceBean> list;

    public Provice_Adapter(Context context, List<ProviceBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.provice_item, null);
        ProvieceViewHolder provieceViewHolder=new ProvieceViewHolder(view);
        return provieceViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
      ProvieceViewHolder  provieceViewHolder= (ProvieceViewHolder) holder;
      provieceViewHolder.proviceitem_name.setText(list.get(position).getProvince());
      provieceViewHolder.proviceitem_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SelectCitysActivity.class);
                intent.putExtra("provinceid",list.get(position).getProvinceid());
                intent.putExtra("province",list.get(position).getProvince());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ProvieceViewHolder extends  RecyclerView.ViewHolder {

        private TextView proviceitem_name;
        public ProvieceViewHolder(View itemView) {
            super(itemView);
            proviceitem_name=itemView.findViewById(R.id.proviceitem_name);
        }
    }
}

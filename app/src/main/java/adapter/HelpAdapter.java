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

import base.BaseBean;
import bean.HelpBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import untils.MyQusetUtils;

/**
 * Created by 祝文 on 2018/2/23.
 */

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.MyViewHolder>{
    private List<HelpBean> list;
    private Context context;

    public HelpAdapter( List<HelpBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.help_item, null);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.help_tv.setText(list.get(position).getBook());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int id = list.get(position).getId();

                MyQusetUtils.getInstance().getQuestInterface().helping("0", id+"")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<BaseBean<List<HelpBean>>>() {
                            @Override
                            public void onNext(BaseBean<List<HelpBean>> listBaseBean) {
                             if(listBaseBean.code==0){
                                 if(listBaseBean.data!=null){
                                     if(listBaseBean.data.size()>1){
                                         String standby = list.get(position).getStandby();
                                         Intent intent=new Intent(context, Help2Activity.class);
                                         String substring = list.get(position).getBook().substring(3);
                                         intent.putExtra("title1",substring);
                                         intent.putExtra("id",id+"");
                                         context.startActivity(intent);
                                     }else if(listBaseBean.data.size()==1){
                                         Intent intent= new Intent(context,Help3Activity.class);
                                         String substring = list.get(position).getBook().substring(3);
                                         intent.putExtra("title2",substring);
                                         intent.putExtra("id",list.get(position).getId()+"");
                                         context. startActivity(intent);
                                     }
                                 }

                             }
                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });


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
}

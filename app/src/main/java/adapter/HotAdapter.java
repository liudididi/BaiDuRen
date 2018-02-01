package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.R;

import java.util.List;

import base.Basepresent;
import bean.HotBean;

/**
 * Created by 地地 on 2018/2/1.
 * 邮箱：461211527@qq.com.
 */

public class HotAdapter extends BaseAdapter {
    private Context context;
    private List<HotBean> list;

    public HotAdapter(Context context, List<HotBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.hot_item,null);
        }
       TextView tv= convertView.findViewById(R.id.hot_name);
       tv.setText(list.get(position).getHotName());
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(list.get(position).getHotType().equals("0")){
                   Toast.makeText(context, "学校详情"+list.get(position).getHotName(), Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(context, "专业详情"+list.get(position).getHotName(), Toast.LENGTH_SHORT).show();
               }
           }
       });

        return convertView;
    }



}

package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.List;

import bean.MajorstatXQBean;

/**
 * Created by 地地 on 2018/3/12.
 * 邮箱：461211527@qq.com.
 */

public class GridjobinfoAdapter extends BaseAdapter {
    private List<MajorstatXQBean.JobinfoBean> list;
    private Context context;

    public GridjobinfoAdapter(List<MajorstatXQBean.JobinfoBean> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context, R.layout.jobinfor,null);
        }
        TextView jobinfo_tv = convertView.findViewById(R.id.jobinfo_tv);
        jobinfo_tv.setText(list.get(position).getJobname());
        return convertView;
    }
}

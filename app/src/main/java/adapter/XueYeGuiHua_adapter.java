package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.login_demo.R;

import java.util.List;

import bean.jobStarBean;

/**
 * Created by 地地 on 2018/3/15.
 * 邮箱：461211527@qq.com.
 */

public class XueYeGuiHua_adapter extends BaseAdapter {
    private List<jobStarBean>  list;
    private Context context;

    public XueYeGuiHua_adapter(List<jobStarBean> list, Context context) {
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
            convertView=View.inflate(context, R.layout.xygh_item,null);
        }
        return convertView;
    }
}

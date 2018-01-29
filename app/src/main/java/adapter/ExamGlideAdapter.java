package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.ArrayList;

/**
 * Created by 祝文 on 2018/1/26.
 */

public class ExamGlideAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context context;

    public ExamGlideAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.month_item, null);
        TextView tv_month=inflate.findViewById(R.id.tv_month);
        tv_month.setText(list.get(i).toString());

        return inflate;
    }
}

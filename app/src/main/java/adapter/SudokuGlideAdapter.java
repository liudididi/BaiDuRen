package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.R;

import java.util.ArrayList;

import base.BaseApi;
import bean.SlideshowChildBean;

/**
 * Created by 祝文 on 2018/1/21.
 */

public class SudokuGlideAdapter extends BaseAdapter {
    private ArrayList<SlideshowChildBean> list;
    private Context context;

    public SudokuGlideAdapter(ArrayList<SlideshowChildBean> list, Context context) {
        this.list=list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(list.size()>8)
        {
            return 8;
        }
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sodoku_gride_item,null);
        ImageView sodoku_item_iv=inflate.findViewById(R.id.sodoku_item_iv);


        Glide.with(context).load(BaseApi.ImgApi+list.get(i).getExtimg()).into(sodoku_item_iv);




        return inflate;
    }
}

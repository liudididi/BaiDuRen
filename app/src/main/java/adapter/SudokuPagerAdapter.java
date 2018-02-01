package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.login_demo.MoreSchoolActivity;
import com.example.login_demo.ParticularsActivity;
import com.example.login_demo.R;

import java.util.ArrayList;

import bean.SlideshowBean;
import bean.SlideshowChildBean;

/**
 * Created by 祝文 on 2018/1/21.
 */

public class SudokuPagerAdapter extends PagerAdapter {

   private ArrayList<SlideshowChildBean> list;
   private Context context;

    public SudokuPagerAdapter(ArrayList<SlideshowChildBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        if(list.size()<=8)
        {
            return 1;
        }
        else if(list.size()>8&&list.size()<=16)
        {
            return 2;
        }
            return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = View.inflate(context, R.layout.sudoku_glide, null);
        GridView gridview=view.findViewById(R.id.gridview);
        if(position==0){

            SudokuGlideAdapter sudokuGlideAdapter= new SudokuGlideAdapter(list,context);
            gridview.setAdapter(sudokuGlideAdapter);

        }
        if(position==1){
            ArrayList<SlideshowChildBean> list1=new ArrayList<>();
            for (int i = 8; i <list.size() ; i++) {
                list1.add(list.get(i));
            }
            SudokuGlideAdapter sudokuGlideAdapter=new SudokuGlideAdapter(list1,context);
            gridview.setAdapter(sudokuGlideAdapter);
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

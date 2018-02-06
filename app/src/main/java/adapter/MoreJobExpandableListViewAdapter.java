package adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.login_demo.R;

import java.util.List;

import bean.MajorBean;
import bean.MoreJobBean;
import bean.SelectMajorBean;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public class MoreJobExpandableListViewAdapter extends BaseExpandableListAdapter {


    // 大学的集合
    private List<MoreJobBean> colleges;

    private Activity activity;


    public MoreJobExpandableListViewAdapter(List<MoreJobBean> colleges, Activity activity) {
        this.colleges = colleges;
        this.activity = activity;
    }


    public void Refresh(List<MoreJobBean> newlist) {
        if(colleges!=null){
            colleges.clear();
            colleges.addAll(newlist);
            this.notifyDataSetChanged();
        }
    }
    @Override
    public int getGroupCount() {
        return colleges.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 很关键，，一定要返回  1
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return colleges.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return colleges.get(groupPosition).getJobListTwo().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        return getGenericView(colleges.get(groupPosition).getClassifyoneName());
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        // 返回子ExpandableListView 的对象  此时传入是该父条目，即大学的对象（有歧义。。）

        return getGenericExpandableListView(colleges.get(groupPosition));
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private View getGenericView(String string) {
      /*  AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(activity);
        textView.setLayoutParams(layoutParams);

        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

        textView.setPadding(90, 20, 0, 20);
        textView.setText(string);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        return textView;*/


        View inflate = View.inflate(activity, R.layout.yiji_item, null);
        TextView tv_item=inflate.findViewById(R.id.tv_item);
        tv_item.setText(string);
        return inflate;
    }


    /**
     *  返回子ExpandableListView 的对象  此时传入的是该大学下所有班级的集合。
     * @param college
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ExpandableListView getGenericExpandableListView(MoreJobBean college){


        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        CustomExpandableListView view = new CustomExpandableListView(activity);

        // 加载班级的适配器
        MoreJobZiChildExpandableListViewAdapter  adapter=new MoreJobZiChildExpandableListViewAdapter(college.getJobListTwo(),activity);
        view.setAdapter(adapter);

        view.setPadding(20,0,0,0);

        return view;
    }
}

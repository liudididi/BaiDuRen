package adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.JobDetailsActivity;
import com.example.login_demo.R;

import java.util.List;

import bean.MoreJobBean;
import bean.SelectMajorBean;

/**
 * Created by 地地 on 2018/1/30.
 * 邮箱：461211527@qq.com.
 */

public class MoreJobZiChildExpandableListViewAdapter extends BaseExpandableListAdapter {


    // 班级的集合
    private List<MoreJobBean.JobListTwoBean> classes;

    // 创建布局使用
    private Activity activity;


    public MoreJobZiChildExpandableListViewAdapter(List<MoreJobBean.JobListTwoBean> classes, Activity activity) {
        this.classes = classes;
        this.activity = activity;
    }

    @Override
    public int getGroupCount() {
        // 获取一级条目的数量  就是班级的大小
        return classes.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 获取对应一级条目下二级条目的数量，就是各个班学生的数量
        return classes.get(groupPosition).getJobListThree().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // 获取一级条目的对应数据  ，感觉没什么用
        return classes.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // 获取对应一级条目下二级条目的对应数据  感觉没什么用
        return classes.get(groupPosition).getJobListThree().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // 直接返回，没什么用
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // 直接返回，没什么用
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // 谁知道这个是干什么。。。。
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // 获取对应一级条目的View  和ListView 的getView相似

        return getGenericView(classes.get(groupPosition).getClassifytwoName());
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View genericView = getGenericView(classes.get(groupPosition).getJobListThree().get(childPosition).getJob());
        // 获取对应二级条目的View  和ListView 的getView相似
        genericView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Intent intent=new Intent(activity, JobDetailsActivity.class);
                intent.putExtra("jobname",classes.get(groupPosition).getJobListThree().get(childPosition).getJob());
                activity.startActivity(intent);
            }
        });
        return genericView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 根据方法名，此处应该表示二级条目是否可以被点击   先返回true 再讲
        return true;
    }


    /**
     * 根据字符串生成布局，，因为我没有写layout.xml 所以用java 代码生成
     *
     *      实际中可以通过Inflate加载自己的自定义布局文件，设置数据之后并返回
     * @param string
     * @return
     */
    private View getGenericView(final String string) {
/*       AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(activity);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(90, 20, 0, 20);
        textView.setText(string);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);*/

        View inflate = View.inflate(activity, R.layout.erji_item, null);
        TextView tv_item=inflate.findViewById(R.id.tv_item);
        tv_item.setText(string);
        return inflate;
    }
}

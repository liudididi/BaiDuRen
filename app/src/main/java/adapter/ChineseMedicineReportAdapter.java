package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.login_demo.R;

import untils.Question;

/**
 * Created by 祝文 on 2018/3/2.
 */

public class ChineseMedicineReportAdapter extends BaseAdapter {

    Context context;

    Question quesions;



    public ChineseMedicineReportAdapter(Context context, Question quesions) {

        this.context = context;

        this.quesions = quesions;

    }


    @Override
    public int getCount() {
        return quesions.getAnswer().size();
    }

    @Override
    public Object getItem(int i) {
        return quesions.getAnswer().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {

            view = View.inflate(context, R.layout.item_answer_list, null);

            holder = new ViewHolder(view);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

        Question.Answer answer = quesions.getAnswer().get(i);

        holder.tv_answer.setText(answer.getAnswerMessage());
         itemOnClick.SX(view,i);
        return view;
    }
    static class ViewHolder {
        private final TextView tv_answer;

        ViewHolder(View view) {

            tv_answer = view.findViewById(R.id.tv_answer);

        }

    }
    public ItemOnClick itemOnClick;

    public void setItemOnClick(ItemOnClick itemOnClick) {
        this.itemOnClick = itemOnClick;
    }

    public interface ItemOnClick
    {

        void SX(View view, int position);
    }
}

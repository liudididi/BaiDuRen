package fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.MajorDetailActivity;
import com.example.login_demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import adapter.MajorSchoolRecycle;
import base.Basefragment;
import bean.MajorSchoolBean;
import presenter.MajorSchoolPresent;
import view.MajorSchoolView;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class Majorschool_Fragment extends Basefragment implements MajorSchoolView {

    private XRecyclerView majorschool_xrecycle;
    private TextView marjorschool_tvnum;
    private MajorSchoolPresent majorSchoolPresent;
    private ProgressBar majorshool_pb;
    private ImageView majorschool_none;


    @Override
    public int getLayoutid() {
        return R.layout.majorschool;
    }

    @Override
    public void initView() {
     initid();
     majorSchoolPresent = new MajorSchoolPresent(this);

     majorSchoolPresent.getMajorschool(MajorDetailActivity.majorid);

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void initid() {
        majorschool_xrecycle = view.findViewById(R.id.majorschool_xrecycle);
        majorschool_xrecycle.setPullRefreshEnabled(false);
        majorschool_xrecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        marjorschool_tvnum = view.findViewById(R.id.marjorschool_tvnum);
        majorshool_pb = view.findViewById(R.id.majorshool_pb);
        majorschool_none = view.findViewById(R.id.majorschool_none);

    }




    @Override
    public void MarjorSchoolSuccess(List<MajorSchoolBean> list) {
        if(list!=null&list.size()>0){
            majorschool_none.setVisibility(View.GONE);
            majorshool_pb.setVisibility(View.GONE);
            marjorschool_tvnum.setText(list.size()+"所");
            MajorSchoolRecycle adpter=new MajorSchoolRecycle(getActivity(),list);
            majorschool_xrecycle.setAdapter(adpter);
            majorschool_xrecycle.setNestedScrollingEnabled(false);
        }else {
            majorschool_none.setVisibility(View.VISIBLE);
            majorshool_pb.setVisibility(View.GONE);
        }
    }

    @Override
    public void MarjorSchoolFail(String msg) {

    }
}

package fragment;



import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.login_demo.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Wash_School_adapter;
import base.Basefragment;
import bean.SchoolBean;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class WishFragMent extends Basefragment {


    private RecyclerView school_recycle;

    @Override
    public int getLayoutid() {
        return R.layout.wish_fragment;
    }

    @Override
    public void initView() {
    initId();
    }

    private void initId() {
        school_recycle = view.findViewById(R.id.wish_school_recycle);
        List<SchoolBean> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SchoolBean schoolBean=new SchoolBean();
            list.add(schoolBean);
        }
        Wash_School_adapter wash_school_adapter=new Wash_School_adapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        school_recycle.setLayoutManager(linearLayoutManager);
        school_recycle.setAdapter(wash_school_adapter);

    }
}

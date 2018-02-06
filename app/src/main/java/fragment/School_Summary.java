package fragment;

import android.view.View;
import android.widget.TextView;

import com.example.login_demo.R;
import com.example.login_demo.SchoolDetailActivity;

import base.Basefragment;

/**
 * Created by 地地 on 2018/2/5.
 * 邮箱：461211527@qq.com.
 */

public class School_Summary  extends Basefragment {

    private TextView ss_tvshd;
    private TextView ss_bsd;

    @Override
    public int getLayoutid() {
        return R.layout.school_summary;
    }

    @Override
    public void initView() {
        initid();
        if(SchoolDetailActivity.bhsd!=null){
            ss_bsd.setText(SchoolDetailActivity.bhsd);
        }
        if(SchoolDetailActivity.shsd!=null){
            ss_tvshd.setText(SchoolDetailActivity.shsd);
        }

    }

    private void initid() {

        ss_tvshd = view.findViewById(R.id.ss_tvshd);
        ss_bsd = view.findViewById(R.id.ss_bsd);
    }
}

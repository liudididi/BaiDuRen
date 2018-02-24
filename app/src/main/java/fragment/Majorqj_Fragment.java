package fragment;

import android.widget.TextView;

import com.example.login_demo.R;

import base.Basefragment;

/**
 * Created by 地地 on 2018/2/2.
 * 邮箱：461211527@qq.com.
 */

public class Majorqj_Fragment  extends Basefragment{

    private TextView qj_tvqj;
    private TextView qj_tvfx;

    @Override
    public int getLayoutid() {
        return R.layout.majorqj;
    }

    @Override
    public void initView() {
        qj_tvqj = view.findViewById(R.id.qj_tvqj);
        qj_tvfx = view.findViewById(R.id.qj_tvfx);
        if(Majorgk_Fragment.jyqj!=null){
            qj_tvqj.setText(Majorgk_Fragment.jyqj);
        }
        if(Majorgk_Fragment.jyfx!=null){
            qj_tvfx.setText(Majorgk_Fragment.jyfx);
        }




    }
}

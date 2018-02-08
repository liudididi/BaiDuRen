package fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.login_demo.R;
import com.example.login_demo.SchoolBrouesDetailsActivity;
import com.example.login_demo.SchoolDetailActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.School_Brochures_Adapter;
import base.BaseBean;
import base.Basefragment;
import bean.SchoolBrochuresBean;
import presenter.SchoolBrochuresPresent;
import view.SchoolBrochuresView;

/**
 * Created by 祝文 on 2018/2/7.
 */

public class School_Brochures extends Basefragment implements SchoolBrochuresView{

    private ListView school_brochures_lv;
    private ArrayList<String> list;

    @Override
    public int getLayoutid() {
        return R.layout.school_brochures;
    }

    @Override
    public void initView() {
        SchoolBrochuresPresent schoolBrochuresPresent=new SchoolBrochuresPresent(this);
        schoolBrochuresPresent.SchoolBrochuresPresent(SchoolDetailActivity.schoolname);
        school_brochures_lv = view.findViewById(R.id.school_brochures_lv);
        list = new ArrayList<>();
        list.add("招生简章");
        list.add("招生计划");
        list.add("自主招生");
        list.add("保送生招生");
        list.add("特长生招生");
        System.out.println("集合长度+"+ list.size());
        School_Brochures_Adapter school_brochures_adapter=new School_Brochures_Adapter(list,getContext());
        school_brochures_lv.setAdapter(school_brochures_adapter);


    }

    @Override
    public void Brochuressuccess(BaseBean<List<SchoolBrochuresBean>> listBaseBean) {
        List<SchoolBrochuresBean> data = listBaseBean.data;
        if(data.size()>0&&data!=null)
        {
            for (int i = 0; i < data.size(); i++) {
                //招生简章
                final String admissionRules = data.get(i).getAdmissionRules();
                final String admissionPlan = data.get(i).getAdmissionPlan();
                final String independent = data.get(i).getIndependent();
                final String baosongstr = data.get(i).getBaosongstr();
                final String specialtystr = data.get(i).getSpecialtystr();
                school_brochures_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(getContext(), SchoolBrouesDetailsActivity.class);
                        if(i==0)
                        {
                            intent.putExtra("count",admissionRules);
                            intent.putExtra("tltle1",list.get(i).toString());
                         }
                        if(i==1)
                        {
                            intent.putExtra("count",admissionPlan);
                            intent.putExtra("tltle1",list.get(i).toString());
                         }
                        if(i==2)
                        {
                            intent.putExtra("count",independent);
                            intent.putExtra("tltle1",list.get(i).toString());
                         }
                        if(i==3)
                        {
                            intent.putExtra("count",baosongstr);
                            intent.putExtra("tltle1",list.get(i).toString());
                         }
                        if(i==4)
                        {
                            intent.putExtra("count",specialtystr);
                            intent.putExtra("tltle1",list.get(i).toString());
                         }

                        startActivity(intent);
                    }
                });
            }
        }


    }

    @Override
    public void Brochuresfail(Throwable t) {

    }
}

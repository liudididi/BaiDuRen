package fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_demo.MajorStarActivity;
import com.example.login_demo.R;

import java.util.ArrayList;
import java.util.List;

import base.Basefragment;
import bean.jobStarBean;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public class MajorStartFragment extends Basefragment {
    private List<jobStarBean> list;
    private List<TextView>  titlelist=new ArrayList<>();
    private List<TextView> xinzilist=new ArrayList<>();
    private List<TextView> mblist=new ArrayList<>();
    private  List<RelativeLayout> relativeLayouts=new ArrayList<>();
    private  List<ImageView> imageViews=new ArrayList<>();
    private  List<ImageView> xhimageViews=new ArrayList<>();
    private ImageView img_xihuanone;
    private ImageView img_xihuantwo;
    private ImageView img_xihuansan;


    @Override
    public int getLayoutid() {
        return R.layout.majorstat;
    }

    public void setList(List<jobStarBean> list) {
        this.list = list;
    }

    @Override
    public void initView() {
        initid();
        for (int i = 0; i < list.size(); i++) {
            titlelist.get(i).setText(list.get(i).getMajor());
            List<jobStarBean.MajorinfoBean> majorinfo = list.get(i).getMajorinfo();

            if(majorinfo!=null&&majorinfo.size()>0){
                    mblist.get(i).setText(majorinfo.get(0).getTraining_target());
                    xinzilist.get(i).setText("￥"+majorinfo.get(0).getAveragesalary());
            }
            relativeLayouts.get(i).setVisibility(View.VISIBLE);
            final int finalI = i;
            imageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<jobStarBean.MajorinfoBean> majorinfo = list.get(finalI).getMajorinfo();
                    if(majorinfo!=null&&majorinfo.size()>0){
                        MajorStarActivity.tanchuang(list.get(finalI).getMajor_id(),list.get(finalI).getMajor(),majorinfo.get(0).getAveragesalary()+"",getActivity());
                    }else {
                        Toast.makeText(getActivity(), "暂无信息", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).xh==true){
                xhimageViews.get(i).setImageResource(R.drawable.bgxq);
            }else {
                xhimageViews.get(i).setImageResource(R.drawable.bgbxq);
            }
        }
    }

    private void initid() {
        TextView tvmajorone = view.findViewById(R.id.tvmajorone);
        TextView tvmajortwo = view.findViewById(R.id.tvmajortwo);
        TextView tvmajorsan = view.findViewById(R.id.tvmajorsan);
        titlelist.add(tvmajorone);
        titlelist.add(tvmajortwo);
        titlelist.add(tvmajorsan);
        TextView xinzione = view.findViewById(R.id.xinzione);
        TextView xinzitwo = view.findViewById(R.id.xinzitwo);
        TextView xinzisan = view.findViewById(R.id.xinzisan);
        xinzilist.add(xinzione);
        xinzilist.add(xinzitwo);
        xinzilist.add(xinzisan);
        TextView tvpymbsan = view.findViewById(R.id.tvpymbsan);
        TextView tvpymbone = view.findViewById(R.id.tvpymbone);
        TextView tvpymbtwo = view.findViewById(R.id.tvpymbtwo);
        mblist.add(tvpymbone);
        mblist.add(tvpymbtwo);
        mblist.add(tvpymbsan);
        RelativeLayout majorstarone = view.findViewById(R.id.majorstarone);
        RelativeLayout majorstartwo = view.findViewById(R.id.majorstartwo);
        RelativeLayout majorstarsan = view.findViewById(R.id.majorstarsan);
         relativeLayouts.add(majorstarone);
         relativeLayouts.add(majorstartwo);
         relativeLayouts.add(majorstarsan);
        img_xihuanone = view.findViewById(R.id.img_xihuanone);
        img_xihuantwo = view.findViewById(R.id.img_xihuantwo);
        img_xihuansan = view.findViewById(R.id.img_xihuansan);
        xhimageViews.add(img_xihuanone);
        xhimageViews.add(img_xihuantwo);
        xhimageViews.add(img_xihuansan);
        img_xihuanone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(0).xh==false){
                    if(MajorStarActivity.answerllist.size()==6){
                        Toast.makeText(getActivity(), "添加失败，最多选择6个", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    img_xihuanone.setImageResource(R.drawable.bgxq);
                    MajorStarActivity.answerllist.add(list.get(0));
                    list.get(0).xh=true;
                }else {
                    img_xihuanone.setImageResource(R.drawable.bgbxq);
                    MajorStarActivity.answerllist.remove(list.get(0));
                    list.get(0).xh=false;
                }
                MajorStarActivity.scnum.setText(MajorStarActivity.answerllist.size()+"");
            }
        });
        img_xihuantwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(1).xh==false){
                    if(MajorStarActivity.answerllist.size()==6){
                        Toast.makeText(getActivity(), "添加失败，最多选择6个", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    img_xihuantwo.setImageResource(R.drawable.bgxq);
                    MajorStarActivity.answerllist.add(list.get(1));
                    list.get(1).xh=true;
                }else {
                    img_xihuantwo.setImageResource(R.drawable.bgbxq);
                    MajorStarActivity.answerllist.remove(list.get(1));
                    list.get(1).xh=false;
                }

                MajorStarActivity.scnum.setText(MajorStarActivity.answerllist.size()+"");
            }
        });
        img_xihuansan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(2).xh==false){
                    if(MajorStarActivity.answerllist.size()==6){
                        Toast.makeText(getActivity(), "添加失败，最多选择6个", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    img_xihuansan.setImageResource(R.drawable.bgxq);
                    MajorStarActivity.answerllist.add(list.get(2));
                    list.get(2).xh=true;
                }else {
                    img_xihuansan.setImageResource(R.drawable.bgbxq);
                    MajorStarActivity.answerllist.remove(list.get(2));
                    list.get(2).xh=false;
                }

                MajorStarActivity.scnum.setText(MajorStarActivity.answerllist.size()+"");
            }
        });

        ImageView imgyiwenone = view.findViewById(R.id.imgyiwenone);
        ImageView imgyiwentwo = view.findViewById(R.id.imgyiwentwo);
        ImageView imgyiwensan = view.findViewById(R.id.imgyiwensan);
        imageViews.add(imgyiwenone);
        imageViews.add(imgyiwentwo);
        imageViews.add(imgyiwensan);
    }



}

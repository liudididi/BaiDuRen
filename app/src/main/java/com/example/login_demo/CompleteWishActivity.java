package com.example.login_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.Complete_Adapter;
import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompleteWishActivity extends BaseActivity {


    @BindView(R.id.complete_iv_back)
    ImageView completeIvBack;
    @BindView(R.id.ivyi_right)
    ImageView ivyiRight;
    @BindView(R.id.ivyi_next)
    ImageView ivyiNext;
    @BindView(R.id.complete_rl1)
    RelativeLayout completeRl1;
    @BindView(R.id.completelv1)
    ListView completelv1;
    @BindView(R.id.rllistyi)
    RelativeLayout rllistyi;
    @BindView(R.id.complete_tvyi)
    TextView completeTvyi;
    @BindView(R.id.complete_tver)
    TextView completeTver;
    @BindView(R.id.iver_right)
    ImageView iverRight;
    @BindView(R.id.iver_next)
    ImageView iverNext;
    @BindView(R.id.complete_rl2)
    RelativeLayout completeRl2;
    @BindView(R.id.completelv2)
    ListView completelv2;
    @BindView(R.id.rllister)
    RelativeLayout rllister;
    @BindView(R.id.complete_tvsan)
    TextView completeTvsan;
    @BindView(R.id.ivsan_right)
    ImageView ivsanRight;
    @BindView(R.id.ivsan_next)
    ImageView ivsanNext;
    @BindView(R.id.complete_rl3)
    RelativeLayout completeRl3;
    @BindView(R.id.completelv3)
    ListView completelv3;
    @BindView(R.id.rllistsan)
    RelativeLayout rllistsan;
    @BindView(R.id.complete_tvsi)
    TextView completeTvsi;
    @BindView(R.id.ivsi_right)
    ImageView ivsiRight;
    @BindView(R.id.ivsi_next)
    ImageView ivsiNext;
    @BindView(R.id.complete_rl4)
    RelativeLayout completeRl4;
    @BindView(R.id.completelv4)
    ListView completelv4;
    @BindView(R.id.rllistsi)
    RelativeLayout rllistsi;
    @BindView(R.id.complete_tvyes)
    TextView completeTvyes;
    private Boolean lv1msg = false;
    private Boolean lv2msg = false;
    private Boolean lv3msg = false;
    private Boolean lv4msg = false;
    private ArrayList listyi;
    private ArrayList lister;
    private ArrayList listsan;
    private ArrayList listsi;

    private  int cityType=0;
    private  String isMS=null;
    private  String schoolType=null;
    private  String benzhuan=null;

    @Override
    public int getId() {
        return R.layout.activity_complete_wish;
    }

    @Override
    public void InIt() {
        initlist();
    }

    private void initlist() {
        listyi = new ArrayList<>();
        listyi.add("一线城市");
        listyi.add("二线城市");
        listyi.add("省会城市");
        Complete_Adapter completelv1_adapter = new Complete_Adapter(listyi, this);
        completelv1.setAdapter(completelv1_adapter);
        completelv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listyi.get(i).toString();
                rllistyi.setVisibility(View.GONE);
                lv1msg = false;
                ivyiRight.setVisibility(View.VISIBLE);
                ivyiNext.setVisibility(View.GONE);
                completeTvyi.setText(str);
                cityType=i+1;
            }
        });
        lister = new ArrayList<>();
        lister.add("院校优先");
        lister.add("专业优先");
        Complete_Adapter completelv2_adapter = new Complete_Adapter(lister, this);
        completelv2.setAdapter(completelv2_adapter);
        completelv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = lister.get(i).toString();
                rllister.setVisibility(View.GONE);
                lv2msg = false;
                iverRight.setVisibility(View.VISIBLE);
                iverNext.setVisibility(View.GONE);
                completeTver.setText(str);
                if(i==0){
                    isMS="院校";
                }else {
                    isMS="专业";
                }
            }
        });


        listsan = new ArrayList<>();
        listsan.add("理工类院校");
        listsan.add("综合类院校");
        listsan.add("艺体类院校");
        listsan.add("无所谓");

        Complete_Adapter completelv3_adapter = new Complete_Adapter(listsan, this);
        completelv3.setAdapter(completelv3_adapter);
        completelv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listsan.get(i).toString();
                rllistsan.setVisibility(View.GONE);
                lv3msg = false;
                ivsanRight.setVisibility(View.VISIBLE);
                ivsanNext.setVisibility(View.GONE);
                completeTvsan.setText(str);
                if(i==0){
                    schoolType="理工类";
                }else if(i==1) {
                    schoolType="综合类";
                }else if(i==2) {
                    schoolType="艺体类";
                }else {
                    schoolType="";
                }
            }
        });

        listsi = new ArrayList<>();
        listsi.add("是,接受专科");
        listsi.add("否，不接受专科");
        Complete_Adapter completelv4_adapter = new Complete_Adapter(listsi, this);
        completelv4.setAdapter(completelv4_adapter);
        completelv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = listsi.get(i).toString();
                rllistsi.setVisibility(View.GONE);
                lv4msg = false;
                ivsiRight.setVisibility(View.VISIBLE);
                ivsiNext.setVisibility(View.GONE);
                completeTvsi.setText(str);
                if(i==0){
                    benzhuan="需要";
                }else {
                    benzhuan="不需要";
                }
            }
        });
    }

    @OnClick({R.id.complete_iv_back, R.id.complete_rl1, R.id.complete_rl2, R.id.complete_rl3, R.id.complete_rl4,R.id.complete_tvyes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.complete_iv_back:
                finish();
                break;
            case R.id.complete_rl1:
                if (lv1msg) {
                    rllistyi.setVisibility(View.GONE);
                    ivyiRight.setVisibility(View.VISIBLE);
                    ivyiNext.setVisibility(View.GONE);
                    lv1msg = false;
                } else {
                    rllistyi.setVisibility(View.VISIBLE);
                    ivyiRight.setVisibility(View.GONE);
                    ivyiNext.setVisibility(View.VISIBLE);
                    lv1msg = true;
                    lv2msg = false;
                    lv3msg = false;
                    lv4msg = false;
                    rllister.setVisibility(View.GONE);
                    iverRight.setVisibility(View.VISIBLE);
                    iverNext.setVisibility(View.GONE);

                    rllistsan.setVisibility(View.GONE);
                    ivsanRight.setVisibility(View.VISIBLE);
                    ivsanNext.setVisibility(View.GONE);

                    rllistsi.setVisibility(View.GONE);
                    ivsiRight.setVisibility(View.VISIBLE);
                    ivsiNext.setVisibility(View.GONE);
                }
                break;

            case R.id.complete_rl2:
                if (lv2msg) {
                    rllister.setVisibility(View.GONE);
                    iverRight.setVisibility(View.VISIBLE);
                    iverNext.setVisibility(View.GONE);
                    lv2msg = false;
                } else {
                    rllister.setVisibility(View.VISIBLE);
                    iverRight.setVisibility(View.GONE);
                    iverNext.setVisibility(View.VISIBLE);
                    lv2msg = true;
                    lv1msg = false;
                    lv3msg = false;
                    lv4msg = false;

                    rllistyi.setVisibility(View.GONE);
                    ivyiRight.setVisibility(View.VISIBLE);
                    ivyiNext.setVisibility(View.GONE);

                    rllistsan.setVisibility(View.GONE);
                    ivsanRight.setVisibility(View.VISIBLE);
                    ivsanNext.setVisibility(View.GONE);

                    rllistsi.setVisibility(View.GONE);
                    ivsiRight.setVisibility(View.VISIBLE);
                    ivsiNext.setVisibility(View.GONE);
                }
                break;


            case R.id.complete_rl3:
                if (lv3msg) {
                    rllistsan.setVisibility(View.GONE);
                    ivsanRight.setVisibility(View.VISIBLE);
                    ivsanNext.setVisibility(View.GONE);
                    lv3msg = false;
                } else {
                    rllistsan.setVisibility(View.VISIBLE);
                    ivsanRight.setVisibility(View.GONE);
                    ivsanNext.setVisibility(View.VISIBLE);
                    lv3msg = true;
                    lv1msg = false;
                    lv2msg = false;
                    lv4msg = false;
                    rllistyi.setVisibility(View.GONE);
                    ivyiRight.setVisibility(View.VISIBLE);
                    ivyiNext.setVisibility(View.GONE);

                    rllister.setVisibility(View.GONE);
                    iverRight.setVisibility(View.VISIBLE);
                    iverNext.setVisibility(View.GONE);

                    rllistsi.setVisibility(View.GONE);
                    ivsiRight.setVisibility(View.VISIBLE);
                    ivsiNext.setVisibility(View.GONE);

                }
                break;

            case R.id.complete_rl4:
                if (lv4msg) {
                    rllistsi.setVisibility(View.GONE);
                    ivsiRight.setVisibility(View.VISIBLE);
                    ivsiNext.setVisibility(View.GONE);
                    lv4msg = false;
                } else {
                    rllistsi.setVisibility(View.VISIBLE);
                    ivsiRight.setVisibility(View.GONE);
                    ivsiNext.setVisibility(View.VISIBLE);
                    lv4msg = true;
                    lv2msg = false;
                    lv3msg = false;
                    lv1msg = false;
                    rllistyi.setVisibility(View.GONE);
                    ivyiRight.setVisibility(View.VISIBLE);
                    ivyiNext.setVisibility(View.GONE);

                    rllister.setVisibility(View.GONE);
                    iverRight.setVisibility(View.VISIBLE);
                    iverNext.setVisibility(View.GONE);

                    rllistsan.setVisibility(View.GONE);
                    ivsanRight.setVisibility(View.VISIBLE);
                    ivsanNext.setVisibility(View.GONE);
                }
                break;

            case   R.id.complete_tvyes:

                if(cityType!=0&&benzhuan!=null&&schoolType!=null&&isMS!=null){
                    Intent i=new Intent();
                    i.putExtra("isMS", isMS);
                    i.putExtra("cityType", cityType+"");
                    i.putExtra("isAccept", benzhuan);
                    i.putExtra("schoolType", schoolType);
                    setResult(4,i);
                    finish();
                }else {
                    Toast("亲，这些都是必填项");
                }
                break;
        }
    }



}

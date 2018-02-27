package com.example.login_demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import untils.PermissionUtils;
import untils.SPUtils;

public class GuidanceActivity extends BaseActivity {


    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.guidance_tv)
    TextView guidance_tv;


    @Override
    public int getId() {
        return R.layout.activity_guidance;
    }



    @Override
    public void InIt() {


        boolean zhi = (boolean) SPUtils.get(MyApp.context,"zhi", false);
        if(zhi==true)
        {
            startActivity(new Intent(GuidanceActivity.this,SplashActivity.class));
            finish();
             return;
        }

        PermissionUtils permissionUtils=new PermissionUtils(this);
        permissionUtils.requestAllPermissions();
        final ArrayList<Integer> list=new ArrayList<>();
        list.add(R.drawable.yd1);
        list.add(R.drawable.yd2);
        list.add(R.drawable.yd3);
        xbanner.setData(list,null);
        xbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {

                Glide.with(GuidanceActivity.this).load(list.get(position)).into((ImageView) view);

            }
        });
        xbanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position==2)
                {
                    guidance_tv.setVisibility(View.VISIBLE);
                    guidance_tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(GuidanceActivity.this,HomeActivity.class));
                            overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
                            SPUtils.put(MyApp.context,"zhi",true);
                            finish();
                        }
                    });
                }
                else
                {
                    guidance_tv.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

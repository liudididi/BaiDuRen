package com.example.login_demo;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import base.BaseActivity;
import butterknife.BindView;
import fragment.Home_Fragment;
import fragment.My_Fragment;
import fragment.WishFragMent;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    private My_Fragment my_fragment;
    private WishFragMent wish_FragMent;
    private Home_Fragment home_fragment;
    private Fragment currentFragment;
    @Override
    public int getId() {
        return R.layout.activity_home;
    }

    @Override
    public void InIt() {
        //初始化Fragment
        inItFragment();


        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heightPixels = dm.heightPixels;
        CoordinatorLayout.LayoutParams layoutParams= (CoordinatorLayout.LayoutParams) bottomBar.getLayoutParams();
        layoutParams.width=dm.widthPixels;
        layoutParams.height=heightPixels/12;
        bottomBar.setLayoutParams(layoutParams);
        /**
         * 底部点击事件
         */
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId) {

                    case R.id.tab_home:
                        switchFragment(home_fragment).commitAllowingStateLoss();

                        break;
                    case R.id.tab_wish:
                        switchFragment(wish_FragMent).commitAllowingStateLoss();

                        break;
                    case R.id.tab_my:
                        switchFragment(my_fragment).commitAllowingStateLoss();
                        break;
                }
            }
        });
    }

    /**
     * 加载Fragment
     */
    private void inItFragment() {
        my_fragment = new My_Fragment();
        wish_FragMent = new WishFragMent();
        home_fragment = new Home_Fragment();
    }

    /**
     * 切换fragment
     * @param targetFragment
     * @return
     */
    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.frame_main, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }
}

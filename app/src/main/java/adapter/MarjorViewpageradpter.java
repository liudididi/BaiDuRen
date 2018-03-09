package adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import fragment.MajorStartFragment;

/**
 * Created by 地地 on 2018/3/7.
 * 邮箱：461211527@qq.com.
 */

public class MarjorViewpageradpter extends FragmentPagerAdapter {
    private List<MajorStartFragment> list;

    public MarjorViewpageradpter(FragmentManager fm, List<MajorStartFragment> list) {
        super(fm);
        this.list = list;
    }

    public MarjorViewpageradpter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}

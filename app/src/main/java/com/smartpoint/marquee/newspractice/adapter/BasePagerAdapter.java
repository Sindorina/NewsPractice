package com.smartpoint.marquee.newspractice.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/8/15
 * 邮箱 18780569202@163.com
 */
public class BasePagerAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> fragments;
    private List<String> titles;
    public BasePagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }
    public BasePagerAdapter(FragmentManager fm,List<Fragment> fragments,String[] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = new ArrayList<>(Arrays.asList(titles));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }
    //更新viewPager+TabLayout
    public void recreateItems(List<Fragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titles = titles;
        notifyDataSetChanged();
    }
}

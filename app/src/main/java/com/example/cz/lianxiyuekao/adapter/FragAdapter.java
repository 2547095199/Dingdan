package com.example.cz.lianxiyuekao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by CZ on 2018/1/16.
 */

public class FragAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    FragmentManager fm;
    public FragAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fm=fm;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

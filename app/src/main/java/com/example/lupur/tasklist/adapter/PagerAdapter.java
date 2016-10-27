package com.example.lupur.tasklist.adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lupur.tasklist.R;
import com.example.lupur.tasklist.fragment.TasksFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link FragmentPagerAdapter Adapter} that provides a data source for
 * {@link android.support.v4.view.ViewPager ViewPager}.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();

    private final Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragments.add(new TasksFragment());    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tasks List";
    }
}

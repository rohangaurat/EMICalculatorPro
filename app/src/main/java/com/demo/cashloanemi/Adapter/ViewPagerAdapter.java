package com.demo.cashloanemi.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> fragmentTitle = new ArrayList();
    private List<Fragment> fragments = new ArrayList();

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return this.fragmentTitle.get(i);
    }

    public void add(List<Fragment> list, List<String> list2) {
        this.fragments = list;
        this.fragmentTitle = list2;
    }
}

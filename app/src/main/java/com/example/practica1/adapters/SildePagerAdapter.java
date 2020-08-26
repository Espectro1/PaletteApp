package com.example.practica1.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SildePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentlist;
    private String[] titles = new String[]{"Home","Image","Create"};

    public SildePagerAdapter(FragmentManager fm, List<Fragment> fragmentlist){
        super(fm);
        this.fragmentlist = fragmentlist;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

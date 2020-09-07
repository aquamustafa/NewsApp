package com.example.newsapp.Adapters;

import com.example.newsapp.Views.NewsFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class viewpagerAdapter extends FragmentPagerAdapter {
    public viewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
switch (i){

    case 0: return NewsFragment.newInstance("",0);
    case 1:return   NewsFragment.newInstance("sports",1);
    case 2:return   NewsFragment.newInstance("science",1);
    case 3:return   NewsFragment.newInstance("technology",1);
}
return new NewsFragment();

    }

    @Override
    public int getCount() {
        return 4;
    }




    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       switch (position) {
           case 0:return "TopNews";
           case 1:return "Sports";
           case 2:return "Science";
           case 3:return "Tech";
       }
        return null;
    }
}

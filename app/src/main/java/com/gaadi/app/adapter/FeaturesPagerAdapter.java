package com.gaadi.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.gaadi.app.fragments.FragmentFeatures;
import com.gaadi.app.fragments.FragmentSpecification;

/**
 * Created by kanishroshan on 30/3/16.
 */
public class FeaturesPagerAdapter extends FragmentStatePagerAdapter {
    int mNumTabs;

    public FeaturesPagerAdapter(FragmentManager fm, int numtabs) {
        super(fm);
        this.mNumTabs = numtabs;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("Kanish", "In get item");
        switch (position) {
            case 0:
                FragmentFeatures tab1 = new FragmentFeatures();
                return tab1;
            case 1:
                FragmentSpecification tab2 = new FragmentSpecification();
                return tab2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        Log.e("Kanish", "In getcount pageradapter");
        return mNumTabs;
    }
}

package com.phapli.ise;

/**
 * Created by root on 10/04/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a LearnTabFragment (defined as a static inner class below).
        switch (position) {
            case LearnTabFragment.LEARN:
                LearnTabFragment.newInstance(position);
            case LearnTabFragment.FIND:
                LearnTabFragment.newInstance(position);
            case LearnTabFragment.ANALYTICS:
                LearnTabFragment.newInstance(position);
            case LearnTabFragment.SETTING:
                LearnTabFragment.newInstance(position);
        }
        return LearnTabFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case LearnTabFragment.LEARN:
                return "Learn";
            case LearnTabFragment.FIND:
                return "Find";
            case LearnTabFragment.ANALYTICS:
                return "Analytics";
            case LearnTabFragment.SETTING:
                return "Setting";
        }
        return null;
    }
}

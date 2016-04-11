package com.phapli.ise;

/**
 * Created by root on 10/04/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LearnTabFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static final int LEARN = 0;
    public static final int FIND = 1;
    public static final int ANALYTICS = 2;
    public static final int SETTING = 3;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LearnTabFragment newInstance(int sectionNumber) {
        LearnTabFragment fragment = new LearnTabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public LearnTabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.lv_learn);
        return rootView;
    }
}

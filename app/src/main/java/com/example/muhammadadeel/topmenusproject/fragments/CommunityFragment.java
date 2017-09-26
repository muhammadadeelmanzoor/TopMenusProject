package com.example.muhammadadeel.topmenusproject.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.muhammadadeel.topmenusproject.R;
import com.example.muhammadadeel.topmenusproject.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Muhammad Adeel on 9/19/2017.
 */

public class CommunityFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    public static CommunityFragment newInstance(int position) {
        CommunityFragment f = new CommunityFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }

    public CommunityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community_fragment, container, false);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
//                if (viewPager.getCurrentItem() == 0) {
//                    viewPager.setCurrentItem(1);
//                } else if (viewPager.getCurrentItem() == 1) {
//                    viewPager.setCurrentItem(2);
//                } else if (viewPager.getCurrentItem() == 2){
//                    viewPager.setCurrentItem(3);
//                }else if (viewPager.getCurrentItem() == 3){
//                    viewPager.setCurrentItem(4);
//                }else if (viewPager.getCurrentItem() == 4){
//                    viewPager.setCurrentItem(5);
//                }else {
//                    viewPager.setCurrentItem(0);
//                }
            }
        }, 2000, 4000);

        return view;
    }
}

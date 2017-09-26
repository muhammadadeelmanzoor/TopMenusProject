package com.example.muhammadadeel.topmenusproject;

/**
 * Created by Muhammad Adeel on 9/19/2017.
 */

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.muhammadadeel.topmenusproject.R;
import com.example.muhammadadeel.topmenusproject.adapters.RecyclerAdapter;
import com.example.muhammadadeel.topmenusproject.fragments.FeaturedFragment;
import com.example.muhammadadeel.topmenusproject.fragments.CommunityFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(R.color.grey));
        toolbar.setPopupTheme(R.style.ThemeOverlay_AppCompat_Light);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_contact_support:
                Toast.makeText(this, "Contact Information", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_change_accounts:
                Toast.makeText(this, "Accounts Information", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //ADAPTER CLASS
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] titles = {getString(R.string.tab_title_featured),
                getString(R.string.tab_title_community)};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return FeaturedFragment.newInstance(position);
                }
                case 1: {
                    return CommunityFragment.newInstance(position);
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    public MainActivity() {
    }

}

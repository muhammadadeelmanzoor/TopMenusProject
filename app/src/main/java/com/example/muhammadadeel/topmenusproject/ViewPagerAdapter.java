package com.example.muhammadadeel.topmenusproject;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.muhammadadeel.topmenusproject.adapters.RecyclerAdapter;
import com.example.muhammadadeel.topmenusproject.fragments.FeaturedFragment;

/**
 * Created by Muhammad Adeel on 9/20/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    public Integer[] images = {R.drawable.pic3, R.drawable.pic2, R.drawable.pic1, R.drawable.pic4, R.drawable.pic5};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    //CONSTRUCTOR Featured Fragment Class
    public ViewPagerAdapter(FeaturedFragment featuredFragment) {
        context=featuredFragment.getContext();
    }

    //CONSTRUCTOR Recycler Adapter Class
    public ViewPagerAdapter(RecyclerAdapter recyclerAdapter) {
        return;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.featured_sub_fragment, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
//        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}

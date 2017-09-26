package com.example.muhammadadeel.topmenusproject.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muhammadadeel.topmenusproject.fragments.FeaturedFragment;

/**
 * Created by Muhammad Adeel on 9/21/2017.
 */

public class CustomGalleryAdapter extends BaseAdapter {

    private Context context;
    private int[] images;

    //CONSTRUCTOR WITH FEATURED FRAGMENT CLASS
//    public CustomGalleryAdapter(FeaturedFragment featuredFragment, int[] images) {
//        context = featuredFragment.getContext();
//        this.images = images;
//    }

    public CustomGalleryAdapter(RecyclerAdapter recyclerAdapter, int[] images) {
        this.images=images;
    }

//    public CustomGalleryAdapter(Context c, int[] images) {
//        context = c;
//        this.images = images;
//    }

    // returns the number of images
    public int getCount() {
        return images.length;
    }

    // returns the ID of an item
    public Object getItem(int position) {
        return position;
    }

    // returns the ID of an item
    public long getItemId(int position) {
        return position;
    }

    // returns an ImageView view
    public View getView(int position, View convertView, ViewGroup parent) {

        // create a ImageView programmatically
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 350));
        return imageView;
    }
}

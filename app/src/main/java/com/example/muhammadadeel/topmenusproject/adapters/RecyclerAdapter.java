package com.example.muhammadadeel.topmenusproject.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadadeel.topmenusproject.R;
import com.example.muhammadadeel.topmenusproject.ViewPagerAdapter;
import com.example.muhammadadeel.topmenusproject.fragments.FeaturedFragment;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Muhammad Adeel on 9/22/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String tv11, tvGal;
    CustomGalleryAdapter customGalleryAdapter;
    int[] images = {R.drawable.gal1, R.drawable.gal2, R.drawable.gal3, R.drawable.gal5};

//    public RecyclerAdapter(String[] tv1, String[] tv2, ImageView img, Gallery gal, Button btn, ViewPager vpg) {
//        this.tv11 = tv1;
//        this.tvGal = tv2;
//    }

    public RecyclerAdapter(String tvNoteWorthy, String tvGallery) {
        this.tv11 = tvNoteWorthy;
        this.tvGal = tvGallery;
    }

//    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(RecyclerAdapter.this);
//    int[] images = {R.drawable.gal1, R.drawable.gal2, R.drawable.gal3, R.drawable.gal5};
//    ImageView selectedImageView;
//    Gallery gallery;
//    FeaturedFragment featuredFragment;
//    TextView textView;
//    Context context;
//    RecyclerView recyclerView;
//    private static final String ARG_POSITION = "position";
//    private int position;
//    String text = "This book is selected";
//    ViewPager viewPager;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_sub_fragment, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        //DO SOMETHING
//        viewHolder.textView.setText(tv11[position]);
//        viewHolder.tvGallery.setText(tvGal[position]);
        viewHolder.imageView.setImageResource(images[position]);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewHolder.viewPager.setAdapter(viewPagerAdapter);

        CustomGalleryAdapter customGalleryAdapter = new CustomGalleryAdapter(RecyclerAdapter.this, images);
        viewHolder.gallery.setAdapter(customGalleryAdapter);
        viewHolder.gallery.setSpacing(0);

        viewHolder.gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //DO SOMETHING
                switch (position) {
                    case 0:
                        //
                        viewHolder.textView.setText(position);
                        break;
                    case 1:
                        //
                        viewHolder.tvGallery.setText(position);
                        break;
                    case 2:
                        Toast.makeText(view.getContext(), "3rd book Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

//            private Context getResources() {
//                String resource = getResources().getString(R.string.first_book_description);
//                return context;
//            }
        });

        // SETTING TIMER
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                viewHolder.viewPager.getCurrentItem();
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
        }, 1000, 2000);

    }

    @Override
    public int getItemCount() {
        return images.length;
//        return titles.length;
    }

    //VIEW HOLDER CLASS
    class ViewHolder extends RecyclerView.ViewHolder {

        //        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(RecyclerAdapter.this);
//        CustomGalleryAdapter customGalleryAdapter;
//        int[] images = {R.drawable.gal1, R.drawable.gal2, R.drawable.gal3, R.drawable.gal5};
//        String text = "New And Noteworthy";
        ImageView selectedImageView, imageView;
        Gallery gallery;
        TextView textView, tvGallery;
        ViewPager viewPager;
        Button btnRead;

        public ViewHolder(View itemView) {
            super(itemView);

            selectedImageView = (ImageView) itemView.findViewById(R.id.imageView);
            gallery = (Gallery) itemView.findViewById(R.id.simpleGallery);
            textView = (TextView) itemView.findViewById(R.id.textView_noteworthy);
            tvGallery = (TextView) itemView.findViewById(R.id.galleryTextView);
            viewPager = (ViewPager) itemView.findViewById(R.id.pager);
            btnRead = (Button) itemView.findViewById(R.id.button_read);
//            CustomGalleryAdapter customGalleryAdapter = new CustomGalleryAdapter();
//            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    Snackbar.make(view, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }
}

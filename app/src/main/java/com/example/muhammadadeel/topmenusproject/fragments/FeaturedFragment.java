package com.example.muhammadadeel.topmenusproject.fragments;

/**
 * Created by Muhammad Adeel on 9/19/2017.
 */

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadadeel.topmenusproject.MainActivity;
import com.example.muhammadadeel.topmenusproject.R;
import com.example.muhammadadeel.topmenusproject.ViewPagerAdapter;
import com.example.muhammadadeel.topmenusproject.adapters.CustomGalleryAdapter;
import com.example.muhammadadeel.topmenusproject.adapters.RecyclerAdapter;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class FeaturedFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    int[] images = {R.drawable.gal1, R.drawable.gal2, R.drawable.gal3, R.drawable.gal5};

//    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(FeaturedFragment.this);
//    Gallery gallery;
//    String text = "This book is selected";
//    CustomGalleryAdapter customGalleryAdapter;
//    ImageView selectedImageView;

    public static FeaturedFragment newInstance(int position) {
        FeaturedFragment f = new FeaturedFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }

    public FeaturedFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.featured_fragment, container, false);


        String tvNoteWorthy = getActivity().getResources().getString(R.string.new_noteworthy);
        String tvGallery = getActivity().getResources().getString(R.string.first_book_description);


//        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
//        viewPager.setAdapter(viewPagerAdapter);

        //////////////////////
        CardView cardView = (CardView) view.findViewById(R.id.featured_card_view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.featured_recycler_view);

        RecyclerView.Adapter adapter = new RecyclerAdapter(tvNoteWorthy, tvGallery);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //STARTING IMAGE GALLERY
//        final TextView textView = (TextView) view.findViewById(R.id.galleryTextView);
//        gallery = (Gallery) view.findViewById(R.id.simpleGallery);
//        selectedImageView = (ImageView) view.findViewById(R.id.imageView);
//        customGalleryAdapter = new CustomGalleryAdapter(FeaturedFragment.this, images);
//        gallery.setAdapter(customGalleryAdapter);
//        gallery.setSpacing(0);
//        //PERFORM setOnItemClickListener ON THE GALLERY
//        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                //DO SOMETHING
//                switch (position) {
//                    case 0:
//                        textView.setText(getResources().getString(R.string.first_book_description));
//                        break;
//                    case 1:
//                        textView.setText(text);
//                        break;
//                    case 2:
//                        Toast.makeText(getContext(), "3rd book Selected", Toast.LENGTH_SHORT).show();
//                }
////                selectedImageView.setImageResource(images[position]);
////                Toast.makeText(getContext(), "Image Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

//        // SETTING TIMER
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                viewPager.getCurrentItem();
////                if (viewPager.getCurrentItem() == 0) {
////                    viewPager.setCurrentItem(1);
////                } else if (viewPager.getCurrentItem() == 1) {
////                    viewPager.setCurrentItem(2);
////                } else if (viewPager.getCurrentItem() == 2){
////                    viewPager.setCurrentItem(3);
////                }else if (viewPager.getCurrentItem() == 3){
////                    viewPager.setCurrentItem(4);
////                }else if (viewPager.getCurrentItem() == 4){
////                    viewPager.setCurrentItem(5);
////                }else {
////                    viewPager.setCurrentItem(0);
////                }
//            }
//        }, 1000, 2000);

        return view;
    }

}
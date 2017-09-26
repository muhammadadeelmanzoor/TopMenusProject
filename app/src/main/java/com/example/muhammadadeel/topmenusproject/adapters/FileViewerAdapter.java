package com.example.muhammadadeel.topmenusproject.adapters;

/**
 * Created by Muhammad Adeel on 9/19/2017.
 */

import android.view.View;
import android.widget.TextView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.format.DateUtils;

import com.example.muhammadadeel.topmenusproject.R;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class FileViewerAdapter extends RecyclerView.Adapter<FileViewerAdapter.RecordingsViewHolder> {

    private static final String LOG_TAG = "FileViewerAdapter";

    Context mContext;
    LinearLayoutManager llm;

    public FileViewerAdapter(Context context, LinearLayoutManager linearLayoutManager) {
        super();
        mContext = context;
        llm = linearLayoutManager;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public RecordingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_view, parent, false);

        mContext = parent.getContext();

        return new RecordingsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecordingsViewHolder holder, int position) {

    }

    public static class RecordingsViewHolder extends RecyclerView.ViewHolder {
        protected TextView vName;
        protected TextView vLength;
        protected TextView vDateAdded;
        protected View cardView;

        public RecordingsViewHolder(View v) {
            super(v);
            vName = (TextView) v.findViewById(R.id.file_name_text);
            vLength = (TextView) v.findViewById(R.id.file_length_text);
            vDateAdded = (TextView) v.findViewById(R.id.file_date_added_text);
            cardView = v.findViewById(R.id.card_view);
        }
    }

    public void onNewDatabaseEntryAdded() {
        //item added to top of the list
        notifyItemInserted(getItemCount() - 1);
        llm.scrollToPosition(getItemCount() - 1);
    }

    //TODO
    public void removeOutOfApp(String filePath) {
        //user deletes a saved recording out of the application through another application
    }

}
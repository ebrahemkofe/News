package com.colleg.project.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.colleg.project.news.Activitys.Details;
import com.colleg.project.news.Models.ModelMediaVideos;
import com.colleg.project.news.R;
import java.util.List;

public class AdapterListViewVideos extends ArrayAdapter {



       List<ModelMediaVideos.AllVideosBean> mlist;
       Context mContext ;

        public AdapterListViewVideos(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);

            mlist = objects;
            mContext = context ;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_listview_videos, parent,false);

            final VideoView video = convertView.findViewById(R.id.Video);

            video.setVideoPath(mlist.get(position).getVideo());
            video.setMediaController(new MediaController(mContext));
            video.requestFocus();
            video.start();


            return convertView;
        }



}

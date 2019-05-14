package com.colleg.project.news.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.colleg.project.news.Models.ModelListViewHome;
import com.colleg.project.news.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterListViewCategory extends ArrayAdapter {



       List<ModelListViewHome> mlist;

        public AdapterListViewCategory(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);

            mlist = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.item_category, parent,false);

            TextView textdisc = convertView.findViewById(R.id.dis_category);
            TextView textTitle = convertView.findViewById(R.id.title_category);
            ImageView images = convertView.findViewById(R.id.categorepic);


            textdisc.setText(mlist.get(position).textdis);
            textTitle.setText(mlist.get(position).texttime);
            images.setImageResource(mlist.get(position).image);


            return convertView;
        }

}

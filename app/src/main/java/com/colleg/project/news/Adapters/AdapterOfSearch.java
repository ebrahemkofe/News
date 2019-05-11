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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.colleg.project.news.Models.ModelListViewHome;
import com.colleg.project.news.Models.ModelOfSearchResult;
import com.colleg.project.news.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterOfSearch extends ArrayAdapter {

    List<ModelOfSearchResult.PostsBean> mlist = new ArrayList<>();

    Context mContext ;

    public AdapterOfSearch(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        mlist = objects;

        mContext = context ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = layoutInflater.inflate(R.layout.item_listview_favourite, parent,false);

        TextView categoryTittle = convertView.findViewById(R.id.subject_list_fav);
        TextView newsTittle = convertView.findViewById(R.id.title_listview);
        TextView desc = convertView.findViewById(R.id.dis_listview);
        ImageView images = convertView.findViewById(R.id.listviewFavPic);

        Glide.with(mContext).load(mlist.get(position).getPost_img()).into(images);
        categoryTittle.setText(mlist.get(position).getCategory_post());
        newsTittle.setText(mlist.get(position).getPost_title());
        desc.setText(mlist.get(position).getDescription());


        return convertView;
    }

}

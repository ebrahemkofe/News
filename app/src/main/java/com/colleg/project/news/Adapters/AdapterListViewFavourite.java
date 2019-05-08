package com.colleg.project.news.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.colleg.project.news.Models.ModelListViewFavourite;
import com.colleg.project.news.R;

import java.util.ArrayList;
import java.util.List;


public class AdapterListViewFavourite extends ArrayAdapter {

    List<ModelListViewFavourite> heroList;

    Context context;
    boolean c=false;
    int resource;

    public AdapterListViewFavourite(Context context, int resource, List objects) {
        super(context , resource , objects);
        this.context = context;
        this.resource = resource;
        this.heroList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_listview_favourite, null);

        ImageView imageView = view.findViewById(R.id.listviewFavPic);
        TextView textViewtitle = view.findViewById(R.id.title_listview);
        TextView textViewdis = view.findViewById(R.id.dis_listview);
        TextView textViewsubject = view.findViewById(R.id.subject_list_fav);
        ImageView buttonDelete = view.findViewById(R.id.unsave_in_listview);
        ImageView morebtn = view.findViewById(R.id.more_fav);
        final LinearLayout morelayout=view.findViewById(R.id.more_in_listview_fav);



        imageView.setImageResource(heroList.get(position).image);
        textViewtitle.setText(heroList.get(position).texttitle);
        textViewdis.setText(heroList.get(position).textdis);
        textViewsubject.setText(heroList.get(position).subject);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeHero(position);
            }
        });

        morebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==false) {

                    morelayout.setVisibility(View.VISIBLE);

                    c=true;
                }
                else{
                    morelayout.setVisibility(View.GONE);
                    c=false;
                }
            }
        });

        return view;
    }

    private void removeHero(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                heroList.remove(position);


                notifyDataSetChanged();
            }
        });


        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
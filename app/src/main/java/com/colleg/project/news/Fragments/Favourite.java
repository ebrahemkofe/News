package com.colleg.project.news.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.colleg.project.news.Activitys.Details;
import com.colleg.project.news.Adapters.AdapterListViewFavourite;
import com.colleg.project.news.Adapters.AdapterListViewHome;
import com.colleg.project.news.Models.ModelListViewHome;
import com.colleg.project.news.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Favourite extends Fragment {

    String []dis = {"الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند"};
    String []time = {"2019 jun 7 09:12" , "2019 jun 7 09:12", "2019 jun 7 09:12"};
    int []image = {R.drawable.sheekh,R.drawable.tramp,R.drawable.news};
    ListView listView ;
    ArrayList<ModelListViewHome> list = new ArrayList<>();
    AdapterListViewFavourite adapter;
    ImageView morebtn;
    LinearLayout morelayout;

    boolean c;
    public Favourite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        morelayout=view.findViewById(R.id.more_in_listview_fav);
        morebtn=view.findViewById(R.id.more_fav);
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










        listView = view.findViewById(R.id.homeListview);

        for(int i=0;i<image.length;i++) {
            list.add(new ModelListViewHome(dis[i], time[i], image[i]));
        }


        adapter = new AdapterListViewFavourite(getContext(), R.layout.item_listview_home, list);

        listView.setAdapter(adapter);
        ListViewClick();


        return view;
    }


    private void ListViewClick() {

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent go=new Intent(getContext(), Details.class);
                    startActivity(go);
                }

                else if (position == 1) {
                    Intent go=new Intent(getContext(), Details.class);
                    startActivity(go);
                }
            }
        });

    }

}

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
import com.colleg.project.news.Models.ModelListViewFavourite;
import com.colleg.project.news.Models.ModelListViewHome;
import com.colleg.project.news.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Favourite extends Fragment {

    String []dis = {"الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند"};
    String []time = {"2019 jun 7 09:12" , "2019 jun 7 09:12", "2019 jun 7 09:12"};
    String []subj = {"اخبار" , "اخبار", "اخبار"};
    int [] image = {R.drawable.sheekh,R.drawable.tramp,R.drawable.news};

    ListView listView ;
    List<ModelListViewFavourite> list = new ArrayList<>();
    ImageView morebtn;
    LinearLayout morelayout;

    public Favourite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        morelayout=view.findViewById(R.id.more_in_listview_fav);
        morebtn=view.findViewById(R.id.more_fav);

        list.add(new ModelListViewFavourite(dis[0],time[0],subj[0],image[0]));
        list.add(new ModelListViewFavourite(dis[1],time[1],subj[1],image[1]));
        list.add(new ModelListViewFavourite(dis[2],time[2],subj[2],image[2]));

        listView=view.findViewById(R.id.FavouriteListView);

        listView.setAdapter(new AdapterListViewFavourite(getContext(),R.layout.item_listview_favourite,list));




        return view;
    }

}

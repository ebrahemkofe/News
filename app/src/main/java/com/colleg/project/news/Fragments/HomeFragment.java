package com.colleg.project.news.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.colleg.project.news.Adapters.AdapterListViewHome;
import com.colleg.project.news.Adapters.CustomPagerAdapter;
import com.colleg.project.news.R;
import com.colleg.project.news.Models.ModelListViewHome;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    String []dis = {"hellohellohelhellohellohellohlohellohlohellohlohellohlohellohello" ,"hellohellohelhellohellohellohlohellohlohellohlohellohlohellohello" , "hellohellohelhellohellohellohlohellohlohellohlohellohlohellohello"};
    String []time = {"2019 jun 7 09:12" , "2019 jun 7 09:12", "2019 jun 7 09:12"};
    int []image = {R.drawable.sheekh,R.drawable.sheekh,R.drawable.sheekh};
    ListView listView ;
    ArrayList<ModelListViewHome> list = new ArrayList<>();

    boolean c=false , spo=false , ing=false ;
    AdapterListViewHome adapter ;
    ImageView more_acc,more_spo,more_ing;
    LinearLayout morelayout_acc,morelayout_spo,morelayout_ing;

    public HomeFragment() {
           }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_home, container, false);

         more_acc=v.findViewById(R.id.more_accidents);
         morelayout_acc=v.findViewById(R.id.more_in_linearlayout_accidents);
         more_acc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(c==false) {
                     morelayout_acc.setVisibility(View.VISIBLE);
                     c=true;
                 }
                 else{
                     morelayout_acc.setVisibility(View.GONE);
                     c=false;
                 }
             }
         });



         more_spo=v.findViewById(R.id.more_sports);
         morelayout_spo=v.findViewById(R.id.more_in_linearlayout_sports);
         more_spo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(spo==false) {
                     morelayout_spo.setVisibility(View.VISIBLE);
                     spo=true;
                 }
                 else{
                     morelayout_spo.setVisibility(View.GONE);
                     spo=false;
                 }
             }
         });



         more_ing=v.findViewById(R.id.more_Investigations);
         morelayout_ing=v.findViewById(R.id.more_in_linearlayout_Investigations);
         more_ing.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(ing==false) {
                     morelayout_ing.setVisibility(View.VISIBLE);
                     ing=true;
                 }
                 else{
                     morelayout_ing.setVisibility(View.GONE);
                     ing=false;
                 }
             }
         });




        List<Integer> listImagesAcc = new ArrayList<>();
        listImagesAcc.add(R.drawable.acs);
        listImagesAcc.add(R.drawable.acs);

        ViewPager viewPagerAcc = v.findViewById(R.id.viewpager_accidents);
        viewPagerAcc.setAdapter(new CustomPagerAdapter(getContext(), listImagesAcc));

        List<Integer> listImagesInvestigations = new ArrayList<>();
        listImagesInvestigations.add(R.drawable.tramp);
        listImagesInvestigations.add(R.drawable.tramp);

        ViewPager viewPagerInvestigations = v.findViewById(R.id.viewpager_Investigations);
        viewPagerInvestigations.setAdapter(new CustomPagerAdapter(getContext(), listImagesInvestigations));


        List<Integer> listImagesSports = new ArrayList<>();
        listImagesSports.add(R.drawable.mohamedsalah);
        listImagesSports.add(R.drawable.mohamedsalah);

        ViewPager viewPagerSports = v.findViewById(R.id.viewpager_sports);
        viewPagerSports.setAdapter(new CustomPagerAdapter(getContext(), listImagesSports));

        listView = v.findViewById(R.id.homeListview);

        for(int i=0;i<image.length;i++) {
            list.add(new ModelListViewHome(dis[i], time[i], image[i]));
        }


        adapter = new AdapterListViewHome(getContext(), R.layout.item_listview_home, list);

        listView.setAdapter(adapter);
        ListViewClick();
        setListViewHeightBasedOnChildren(listView);
        return v;
    }
    private void ListViewClick() {


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                }

                else if (position == 1) {
                    Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;

        View.MeasureSpec m = new View.MeasureSpec();


        int desiredWidth = m.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) view.setLayoutParams(new
                    ViewGroup.LayoutParams(desiredWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
        listView.requestLayout();

    }

}

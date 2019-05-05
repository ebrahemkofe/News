package com.colleg.project.news.Fragments;


import android.annotation.SuppressLint;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.colleg.project.news.Activitys.Details;
import com.colleg.project.news.Adapters.AdapterListViewHome;
import com.colleg.project.news.Adapters.CustomPagerAdapterAcc;
import com.colleg.project.news.Adapters.CustomPagerAdapterSports;
import com.colleg.project.news.Adapters.CustomPagerAdapterTran;
import com.colleg.project.news.Models.GsonForHome;
import com.colleg.project.news.R;
import com.colleg.project.news.Models.ModelListViewHome;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;


public class HomeFragment extends Fragment {

    String []dis = {"الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند","الطيب : اطلس الاوقاف يضم 25 مليون مستند"};
    String []time = {"2019 jun 7 09:12" , "2019 jun 7 09:12", "2019 jun 7 09:12"};
    int []image = {R.drawable.sheekh,R.drawable.sheekh,R.drawable.sheekh};
    ListView listView ;
    ViewPager pager;
    ArrayList<ModelListViewHome> list = new ArrayList<>();
    List<GsonForHome.NewsBean> listGson =new ArrayList<>();


    ViewPager viewPagerAcc, viewPagerSports ,viewPagerTran;
    boolean c=false , spo=false , ing=false ;
    AdapterListViewHome adapter ;
    ImageView more_acc,more_spo,more_ing;
    LinearLayout morelayout_acc,morelayout_spo,morelayout_ing;

    public HomeFragment() {
           }


    @SuppressLint("ClickableViewAccessibility")
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





//......................  View pager accident ................................................



//        List<Integer> listImagesAcc = new ArrayList<>();
//        List<String> listTitleAcc = new ArrayList<>();
//        final List<String> listDisAcc = new ArrayList<>();
//        listImagesAcc.add(R.drawable.acs);
//        listImagesAcc.add(R.drawable.acs);
//        listTitleAcc.add("Explosion volcano");
//        listTitleAcc.add("Explosion volcano");
//        listDisAcc.add("Mexican authorities have raised the level of alert from the eruption of the Popocapatile volcano to the highest degree below the state of emergency.");
//        listDisAcc.add("Mexican authorities have raised the level of alert from the eruption of the Popocapatile volcano to the highest degree below the state of emergency.");
//
         viewPagerAcc = v.findViewById(R.id.viewpager_accidents);

        Get_Data();


//......................  View pager Investigations ................................................


//        List<Integer> listImagesInvestigations = new ArrayList<>();
//        List<String> listTitleInvestigations = new ArrayList<>();
//        List<String> listDisInvestigations = new ArrayList<>();
//        listImagesInvestigations.add(R.drawable.tramp);
//        listImagesInvestigations.add(R.drawable.tramp);
//        listTitleInvestigations.add("Trump calls for trial of all those accused of collusion with Russia");
//        listTitleInvestigations.add("Trump calls for trial of all those accused of collusion with Russia");
//        listDisInvestigations.add("US President Donald Trump, to try those who brought him in collusion with Russia in his election");
//        listDisInvestigations.add("US President Donald Trump, to try those who brought him in collusion with Russia in his election");
//
          viewPagerTran = v.findViewById(R.id.viewpager_Investigations);
//        viewPagerInvestigations.setAdapter(new CustomPagerAdapter(getContext(), listImagesInvestigations,listTitleInvestigations,listDisInvestigations));


//......................  View pager Sports ................................................



//        List<Integer> listImagesSports = new ArrayList<>();
//        List<String> listTitleSports = new ArrayList<>();
//        List<String> listDisSports = new ArrayList<>();
//        listImagesSports.add(R.drawable.mohamedsalah);
//        listImagesSports.add(R.drawable.mohamedsalah);
//        listTitleSports.add("Liverpool regain top spot in the Premier League");
//        listTitleSports.add("Liverpool regain top spot in the Premier League");
//        listDisSports.add("Liverpool rode their luck in the second half as Alisson's costly error almost gifted relegation-threatened Cardiff the equalizer, but Sean Morrison failed to convert.");
//        listDisSports.add("Liverpool rode their luck in the second half as Alisson's costly error almost gifted relegation-threatened Cardiff the equalizer, but Sean Morrison failed to convert.");
//
          viewPagerSports = v.findViewById(R.id.viewpager_sports);
//        viewPagerSports.setAdapter(new CustomPagerAdapter(getContext(), listImagesSports,listTitleSports,listDisSports));


//......................  List view ................................................


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


    private void Get_Data() {

        AndroidNetworking.get("https://cizaro.net/2030/api/allnews")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {


                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        GsonForHome array = gson.fromJson(response.toString(), GsonForHome.class);

                           listGson = array.getNews();

                        viewPagerAcc.setAdapter(new CustomPagerAdapterAcc(getContext(),listGson));
//                        viewPagerAcc.setAdapter(new CustomPagerAdapterSports(getContext(),listGson));
//                        viewPagerAcc.setAdapter(new CustomPagerAdapterTran(getContext(),listGson));

                        Toast.makeText(getContext(),listGson.get(0).getCategory_posts().get(0).getPost_title().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(getContext(), "connection field", Toast.LENGTH_SHORT).show();

                    }
                });
    }


}

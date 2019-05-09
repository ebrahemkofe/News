package com.colleg.project.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.colleg.project.news.Activitys.Details;
import com.colleg.project.news.Models.GsonForHome;
import com.colleg.project.news.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapterfifth extends PagerAdapter {

    private Context mContext;

    private List<GsonForHome.NewsBean> list = new ArrayList<>();
    List<GsonForHome.NewsBean.CategoryPostsBean>list2 = new ArrayList<>();

    public CustomPagerAdapterfifth(Context context, List listDate) {
        mContext = context;
        list = listDate;
        list2 = list.get(4).getCategory_posts();


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list2.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.item_viewpager, container, false);

        final ImageView image = view.findViewById(R.id.viewpagerpic);
        final TextView titl = view.findViewById(R.id.title_viewpager);
        final TextView disc = view.findViewById(R.id.dis_viewpager);


        Glide.with(mContext).load(list2.get(position).getPost_img()).into(image);
        titl.setText(list2.get(position).getPost_title());
        disc.setText(list2.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CustomPagerAdapterAcc.PostID= String.valueOf(list.get(4).getCategory_posts().get(position).getPost_id());
                Intent i = new Intent(mContext,Details.class);
                mContext.startActivity(i);

            }
        });
        container.addView(view);
        return view;
    }



}
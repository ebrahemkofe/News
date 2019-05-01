package com.colleg.project.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.colleg.project.news.Activitys.Details;
import com.colleg.project.news.R;

import java.util.List;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> mListData;
    private List<String> title;
    private List<String> dis;


    public CustomPagerAdapter(Context context, List<Integer> listDate, List<String> Title, List<String> Dis) {
        mContext = context;
        mListData = listDate;
        title = Title;
        dis = Dis;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mListData.size();
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

        image.setImageResource(mListData.get(position));
        titl.setText(title.get(position));
        disc.setText(dis.get(position));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0) {

                    Intent go=new Intent(mContext, Details.class);
                    mContext.startActivity(go);

                }

                else if(position==1) {
                    Intent go=new Intent(mContext, Details.class);
                    mContext.startActivity(go);
                }

            }
        });
        container.addView(view);
        return view;
    }



}
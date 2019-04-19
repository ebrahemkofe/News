package com.colleg.project.news;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anupamchugh on 26/12/15.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<Integer> mListData;

    public CustomPagerAdapter(Context context, List<Integer> listDate) {
        mContext = context;
        mListData = listDate;
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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.view_blue, container, false);

        final ImageView textView = view.findViewById(R.id.viewpagerpic);


        container.addView(view);
        return view;
    }
}
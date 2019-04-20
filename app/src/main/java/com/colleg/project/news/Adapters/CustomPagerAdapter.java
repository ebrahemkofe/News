package com.colleg.project.news.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.colleg.project.news.R;

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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.item_viewpager, container, false);

        final ImageView image = view.findViewById(R.id.viewpagerpic);

        image.setImageResource(mListData.get(position));


        container.addView(view);
        return view;
    }
}
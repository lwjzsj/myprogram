package com.example.lwjzsj.newstest;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/3/23.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceId;

    public NewsAdapter( Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        News news = getItem(position);
        View view;
        if(converView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = converView;
        }
        TextView textView = (TextView)view.findViewById(R.id.news_title);
        textView.setText(news.getTitle());
        return view;
    }
}

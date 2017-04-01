package com.example.lwjzsj.newstest3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/3/29.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private int resourId;
    public NewsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<News> objects) {
        super(context, resource, objects);
        resourId = resource;
    }
    @Override
    public View getView(int position, View contentView, ViewGroup viewGroup){
        News news = getItem(position);
        View view;
        if(contentView == null){
            view = LayoutInflater.from(getContext()).inflate(resourId,null);
        }else{
            view = contentView;
        }
        TextView textView = (TextView)view.findViewById(R.id.news_title);
        textView.setText(news.getNewsTitle());

        return view;
    }
}

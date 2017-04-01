package com.example.lwjzsj.newstest2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/3/27.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    private int resorceId;

    public NewsAdapter(Context context, int resorce, List<News> object){
        super(context,resorce,object);
        resorceId = resorce;
    }
    @Override
    public View getView(int position, View conventView, ViewGroup viewGroup){
        News news = getItem(position);
        View view;
        if(conventView == null){
            view = LayoutInflater.from(getContext()).inflate(resorceId,null);
        }else{
            view = conventView;
        }
        TextView textView = (TextView)view.findViewById(R.id.news_title);
        textView.setText(news.getNewsTitle());

        return view;
    }
}

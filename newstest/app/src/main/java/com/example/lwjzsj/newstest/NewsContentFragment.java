package com.example.lwjzsj.newstest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lwjzsj on 2017/3/23.
 */

public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }
    public  void refresh(String newsTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsContentText = (TextView)view.findViewById(R.id.news_content);
        TextView newsTitleText = (TextView)view.findViewById(R.id.news_title);

        newsContentText.setText(newsContent);
        newsTitleText.setText(newsTitle);
    }
}

package com.example.lwjzsj.newstest3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lwjzsj on 2017/3/30.
 */

public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
       view = inflater.inflate(R.layout.news_content_frag,viewGroup,false);
        return view;
    }

    public void refrash(String newsTitle,String newsContent){
        View contentVisibility = view.findViewById(R.id.visibility_layout);
        contentVisibility.setVisibility(View.VISIBLE);

        TextView newsTitleText = (TextView)view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView)view.findViewById(R.id.news_content);
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}

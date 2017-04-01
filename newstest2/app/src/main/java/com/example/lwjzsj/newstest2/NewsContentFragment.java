package com.example.lwjzsj.newstest2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lwjzsj on 2017/3/27.
 */

public class NewsContentFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGrou, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.news_content_frag,viewGrou);
        return view;
    }
    public void reflash(String newsTitle,String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
//        设置新闻碎片标题
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        newsTitleText.setText(newsTitle);
//        设置新闻碎片内容
        TextView newsContentText = (TextView)view.findViewById(R.id.news_content);
        newsContentText.setText(newsContent);
    }
}

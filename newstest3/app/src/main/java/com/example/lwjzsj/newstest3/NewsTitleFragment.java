package com.example.lwjzsj.newstest3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/3/29.
 */

public class NewsTitleFragment extends Fragment {
    private List<News> newsList;
    private ListView listView;
    private boolean isTwoPane;
    private NewsAdapter adapter;

    private List<News> getNews() {
        List<News> newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setNewsTitle("Succeed in College as a Learning Disabled Student");
        news1.setNewsContent("College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setNewsTitle("Google Android exec poached by China's Xiaomi");
        news2.setNewsContent("China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);
        return newsList;
    }

        @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        newsList = this.getNews();
        adapter = new NewsAdapter(activity,R.layout.news_item,newsList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag,viewGroup,false);
        listView = (ListView)view.findViewById(R.id.news_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if(isTwoPane){
                    NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    newsContentFragment.refrash(news.getNewsTitle(),news.getNewsContent());
                }else{
                    NewsContentActivity.actionStart(getActivity(),news.getNewsTitle(),news.getNewsContent());
                }
            }
        });
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout) != null){
            isTwoPane = true;
        }else{
            isTwoPane = false;
        }
    }
}

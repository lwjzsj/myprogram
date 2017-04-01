package com.example.lwjzsj.newstest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/3/23.
 */

public class NewsTitleFragment extends Fragment {

    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        newsList = getNews();

        adapter = new NewsAdapter(activity,R.layout.news_item,newsList);

    }
//        @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.news_title_frag, container, false);
//        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
//        newsTitleListView.setAdapter(adapter);
//        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                News news = newsList.get(position);
//                if (isTwoPane) {
//                    // 如果是双页模式，则刷新NewsContentFragment中的内容
//                    NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
//                    newsContentFragment.refresh(news.getTitle(), news.getContent());
//                } else {
//                    // 如果是单页模式，则直接启动NewsContentActivity
//                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
//                }
//            }
//        });
//        return view;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if(isTwoPane){
                    NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    newsContentFragment.refresh(news.getTitle(),news.getContent());
                }else{
                    NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                }
            }
        });
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true; // 可以找到news_content_layout布局时，为双页模式
        } else {
            isTwoPane = false; // 找不到news_content_layout布局时，为单页模式
        }
    }

    private List<News> getNews(){
        List<News> newsList = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("新闻标题1");
        news1.setContent("新闻内容：巴拉巴拉巴拉");
        newsList.add(news1);

        News news2 = new News();
        news2.setTitle("新闻标题2");
        news2.setContent("新闻内容：biu~biu~biu~biu~");
        newsList.add(news2);

        return newsList;
    }
}
//public class NewsTitleFragment extends Fragment{
//    private ListView newsTitleListView;
//    private List<News> newsList;
//    private NewsAdapter adapter;
//    private boolean isTwoPane;
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        newsList = getNews(); // 初始化新闻数据第 2 章 先从看得到的入手，探究活动
//
//        adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.news_title_frag, container, false);
//        newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
//        newsTitleListView.setAdapter(adapter);
//        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                News news = newsList.get(position);
//                if (isTwoPane) {
//                    // 如果是双页模式，则刷新NewsContentFragment中的内容
//                    NewsContentFragment newsContentFragment = (NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
//                    newsContentFragment.refresh(news.getTitle(), news.getContent());
//                } else {
//                    // 如果是单页模式，则直接启动NewsContentActivity
//                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
//                }
//            }
//        });
//        return view;
//    }
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (getActivity().findViewById(R.id.news_content_layout) != null) {
//            isTwoPane = true; // 可以找到news_content_layout布局时，为双页模式
//        } else {
//            isTwoPane = false; // 找不到news_content_layout布局时，为单页模式
//        }
//    }
//
//    private List<News> getNews() {
//        List<News> newsList = new ArrayList<News>();
//        News news1 = new News();
//        news1.setTitle("Succeed in College as a Learning Disabled Student");
//        news1.setContent("College freshmen will soon learn to live with aroommate, adjust to a new social scene and survive less-than-stellardining hall food. Students with learning disabilitiestransitions while also grappling with a few more hurdles.");
//        newsList.add(news1);
//        News news2 = new News();
//        news2.setTitle("Google Android exec poached by China's Xiaomi");
//        news2.setContent("China's Xiaomi has poached a key Google executiveinvolved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
//        newsList.add(news2);
//        return newsList;
//    }
//}
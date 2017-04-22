package com.example.lwjzsj.wechat;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/4/21.
 */

public class WechatFragment extends Fragment {
    private List<Wechat> wechatList;
    private ListView listView;
    private WechatAdapter adapter;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        wechatList = this.getWechat();
        adapter = new WechatAdapter(activity,R.layout.wechat_item,wechatList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.wechat_list_frag,viewGroup,false);
        listView = (ListView)view.findViewById(R.id.wechat_list_frag_view);
        listView.setAdapter(adapter);
        return view;
    }

    private List<Wechat> getWechat(){
        List<Wechat> list = new ArrayList<Wechat>();
        Wechat wechat = null;
        String name;
        String msgInfo;
        for(int i = 0; i<10;i++){
            wechat = new Wechat();
            name = "name";
            msgInfo = "msginfo msginfo msginfo";
            wechat.setName(name);
            wechat.setMsginfo(msgInfo);
            list.add(wechat);
            wechat = null;

        }
        return list;
    }
}

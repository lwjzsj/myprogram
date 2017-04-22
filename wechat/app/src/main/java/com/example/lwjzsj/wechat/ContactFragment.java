package com.example.lwjzsj.wechat;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/4/22.
 */

public class ContactFragment extends Fragment {
    private List<Wechat> contactList;
    private ListView listView;
    private ContactAdapter adapter;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        contactList = getContact();
        adapter = new ContactAdapter(activity,R.layout.contact_item,contactList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.contact_list_frag,viewGroup,false);
        listView = (ListView)view.findViewById(R.id.contact_frag_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MsgActivity.actionStart(getActivity());
            }
        });
        return view;
    }
    private List<Wechat> getContact(){
        List<Wechat> list = new ArrayList<Wechat>();
        Wechat ContactName = null;
        String name;
        for(int i = 0; i<10;i++){
            ContactName = new Wechat();
            name = "name";
            ContactName.setName(name);
            list.add(ContactName);
            ContactName = null;
        }
        return list;
    }
}

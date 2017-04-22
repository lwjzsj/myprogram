package com.example.lwjzsj.wechat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/4/22.
 */

public class ChatListAdapter extends ArrayAdapter<Chat> {
    private int resourceId,build;
    public ChatListAdapter(Context context, int resource, List<Chat> objects){
        super(context,resource,objects);
        resourceId = resource;
    }
    @Override
    public View getView(int position, View converView, ViewGroup viewGroup){
        Chat chat = getItem(position);
        View view;
        if(converView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = converView;
        }
        LinearLayout right = (LinearLayout)view.findViewById(R.id.layout_msg_right);
        LinearLayout left = (LinearLayout)view.findViewById(R.id.layout_msg_left);
        TextView textView;
        build = chat.getBuild();
        if(build==1){
            right.setVisibility(View.GONE);
            left.setVisibility(View.VISIBLE);
            textView = (TextView)view.findViewById(R.id.msg_left);
        }else{
            left.setVisibility(View.GONE);
            right.setVisibility(View.VISIBLE);
            textView = (TextView)view.findViewById(R.id.msg_right);
        }
        textView.setText(chat.getMsg());
        Log.d("msg",chat.getMsg());
        return view;
    }
}

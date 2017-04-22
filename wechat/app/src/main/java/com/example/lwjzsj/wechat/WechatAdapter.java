package com.example.lwjzsj.wechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/4/21.
 */

public class WechatAdapter extends ArrayAdapter<Wechat> {
    private int resourceId;
    public WechatAdapter(Context context, int resource, List<Wechat> objects){
        super(context,resource,objects);
        resourceId = resource;
    }
    public View getView(int position, View converView, ViewGroup viewGroup){
        Wechat wechat = getItem(position);
        View view;
        if(converView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = converView;
        }
        TextView title = (TextView)view.findViewById(R.id.wechat_name);
        TextView content = (TextView)view.findViewById(R.id.wechat_content);

        title.setText(wechat.getName());
        content.setText(wechat.getMsginfo());

        return view;
    }
}

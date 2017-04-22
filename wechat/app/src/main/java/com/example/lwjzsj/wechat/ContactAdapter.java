package com.example.lwjzsj.wechat;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/4/22.
 */

public class ContactAdapter extends ArrayAdapter<Wechat> {
    private int resourceId;
    public ContactAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Wechat> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){
        Wechat wechat = getItem(position);
        View view ;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else{
            view = convertView;
        }
        TextView textView = (TextView)view.findViewById(R.id.contact_name);
        textView.setText(wechat.getName());
        return view;
    }
}

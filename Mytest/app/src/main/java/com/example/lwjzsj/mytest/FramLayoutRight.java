package com.example.lwjzsj.mytest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lwjzsj on 2017/3/20.
 */

public class FramLayoutRight extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance){
        View view = inflater.inflate(R.layout.activity_right,viewGroup,false);
        return view;
    }
}

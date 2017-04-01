package com.example.lwjzsj.test1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by lwjzsj on 2017/3/22.
 */

public class rightActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance){
        View view = inflater.inflate(R.layout.right_fragment,viewGroup,false);
        return view;
    }

}

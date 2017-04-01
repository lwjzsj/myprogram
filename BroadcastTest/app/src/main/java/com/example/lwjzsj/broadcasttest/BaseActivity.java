package com.example.lwjzsj.broadcasttest;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removed(this);
    }
}

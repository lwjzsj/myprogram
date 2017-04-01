package com.example.lwjzsj.broadcasttest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/4/1.
 */

public class ActivityCollector {
    public static List<Activity> activities= new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removed(Activity activity){
        activities.remove(activity);
    }
    public static void finishedAll(){
        for(Activity activity:activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

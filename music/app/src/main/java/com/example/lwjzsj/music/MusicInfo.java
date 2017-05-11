package com.example.lwjzsj.music;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.system.ErrnoException;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicInfo {
    private static String name;//歌名
    private static String path;//歌曲路径
    private static int id;//歌曲在表的id
    private static String tabName;//当前播放表名
    private static int love;//收藏标识符
    private static String actName;//作者
    private static boolean isPlay;//当前是否在播放
    public static MediaPlayer mPlayer;//播放媒体

    public static String getName() {
        return name;
    }

    public static String getPath() {
        return path;
    }

    public static int getId() {
        return id;
    }
    public static void setId(int id) {
        MusicInfo.id = id;
    }

    public static String getTabName() {
        return tabName;
    }
    public static void setTabName(String tabName) {
        MusicInfo.tabName = tabName;
    }

    public static int getLove() {
        return love;
    }

    public static String getActName() {
        return actName;
    }

    public static boolean getPlay() {
        return isPlay;
    }
    public static void setIsPlay(boolean isPlay) {
        MusicInfo.isPlay = isPlay;
    }


    //set
    public static void setMusicInfo(SQLiteDatabase db,String condition,String[] args){
        Cursor idLimt = db.query(MusicInfo.getTabName(),null,null,null,null,null,"id DESC");
        int maxId,minId;
        if(idLimt.moveToFirst()){
            maxId = idLimt.getInt(idLimt.getColumnIndex("id"));
            idLimt.moveToLast();
            minId = idLimt.getInt(idLimt.getColumnIndex("id"));
        }else{
            maxId = -1;
            minId = -1;
        }
        if((maxId != -1) && (minId != -1)){
            if(MusicInfo.getId()<minId){
                MusicInfo.setId(maxId);
            }else if(MusicInfo.getId() > maxId){
                MusicInfo.setId(minId);
            }
        }
        if(condition == null){
            condition = "id = ?";
            args = null;
            args = new String[]{String.valueOf(MusicInfo.getId())};
        }else{
            condition = condition + "id = ?";
            String[] a = new String[args.length+1];
            for(int i = 0;i<args.length;i++){
                a[i] = args[i];
            }
            a[args.length] = String.valueOf(MusicInfo.getId());
            args = a;
        }
        Cursor cursor;
        cursor= db.query(MusicInfo.getTabName(),null,condition,args,null,null,null);
        if(cursor.moveToFirst()){
            MusicInfo.actName = cursor.getString(cursor.getColumnIndex("actname"));
            MusicInfo.name = cursor.getString(cursor.getColumnIndex("name"));
            MusicInfo.path = cursor.getString(cursor.getColumnIndex("path"));
        }else{
            MusicInfo.setId(MusicInfo.getId()+1);
            MusicInfo.setMusicInfo(db,condition,args);
        }
    }

}

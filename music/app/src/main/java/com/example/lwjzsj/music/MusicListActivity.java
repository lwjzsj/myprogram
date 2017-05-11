package com.example.lwjzsj.music;

import android.app.Activity;
import android.app.Presentation;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicListActivity extends Activity {
    public static void startMusicListActivity(Context context, Intent intent){
        Intent intent1 = new Intent(context,MusicListActivity.class);
        intent1.putExtra("tabname",intent.getStringExtra("tabname"));
    }

    private String TabName;//当前页面要展现的表名
    private String DBName;
    private MySQL mySQL;
    private SQLiteDatabase db;

    private
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.music_list_activity);
        TabName = getIntent().getStringExtra("tabname");
        DBName = getIntent().getStringExtra("dbname");
        mySQL = new MySQL(this,DBName,null);
        db = mySQL.getReadableDatabase();




    }
    private List<MusicListObject> initList(){
        Cursor cursor = db.query(TabName,null,null,null,null,null,null);
        MusicListObject object;
        List<MusicListObject> list = new ArrayList<MusicListObject>();
        if(cursor.moveToFirst()){
            do{
                object = new MusicListObject();
                object.setId(cursor.getInt(cursor.getColumnIndex("id")));
                object.setLove(cursor.getInt(cursor.getColumnIndex("love")));
                object.setActName(cursor.getString(cursor.getColumnIndex("actname")));
                object.setName(cursor.getString(cursor.getColumnIndex("name")));
                object.setPath(cursor.getString(cursor.getColumnIndex("path")));
                list.add(object);
                object = null;
            }while (cursor.moveToNext());
        }
        return list;
    }
}

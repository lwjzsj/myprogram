package com.example.lwjzsj.music;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicController extends LinearLayout implements View.OnClickListener {

    static TextView MusicName,MusicActName;
    static  ImageView LastBtn,PlayPauseBtn,NextBtn;
    //定义播放数据库 表
    public static MySQL mySQL;
    public static SQLiteDatabase db;


    private Context mContext;
    public MusicController(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        mySQL = new MySQL(context,MySQL.getDbName(),null);
        db = mySQL.getReadableDatabase();

        LayoutInflater.from(context).inflate(R.layout.music_controller,this);
        MusicName = (TextView)findViewById(R.id.music_controller_name);
        MusicActName = (TextView)findViewById(R.id.music_controller_act);
        LastBtn = (ImageView)findViewById(R.id.music_controller_last);
        PlayPauseBtn = (ImageView)findViewById(R.id.music_controller_pause_play);
        NextBtn = (ImageView)findViewById(R.id.music_controller_next);

        if((MusicInfo.getPath() == null) || (MusicInfo.getPlay() == false)){
            PlayPauseBtn.setImageResource(R.drawable.play);
        }
        if((MusicInfo.getTabName()!=null) && (MusicInfo.getPath() != null)){
            MusicInfo.setMusicInfo(db,null,null);
            MusicName.setText(MusicInfo.getName());
            MusicActName.setText(MusicInfo.getActName());
            PlayPauseBtn.setOnClickListener(this);
            LastBtn.setOnClickListener(this);
            NextBtn.setOnClickListener(this);
        }
    }
    public void onClick(View v){
        Intent intent = new Intent(mContext,MusicPlayerService.class);
        switch (v.getId()){
            case R.id.music_controller_pause_play:
                intent.putExtra("state",0);
                break;
            case R.id.music_controller_last:
                intent.putExtra("state",-1);
                break;
            case R.id.music_controller_next:
                intent.putExtra("state",1);
                break;
        }
        mContext.startService(intent);
        MusicController.reflash();
    }
    public static void reflash(){
        MusicName.setText(MusicInfo.getName());
        MusicActName.setText(MusicInfo.getActName());
        if(MusicInfo.getPlay() == false){
            PlayPauseBtn.setImageResource(R.drawable.play);
        }else{
            PlayPauseBtn.setImageResource(R.drawable.pause);
        }
    }
}

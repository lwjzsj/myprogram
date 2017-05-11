package com.example.lwjzsj.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicPlayerService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("intent",String.valueOf(1));
        MusicInfo.mPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        int i = intent.getIntExtra("state",4);
        Log.i("intent",String.valueOf(i));
        if(MusicInfo.getPath() != null){
            //@i 播放控制
            //1：播放
            //0：切换播放暂停
            switch (i){
                case 1:
                    try {
                        MusicInfo.mPlayer.reset();
                        MusicInfo.setId(MusicInfo.getId()+1);
                        MusicInfo.setMusicInfo(MusicController.db,null,null);
                        MusicInfo.mPlayer.setDataSource(MusicInfo.getPath());
                        MusicInfo.mPlayer.prepare();
                        MusicInfo.mPlayer.start();
                        MusicInfo.setIsPlay(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    if(MusicInfo.getPlay()){
                        MusicInfo.mPlayer.pause();
                        MusicInfo.setIsPlay(false);
                    }else{
                        MusicInfo.mPlayer.start();
                        MusicInfo.setIsPlay(true);
                    }
                    break;
                case -1:
                    try {
                        MusicInfo.mPlayer.reset();
                        MusicInfo.setId(MusicInfo.getId()-1);
                        MusicInfo.setMusicInfo(MusicController.db,null,null);
                        MusicInfo.mPlayer.setDataSource(MusicInfo.getPath());
                        MusicInfo.mPlayer.prepare();
                        MusicInfo.mPlayer.start();
                        MusicInfo.setIsPlay(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        MusicInfo.mPlayer.reset();
                        MusicInfo.setMusicInfo(MusicController.db,null,null);
                        MusicInfo.mPlayer.setDataSource(MusicInfo.getPath());
                        MusicInfo.mPlayer.prepare();
                        MusicInfo.mPlayer.start();
                        MusicInfo.setIsPlay(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

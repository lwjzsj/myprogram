package com.example.lwjzsj.music;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicListAdapter extends ArrayAdapter<MusicListObject> {
    private int resourceId;
    public MusicListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MusicListObject> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final MusicListObject music = getItem(position);
        View view;
        if(convertView != null){
            view = convertView;
        }else{
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        }
        TextView musicNameText = (TextView)view.findViewById(R.id.music_name);
        TextView musicActText = (TextView)view.findViewById(R.id.music_act);
        final ImageView loveBtn = (ImageView)view.findViewById(R.id.music_love_btn);
        ImageView musicMenu = (ImageView)view.findViewById(R.id.music_menu);

        musicNameText.setText(music.getName());
        musicActText.setText(music.getActName());

        if(music.getLove() == 1){
            loveBtn.setImageResource(R.drawable.lovely);
        }else{
            loveBtn.setImageResource(R.drawable.love);
        }

        loveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int love;
                if(music.getLove() == 1){
                    music.setLove(0);
                    love=0;
                    loveBtn.setImageResource(R.drawable.love);
                }else{
                    music.setLove(1);
                    love=1;
                    loveBtn.setImageResource(R.drawable.lovely);
                }
                SQLiteDatabase db = (new MySQL(getContext(),MySQL.getDbName(),null)).getReadableDatabase();
                ContentValues values = new ContentValues();
                values.clear();
                values.put("love",love);
                db.update(music.getInTabName(),values,"id=?",new String[]{String.valueOf(music.getId())});
            }
        });

        return view;
    }
}

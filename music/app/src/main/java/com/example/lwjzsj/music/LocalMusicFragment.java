package com.example.lwjzsj.music;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class LocalMusicFragment extends Fragment {

    private static Intent intent;
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loacl_music_frag,container,false);
        TextView loaclMusicBtn = (TextView)view.findViewById(R.id.local_music_index);
        loaclMusicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.putExtra("tabname","loaclmusic");
                intent.putExtra("dbname","local")
                MusicListActivity.startMusicListActivity(getContext(),intent);
            }
        });

        return view;
    }
}

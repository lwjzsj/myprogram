package com.example.lwjzsj.wechat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwjzsj on 2017/4/22.
 */

public class MsgActivity extends Activity {
    private ListView listView;
    private List<Chat> chatList;
    private ChatListAdapter adapter;

    public static void actionStart(Context context){
        Intent intent = new Intent(context,MsgActivity.class);
        context.startActivity(intent);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_list);
        chatList = getChat();
        listView = (ListView)findViewById(R.id.msg_list);
        adapter = new ChatListAdapter(MsgActivity.this,R.layout.chat_list_item,chatList);
        listView.setAdapter(adapter);
    }
    private List<Chat> getChat(){
        List<Chat> list = new ArrayList<Chat>();
        Chat chat = null;
        for(int i = 0; i<20;i++){
            chat = new Chat();
            int build = i%2;
            String msg = "测试信息";
            chat.setBuild(build);
            chat.setMsg(msg);
            list.add(chat);
        }
        return list;
    }
}

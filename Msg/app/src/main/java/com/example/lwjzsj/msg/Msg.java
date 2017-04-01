package com.example.lwjzsj.msg;

/**
 * Created by lwjzsj on 2017/3/8.
 */

public class Msg {
    public static final int TYPE_RECEIVER = 0;
    public static final int TYPE_SENt = 1;
    private String content;
    private int type;
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public String getContent(){
        return content;
    }
    public  int getType(){
        return type;
    }
}

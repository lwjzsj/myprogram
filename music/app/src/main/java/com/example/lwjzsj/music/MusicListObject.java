package com.example.lwjzsj.music;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MusicListObject {
    private String name = null;//歌名
    private String path  = null;//歌曲路径
    private int id;//歌曲在表的id
    private int love;//收藏标识符
    private String actName  = null;//作者
    private String inTabName;//当前加载的播放列表是哪一张表

    public String getName() {
        return name;
    }

    public String getInTabName() {
        return inTabName;
    }

    public void setInTabName(String inTabName) {
        this.inTabName = inTabName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }
}

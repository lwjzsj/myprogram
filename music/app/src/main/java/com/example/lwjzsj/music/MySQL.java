package com.example.lwjzsj.music;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PrivateKey;

/**
 * Created by lwjzsj on 2017/5/10.
 */

public class MySQL extends SQLiteOpenHelper {

    private static String dbName;
    public static String getDbName() {
        return dbName;
    }
    public static void setDbName(String dbName) {
        MySQL.dbName = dbName;
    }

    //设置数据库版本号
    private static int sqlVersion;
    public static void setSqlVersion(int sqlVersion) {
        MySQL.sqlVersion = sqlVersion;
    }

    //设置要创建的表
    private static String sql;
    public static void setSql(String sql) {
        MySQL.sql = sql;
    }

    public MySQL(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, MySQL.sqlVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MySQL.sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

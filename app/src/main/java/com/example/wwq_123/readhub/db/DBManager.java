package com.example.wwq_123.readhub.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.wwq_123.readhub.model.jsonbean.bean.DaoMaster;

public class DBManager {
    private static final String DB_NAME = "readhub_db";
    private Context context;
    private static DaoMaster.DevOpenHelper helper;
    private static DBManager manager;


    public static DBManager newInstance(Context context){
        if (manager==null){
            synchronized (DBManager.class){
                if (manager==null){
                    manager = new DBManager(context);
                }
            }
        }
        return manager;
    }

    public DBManager(Context context){
        this.context = context;
        helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
    }
    public SQLiteDatabase getReadableDataBase(){
        if (helper==null){
            helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
        }
        SQLiteDatabase database = helper.getReadableDatabase();
        return database;
    }
    public SQLiteDatabase getWritableDataBase(){
        if (helper==null){
            helper = new DaoMaster.DevOpenHelper(context,DB_NAME,null);
        }
        return helper.getWritableDatabase();
    }
}

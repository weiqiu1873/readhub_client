package com.example.wwq_123.readhub.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.wwq_123.readhub.greendao.gen.DaoMaster;
import com.example.wwq_123.readhub.greendao.gen.DaoSession;


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

    public DaoSession getReadSession(){
        DaoMaster master = new DaoMaster(helper.getReadableDatabase());
        return master.newSession();
    }
    public DaoSession getWriteSession(){
        DaoMaster master = new DaoMaster(helper.getWritableDatabase());
        return master.newSession();
    }
}

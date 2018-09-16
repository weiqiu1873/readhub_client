package com.example.wwq_123.readhub.db;

import android.content.Context;

import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.jsonbean.bean.CommonDataItemDao;
import com.example.wwq_123.readhub.model.jsonbean.bean.DaoMaster;
import com.example.wwq_123.readhub.model.jsonbean.bean.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


public class NewsDB {
    private DBManager manager;

    public NewsDB(Context context){
        manager = new DBManager(context);
    }

    public void insert(CommonDataItem dataItem){
        DaoMaster master = new DaoMaster(manager.getWritableDataBase());
        DaoSession session = master.newSession();
        CommonDataItemDao dao = session.getCommonDataItemDao();
        dao.insertOrReplace(dataItem);
    }
    public void delete(CommonDataItem dataItem){
        DaoMaster master = new DaoMaster(manager.getWritableDataBase());
        DaoSession session = master.newSession();
        CommonDataItemDao dao = session.getCommonDataItemDao();
        dao.delete(dataItem);
    }
    public List<CommonDataItem> getAll(){
        DaoMaster master = new DaoMaster(manager.getReadableDataBase());
        DaoSession session = master.newSession();
        CommonDataItemDao dao = session.getCommonDataItemDao();
        QueryBuilder<CommonDataItem> builder = dao.queryBuilder();
        return builder.list();
    }
}

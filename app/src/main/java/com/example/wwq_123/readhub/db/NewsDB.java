package com.example.wwq_123.readhub.db;

import android.content.Context;


import com.example.wwq_123.readhub.greendao.gen.CommonDataItemDao;
import com.example.wwq_123.readhub.greendao.gen.DaoMaster;
import com.example.wwq_123.readhub.greendao.gen.DaoSession;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import org.greenrobot.greendao.query.QueryBuilder;
import java.util.List;


public class NewsDB {
    private DBManager manager;

    public NewsDB(Context context){
        manager = new DBManager(context);
    }

    public void insert(CommonDataItem dataItem){
        CommonDataItemDao dao = manager.getWriteSession().getCommonDataItemDao();
        dao.insertOrReplace(dataItem);
    }
    public void delete(CommonDataItem dataItem){
        CommonDataItemDao dao = manager.getWriteSession().getCommonDataItemDao();
        dao.delete(dataItem);
    }
    public List<CommonDataItem> getAll(){
        CommonDataItemDao dao = manager.getReadSession().getCommonDataItemDao();
        QueryBuilder<CommonDataItem> builder = dao.queryBuilder();
        return builder.list();
    }
}

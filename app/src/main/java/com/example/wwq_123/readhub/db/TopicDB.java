package com.example.wwq_123.readhub.db;

import android.content.Context;

import com.example.wwq_123.readhub.greendao.gen.DaoMaster;
import com.example.wwq_123.readhub.greendao.gen.DaoSession;
import com.example.wwq_123.readhub.greendao.gen.TopicDataItemDao;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import org.greenrobot.greendao.query.QueryBuilder;
import java.util.List;

public class TopicDB {

    private DBManager manager;
    private Context context;

    public TopicDB(Context context){
        this.context = context;
        manager = DBManager.newInstance(context);
    }
    //插入一条数据
    public void insert(TopicDataItem dataItem){
        DaoMaster master = new DaoMaster(manager.getWritableDataBase());
        DaoSession session = master.newSession();
        TopicDataItemDao dao = session.getTopicDataItemDao();
        dao.insertOrReplace(dataItem);
    }
    public void delete(TopicDataItem dataItem){
        DaoMaster master = new DaoMaster(manager.getWritableDataBase());
        DaoSession session = master.newSession();
        TopicDataItemDao dao = session.getTopicDataItemDao();
        dao.delete(dataItem);
    }
    public List<TopicDataItem> getAll(){
        DaoMaster master = new DaoMaster(manager.getReadableDataBase());
        DaoSession session = master.newSession();
        TopicDataItemDao dao = session.getTopicDataItemDao();
        QueryBuilder<TopicDataItem> builder = dao.queryBuilder();
        List<TopicDataItem> topicDataItems = builder.list();
        return topicDataItems;
    }
}

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
        TopicDataItemDao dao = manager.getWriteSession().getTopicDataItemDao();
        dao.insertOrReplace(dataItem);
    }
    public void delete(TopicDataItem dataItem){
        TopicDataItemDao dao = manager.getWriteSession().getTopicDataItemDao();
        dao.delete(dataItem);
    }
    public List<TopicDataItem> getAll(){
        TopicDataItemDao dao = manager.getReadSession().getTopicDataItemDao();
        QueryBuilder<TopicDataItem> builder = dao.queryBuilder();
        return builder.list();
    }
}

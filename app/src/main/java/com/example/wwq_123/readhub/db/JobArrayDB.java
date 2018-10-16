package com.example.wwq_123.readhub.db;

import android.content.Context;

import com.example.wwq_123.readhub.greendao.gen.JobArrayBeanDao;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

//对收藏的职业信息进行DB操作
public class JobArrayDB {
    private DBManager manager;
    public JobArrayDB(Context context){
        manager = new DBManager(context);
    }
    public void insert(JobArrayBean bean){
        JobArrayBeanDao dao = manager.getWriteSession().getJobArrayBeanDao();
        dao.insertOrReplace(bean);
    }

    public void delete(JobArrayBean bean){
        JobArrayBeanDao dao = manager.getWriteSession().getJobArrayBeanDao();
        dao.delete(bean);
    }
    //获取所有收藏的职业
    public List<JobArrayBean> getAllJob(){
        JobArrayBeanDao dao = manager.getReadSession().getJobArrayBeanDao();
        QueryBuilder<JobArrayBean> builder = dao.queryBuilder();
        return builder.list();
    }
}

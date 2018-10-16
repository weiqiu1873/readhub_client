package com.example.wwq_123.readhub.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.bean.User;

import com.example.wwq_123.readhub.greendao.gen.CommonDataItemDao;
import com.example.wwq_123.readhub.greendao.gen.JobArrayBeanDao;
import com.example.wwq_123.readhub.greendao.gen.TopicDataItemDao;
import com.example.wwq_123.readhub.greendao.gen.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig commonDataItemDaoConfig;
    private final DaoConfig jobArrayBeanDaoConfig;
    private final DaoConfig topicDataItemDaoConfig;
    private final DaoConfig userDaoConfig;

    private final CommonDataItemDao commonDataItemDao;
    private final JobArrayBeanDao jobArrayBeanDao;
    private final TopicDataItemDao topicDataItemDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        commonDataItemDaoConfig = daoConfigMap.get(CommonDataItemDao.class).clone();
        commonDataItemDaoConfig.initIdentityScope(type);

        jobArrayBeanDaoConfig = daoConfigMap.get(JobArrayBeanDao.class).clone();
        jobArrayBeanDaoConfig.initIdentityScope(type);

        topicDataItemDaoConfig = daoConfigMap.get(TopicDataItemDao.class).clone();
        topicDataItemDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        commonDataItemDao = new CommonDataItemDao(commonDataItemDaoConfig, this);
        jobArrayBeanDao = new JobArrayBeanDao(jobArrayBeanDaoConfig, this);
        topicDataItemDao = new TopicDataItemDao(topicDataItemDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(CommonDataItem.class, commonDataItemDao);
        registerDao(JobArrayBean.class, jobArrayBeanDao);
        registerDao(TopicDataItem.class, topicDataItemDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        commonDataItemDaoConfig.clearIdentityScope();
        jobArrayBeanDaoConfig.clearIdentityScope();
        topicDataItemDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public CommonDataItemDao getCommonDataItemDao() {
        return commonDataItemDao;
    }

    public JobArrayBeanDao getJobArrayBeanDao() {
        return jobArrayBeanDao;
    }

    public TopicDataItemDao getTopicDataItemDao() {
        return topicDataItemDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}

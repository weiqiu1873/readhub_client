package com.example.wwq_123.readhub.db;

import android.content.Context;

import com.example.wwq_123.readhub.greendao.gen.DaoMaster;
import com.example.wwq_123.readhub.greendao.gen.DaoSession;
import com.example.wwq_123.readhub.greendao.gen.UserDao;
import com.example.wwq_123.readhub.model.bean.User;

public class UserDB {
    private DBManager manager;
    private Context context;

    public UserDB(Context context){
        this.context = context;
        manager = DBManager.newInstance(context);
    }

    public void insert(User user){
        UserDao dao = manager.getWriteSession().getUserDao();
        dao.insertOrReplace(user);
    }

}

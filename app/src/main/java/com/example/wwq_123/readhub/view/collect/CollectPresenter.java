package com.example.wwq_123.readhub.view.collect;

import android.content.Context;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.db.NewsDB;
import com.example.wwq_123.readhub.db.PreferencesUtil;
import com.example.wwq_123.readhub.db.TopicDB;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;

import java.util.List;

public class CollectPresenter extends BasePresenter<CollectContract.View> implements CollectContract.Presenter {
    private Context context;
    private TopicDB topicDB;
    private NewsDB newsDB;
    private PreferencesUtil util;
    public CollectPresenter(CollectContract.View view, Context context){
        attachView(view);
        this.context = context;
        util = PreferencesUtil.getInstance(context);
    }
    @Override
    public void getTopic() {
        List<TopicDataItem> topicList = null;
        if (util.loginStatus()){
            topicDB = new TopicDB(context);
            topicList = topicDB.getAll();
        }
        view.showTopic(topicList);
    }

    @Override
    public void getNews() {
        List<CommonDataItem> newsList = null;
        if (util.loginStatus()){
            newsDB = new NewsDB(context);
            newsList = newsDB.getAll();
        }
        view.showNews(newsList);
    }
}

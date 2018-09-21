package com.example.wwq_123.readhub.view.collect;

import android.content.Context;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.db.NewsDB;
import com.example.wwq_123.readhub.db.TopicDB;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;

import java.util.List;

public class CollectPresenter extends BasePresenter<CollectContract.View> implements CollectContract.CollectPresenter {
    private Context context;
    private TopicDB topicDB;
    private NewsDB newsDB;
    public CollectPresenter(CollectContract.View view, Context context){
        attachView(view);
        this.context = context;
    }
    @Override
    public void getTopic() {
        topicDB = new TopicDB(context);
        List<TopicDataItem> topicList = topicDB.getAll();
        view.showTopic(topicList);
    }

    @Override
    public void getNews() {
        newsDB = new NewsDB(context);
        List<CommonDataItem> newsList = newsDB.getAll();
        view.showNews(newsList);
    }
}

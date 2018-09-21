package com.example.wwq_123.readhub.view.collect;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;


import java.util.List;

public class CollectContract implements BaseContract {
    interface View extends BaseContract.BaseView{
        void showTopic(List<TopicDataItem> topicList);
        void showNews(List<CommonDataItem> newsList);
    }
    interface CollectPresenter extends BaseContract.BasePresenter<View>{
        void getTopic();
        void getNews();
    }
}

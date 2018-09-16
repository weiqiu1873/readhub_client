package com.example.wwq_123.readhub.view.topic;

import com.example.wwq_123.readhub.base.BaseContract;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;


import java.util.List;

public interface TopicContract {
    interface View extends BaseContract.BaseView{
        void showTopicData(List<TopicDataItem> topicList);
        void showMoreTopicData(List<TopicDataItem> topicList);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getTopic();
        void getMoreTopic(String order);
    }
}

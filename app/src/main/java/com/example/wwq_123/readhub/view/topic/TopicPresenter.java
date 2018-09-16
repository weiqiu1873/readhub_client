package com.example.wwq_123.readhub.view.topic;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

public class TopicPresenter extends BasePresenter<TopicContract.View> implements TopicContract.Presenter{
    public TopicPresenter(TopicContract.View view){
        attachView(view);
    }
    @Override
    public void getTopic() {
        addSubscription(api.getTopicData("",10)
                .map((topicData)->dataChange(topicData))
                ,new MySubscriber<List<TopicDataItem>>(){
            @Override
            public void onNext(List<TopicDataItem> list) {
                view.showTopicData(list);
                view.showSuccess();
            }
        });
    }

    @Override
    public void getMoreTopic(String order) {
        addSubscription(api
                .getTopicData(order,10)
                .map((topicData)-> dataChange(topicData))
                ,new MySubscriber<List<TopicDataItem>>(){
                    @Override
                    public void onNext(List<TopicDataItem> list) { view.showMoreTopicData(list); }
                });
    }

    public List<TopicDataItem> dataChange(TopicData topicData){
        DataUtil util = new DataUtil();
        List<TopicDataItem> topicList = util.extractTopic(topicData);
        return topicList;
    }
}

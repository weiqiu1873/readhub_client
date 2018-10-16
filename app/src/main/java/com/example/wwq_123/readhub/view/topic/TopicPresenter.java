package com.example.wwq_123.readhub.view.topic;

import android.util.Log;

import com.example.wwq_123.readhub.base.BasePresenter;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;
import com.example.wwq_123.readhub.net.retrofit.MySubscriber;
import com.example.wwq_123.readhub.util.DataUtil;

import java.util.List;

public class TopicPresenter extends BasePresenter<TopicContract.View> implements TopicContract.Presenter{

    private String lastOrder = "";
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
                        lastOrder = String.valueOf(list.get(list.size()-1).getOrder());
                        view.showTopicData(list);
                    }
                });
    }

    @Override
    public void getMoreTopic() {
        addSubscription(api
                .getTopicData(lastOrder,10)
                .map((topicData)-> dataChange(topicData))
                ,new MySubscriber<List<TopicDataItem>>(){
                    @Override
                    public void onNext(List<TopicDataItem> list) {
                        lastOrder = String.valueOf(list.get(list.size()-1).getOrder());
                        view.showMoreTopicData(list);
                    }
                });
    }

    @Override
    public void getLatestTopic() {
        addSubscription(api.getTopicData("",10)
                .map((topicData) -> dataChange(topicData)),
                new MySubscriber<List<TopicDataItem>>(){
                    @Override
                    public void onNext(List<TopicDataItem> list) {
                        String order = String.valueOf(list.get(list.size()-1).getOrder());
                        if (lastOrder.equals(order)){
                            view.showLatestTopicData(null);
                        }else {
                            lastOrder = order;
                            view.showLatestTopicData(list);
                        }
                    }
                });
    }

    private List<TopicDataItem> dataChange(TopicData topicData){
        DataUtil util = new DataUtil();
        List<TopicDataItem> topicList = util.extractTopic(topicData);
        return topicList;
    }
}
